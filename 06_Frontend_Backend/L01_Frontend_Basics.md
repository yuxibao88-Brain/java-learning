# 📖 前端基础 — 后端开发者需要了解的前端知识

> 💡 作为后端开发者，不需要精通前端，但需要了解基本概念
> 能看懂前端代码、能配合前端联调就够了

---

## ⭐ HTML（骨架）

```html
<!DOCTYPE html>
<html>
<head>
    <title>我的页面</title>
</head>
<body>
    <h1>标题</h1>
    <p>段落文字</p>
    <input type="text" placeholder="请输入...">
    <button>提交</button>

    <!-- 列表 -->
    <ul>
        <li>项目1</li>
        <li>项目2</li>
    </ul>

    <!-- 表格 -->
    <table>
        <tr><th>姓名</th><th>年龄</th></tr>
        <tr><td>张三</td><td>25</td></tr>
    </table>
</body>
</html>
```

> 💡 HTML 就是搭页面结构，了解常用标签就行

---

## ⭐ CSS（样式，了解即可）

```css
/* 选择器 { 属性: 值; } */
h1 {
    color: #333;
    font-size: 24px;
}

.container {
    width: 80%;
    margin: 0 auto;     /* 居中 */
    padding: 20px;
}

button {
    background-color: #1890ff;
    color: white;
    border: none;
    padding: 8px 16px;
    border-radius: 4px;
    cursor: pointer;
}
```

> 💡 后端不用精通 CSS，有 AI 帮你写

---

## ⭐ JavaScript（逻辑，需要能看懂）

```javascript
// 变量
let name = "张三";        // 可变
const age = 25;           // 常量

// 函数
function greet(name) {
    return `你好，${name}！`;    // 模板字符串
}

// 箭头函数（简写）
const add = (a, b) => a + b;

// 数组操作
const nums = [1, 2, 3, 4, 5];
const doubled = nums.map(n => n * 2);        // [2, 4, 6, 8, 10]
const evens = nums.filter(n => n % 2 === 0); // [2, 4]

// 对象
const user = { name: "张三", age: 25 };
console.log(user.name);

// 异步请求（调用后端 API）
async function getUsers() {
    const response = await fetch('/api/users');
    const data = await response.json();
    console.log(data);
}
```

---

## ⭐ Vue 3 快速入门

> Vue 是国内最流行的前端框架（尤雨溪开发，中文文档友好）

### 核心概念
```vue
<template>
  <!-- 模板：写 HTML + 数据绑定 -->
  <div>
    <h1>{{ title }}</h1>                   <!-- 数据绑定 -->
    <input v-model="keyword" />            <!-- 双向绑定 -->
    <button @click="search">搜索</button>   <!-- 事件绑定 -->

    <!-- 列表渲染 -->
    <ul>
      <li v-for="user in users" :key="user.id">
        {{ user.name }} - {{ user.age }}岁
      </li>
    </ul>

    <!-- 条件渲染 -->
    <p v-if="users.length === 0">暂无数据</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

// 响应式数据
const title = ref('用户管理')
const keyword = ref('')
const users = ref([])

// 方法
const search = async () => {
  const { data } = await axios.get('/api/users', {
    params: { keyword: keyword.value }
  })
  users.value = data.data
}

// 页面加载时执行
onMounted(() => {
  search()
})
</script>
```

### Vue 核心语法速查
| 语法 | 作用 | 示例 |
|---|---|---|
| `{{ }}` | 文本绑定 | `{{ user.name }}` |
| `v-model` | 双向绑定（表单） | `<input v-model="name">` |
| `v-for` | 列表循环 | `v-for="item in list"` |
| `v-if / v-show` | 条件显示 | `v-if="isLogin"` |
| `@click` | 点击事件 | `@click="handleClick"` |
| `:src` | 动态属性 | `:src="imageUrl"` |
| `ref()` | 响应式变量 | `const name = ref('')` |

---

## ⭐ Axios（前端调后端 API）

```javascript
import axios from 'axios'

// 配置基础 URL
axios.defaults.baseURL = 'http://localhost:8080'

// GET 请求
const res = await axios.get('/api/users')

// GET 带参数
const res = await axios.get('/api/users', {
    params: { page: 1, size: 10 }
})

// POST 请求（发送 JSON）
const res = await axios.post('/api/users', {
    username: '张三',
    password: '123456'
})

// PUT 请求
const res = await axios.put('/api/users', { id: 1, name: '新名字' })

// DELETE 请求
const res = await axios.delete('/api/users/1')
```

---

## 💡 前端项目创建（了解即可）

```bash
# 创建 Vue 3 项目
npm create vue@latest

# 安装依赖
npm install

# 安装常用库
npm install axios                # HTTP 请求
npm install element-plus         # UI 组件库（表格、表单、弹窗等）
npm install vue-router           # 路由

# 启动开发服务器
npm run dev
```

> 💡 前端项目的搭建和配置可以让 AI 帮你完成
