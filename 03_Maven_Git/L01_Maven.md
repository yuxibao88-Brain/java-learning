# 📖 Maven — Java 项目构建工具

## ⭐ Maven 是什么？

> Maven = **依赖管理** + **项目构建** 的自动化工具

不用 Maven 之前：手动下载 jar 包 → 放到 lib 目录 → 配置 classpath（噩梦 😱）
用 Maven 之后：在 `pom.xml` 里写几行配置 → Maven 自动下载和管理（天堂 😇）

---

## ⭐ 核心概念

### 1. pom.xml（项目的"身份证"）

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project>
    <modelVersion>4.0.0</modelVersion>

    <!-- 项目坐标（唯一标识一个项目） -->
    <groupId>com.example</groupId>     <!-- 公司/组织名 -->
    <artifactId>my-project</artifactId> <!-- 项目名 -->
    <version>1.0.0</version>            <!-- 版本号 -->

    <!-- 依赖管理（需要什么第三方库，在这里声明） -->
    <dependencies>
        <!-- 例如：引入 MySQL 驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version>
        </dependency>
    </dependencies>
</project>
```

> 💡 需要什么依赖？去 [mvnrepository.com](https://mvnrepository.com/) 搜索，复制粘贴到 pom.xml

### 2. 项目结构（标准约定）

```
my-project/
├── pom.xml                          ← 项目配置文件
├── src/
│   ├── main/
│   │   ├── java/                    ← Java 源代码
│   │   │   └── com/example/
│   │   │       └── App.java
│   │   └── resources/               ← 配置文件（application.yml 等）
│   └── test/
│       └── java/                    ← 测试代码
│           └── com/example/
│               └── AppTest.java
└── target/                          ← 编译输出（自动生成）
```

> ⭐ 记住这个结构！所有 Maven 项目都是这样的

---

## ⭐ 常用命令

```bash
# 清理（删除 target 目录）
mvn clean

# 编译
mvn compile

# 打包（生成 jar/war 文件）
mvn package

# 安装到本地仓库
mvn install

# 清理 + 打包（最常用的组合 ✅）
mvn clean package

# 跳过测试打包（赶时间时用）
mvn clean package -DskipTests
```

> 💡 实际开发中用得最多的就是 `mvn clean package`

---

## ⭐ IDEA 中使用 Maven

1. **创建项目**：File → New → Project → Maven → 选 JDK 版本
2. **添加依赖**：编辑 pom.xml → 保存 → IDEA 自动下载
3. **刷新依赖**：右侧 Maven 面板 → 点击刷新按钮 🔄
4. **运行命令**：右侧 Maven 面板 → Lifecycle → 双击 `clean`/`package`

> 💡 大部分操作在 IDEA 里点几下就行，不需要手动敲命令

---

## 💡 了解即可

### Maven 仓库层级
```
本地仓库（~/.m2/repository）
    ↓ 找不到
私服/镜像（公司内部的 Nexus）
    ↓ 找不到
中央仓库（repo.maven.apache.org）
```

### 配置阿里云镜像（国内下载更快）
编辑 `~/.m2/settings.xml`：
```xml
<mirrors>
    <mirror>
        <id>aliyun</id>
        <mirrorOf>central</mirrorOf>
        <name>阿里云仓库</name>
        <url>https://maven.aliyun.com/repository/public</url>
    </mirror>
</mirrors>
```

### 依赖范围（scope）
| scope | 说明 | 示例 |
|---|---|---|
| compile（默认） | 编译+运行都需要 | Spring Boot |
| test | 只在测试时用 | JUnit |
| runtime | 只在运行时用 | MySQL 驱动 |
| provided | 编译时用，运行时由环境提供 | Servlet API |
