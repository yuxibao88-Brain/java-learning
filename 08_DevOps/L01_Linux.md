# 📖 Linux 常用命令 — 后端必备

> 💡 服务器基本都是 Linux 系统，必须会基本操作

---

## ⭐ 文件和目录操作

```bash
# 查看当前目录
pwd

# 列出文件
ls              # 简单列出
ls -la          # 详细列出（包括隐藏文件）

# 切换目录
cd /home/app    # 进入指定目录
cd ..           # 返回上级
cd ~            # 回到用户主目录

# 创建目录
mkdir -p /data/app/logs    # -p 自动创建父目录

# 复制 / 移动 / 删除
cp file.txt backup.txt           # 复制
cp -r dir1 dir2                  # 复制目录
mv file.txt /data/               # 移动
mv old.txt new.txt               # 重命名
rm file.txt                      # 删除文件
rm -rf dir/                      # 删除目录（⚠️ 慎用！）
```

---

## ⭐ 文件查看和编辑

```bash
# 查看文件内容
cat file.txt              # 全部显示
head -20 file.txt         # 显示前20行
tail -50 file.txt         # 显示后50行
tail -f app.log           # ⭐ 实时跟踪日志（开发常用！）

# 搜索内容
grep "error" app.log              # 搜索包含 error 的行
grep -i "error" app.log           # 忽略大小写
grep -n "error" app.log           # 显示行号
grep -r "TODO" /data/project/     # 递归搜索目录

# 编辑文件（vi/vim）
vi file.txt
# i → 进入编辑模式
# ESC → 退出编辑模式
# :wq → 保存并退出
# :q! → 不保存退出

# 💡 如果不熟悉 vi，可以用 nano（更简单）
nano file.txt
```

---

## ⭐ 进程和服务管理

```bash
# 查看进程
ps aux                            # 所有进程
ps aux | grep java                # 查找 Java 进程

# 杀掉进程
kill 12345                        # 正常结束（PID）
kill -9 12345                     # 强制杀死

# 查看端口占用
netstat -tlnp | grep 8080        # 查看 8080 端口
lsof -i :8080                    # 谁在用 8080 端口

# 后台运行
nohup java -jar app.jar > app.log 2>&1 &
# nohup → 不挂断
# > app.log → 输出到文件
# 2>&1 → 错误也输出到文件
# & → 后台运行
```

---

## ⭐ 系统资源监控

```bash
# 查看磁盘使用
df -h                             # 磁盘剩余空间
du -sh /data/                     # 某个目录占用大小

# 查看内存
free -h                           # 内存使用情况

# 查看 CPU 和实时进程
top                               # 实时监控（按 q 退出）
htop                              # 更好看的 top（需安装）
```

---

## ⭐ 权限和用户

```bash
# 修改权限
chmod 755 script.sh               # 给脚本添加执行权限
chmod -R 755 /data/app/           # 递归修改目录权限

# 修改所有者
chown -R app:app /data/app/       # 把目录交给 app 用户

# 切换用户
su - root                         # 切换到 root
sudo command                      # 用管理员权限执行命令
```

---

## ⭐ 常用组合命令

```bash
# 查看 Java 应用日志中的错误
tail -1000 app.log | grep -i "error"

# 查找大文件
find / -size +100M -type f 2>/dev/null

# 统计日志中某个关键词出现次数
grep -c "ERROR" app.log

# 查看系统信息
uname -a                          # 系统版本
cat /etc/os-release               # 发行版信息
```
