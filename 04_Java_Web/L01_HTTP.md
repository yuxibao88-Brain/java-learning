# 📖 HTTP 协议 — 前后端通信的基础

## ⭐ HTTP 是什么？

> HTTP = **浏览器和服务器之间的"通话规则"**

```
用户点击按钮 → 浏览器发送 HTTP 请求 → 服务器处理 → 返回 HTTP 响应 → 浏览器展示
```

---

## ⭐ 请求方法（最常用的 4 个）

| 方法 | 用途 | 示例 |
|---|---|---|
| **GET** | 查询数据 | 获取用户列表、查看文章详情 |
| **POST** | 新增数据 | 注册用户、发表文章 |
| **PUT** | 修改数据 | 修改用户信息、编辑文章 |
| **DELETE** | 删除数据 | 删除文章、注销账号 |

> 💡 这就是 **RESTful API** 的核心思想：用不同的 HTTP 方法表示不同的操作

### RESTful API 设计示例
```
GET    /api/users          → 获取所有用户
GET    /api/users/1        → 获取 ID=1 的用户
POST   /api/users          → 创建新用户
PUT    /api/users/1        → 修改 ID=1 的用户
DELETE /api/users/1        → 删除 ID=1 的用户
```

---

## ⭐ HTTP 状态码（必须记住的）

| 状态码 | 含义 | 说明 |
|---|---|---|
| **200** | OK | 请求成功 ✅ |
| **201** | Created | 创建成功 |
| **400** | Bad Request | 请求参数错误（前端的锅）|
| **401** | Unauthorized | 未登录/未授权 |
| **403** | Forbidden | 没有权限 |
| **404** | Not Found | 资源不存在（URL 写错了）|
| **500** | Internal Server Error | 服务器内部错误（后端的锅 😅）|

> 💡 简单记忆：**2xx 成功，4xx 前端问题，5xx 后端问题**

---

## ⭐ 请求和响应的结构

### HTTP 请求
```
POST /api/users HTTP/1.1              ← 请求行（方法 + URL + 协议版本）
Host: api.example.com                 ← 请求头
Content-Type: application/json        ← 告诉服务器：我发的是 JSON 格式
Authorization: Bearer eyJhbGci...     ← 认证信息（登录后的 token）

{                                     ← 请求体（Body）
    "name": "张三",
    "age": 25
}
```

### HTTP 响应
```
HTTP/1.1 200 OK                       ← 状态行
Content-Type: application/json        ← 响应头

{                                     ← 响应体
    "code": 200,
    "message": "成功",
    "data": {
        "id": 1,
        "name": "张三"
    }
}
```

---

## ⭐ 常见请求头

| 请求头 | 说明 | 常见值 |
|---|---|---|
| Content-Type | 请求体的格式 | `application/json`（最常用） |
| Authorization | 认证信息 | `Bearer <token>` |
| Accept | 期望的响应格式 | `application/json` |
| Cookie | Cookie 信息 | 自动携带 |

---

## ⭐ 统一响应格式（实际项目中的标准）

> 实际项目中后端返回的 JSON 通常有统一格式：

```json
{
    "code": 200,         // 业务状态码
    "message": "操作成功", // 提示信息
    "data": {             // 实际数据
        "id": 1,
        "name": "张三"
    }
}
```

```json
{
    "code": 500,
    "message": "用户名已存在",
    "data": null
}
```

---

## 💡 GET vs POST 的区别

| 对比项 | GET | POST |
|---|---|---|
| 参数位置 | URL 上（?name=张三&age=25） | 请求体里（Body） |
| 安全性 | 低（参数暴露在 URL） | 高（参数在 Body 中） |
| 数据大小 | 有限制（URL 长度限制） | 无限制 |
| 用途 | 查询 | 新增/修改 |
| 可缓存 | 可以 | 不可以 |

> 💡 查询用 GET，提交数据用 POST，这是最基本的原则
