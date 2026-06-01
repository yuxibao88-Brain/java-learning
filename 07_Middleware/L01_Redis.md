# 📖 Redis — 内存缓存数据库

## ⭐ Redis 是什么？

> Redis = **把数据放在内存里**的数据库，读写速度极快（微秒级）
> MySQL 从硬盘读：毫秒级 → Redis 从内存读：微秒级（快 100~1000 倍）

---

## ⭐ 常见使用场景

| 场景 | 说明 |
|---|---|
| **缓存热点数据** | 首页数据、商品详情、用户信息 |
| **登录 Session/Token** | 存储用户登录状态 |
| **计数器** | 点赞数、浏览量、库存 |
| **排行榜** | 用 Sorted Set 做排名 |
| **分布式锁** | 防止重复下单、重复提交 |
| **限流** | 接口访问频率控制 |

---

## ⭐ Redis 数据类型

| 类型 | 说明 | 使用场景 |
|---|---|---|
| **String** | 最简单，存字符串/数字 | 缓存、计数器、Session |
| **Hash** | 键值对集合（类似 Map） | 存对象（用户信息） |
| **List** | 有序列表 | 消息队列、最新列表 |
| **Set** | 无序集合（自动去重） | 标签、共同好友 |
| **Sorted Set** | 有序集合（带分数） | 排行榜 |

---

## ⭐ Redis 常用命令

```bash
# 启动 Redis（Docker 方式）
docker run -d --name redis -p 6379:6379 redis:7

# 连接
docker exec -it redis redis-cli

# ----- String -----
SET name "张三"           # 设置
GET name                  # 获取 → "张三"
SET token "abc123" EX 3600  # 设置并指定过期时间（3600秒）
DEL name                  # 删除
EXISTS name               # 是否存在
INCR counter              # 自增 +1
DECR counter              # 自减 -1

# ----- Hash -----
HSET user:1 name "张三"    # 设置 hash 字段
HSET user:1 age 25
HGET user:1 name          # 获取 → "张三"
HGETALL user:1            # 获取所有字段

# ----- 过期时间 -----
EXPIRE key 3600           # 设置过期时间（秒）
TTL key                   # 查看剩余时间
```

---

## ⭐ Spring Boot 整合 Redis

### 1. 添加依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

### 2. 配置
```yaml
spring:
  data:
    redis:
      host: localhost
      port: 6379
      password:           # 没设密码就留空
```

### 3. 使用 StringRedisTemplate（最常用 ✅）
```java
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    public User getById(Long id) {
        String key = "user:" + id;

        // 1. 先从 Redis 缓存中查
        String json = redisTemplate.opsForValue().get(key);
        if (json != null) {
            return JSON.parseObject(json, User.class);  // 缓存命中
        }

        // 2. 缓存没有，查数据库
        User user = userMapper.selectById(id);

        // 3. 写入缓存（设置过期时间 30 分钟）
        if (user != null) {
            redisTemplate.opsForValue().set(key,
                JSON.toJSONString(user), 30, TimeUnit.MINUTES);
        }

        return user;
    }

    // 修改/删除时，记得清除缓存！
    public void update(User user) {
        userMapper.updateById(user);
        redisTemplate.delete("user:" + user.getId());  // 清除缓存
    }
}
```

---

## ⭐ 缓存策略总结

```
读取：先查缓存 → 有则返回 → 没有则查数据库 → 写入缓存 → 返回
修改：更新数据库 → 删除缓存
删除：删除数据库 → 删除缓存
```

> ⚠️ **修改数据后一定要清除对应的缓存，否则会读到旧数据！**
