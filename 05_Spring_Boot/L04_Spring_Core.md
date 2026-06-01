# 📖 Spring 核心概念 — IoC / DI / AOP

## ⭐ IoC（控制反转）+ DI（依赖注入）

### 什么意思？

**不用 Spring 之前（手动创建对象）：**
```java
// 自己 new 对象，自己管理依赖关系
UserMapper userMapper = new UserMapper();
UserService userService = new UserServiceImpl(userMapper);
UserController controller = new UserController(userService);
```

**用 Spring 之后（框架帮你管理）：**
```java
@Service
public class UserServiceImpl implements UserService {

    @Autowired  // Spring 自动帮你创建并注入 UserMapper
    private UserMapper userMapper;
}
```

> ⭐ **IoC = 对象的创建和管理交给 Spring 容器**
> ⭐ **DI = Spring 自动把依赖的对象"注入"进来**

### 常用注入方式

```java
// 方式1：字段注入（最简洁，项目中最常见）
@Autowired
private UserMapper userMapper;

// 方式2：构造器注入（推荐，但代码较多）
private final UserMapper userMapper;

public UserServiceImpl(UserMapper userMapper) {
    this.userMapper = userMapper;
}

// 方式3：配合 Lombok 简化构造器注入
@Service
@RequiredArgsConstructor          // Lombok 自动生成构造器
public class UserServiceImpl {
    private final UserMapper userMapper;  // final 字段自动注入
}
```

### Spring 管理的组件注解

| 注解 | 用在哪 | 说明 |
|---|---|---|
| `@Controller` / `@RestController` | Controller 层 | 控制器 |
| `@Service` | Service 层 | 服务类 |
| `@Repository` | Mapper/DAO 层 | 数据访问类 |
| `@Component` | 通用 | 其他组件（工具类等） |
| `@Configuration` | 配置类 | 配置类（替代 XML 配置）|

> 💡 加了这些注解的类，Spring 会自动创建实例并管理

---

## ⭐ AOP（面向切面编程）

### 什么意思？

> AOP = **在不修改原有代码的情况下，统一添加额外功能**

比如：你有 100 个方法，都需要记录日志。
不用 AOP：在每个方法里手动加日志代码（重复 100 次 😱）
用 AOP：写一个切面，自动给所有方法加日志（写一次 😇）

### 实际场景
- 日志记录（记录每个接口的调用时间、参数）
- 权限校验（检查用户是否有权限）
- 事务管理（`@Transactional`）
- 接口耗时统计

### 示例：统一记录接口耗时
```java
@Aspect                           // 标记为切面
@Component
@Slf4j                            // Lombok 日志
public class LogAspect {

    // 拦截 controller 包下的所有方法
    @Around("execution(* com.example.controller.*.*(..))")
    public Object logTime(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        String methodName = point.getSignature().getName();

        Object result = point.proceed();  // 执行原方法

        long cost = System.currentTimeMillis() - start;
        log.info("接口 {} 耗时 {} ms", methodName, cost);

        return result;
    }
}
```

> 💡 **初学者只需要知道 AOP 的概念和 `@Transactional` 的用法即可**
> 复杂的切面逻辑，让 AI 帮你写

---

## ⭐ @Transactional（事务管理，必须掌握！）

```java
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StockMapper stockMapper;

    @Transactional  // ⭐ 加上这个注解，方法内多个数据库操作要么全成功，要么全失败
    public void createOrder(Order order) {
        // 1. 创建订单
        orderMapper.insert(order);

        // 2. 扣减库存
        stockMapper.decrease(order.getProductId(), order.getQuantity());

        // 如果第2步失败，第1步也会自动回滚（撤销）！
    }
}
```

> ⭐ 什么时候用 `@Transactional`？
> **一个方法里有多个数据库写操作（增/删/改），需要保证一致性时用**
