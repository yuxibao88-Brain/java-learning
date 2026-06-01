# 📖 微服务架构概览

> 💡 这是高级话题，了解概念和整体架构即可
> 等工作中实际用到再深入学习

---

## ⭐ 单体架构 vs 微服务架构

### 单体架构（Monolithic）

```
一个 Spring Boot 项目包含所有功能：
├── 用户模块
├── 订单模块
├── 商品模块
├── 支付模块
└── 通知模块
→ 打成一个 jar，部署在一台服务器上
```

**优点**：简单、开发快、适合小项目
**缺点**：项目大了以后，改一个模块要重新部署整个项目

### 微服务架构（Microservices）

```
每个模块是独立的服务，独立部署：
用户服务 (user-service)      → 端口 8081
订单服务 (order-service)      → 端口 8082
商品服务 (product-service)    → 端口 8083
支付服务 (payment-service)    → 端口 8084
→ 通过 HTTP / RPC 互相调用
```

**优点**：独立部署、独立扩展、技术栈灵活
**缺点**：运维复杂、需要处理分布式问题

> 💡 **小项目用单体，大项目用微服务**
> 初学者先掌握单体架构（Spring Boot），再学微服务

---

## ⭐ Spring Cloud 核心组件

| 组件          | 作用                      | 类比               |
| ------------- | ------------------------- | ------------------ |
| **Nacos**     | 服务注册与发现 + 配置中心 | 通讯录（谁在哪里） |
| **OpenFeign** | 服务间调用                | 打电话给别的服务   |
| **Gateway**   | API 网关                  | 门卫（统一入口）   |
| **Sentinel**  | 限流熔断                  | 保险丝（防止雪崩） |
| **Seata**     | 分布式事务                | 跨服务的一致性保证 |

### 架构图

```
客户端请求
    ↓
Gateway（网关）— 统一入口、鉴权、限流
    ↓
Nacos（注册中心）— 服务注册与发现
    ├── user-service
    ├── order-service ←→ OpenFeign ←→ product-service
    └── payment-service

各服务 → MySQL / Redis / MQ
```

---

## ⭐ 服务间调用（OpenFeign）

```java
// 1. 定义 Feign 客户端
@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/api/products/{id}")
    Product getById(@PathVariable Long id);
}

// 2. 在 Order 服务中调用 Product 服务
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductClient productClient;

    public Order createOrder(Long productId, Integer quantity) {
        // 调用商品服务获取商品信息（就像调用本地方法一样！）
        Product product = productClient.getById(productId);

        Order order = new Order();
        order.setProductName(product.getName());
        order.setPrice(product.getPrice() * quantity);
        orderMapper.insert(order);
        return order;
    }
}
```

---

## 💡 什么时候用微服务？

| 条件                 | 建议         |
| -------------------- | ------------ |
| 团队 < 5 人          | 单体架构     |
| 项目初期             | 单体架构     |
| 团队 > 10 人         | 考虑微服务   |
| 需要独立扩展某些模块 | 微服务       |
| 学习阶段             | 先学好单体！ |

> ⭐ **忠告：不要为了微服务而微服务！**
> 先把 Spring Boot 单体架构学好，微服务是在此基础上的扩展

---

## 🎓 恭喜！

走到这里，你已经对 Java 后端开发的全貌有了完整的认知：

```
Java 基础 → SQL → Maven/Git → HTTP → Spring Boot → 前后端联调
    → Redis/MQ → Docker 部署 → 多线程 → JVM → 设计模式 → 微服务
```

**接下来最重要的事：动手做项目！**

推荐练手项目：

1. **博客系统**：用户注册登录 + 文章 CRUD + 评论
2. **商城系统**：商品管理 + 购物车 + 订单 + 支付
3. **后台管理系统**：RBAC 权限 + 数据看板 + 导出报表

> 💡 做项目过程中遇到的问题，随时问 AI 就好！
