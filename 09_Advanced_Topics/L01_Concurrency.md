# 📖 多线程与并发编程

> 💡 初学者掌握基本概念和线程池即可，复杂的并发问题让 AI 帮你

---

## ⭐ 什么是多线程？

> 单线程 = 一个人做事，一件做完再做下一件
> 多线程 = 多个人同时做事，效率更高

---

## ⭐ 创建线程的方式

```java
// 方式1：继承 Thread（了解即可）
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程运行中: " + Thread.currentThread().getName());
    }
}
new MyThread().start();

// 方式2：实现 Runnable（了解即可）
new Thread(() -> {
    System.out.println("Lambda 线程: " + Thread.currentThread().getName());
}).start();

// 方式3：线程池（⭐ 实际开发用这个！）
ExecutorService pool = Executors.newFixedThreadPool(5);  // 5个线程的线程池
pool.submit(() -> {
    System.out.println("线程池中的线程: " + Thread.currentThread().getName());
});
pool.shutdown();
```

---

## ⭐ 线程池（实际开发必用）

```java
// ⭐ 推荐写法：手动创建线程池（更可控）
ThreadPoolExecutor pool = new ThreadPoolExecutor(
    5,                  // 核心线程数
    10,                 // 最大线程数
    60L,                // 空闲线程存活时间
    TimeUnit.SECONDS,
    new LinkedBlockingQueue<>(100),  // 等待队列
    new ThreadPoolExecutor.CallerRunsPolicy()  // 拒绝策略
);

// 提交任务
pool.submit(() -> {
    // 耗时操作，比如发邮件、生成报表
    sendEmail(user);
});
```

### Spring Boot 中使用 @Async
```java
// 1. 启动类加 @EnableAsync
@SpringBootApplication
@EnableAsync
public class App { ... }

// 2. 方法上加 @Async
@Service
public class EmailService {

    @Async  // ⭐ 这个方法会在新线程中执行，不阻塞调用者
    public void sendEmail(String to, String content) {
        // 发送邮件（耗时操作）
    }
}

// 3. 调用时自动异步
userService.register(user);
emailService.sendEmail(user.getEmail(), "欢迎注册");  // 不等邮件发完就返回
```

---

## ⭐ 线程安全问题

```java
// ⚠️ 多个线程同时修改同一个变量，会出问题！
private int count = 0;

// 解决方案1：synchronized（加锁）
public synchronized void increment() {
    count++;
}

// 解决方案2：AtomicInteger（原子操作，性能更好）
private AtomicInteger count = new AtomicInteger(0);
count.incrementAndGet();  // 线程安全的 +1

// 解决方案3：ConcurrentHashMap（线程安全的 Map）
Map<String, String> map = new ConcurrentHashMap<>();
```

---

## 💡 CompletableFuture（异步编程，了解即可）

```java
// 异步执行，不阻塞主线程
CompletableFuture<User> future = CompletableFuture.supplyAsync(() -> {
    return userService.getById(1L);
});

// 结果处理
future.thenAccept(user -> {
    System.out.println("查到了: " + user.getName());
});
```
