package projects._01_console_task_manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ===================================
 * 🎯 控制台任务管理器 — 通关项目
 * ===================================
 *
 * 这个项目把 L01~L12 的知识串起来：
 *   - 变量、条件、循环（L01~L04）
 *   - 数组、字符串（L05~L06）
 *   - 方法（L07）
 *   - 类与对象（L08~L10）
 *   - 集合、异常处理（L11~L12）
 *
 * 📋 完成步骤（按顺序来，每步都能运行）：
 *   Step 1: 显示菜单 + 退出（已帮你写好）
 *   Step 2: 新增任务
 *   Step 3: 查看任务列表
 *   Step 4: 标记任务完成
 *   Step 5: 删除任务
 *   Step 6: 搜索任务
 *   Step 7: 输入错误时不崩溃（异常处理）
 */
public class TaskManager {

    // ========== 数据存储 ==========
    // 用 ArrayList 存储任务（比数组更灵活，可以动态增删）
    private List<String> tasks = new ArrayList<>();
    private List<Boolean> completed = new ArrayList<>();  // 每个任务是否完成

    private Scanner scanner = new Scanner(System.in);

    // ========== 主循环 ==========
    public void run() {
        System.out.println("📋 欢迎使用任务管理器！");

        boolean running = true;
        while (running) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTask();
                    break;
                case "2":
                    listTasks();
                    break;
                case "3":
                    // TODO: 实现标记完成功能
                    System.out.println("⚠️ 功能开发中...");
                    break;
                case "4":
                    // TODO: 实现删除功能
                    System.out.println("⚠️ 功能开发中...");
                    break;
                case "5":
                    // TODO: 实现搜索功能
                    System.out.println("⚠️ 功能开发中...");
                    break;
                case "0":
                    running = false;
                    System.out.println("👋 再见！");
                    break;
                default:
                    System.out.println("❌ 无效选项，请重新输入");
            }
            System.out.println();
        }
        scanner.close();
    }

    // ========== Step 1: 显示菜单（已完成）==========
    private void showMenu() {
        System.out.println("========== 菜单 ==========");
        System.out.println("1. 新增任务");
        System.out.println("2. 查看任务");
        System.out.println("3. 标记完成");
        System.out.println("4. 删除任务");
        System.out.println("5. 搜索任务");
        System.out.println("0. 退出");
        System.out.println("==========================");
        System.out.print("请选择: ");
    }

    // ========== Step 2: 新增任务 ==========
    // 💡 提示：用 scanner.nextLine() 获取用户输入，用 tasks.add() 添加
    private void addTask() {
        System.out.print("输入任务内容: ");
        String task = scanner.nextLine();
        if (task.isEmpty()) {
            System.out.println("⚠️ 任务不能为空");
            return;
        }
        tasks.add(task);
        completed.add(false);  // 新任务默认未完成
        System.out.println("✅ 已添加: " + task);
    }

    // ========== Step 3: 查看任务列表 ==========
    // 💡 提示：遍历 tasks，同时显示序号、完成状态、内容
    private void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("📭 暂无任务");
            return;
        }
        System.out.println("📋 任务列表:");
        for (int i = 0; i < tasks.size(); i++) {
            String status = completed.get(i) ? "✅" : "⬜";
            System.out.println("  " + (i + 1) + ". " + status + " " + tasks.get(i));
        }
    }

    // ========== Step 4: 标记任务完成 ==========
    // 💡 提示：让用户输入序号，把 completed 对应位置改为 true
    // TODO: 取消注释并实现
    /*
    private void markComplete() {
        System.out.print("输入要标记的序号: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        // 检查序号是否合法
        if (index >= 0 && index < tasks.size()) {
            completed.set(index, true);
            System.out.println("✅ 已标记完成");
        } else {
            System.out.println("❌ 序号无效");
        }
    }
    */

    // ========== Step 5: 删除任务 ==========
    // 💡 提示：用 tasks.remove(index) 和 completed.remove(index)
    // TODO: 取消注释并实现
    /*
    private void deleteTask() {
        System.out.print("输入要删除的序号: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < tasks.size()) {
            String removed = tasks.remove(index);
            completed.remove(index);
            System.out.println("🗑️ 已删除: " + removed);
        } else {
            System.out.println("❌ 序号无效");
        }
    }
    */

    // ========== Step 6: 搜索任务 ==========
    // 💡 提示：遍历 tasks，用 contains() 判断是否包含关键词
    // TODO: 取消注释并实现
    /*
    private void searchTask() {
        System.out.print("输入关键词: ");
        String keyword = scanner.nextLine();
        System.out.println("🔍 搜索结果:");
        boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).contains(keyword)) {
                String status = completed.get(i) ? "✅" : "⬜";
                System.out.println("  " + (i + 1) + ". " + status + " " + tasks.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("  未找到相关任务");
        }
    }
    */

    // ========== 程序入口 ==========
    public static void main(String[] args) {
        new TaskManager().run();
    }
}
