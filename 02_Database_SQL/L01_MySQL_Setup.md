# 📖 MySQL 安装与连接

## ⭐ 安装 MySQL

### macOS（推荐用 Homebrew）
```bash
# 安装
brew install mysql

# 启动服务
brew services start mysql

# 设置 root 密码
mysql_secure_installation
```

### Windows
1. 下载 [MySQL Installer](https://dev.mysql.com/downloads/installer/)
2. 选择 "Developer Default" 安装
3. 安装过程中设置 root 密码（记住它！）

### Docker（推荐！最简单）
```bash
# 一行命令搞定
docker run -d --name mysql8 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql:8.0

# 连接
docker exec -it mysql8 mysql -uroot -p123456
```

---

## ⭐ 连接 MySQL

### 命令行连接
```bash
mysql -u root -p
# 输入密码后进入 MySQL 命令行
```

### 常用客户端工具（选一个就行）
| 工具 | 说明 |
|---|---|
| **Navicat** | 最经典，功能全面（付费，有试用） |
| **DBeaver** | 免费开源，支持多种数据库 |
| **DataGrip** | JetBrains 出品（和 IDEA 同家族） |
| **MySQL Workbench** | MySQL 官方工具（免费） |

> 💡 推荐初学者用 **Navicat** 或 **DBeaver**，界面直观

---

## ⭐ 第一条 SQL

```sql
-- 查看所有数据库
SHOW DATABASES;

-- 创建数据库
CREATE DATABASE IF NOT EXISTS java_learning
DEFAULT CHARACTER SET utf8mb4;

-- 使用数据库
USE java_learning;

-- 查看当前数据库中的表
SHOW TABLES;
```

> ⚠️ **编码必须用 `utf8mb4`**，不要用 `utf8`！MySQL 的 utf8 是阉割版（最多3字节），utf8mb4 才是真正的 UTF-8（支持 emoji 等4字节字符）

---

## 💡 MySQL 配置（了解即可）

```ini
# my.cnf 常用配置
[mysqld]
port = 3306
character-set-server = utf8mb4
collation-server = utf8mb4_unicode_ci
max_connections = 200
```

> 💡 生产环境的 MySQL 配置通常由 DBA 或运维负责，开发者了解即可
