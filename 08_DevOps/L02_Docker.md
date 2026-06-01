# 📖 Docker — 容器化部署

## ⭐ Docker 是什么？

> Docker = **把应用和环境打包在一起**，走到哪里都能运行
>
> 不用 Docker：在我电脑上能跑，到服务器上装不上环境 😱
> 用 Docker：打包成镜像，任何机器都能跑 😇

---

## ⭐ 核心概念

| 概念 | 类比 | 说明 |
|---|---|---|
| **镜像（Image）** | 安装包 | 打包好的应用 + 环境 |
| **容器（Container）** | 运行中的程序 | 镜像的运行实例 |
| **Dockerfile** | 打包脚本 | 描述如何构建镜像 |
| **Docker Compose** | 一键启动脚本 | 同时管理多个容器 |

---

## ⭐ 常用命令

```bash
# ===== 镜像操作 =====
docker images                          # 查看所有镜像
docker pull mysql:8.0                  # 拉取镜像
docker rmi mysql:8.0                   # 删除镜像

# ===== 容器操作 =====
docker ps                              # 查看运行中的容器
docker ps -a                           # 查看所有容器（包括停止的）

# 运行容器
docker run -d \                        # -d 后台运行
  --name mysql8 \                      # 容器名
  -p 3306:3306 \                       # 端口映射（宿主机:容器）
  -e MYSQL_ROOT_PASSWORD=123456 \      # 环境变量
  -v /data/mysql:/var/lib/mysql \      # 数据挂载（持久化）
  mysql:8.0                            # 镜像名

# 停止 / 启动 / 重启 / 删除
docker stop mysql8
docker start mysql8
docker restart mysql8
docker rm mysql8                       # 删除（需先停止）

# 查看日志
docker logs mysql8                     # 查看日志
docker logs -f mysql8                  # 实时跟踪日志

# 进入容器内部
docker exec -it mysql8 bash
```

---

## ⭐ Dockerfile（打包 Java 应用）

```dockerfile
# 基础镜像
FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /app

# 复制 jar 包
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# 暴露端口
EXPOSE 8080

# 启动命令
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### 构建和运行
```bash
# 打包 Spring Boot 项目
mvn clean package -DskipTests

# 构建 Docker 镜像
docker build -t my-app:1.0 .

# 运行
docker run -d --name my-app -p 8080:8080 my-app:1.0
```

---

## ⭐ Docker Compose（一键启动多个服务）

### docker-compose.yml
```yaml
version: '3.8'

services:
  # MySQL
  mysql:
    image: mysql:8.0
    container_name: mysql
    ports:
      - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: 123456
      MYSQL_DATABASE: java_learning
    volumes:
      - ./data/mysql:/var/lib/mysql

  # Redis
  redis:
    image: redis:7
    container_name: redis
    ports:
      - "6379:6379"

  # 后端应用
  app:
    build: .
    container_name: my-app
    ports:
      - "8080:8080"
    depends_on:
      - mysql
      - redis
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://mysql:3306/java_learning
      SPRING_DATASOURCE_PASSWORD: 123456
      SPRING_DATA_REDIS_HOST: redis

  # Nginx
  nginx:
    image: nginx:latest
    container_name: nginx
    ports:
      - "80:80"
    volumes:
      - ./nginx.conf:/etc/nginx/conf.d/default.conf
      - ./dist:/usr/share/nginx/html
    depends_on:
      - app
```

### 一键启动
```bash
# 启动所有服务
docker-compose up -d

# 查看状态
docker-compose ps

# 查看日志
docker-compose logs -f app

# 停止所有
docker-compose down
```

> 💡 **Docker Compose 是部署的最佳实践**
> 一个 yml 文件管理 MySQL + Redis + 后端 + Nginx，一键启动！
