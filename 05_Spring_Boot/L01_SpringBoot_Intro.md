# 📖 Spring Boot 入门

## ⭐ Spring Boot 是什么？

> Spring Boot = **Java 后端开发的标准框架**
> 它简化了 Spring 的配置，让你能快速搭建 Web 应用

不用 Spring Boot：需要大量 XML 配置（几百行 😱）
用 Spring Boot：约定大于配置，开箱即用（几行代码 😇）

---

## ⭐ 创建 Spring Boot 项目

### 方式1：Spring Initializr（推荐 ✅）
1. 打开 [start.spring.io](https://start.spring.io/)
2. 选择配置：
   - Project: **Maven**
   - Language: **Java**
   - Spring Boot: **最新稳定版**（不选 SNAPSHOT）
   - Group: `com.example`
   - Artifact: `demo`
   - Java: **17**
3. 添加依赖：
   - **Spring Web**（Web 开发必选）
   - **MyBatis-Plus**（数据库操作）
   - **MySQL Driver**（MySQL 驱动）
   - **Lombok**（简化代码）
4. 点击 Generate → 下载 zip → 用 IDEA 打开

### 方式2：IDEA 创建
File → New → Project → Spring Initializr → 同上配置

---

## ⭐ 项目结构

```
src/main/java/com/example/demo/
├── DemoApplication.java           ← 启动类（程序入口）
├── controller/                    ← 控制器层（接收请求）
│   └── UserController.java
├── service/                       ← 服务层（业务逻辑）
│   ├── UserService.java           ← 接口
│   └── impl/
│       └── UserServiceImpl.java   ← 实现类
├── mapper/                        ← 数据层（操作数据库）
│   └── UserMapper.java
├── entity/                        ← 实体类（对应数据库表）
│   └── User.java
├── dto/                           ← 数据传输对象
│   └── UserDTO.java
├── vo/                            ← 视图对象（返回给前端的）
│   └── UserVO.java
└── common/                        ← 公共模块
    └── Result.java                ← 统一响应类

src/main/resources/
├── application.yml                ← 核心配置文件 ⭐
├── mapper/                        ← MyBatis XML 映射文件
└── static/                        ← 静态资源
```

---

## ⭐ 核心配置 application.yml

```yaml
server:
  port: 8080                       # 服务端口

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/java_learning?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8mb4
    username: root
    password: 123456
    driver-class-name: com.mysql.cj.jdbc.Driver

mybatis-plus:
  mapper-locations: classpath:mapper/*.xml   # XML 映射文件位置
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl  # 打印 SQL（开发时开启）
    map-underscore-to-camel-case: true  # 下划线 → 驼峰自动转换
```

---

## ⭐ 第一个接口

```java
@RestController                    // 标记为控制器，返回 JSON
@RequestMapping("/api")            // 路径前缀
public class HelloController {

    @GetMapping("/hello")          // GET /api/hello
    public String hello() {
        return "Hello Spring Boot!";
    }

    @GetMapping("/user/{id}")      // GET /api/user/1
    public Map<String, Object> getUser(@PathVariable Long id) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("name", "张三");
        return user;               // 自动转成 JSON
    }
}
```

> 启动项目后访问 http://localhost:8080/api/hello 就能看到结果！

---

## ⭐ 常用注解速查

| 注解 | 作用 | 位置 |
|---|---|---|
| `@RestController` | 标记控制器类，返回 JSON | 类上 |
| `@RequestMapping("/api")` | 路径前缀 | 类上 |
| `@GetMapping("/xxx")` | GET 请求 | 方法上 |
| `@PostMapping("/xxx")` | POST 请求 | 方法上 |
| `@PutMapping("/xxx")` | PUT 请求 | 方法上 |
| `@DeleteMapping("/xxx")` | DELETE 请求 | 方法上 |
| `@PathVariable` | 获取 URL 路径参数 `/user/{id}` | 参数上 |
| `@RequestParam` | 获取查询参数 `?name=张三` | 参数上 |
| `@RequestBody` | 获取请求体 JSON 数据 | 参数上 |
| `@Service` | 标记 Service 层 | 类上 |
| `@Autowired` | 自动注入依赖 | 字段上 |
| `@Mapper` | 标记 MyBatis Mapper | 类上 |

---

## 💡 启动类

```java
@SpringBootApplication    // 核心注解，标记启动类
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

> 💡 这个类不需要改，记住它是程序入口就行
