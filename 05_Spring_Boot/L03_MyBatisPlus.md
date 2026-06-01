# 📖 MyBatis-Plus — 简化数据库操作

## ⭐ MyBatis-Plus 是什么？

> MyBatis-Plus = **MyBatis 的增强版**
> 基本的增删改查不用写 SQL，自动搞定！

---

## ⭐ 基本用法（继承 BaseMapper 即可）

```java
@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 啥也不用写！以下方法自动拥有：
    // insert(user)         — 插入
    // deleteById(id)       — 删除
    // updateById(user)     — 更新
    // selectById(id)       — 按 ID 查
    // selectList(wrapper)  — 条件查询
    // selectCount(wrapper) — 计数
    // selectPage(page, wrapper) — 分页查询
}
```

---

## ⭐ 条件构造器（QueryWrapper）

```java
// 查询年龄 > 20 且性别为男的用户
QueryWrapper<User> wrapper = new QueryWrapper<>();
wrapper.gt("age", 20)              // age > 20
       .eq("gender", "男")          // gender = '男'
       .orderByDesc("create_time"); // 按创建时间倒序

List<User> users = userMapper.selectList(wrapper);
```

### 常用条件方法
| 方法 | SQL | 说明 |
|---|---|---|
| `eq("name", "张三")` | `name = '张三'` | 等于 |
| `ne("status", 0)` | `status != 0` | 不等于 |
| `gt("age", 20)` | `age > 20` | 大于 |
| `ge("age", 20)` | `age >= 20` | 大于等于 |
| `lt("age", 30)` | `age < 30` | 小于 |
| `le("age", 30)` | `age <= 30` | 小于等于 |
| `like("name", "张")` | `name LIKE '%张%'` | 模糊匹配 |
| `likeRight("name", "张")` | `name LIKE '张%'` | 右模糊 |
| `in("id", list)` | `id IN (1,2,3)` | IN 查询 |
| `isNull("email")` | `email IS NULL` | 为空 |
| `isNotNull("email")` | `email IS NOT NULL` | 不为空 |
| `between("age", 20, 30)` | `age BETWEEN 20 AND 30` | 范围 |
| `orderByDesc("create_time")` | `ORDER BY create_time DESC` | 倒序 |

### LambdaQueryWrapper（推荐 ✅）
```java
// 用 Lambda 写法，避免硬编码字段名字符串（重构时不会遗漏）
LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
wrapper.eq(User::getGender, "男")
       .gt(User::getAge, 20)
       .orderByDesc(User::getCreateTime);

List<User> users = userMapper.selectList(wrapper);
```

---

## ⭐ 分页查询（开发必用！）

### 1. 配置分页插件
```java
@Configuration
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
```

### 2. 使用分页
```java
// 第1页，每页10条
Page<User> page = new Page<>(1, 10);

LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
wrapper.eq(User::getStatus, 1);

Page<User> result = userMapper.selectPage(page, wrapper);

result.getRecords();    // 当前页数据（List<User>）
result.getTotal();      // 总记录数
result.getPages();      // 总页数
result.getCurrent();    // 当前页码
result.getSize();       // 每页条数
```

---

## ⭐ 常用注解

| 注解 | 作用 | 示例 |
|---|---|---|
| `@TableName("user")` | 指定表名 | 类名和表名不一致时用 |
| `@TableId(type = IdType.AUTO)` | 主键策略（自增） | 放在 id 字段上 |
| `@TableField("user_name")` | 指定列名 | 字段名和列名不一致时用 |
| `@TableField(exist = false)` | 非数据库字段 | 临时字段，不映射到表 |
| `@TableLogic` | 逻辑删除 | 放在 is_deleted 字段上 |

---

## ⭐ IService 快捷方法（Service 层）

```java
// Service 接口继承 IService
public interface UserService extends IService<User> {
    // 自动拥有更多便捷方法
}

// Service 实现继承 ServiceImpl
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    // 自动拥有：
    // save(user)             — 保存
    // saveBatch(list)        — 批量保存
    // removeById(id)         — 删除
    // updateById(user)       — 更新
    // getById(id)            — 查询
    // list()                 — 查询所有
    // list(wrapper)          — 条件查询
    // page(page, wrapper)    — 分页查询
    // count()                — 计数
}
```

---

## 💡 自定义 SQL（复杂查询时用）

```java
// 在 Mapper 中用注解写 SQL
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT u.*, COUNT(a.id) as article_count " +
            "FROM user u LEFT JOIN article a ON u.id = a.user_id " +
            "GROUP BY u.id")
    List<Map<String, Object>> getUserWithArticleCount();
}
```

> 💡 简单查询用 Wrapper，复杂查询（多表联查）写自定义 SQL
