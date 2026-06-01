# 📖 Spring Boot 常用功能速查

## ⭐ 参数校验

```java
// 1. 引入依赖（pom.xml）
// spring-boot-starter-validation

// 2. 在 DTO 上加校验注解
@Data
public class UserDTO {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度6-20位")
    private String password;

    @Email(message = "邮箱格式不正确")
    private String email;

    @Min(value = 0, message = "年龄不能为负数")
    @Max(value = 150, message = "年龄不合理")
    private Integer age;
}

// 3. 在 Controller 上使用 @Valid
@PostMapping("/register")
public Result register(@Valid @RequestBody UserDTO dto) {
    // 校验不通过会自动返回错误信息
}
```

---

## ⭐ 全局异常处理

```java
@RestControllerAdvice              // 全局异常处理器
public class GlobalExceptionHandler {

    // 处理参数校验异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return Result.error(message);
    }

    // 处理业务异常
    @ExceptionHandler(RuntimeException.class)
    public Result handleRuntimeException(RuntimeException e) {
        return Result.error(e.getMessage());
    }

    // 兜底：处理所有未捕获的异常
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("系统异常", e);
        return Result.error("系统繁忙，请稍后重试");
    }
}
```

> 💡 有了全局异常处理器，Controller 里就不用到处写 try-catch 了！

---

## ⭐ Lombok 常用注解

```java
@Data                    // = @Getter + @Setter + @ToString + @EqualsAndHashCode
@NoArgsConstructor       // 无参构造
@AllArgsConstructor      // 全参构造
@Builder                 // 建造者模式
@Slf4j                   // 日志（自动创建 log 变量）

// 使用示例
@Data
@Builder
public class User {
    private Long id;
    private String name;
}

// Builder 用法
User user = User.builder()
    .id(1L)
    .name("张三")
    .build();

// 日志用法
@Slf4j
@Service
public class UserServiceImpl {
    public void doSomething() {
        log.info("开始处理...");
        log.error("出错了: {}", errorMsg);
    }
}
```

---

## ⭐ 跨域配置（前后端分离必须）

```java
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("*");
            }
        };
    }
}
```

---

## ⭐ 配置文件读取

```yaml
# application.yml
app:
  name: 我的应用
  upload-path: /data/uploads
  max-file-size: 10MB
```

```java
@Component
@ConfigurationProperties(prefix = "app")
@Data
public class AppConfig {
    private String name;
    private String uploadPath;
    private String maxFileSize;
}

// 使用
@Autowired
private AppConfig appConfig;
// appConfig.getUploadPath()  → /data/uploads
```

---

## ⭐ 文件上传

```java
@PostMapping("/upload")
public Result upload(@RequestParam("file") MultipartFile file) {
    if (file.isEmpty()) {
        return Result.error("文件为空");
    }

    String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
    String filePath = "/data/uploads/" + fileName;

    try {
        file.transferTo(new File(filePath));
        return Result.success(fileName);
    } catch (IOException e) {
        return Result.error("上传失败");
    }
}
```

---

## 💡 常用依赖速查（pom.xml）

```xml
<!-- Web 开发 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- MyBatis-Plus -->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-spring-boot3-starter</artifactId>
    <version>3.5.5</version>
</dependency>

<!-- MySQL 驱动 -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<!-- 参数校验 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<!-- Hutool 工具包（可选，好用的工具集）-->
<dependency>
    <groupId>cn.hutool</groupId>
    <artifactId>hutool-all</artifactId>
    <version>5.8.25</version>
</dependency>
```
