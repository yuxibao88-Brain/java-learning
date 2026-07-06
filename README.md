# 📖 Java + AI 全栈学习大纲

本仓库面向已有前端经验的开发者，目标不是从零慢慢转传统 Java 后端，而是补齐后端能力，并逐步具备独立交付 AI 应用的能力。

核心路线：

前端能力保留 → Java 后端基础 → 数据库与接口 → Spring Boot 项目 → AI 接入 → 知识库问答 → 完整 AI 全栈作品 → 部署上线

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

## 🎓 精华学习路线：从前端到 AI 全栈工程师

> 下面是一条更适合 5 年前端开发者的成长路线：不追求“学完 Java”，而是每个阶段都做出可运行成果。

### 📍 第一站：Java 语法基础（约 2 周）

- 完成本仓库 **L01 ~ L12** 全部课程
- 重点掌握 Java 语法、类与对象、集合、异常、常用工具类
- 不急着深入 JVM、多线程底层和复杂设计模式
- 🏆 **通关标志**：能独立写出一个“控制台版任务管理/学生管理”小程序

### 📍 第二站：数据库与 SQL（约 1~2 周）

- 学习 MySQL 表设计、增删改查、分页、条件查询
- 重点练习接口背后的数据结构设计
- 🏆 **通关标志**：能设计并操作一个“用户 + 文章 + 标签”数据库

### 📍 第三站：工程化工具链（约 1 周）

- **Maven**：Java 项目的标准构建工具，自动管理第三方 jar 包依赖
- **Git**：代码版本管理神器，学会 `add`、`commit`、`push`、`pull`、分支合并
- **IDEA 快捷键**：熟练使用 IntelliJ IDEA 开发工具，提升编码效率
- 🏆 **通关标志**：能用 Maven 创建项目，并把代码推送到 GitHub/Gitee 仓库

### 📍 第四站：Spring Boot 框架（约 3 周）

- 学习 Controller、Service、Mapper 三层结构
- 学习 MyBatis-Plus、统一返回、统一异常、参数校验、登录鉴权、文件上传
- 🏆 **通关标志**：完成一个“用户注册登录 + 增删改查”的后端接口项目

### 📍 第五站：前后端联调（约 1~2 周）

- 用 Vue/React 调用 Spring Boot 接口
- 统一处理登录态、接口错误、列表分页、表单提交、文件上传
- 🏆 **通关标志**：完成一个可在浏览器操作的“AI 笔记管理系统”基础版

### 📍 第六站：AI 接入（约 2 周）

- 学习大模型 API 调用、Prompt、流式输出、对话历史、超时和错误处理
- 把 AI 能力接入已有项目，而不是单独写 demo
- 🏆 **通关标志**：实现 AI 总结、自动生成标题、提取待办、周报生成

### 📍 第七站：知识库问答 RAG（约 3 周）

- 学习文档上传、内容切分、向量化、相似内容检索、引用来源展示
- 重点理解“让 AI 基于你的资料回答”的完整流程
- 🏆 **通关标志**：完成一个“个人知识库问答系统”

### 📍 第八站：完整 AI 全栈项目（约 2 周）

- 整合登录、笔记、文件、AI 总结、AI 问答、知识库、后台管理
- 重点打磨交互体验和作品完整度
- 🏆 **通关标志**：形成一个可展示、可写进简历的 AI 全栈作品

### 📍 第九站：部署上线（约 1~2 周）

- 学习 Linux、Docker、Nginx、前后端部署、数据库部署、环境变量、日志查看
- 🏆 **通关标志**：项目成功上线，并拥有可访问地址

### 📍 第十站：进阶深入（持续学习）

- **多线程与并发编程**：`synchronized`、线程池、`CompletableFuture`
- **JVM 虚拟机调优**：内存模型、垃圾回收机制、性能排查
- **微服务架构**：Spring Cloud、服务注册与发现、网关、链路追踪
- **设计模式**：单例、工厂、策略、观察者等 23 种经典模式

---

### 🗓️ 总时间预估

| 阶段 | 内容 | 预估周期 |
|:---|:---|:---|
| 第一站 | Java 语法基础（本仓库） | 2 周 |
| 第二站 | MySQL 数据库 | 1~2 周 |
| 第三站 | Maven + Git 工具链 | 1 周 |
| 第四站 | Spring Boot（核心） | 3 周 |
| 第五站 | 前后端联调 | 1~2 周 |
| 第六站 | AI 接入 | 2 周 |
| 第七站 | 知识库问答 RAG | 3 周 |
| 第八站 | 完整 AI 全栈项目 | 2 周 |
| 第九站 | Linux / Docker 部署 | 1~2 周 |
| **合计** | **从前端到 AI 全栈作品上线** | **约 3~4 个月** |

> 💡 **建议**：每完成一站，都动手做一个小项目巩固。
> 看 10 遍不如自己写 1 遍，写 10 遍不如调 1 个 Bug！

---

## 🧭 推荐学习顺序

```text
01_Java_Basics
02_Database_SQL
03_Maven_Git
05_Spring_Boot
06_Frontend_Backend
10_AI_Integration
11_RAG_Knowledge_Base
12_AI_Fullstack_Project
13_Deployment_AI_App
```

以下内容可以作为补充学习，不必太早深入：

```text
04_Java_Web
07_Middleware
08_DevOps
09_Advanced_Topics
```
