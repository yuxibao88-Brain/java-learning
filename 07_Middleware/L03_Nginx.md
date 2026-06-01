# 📖 Nginx — 反向代理与负载均衡

## ⭐ Nginx 是什么？

> Nginx = **Web 服务器 + 反向代理 + 负载均衡**
> 是用户请求到达后端服务之前的"门卫"

```
用户请求 → Nginx（80端口） → 后端服务（8080端口）
                           → 后端服务（8081端口）  ← 多台服务分担压力
```

---

## ⭐ 常见用途

| 用途 | 说明 |
|---|---|
| **反向代理** | 隐藏后端真实地址，统一入口 |
| **负载均衡** | 把请求分发到多台服务器 |
| **静态资源托管** | 部署前端页面（HTML/CSS/JS）|
| **HTTPS 证书** | 配置 SSL 证书，启用 HTTPS |

---

## ⭐ 安装

```bash
# Docker（推荐）
docker run -d --name nginx -p 80:80 nginx

# macOS
brew install nginx

# 启动 / 重启 / 停止
nginx
nginx -s reload    # 重新加载配置
nginx -s stop      # 停止
```

---

## ⭐ 核心配置（nginx.conf）

### 反向代理（最常用）
```nginx
server {
    listen 80;
    server_name example.com;

    # 前端页面
    location / {
        root /usr/share/nginx/html;
        index index.html;
        try_files $uri $uri/ /index.html;   # Vue 路由必须加这行
    }

    # 后端 API 代理
    location /api/ {
        proxy_pass http://localhost:8080;     # 转发到 Spring Boot
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
    }
}
```

> 💡 这段配置的意思：
> - 访问 `example.com` → 返回前端页面
> - 访问 `example.com/api/xxx` → 转发给后端 Spring Boot

### 负载均衡
```nginx
upstream backend {
    server 192.168.1.100:8080;    # 服务器1
    server 192.168.1.101:8080;    # 服务器2
    server 192.168.1.102:8080;    # 服务器3
}

server {
    listen 80;

    location /api/ {
        proxy_pass http://backend;   # 自动分配到上面的3台服务器
    }
}
```

### HTTPS 配置
```nginx
server {
    listen 443 ssl;
    server_name example.com;

    ssl_certificate /etc/nginx/ssl/cert.pem;
    ssl_certificate_key /etc/nginx/ssl/key.pem;

    location / {
        root /usr/share/nginx/html;
    }

    location /api/ {
        proxy_pass http://localhost:8080;
    }
}

# HTTP 自动跳转 HTTPS
server {
    listen 80;
    server_name example.com;
    return 301 https://$host$request_uri;
}
```

---

## 💡 前后端部署架构

```
用户浏览器
    ↓
Nginx (80/443)
    ├── /           → 前端静态文件（Vue 打包后的 dist 目录）
    └── /api/       → 后端 Spring Boot (8080)
                          ↓
                      MySQL (3306)
                      Redis (6379)
```

> 💡 这就是最常见的生产环境部署架构
