# 📖 Java 学习大纲

欢迎来到 Java 学习之旅！本大纲整理了 12 门核心课程，分为三个递进阶段。

---

## 🟢 第一阶段：语法基本功 (stage1_basics)
> 目标：掌握基础的程序逻辑，学会命令电脑做选择、重复工作和处理数据。

- 🚀 **L01: Hello World**
  - **文件**：[L01_HelloWorld.java](01_Java_Basics/stage1_basics/L01_HelloWorld.java)
  - **要点**：程序入口 `main` 方法、屏幕打印 `System.out.println`、分号结束符。

- 📦 **L02: 变量与数据类型**
  - **文件**：[L02_Variables.java](01_Java_Basics/stage1_basics/L02_Variables.java)
  - **要点**：8种基本数据类型（如 `int`, `double`）、类型强制与自动转换、常量 `final`。

- ❓ **L03: 条件选择**
  - **文件**：[L03_Conditionals.java](01_Java_Basics/stage1_basics/L03_Conditionals.java)
  - **要点**：条件分支判断（`if-else` 分支、`switch-case` 选择）。

- 🔄 **L04: 循环控制**
  - **文件**：[L04_Loops.java](01_Java_Basics/stage1_basics/L04_Loops.java)
  - **要点**：循环结构（`for` 循环、`while` 循环）以及中断关键字 `break`/`continue`。

- 🗄️ **L05: 数组操作**
  - **文件**：[L05_Arrays.java](01_Java_Basics/stage1_basics/L05_Arrays.java)
  - **要点**：一维和二维数组的创建与遍历、常见排序与查找。

- 🔤 **L06: 字符串处理**
  - **文件**：[L06_Strings.java](01_Java_Basics/stage1_basics/L06_Strings.java)
  - **要点**：`String` 的不可变特性、常见字符串处理 API、`StringBuilder` 的拼接。

---

## 🔵 第二阶段：面向对象编程 OOP (stage2_oop)
> 目标：理解 Java 的核心灵魂，学会用代码抽象和模拟现实世界。

- 🧱 **L07: 类与对象基础**
  - **文件**：[L07_OOP_Basics.java](01_Java_Basics/stage2_oop/L07_OOP_Basics.java) (搭配 [Person.java](01_Java_Basics/stage2_oop/Person.java))
  - **要点**：类的定义、构造方法、`private` 封装与 getter/setter 校验、`this` 关键字。

- 🧬 **L08: 继承与重写**
  - **文件**：[L08_Inheritance.java](01_Java_Basics/stage2_oop/L08_Inheritance.java)
  - **要点**：`extends` 继承、`super` 调用父类、`@Override` 方法重写。

- 🎭 **L09: 多态与转换**
  - **文件**：[L09_Polymorphism.java](01_Java_Basics/stage2_oop/L09_Polymorphism.java)
  - **要点**：多态特征、“父类引用指向子类对象”、向上/向下转型、`instanceof`。

- 📜 **L10: 接口与抽象类**
  - **文件**：[L10_Interfaces.java](01_Java_Basics/stage2_oop/L10_Interfaces.java)
  - **要点**：`abstract` 抽象类定义、`interface` 接口的实现与契约设计。

---

## 🟡 第三阶段：开发常用高级工具 (stage3_advanced)
> 目标：掌握 Java 最实用的内置工具与防崩溃容错机制。

- 🗃️ **L11: 集合框架**
  - **文件**：[L11_Collections.java](01_Java_Basics/stage3_advanced/L11_Collections.java)
  - **要点**：`List` (动态数组)、`Set` (去重集合)、`Map` (键值对)、泛型与包装类。

- 🛡️ **L12: 异常处理**
  - **文件**：[L12_Exceptions.java](01_Java_Basics/stage3_advanced/L12_Exceptions.java)
  - **要点**：异常分类、`try-catch-finally` 语法、`throw` / `throws` 传递异常。

---

## 🎓 精华学习路线：从零基础到 Java 工程师

> 下面是一条经过精心梳理的 **Java 后端工程师成长路线**，按照时间顺序排列。
> 每一步都标注了预估学习周期和推荐的练手项目，帮助您把握节奏。

### 📍 第一站：Java 语法基础（当前阶段，约 2~3 周）

- 完成本仓库 **L01 ~ L12** 全部课程
- 每节课亲手敲代码、修改参数、观察输出变化
- 🏆 **通关标志**：能独立写出一个"控制台版学生成绩管理系统"
  - 用到变量、循环、数组/集合、类与对象、异常处理

