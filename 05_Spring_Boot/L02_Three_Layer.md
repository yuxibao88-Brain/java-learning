# 📖 三层架构 — Spring Boot 的核心设计模式

## ⭐ 什么是三层架构？

```
浏览器/前端
    ↓ HTTP 请求
┌─────────────────────────────────────┐
│  Controller（控制层）                │ ← 接收请求、参数校验、调用 Service
│         ↓                           │
│  Service（服务层）                   │ ← 业务逻辑（核心代码写在这里！）
│         ↓                           │
│  Mapper/DAO（数据层）               │ ← 操作数据库（SQL）
└─────────────────────────────────────┘
    ↓ 数据库
  MySQL
```

> ⭐ **分层原则：每层只做自己的事，不越权！**

---

## ⭐ 各层职责

| 层 | 包名 | 职责 | 注解 |
|---|---|---|---|
| **Controller** | controller/ | 接收请求、返回响应 | `@RestController` |
| **Service** | service/ | 业务逻辑 | `@Service` |
| **Mapper** | mapper/ | 数据库操作 | `@Mapper` |
| **Entity** | entity/ | 实体类（对应数据库表） | `@TableName` |

---

## ⭐ 完整示例：用户 CRUD

### 1. Entity（实体类）
```java
package com.example.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data                               // Lombok：自动生成 getter/setter/toString
@TableName("user")                  // 对应数据库的 user 表
public class User {

    @TableId(type = IdType.AUTO)    // 主键自增
    private Long id;

    private String username;
    private String password;
    private String nickname;
    private String phone;
    private String email;
    private Integer status;

    @TableLogic                      // 逻辑删除字段
    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT)  // 插入时自动填充
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)  // 插入和更新时自动填充
    private LocalDateTime updateTime;
}
```

### 2. Mapper（数据层）
```java
package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 继承 BaseMapper 后，基本的增删改查都自动有了！
    // 不需要写任何代码 🎉
}
```

### 3. Service（服务层）
```java
// ===== 接口 =====
package com.example.service;

import com.example.entity.User;
import java.util.List;

public interface UserService {
    List<User> listAll();
    User getById(Long id);
    void create(User user);
    void update(User user);
    void delete(Long id);
}

// ===== 实现类 =====
package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service                              // 标记为 Service 组件
public class UserServiceImpl implements UserService {

    @Autowired                        // 自动注入 Mapper
    private UserMapper userMapper;

    @Override
    public List<User> listAll() {
        return userMapper.selectList(null);  // 查询所有
    }

    @Override
    public User getById(Long id) {
        return userMapper.selectById(id);    // 按 ID 查询
    }

    @Override
    public void create(User user) {
        userMapper.insert(user);             // 插入
    }

    @Override
    public void update(User user) {
        userMapper.updateById(user);         // 按 ID 更新
    }

    @Override
    public void delete(Long id) {
        userMapper.deleteById(id);           // 按 ID 删除（逻辑删除）
    }
}
```

### 4. Controller（控制层）
```java
package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET /api/users — 查询所有用户
    @GetMapping
    public Result<List<User>> list() {
        return Result.success(userService.listAll());
    }

    // GET /api/users/1 — 查询单个用户
    @GetMapping("/{id}")
    public Result<User> getById(@PathVariable Long id) {
        return Result.success(userService.getById(id));
    }

    // POST /api/users — 创建用户（请求体是 JSON）
    @PostMapping
    public Result<Void> create(@RequestBody User user) {
        userService.create(user);
        return Result.success();
    }

    // PUT /api/users — 修改用户
    @PutMapping
    public Result<Void> update(@RequestBody User user) {
        userService.update(user);
        return Result.success();
    }

    // DELETE /api/users/1 — 删除用户
    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return Result.success();
    }
}
```

### 5. 统一响应类 Result
```java
package com.example.common;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMessage("成功");
        r.setData(data);
        return r;
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> error(String message) {
        Result<T> r = new Result<>();
        r.setCode(500);
        r.setMessage(message);
        return r;
    }
}
```

---

## ⭐ 数据流向总结

```
前端发请求 → Controller 接收 → 调用 Service → Service 调用 Mapper → 操作数据库
数据库返回 → Mapper 返回 Entity → Service 处理逻辑 → Controller 返回 JSON → 前端展示
```

> 💡 **记住这个流向，看任何 Spring Boot 项目都不会迷路！**
