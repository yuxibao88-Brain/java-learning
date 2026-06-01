# 📖 消息队列 — RabbitMQ

## ⭐ 消息队列是什么？

> 消息队列 = **异步通信的中转站**
> A 系统把消息"扔"进队列，B 系统从队列"取"出来处理

```
不用消息队列：用户注册 → 写数据库 → 发邮件 → 发短信 → 返回（串行，慢！）
用消息队列：  用户注册 → 写数据库 → 发消息到队列 → 立即返回（快！）
                                        ↓
                              邮件服务异步消费 → 发邮件
                              短信服务异步消费 → 发短信
```

---

## ⭐ 使用场景

| 场景 | 说明 |
|---|---|
| **异步处理** | 注册后发邮件/短信、下单后通知仓库 |
| **削峰填谷** | 秒杀活动时把大量请求放队列慢慢处理 |
| **系统解耦** | A 系统不直接调 B 系统，通过队列解耦 |

---

## ⭐ Spring Boot 整合 RabbitMQ

### 1. 安装 RabbitMQ（Docker）
```bash
docker run -d --name rabbitmq \
  -p 5672:5672 -p 15672:15672 \
  rabbitmq:3-management

# 管理界面：http://localhost:15672
# 账号密码：guest / guest
```

### 2. 添加依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```

### 3. 配置
```yaml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
```

### 4. 发送消息（生产者）
```java
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void register(User user) {
        // 1. 保存用户到数据库
        userMapper.insert(user);

        // 2. 发送消息到队列（异步处理邮件通知）
        rabbitTemplate.convertAndSend("user.register", user.getEmail());

        // 立即返回，不等邮件发完
    }
}
```

### 5. 接收消息（消费者）
```java
@Component
@Slf4j
public class EmailConsumer {

    @RabbitListener(queues = "user.register")
    public void handleRegister(String email) {
        log.info("收到注册消息，发送邮件到: {}", email);
        // 发送邮件逻辑...
    }
}
```

---

## 💡 RabbitMQ vs Kafka

| 对比 | RabbitMQ | Kafka |
|---|---|---|
| 适合场景 | 业务系统（订单、通知） | 大数据（日志、监控） |
| 吞吐量 | 万级 | 百万级 |
| 消息可靠性 | 高（确认机制完善） | 高 |
| 学习难度 | 简单 | 较复杂 |
| 推荐 | 中小项目首选 ✅ | 大数据场景 |

> 💡 初学者先学 RabbitMQ，够用了