### 📍 第二站：数据库与 SQL（约 1~2 周）

- 学习 **MySQL** 数据库的安装和使用
- 掌握 SQL 四大操作：增（INSERT）、删（DELETE）、改（UPDATE）、查（SELECT）
- 学习表的设计：主键、外键、索引、一对多/多对多关系
- 🏆 **通关标志**：能用 SQL 语句设计并操作一个"图书管理"数据库

### 📍 第三站：工程化工具链（约 1 周）

- **Maven**：Java 项目的标准构建工具，自动管理第三方 jar 包依赖
- **Git**：代码版本管理神器，学会 `add`、`commit`、`push`、`pull`、分支合并
- **IDEA 快捷键**：熟练使用 IntelliJ IDEA 开发工具，提升编码效率
- 🏆 **通关标志**：能用 Maven 创建项目，并把代码推送到 GitHub/Gitee 仓库

### 📍 第四站：Java Web 基础（约 1~2 周）

- 理解 **HTTP 协议**：请求方法（GET/POST）、状态码（200/404/500）、请求头与响应体
- 学习 **Servlet**（了解即可，知道底层原理）
- 学习 **JSON 数据格式**：前后端数据交换的通用语言
- 🏆 **通关标志**：理解浏览器发请求 → 服务器处理 → 返回数据的完整流程

### 📍 第五站：Spring Boot 框架（核心重点，约 3~4 周）

- **Spring Boot**：现代 Java 后端开发的绝对核心框架
  - 学习 Controller（接收请求）→ Service（业务逻辑）→ Mapper（操作数据库）三层架构
  - 学习 RESTful API 设计规范
- **MyBatis / MyBatis-Plus**：用 Java 代码优雅地操作 MySQL 数据库
- **Spring 核心概念**：IoC 控制反转、DI 依赖注入、AOP 面向切面编程
- 🏆 **通关标志**：独立完成一个 **"用户注册登录 + 增删改查"** 的完整后端项目

### 📍 第六站：前后端联调（约 1~2 周）

- 了解前端基础：HTML + CSS + JavaScript（不需要精通）
- 学习 **Vue.js** 前端框架的基本用法
- 掌握前后端分离架构：前端发 Ajax/Axios 请求 → 后端返回 JSON 数据
- 🏆 **通关标志**：前后端联合完成一个可在浏览器操作的"待办事项管理系统"

### 📍 第七站：常用中间件（约 2~3 周）

- **Redis**：内存缓存数据库，把热点数据放内存里，让系统快 100 倍
- **RabbitMQ / Kafka**：消息队列，用于系统间异步通信和削峰填谷
- **Nginx**：反向代理与负载均衡，将用户请求分发到多台服务器
- 🏆 **通关标志**：在项目中实现"缓存用户登录状态"和"异步发送邮件通知"

### 📍 第八站：部署与运维（约 1~2 周）

- **Linux 基础**：学会在服务器上操作文件、安装软件、查看日志
- **Docker**：用容器技术一键打包和部署你的 Java 应用
- **云服务器**：将项目部署到阿里云/腾讯云，让全世界都能访问你的系统
- 🏆 **通关标志**：你的项目成功上线，朋友通过域名就能访问！

### 📍 第九站：进阶深入（持续学习）

- **多线程与并发编程**：`synchronized`、线程池、`CompletableFuture`
- **JVM 虚拟机调优**：内存模型、垃圾回收机制、性能排查
- **微服务架构**：Spring Cloud、服务注册与发现、网关、链路追踪
- **设计模式**：单例、工厂、策略、观察者等 23 种经典模式

---

### 🗓️ 总时间预估

| 阶段 | 内容 | 预估周期 |
|:---|:---|:---|
| 第一站 | Java 语法基础（本仓库） | 2~3 周 |
| 第二站 | MySQL 数据库 | 1~2 周 |
| 第三站 | Maven + Git 工具链 | 1 周 |
| 第四站 | Java Web 基础 | 1~2 周 |
| 第五站 | Spring Boot（核心） | 3~4 周 |
| 第六站 | 前后端联调 | 1~2 周 |
| 第七站 | Redis / 消息队列 | 2~3 周 |
| 第八站 | Linux / Docker 部署 | 1~2 周 |
| **合计** | **从零到独立做项目** | **约 3~5 个月** |

> 💡 **建议**：每完成一站，都动手做一个小项目巩固。
> 看 10 遍不如自己写 1 遍，写 10 遍不如调 1 个 Bug！
