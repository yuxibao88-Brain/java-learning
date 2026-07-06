# 控制台任务管理器 — 分步指南

## 开始之前

确保你已经学完 L01~L12，理解了：
- 变量、条件、循环
- 数组、字符串操作
- 方法定义和调用
- 类与对象
- ArrayList 和 HashMap
- try-catch 异常处理

## 运行脚手架代码

```bash
cd projects/01_console_task_manager
javac TaskManager.java
java projects._01_console_task_manager.TaskManager
```

现在可以：
- 看到菜单
- 选择 1 新增任务
- 选择 2 查看任务列表
- 选择 0 退出

---

## 完成步骤

### ✅ Step 1: 菜单 + 退出（已完成）

脚手架已经帮你写好了，理解代码逻辑即可。

### ✅ Step 2: 新增任务（已完成）

`addTask()` 方法已经实现，理解 `tasks.add()` 和 `completed.add()` 的作用。

### 📝 Step 3: 标记任务完成

打开 `TaskManager.java`，找到 `markComplete()` 方法（被注释掉了）：

1. 取消注释 `markComplete()` 方法
2. 在 `run()` 方法的 `switch` 里，把 `case "3"` 改成调用 `markComplete()`
3. 运行测试

**用到的知识：**
- L03 条件判断（检查序号是否合法）
- L05 数组索引（`completed.set(index, true)`）

---

### 📝 Step 4: 删除任务

1. 取消注释 `deleteTask()` 方法
2. 在 `switch` 里把 `case "4"` 改成调用 `deleteTask()`
3. 运行测试

**用到的知识：**
- L11 ArrayList 的 `remove()` 方法
- 注意：`tasks.remove(index)` 和 `completed.remove(index)` 要同时调用

---

### 📝 Step 5: 搜索任务

1. 取消注释 `searchTask()` 方法
2. 在 `switch` 里把 `case "5"` 改成调用 `searchTask()`
3. 运行测试

**用到的知识：**
- L06 String 的 `contains()` 方法
- L04 循环遍历

---

### 📝 Step 6: 输入错误时不崩溃

现在输入非数字（如 "abc"）会崩溃，用 try-catch 保护：

```java
try {
    int index = Integer.parseInt(scanner.nextLine()) - 1;
    // ...
} catch (NumberFormatException e) {
    System.out.println("❌ 请输入数字");
}
```

**用到的知识：**
- L12 异常处理

---

## 通关标准

- [ ] 程序能正常启动，显示菜单
- [ ] 可以新增、查看、标记完成、删除、搜索任务
- [ ] 输入错误（如非数字、越界序号）时给出提示，不崩溃
- [ ] 退出后不报错

---

## 进阶挑战（可选）

完成基础功能后，可以尝试：

1. **任务分类**：给每个任务加一个分类标签（工作/学习/生活）
2. **保存到文件**：把任务保存到 txt 文件，下次启动能读取
3. **面向对象重构**：把 `Task` 抽成一个独立的类，包含 `title`、`completed`、`category` 字段

---

## 遇到问题？

1. 先看错误信息，尝试自己理解
2. 在对应课程（L01~L12）里找类似的代码
3. 让 AI 帮你解释错误，但**不要直接复制答案**
4. 把问题记到 `LEARNING_PROGRESS.md` 的问题清单里
