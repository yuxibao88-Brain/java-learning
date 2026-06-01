# 📖 常用设计模式

> 💡 设计模式有 23 种，掌握以下几个常用的即可
> 复杂的模式实现让 AI 帮你写，你需要知道什么场景用什么模式

---

## ⭐ 1. 单例模式（Singleton）

> 全局只有一个实例（比如配置类、连接池）

```java
// 最简单的写法（推荐 ✅）
public class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();

    private AppConfig() {}  // 私有构造，防止外部 new

    public static AppConfig getInstance() {
        return INSTANCE;
    }
}

// 💡 在 Spring 中，所有 @Service @Component 默认就是单例的！不需要手动实现
```

---

## ⭐ 2. 工厂模式（Factory）

> 根据条件创建不同的对象，隐藏创建细节

```java
// 简单工厂
public class PaymentFactory {

    public static PaymentService create(String type) {
        switch (type) {
            case "alipay":  return new AlipayService();
            case "wechat":  return new WechatPayService();
            case "bank":    return new BankPayService();
            default: throw new RuntimeException("不支持的支付方式: " + type);
        }
    }
}

// 使用
PaymentService payment = PaymentFactory.create("alipay");
payment.pay(100.0);

// 💡 Spring 中更常用的做法：用 @Autowired 注入 Map<String, PaymentService>
```

---

## ⭐ 3. 策略模式（Strategy）

> 把一组算法封装起来，可以互相替换

```java
// 定义策略接口
public interface DiscountStrategy {
    double calculate(double price);
}

// 不同策略
public class NormalDiscount implements DiscountStrategy {
    public double calculate(double price) { return price; }
}

public class VipDiscount implements DiscountStrategy {
    public double calculate(double price) { return price * 0.8; }
}

public class SuperVipDiscount implements DiscountStrategy {
    public double calculate(double price) { return price * 0.6; }
}

// 使用
DiscountStrategy strategy = new VipDiscount();
double finalPrice = strategy.calculate(100.0);  // 80.0

// 💡 策略模式 + Spring 注入 = 超级好用
// @Autowired Map<String, DiscountStrategy> strategies;
```

---

## ⭐ 4. 模板方法模式（Template Method）

> 定义算法骨架，具体步骤由子类实现

```java
// 抽象模板
public abstract class DataExporter {

    // 模板方法：定义固定流程
    public final void export() {
        queryData();        // 第1步：查询数据
        processData();      // 第2步：处理数据（子类实现）
        writeFile();        // 第3步：写文件（子类实现）
        sendNotification(); // 第4步：发通知
    }

    private void queryData() {
        System.out.println("查询数据...");
    }

    protected abstract void processData();  // 子类实现
    protected abstract void writeFile();    // 子类实现

    private void sendNotification() {
        System.out.println("发送通知...");
    }
}

// Excel 导出
public class ExcelExporter extends DataExporter {
    protected void processData() { /* 处理成 Excel 格式 */ }
    protected void writeFile() { /* 写 .xlsx 文件 */ }
}

// CSV 导出
public class CsvExporter extends DataExporter {
    protected void processData() { /* 处理成 CSV 格式 */ }
    protected void writeFile() { /* 写 .csv 文件 */ }
}
```

---

## ⭐ 5. 建造者模式（Builder）

> 分步骤构建复杂对象

```java
// Lombok 直接搞定 ✅
@Data
@Builder
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

// 使用
User user = User.builder()
    .id(1L)
    .name("张三")
    .age(25)
    .email("zhangsan@example.com")
    .build();
```

---

## 💡 设计模式 vs Spring

| 设计模式 | Spring 中的应用 |
|---|---|
| 单例 | @Service/@Component 默认单例 |
| 工厂 | BeanFactory、FactoryBean |
| 代理 | AOP 动态代理 |
| 模板方法 | JdbcTemplate、RestTemplate |
| 观察者 | @EventListener 事件监听 |
| 策略 | 接口 + 多实现 + @Autowired |

> 💡 很多设计模式在 Spring 框架中已经帮你用好了，理解概念就行
