# 📖 前后端联调实战

## ⭐ 前后端分离架构

```
┌──────────────┐          HTTP 请求          ┌──────────────┐
│   前端 Vue    │  ───────────────────────→  │  后端 Spring  │
│  localhost:   │                             │  localhost:   │
│    5173       │  ←───────────────────────  │    8080       │
│              │         JSON 响应            │              │
└──────────────┘                             └──────────────┘
                                                    ↓
                                             ┌──────────────┐
                                             │    MySQL      │
                                             │    3306       │
                                             └──────────────┘
```

> ⭐ 前端和后端是两个独立项目，通过 HTTP + JSON 通信

---

## ⭐ 联调步骤

### 1. 后端：提供 API 接口
```java
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public Result<List<Todo>> list() {
        return Result.success(todoService.list());
    }

    @PostMapping
    public Result<Void> add(@RequestBody Todo todo) {
        todoService.save(todo);
        return Result.success();
    }

    @PutMapping("/{id}/toggle")
    public Result<Void> toggle(@PathVariable Long id) {
        todoService.toggleDone(id);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        todoService.removeById(id);
        return Result.success();
    }
}
```

### 2. 前端：调用 API
```vue
<template>
  <div class="todo-app">
    <h1>待办事项</h1>

    <!-- 添加 -->
    <div>
      <input v-model="newTodo" placeholder="添加待办..." @keyup.enter="addTodo" />
      <button @click="addTodo">添加</button>
    </div>

    <!-- 列表 -->
    <ul>
      <li v-for="todo in todos" :key="todo.id">
        <input type="checkbox" :checked="todo.done" @change="toggleTodo(todo.id)" />
        <span :class="{ done: todo.done }">{{ todo.title }}</span>
        <button @click="deleteTodo(todo.id)">删除</button>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const newTodo = ref('')
const todos = ref([])

// 获取列表
const fetchTodos = async () => {
  const { data } = await axios.get('/api/todos')
  todos.value = data.data
}

// 添加
const addTodo = async () => {
  if (!newTodo.value.trim()) return
  await axios.post('/api/todos', { title: newTodo.value })
  newTodo.value = ''
  fetchTodos()
}

// 切换完成状态
const toggleTodo = async (id) => {
  await axios.put(`/api/todos/${id}/toggle`)
  fetchTodos()
}

// 删除
const deleteTodo = async (id) => {
  await axios.delete(`/api/todos/${id}`)
  fetchTodos()
}

onMounted(fetchTodos)
</script>
```

### 3. 前端代理配置（解决跨域）
```javascript
// vite.config.js
export default {
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true
      }
    }
  }
}
```

---

## ⭐ 联调常见问题

| 问题 | 原因 | 解决 |
|---|---|---|
| **跨域错误（CORS）** | 前后端域名/端口不同 | 后端加 CorsConfig 或前端配代理 |
| **404 Not Found** | URL 路径不对 | 检查前端请求路径和后端 @RequestMapping |
| **400 Bad Request** | 参数格式不对 | 检查前端传参是否匹配后端 @RequestBody |
| **500 Internal Error** | 后端代码报错 | 看后端控制台的报错日志 |
| **数据为空** | 字段名不匹配 | 前端 JSON key 要和后端实体类字段名一致 |

---

## 💡 调试技巧

1. **浏览器 F12 → Network** 面板：查看请求和响应的详细内容
2. **后端控制台**：查看 SQL 日志和报错信息
3. **Postman / Apifox**：先用工具测试接口，确认后端没问题
4. **console.log()**：前端打印变量，排查数据问题
