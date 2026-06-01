# 📖 Git — 代码版本管理

## ⭐ Git 是什么？

> Git = **代码的时光机**，可以记录每次修改、随时回退、多人协作

---

## ⭐ 必须掌握的命令（每天都用）

### 基本工作流
```bash
# 1. 查看当前状态（哪些文件被修改了）
git status

# 2. 把修改的文件添加到暂存区
git add .                    # 添加所有修改的文件
git add src/Main.java        # 只添加指定文件

# 3. 提交到本地仓库
git commit -m "✨ feat: 添加用户登录功能"

# 4. 推送到远程仓库
git push

# 5. 拉取远程最新代码
git pull
```

> ⭐ 日常工作流：`git add .` → `git commit -m "描述"` → `git push`

### 查看历史
```bash
# 查看提交历史
git log --oneline -10        # 简洁模式，显示最近10条

# 查看某个文件的修改历史
git log --oneline src/Main.java

# 查看具体改了什么
git diff                     # 查看未暂存的修改
git diff --staged            # 查看已暂存的修改
```

---

## ⭐ 分支操作（团队协作必备）

```bash
# 查看所有分支
git branch                   # 本地分支
git branch -a                # 包含远程分支

# 创建并切换到新分支
git checkout -b feature/login

# 切换分支
git checkout main
git checkout develop

# 合并分支（先切到目标分支，再 merge）
git checkout main
git merge feature/login

# 删除已合并的分支
git branch -d feature/login
```

### 💡 常见分支模型
```
main        ← 线上正式版本（只合并，不直接改）
  └── develop   ← 开发主分支
        ├── feature/login    ← 功能分支（开发新功能）
        ├── feature/order    ← 功能分支
        └── fix/bug-123      ← 修复分支
```

---

## ⭐ 远程仓库（GitHub / Gitee）

### 首次关联远程仓库
```bash
# 初始化本地仓库
git init

# 关联远程仓库
git remote add origin https://github.com/你的用户名/项目名.git

# 首次推送
git push -u origin main
```

### 克隆已有项目
```bash
git clone https://github.com/xxx/project.git
```

---

## ⭐ 撤销操作

```bash
# 撤销工作区的修改（还没 add）
git checkout -- src/Main.java

# 撤销暂存（已 add，还没 commit）
git reset HEAD src/Main.java

# 撤销最近一次 commit（保留修改）
git reset --soft HEAD~1

# ⚠️ 撤销最近一次 commit（丢弃修改，危险！）
git reset --hard HEAD~1
```

---

## ⭐ .gitignore 文件

> 告诉 Git 哪些文件不要管（不要提交到仓库）

```gitignore
# Java 编译产物
target/
*.class
*.jar

# IDE 配置文件
.idea/
*.iml
.vscode/

# 系统文件
.DS_Store
Thumbs.db

# 日志和临时文件
*.log
*.tmp

# 环境配置（包含密码，不能提交！）
.env
application-local.yml
```

---

## 💡 常见问题

### 合并冲突怎么办？
```
1. git pull 时发现冲突
2. 打开冲突文件，会看到：
   <<<<<<< HEAD
   你的代码
   =======
   别人的代码
   >>>>>>> branch-name
3. 手动选择保留哪个（或合并两者）
4. 删除 <<<<<<< ======= >>>>>>> 标记
5. git add . → git commit → git push
```

### 提交了不该提交的文件？
```bash
# 从 Git 中删除追踪，但保留本地文件
git rm --cached 文件名
```

> 💡 **工作中的 Git 大部分操作用 IDEA 的 Git 面板就能搞定**（提交、推送、拉取、解决冲突），命令行只在特殊情况下用
