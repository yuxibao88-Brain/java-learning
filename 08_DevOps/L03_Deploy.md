# 📖 项目部署实战

## ⭐ 完整部署流程

```
本地开发完成
    ↓
1. mvn clean package（打包 jar）
    ↓
2. 上传到服务器（scp / Git 拉取）
    ↓
3. Docker 构建镜像
    ↓
4. Docker Compose 启动所有服务
    ↓
5. 配置 Nginx + 域名
    ↓
6. 上线完成！🎉
```

---

## ⭐ Step 1：购买云服务器

推荐平台：
- **阿里云 ECS**（国内首选）
- **腾讯云 CVM**
- **华为云 ECS**

> 💡 新用户通常有优惠，2核4G 足够学习用

配置推荐：
- CPU：2核
- 内存：4G（最低 2G）
- 系统：Ubuntu 22.04 或 CentOS 7
- 带宽：5Mbps

---

## ⭐ Step 2：服务器环境准备

```bash
# 连接服务器
ssh root@你的服务器IP

# 安装 Docker
curl -fsSL https://get.docker.com | sh
systemctl enable docker
systemctl start docker

# 安装 Docker Compose
apt install docker-compose-plugin    # Ubuntu
# 或
yum install docker-compose-plugin    # CentOS

# 验证安装
docker --version
docker compose version

# 创建项目目录
mkdir -p /data/app
cd /data/app
```

---

## ⭐ Step 3：上传代码

### 方式1：Git 拉取（推荐）
```bash
cd /data/app
git clone https://github.com/你的用户名/你的项目.git
cd 你的项目
```

### 方式2：scp 上传 jar 包
```bash
# 在本地执行
scp target/app.jar root@服务器IP:/data/app/
```

---

## ⭐ Step 4：部署

```bash
cd /data/app/你的项目

# 打包（如果服务器上有源码）
# mvn clean package -DskipTests

# 一键启动所有服务
docker compose up -d

# 查看运行状态
docker compose ps

# 查看应用日志
docker compose logs -f app
```

---

## ⭐ Step 5：域名和 HTTPS

### 配置域名
1. 购买域名（阿里云万网、腾讯云 DNSPod）
2. 域名解析：添加 A 记录 → 指向服务器 IP
3. 备案（国内服务器必须备案）

### 配置 HTTPS（免费 SSL）
```bash
# 安装 certbot（Let's Encrypt 免费证书）
apt install certbot

# 获取证书
certbot certonly --standalone -d example.com

# 证书位置
# /etc/letsencrypt/live/example.com/fullchain.pem
# /etc/letsencrypt/live/example.com/privkey.pem

# 配置 Nginx 使用证书（参考第七站 L03_Nginx.md）
```

---

## ⭐ 日常运维命令

```bash
# 查看服务状态
docker compose ps

# 重启某个服务
docker compose restart app

# 更新代码后重新部署
git pull
mvn clean package -DskipTests
docker compose up -d --build app

# 查看磁盘空间
df -h

# 清理 Docker 无用资源
docker system prune -a

# 查看应用日志（最近 100 行）
docker compose logs --tail 100 app
```

---

## 💡 部署架构总结

```
互联网
  ↓
域名 DNS → 解析到服务器 IP
  ↓
服务器 (阿里云 ECS)
  ├── Nginx (80/443)        → 反向代理 + 静态资源
  │     ├── /               → 前端 Vue 打包文件
  │     └── /api/           → 代理到后端
  ├── Spring Boot (8080)    → 后端 API 服务
  ├── MySQL (3306)          → 数据库
  └── Redis (6379)          → 缓存
```

> 🎉 走到这一步，恭喜你已经能独立部署一个完整的全栈项目了！
