# 📖 JSON — 前后端数据交换的通用语言

## ⭐ JSON 是什么？

> JSON = **JavaScript Object Notation**，一种轻量级的数据格式
> 前端和后端之间传输数据，几乎都用 JSON

---

## ⭐ JSON 语法

### 基本格式
```json
{
    "name": "张三",
    "age": 25,
    "isStudent": false,
    "phone": null,
    "hobbies": ["读书", "编程", "跑步"],
    "address": {
        "city": "北京",
        "district": "朝阳区"
    }
}
```

### 语法规则
- 键名必须用**双引号**（不能用单引号！）
- 值的类型：字符串、数字、布尔、null、数组、对象
- 最后一个元素后面**不能有逗号**
- 不支持注释

---

## ⭐ Java 中使用 JSON

### 常用 JSON 库

| 库 | 说明 |
|---|---|
| **Jackson** | Spring Boot 默认自带，最常用 ✅ |
| **FastJSON** | 阿里巴巴出品，国内用得多 |
| **Gson** | Google 出品，简单好用 |

### Jackson 基本用法（Spring Boot 自带）
```java
import com.fasterxml.jackson.databind.ObjectMapper;

ObjectMapper mapper = new ObjectMapper();

// Java 对象 → JSON 字符串（序列化）
User user = new User("张三", 25);
String json = mapper.writeValueAsString(user);
// 输出：{"name":"张三","age":25}

// JSON 字符串 → Java 对象（反序列化）
User user2 = mapper.readValue(json, User.class);
```

> 💡 在 Spring Boot 中你通常不需要手动转换！
> 框架会**自动把 Java 对象转成 JSON 返回给前端**

### Spring Boot 中的自动转换
```java
@RestController
public class UserController {

    @GetMapping("/api/user")
    public User getUser() {
        // 直接返回 Java 对象，Spring Boot 自动转成 JSON！
        return new User("张三", 25);
    }
    // 前端收到的是：{"name":"张三","age":25}
}
```

---

## ⭐ 常见的 JSON 数据结构

### 列表数据
```json
{
    "code": 200,
    "message": "成功",
    "data": [
        {"id": 1, "name": "张三", "age": 25},
        {"id": 2, "name": "李四", "age": 22},
        {"id": 3, "name": "王五", "age": 28}
    ]
}
```

### 分页数据
```json
{
    "code": 200,
    "message": "成功",
    "data": {
        "total": 100,
        "pageNum": 1,
        "pageSize": 10,
        "list": [
            {"id": 1, "name": "张三"},
            {"id": 2, "name": "李四"}
        ]
    }
}
```

### 错误响应
```json
{
    "code": 400,
    "message": "用户名不能为空",
    "data": null
}
```

---

## 💡 JSON 常见注解（Spring Boot / Jackson）

```java
public class User {
    private String name;

    @JsonIgnore                        // 序列化时忽略此字段（如密码）
    private String password;

    @JsonProperty("user_age")          // JSON 中的字段名用 user_age
    private int age;

    @JsonFormat(pattern = "yyyy-MM-dd") // 日期格式化
    private Date birthday;
}
```

> 💡 这些注解后面学 Spring Boot 时会经常用到
