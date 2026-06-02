package stage1_basics;

/**
 * ===================================
 * 📖 Java 学习第四课：循环
 * ===================================
 *
 * ⭐ 核心知识（3 个就够）：
 *   1. for 循环：for (int i = 0; i < n; i++)
 *   2. 增强 for：for (元素 : 数组/集合) ← 开发最常用！
 *   3. break 跳出循环 / continue 跳过本次
 *
 * 💡 while / 嵌套循环 用到让 AI 帮写
 */
public class L04_Loops {

    public static void main(String[] args) {

        // ========== ⭐ 1. for 循环 ==========
        System.out.println("【for 循环】");

        for (int i = 1; i <= 5; i++) {
            System.out.println("第 " + i + " 次");
        }

        // 经典用法：累加求和
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1~100 求和: " + sum);

        // ========== ⭐ 2. 增强 for（开发最常用！）==========
        System.out.println("\n【增强 for】");

        String[] fruits = {"🍎 苹果", "🍌 香蕉", "🍊 橙子"};

        // 自动取出每个元素，不需要管索引
        for (String f : fruits) {
            System.out.println(f);
        }

        // ========== ⭐ 3. break / continue ==========
        System.out.println("\n【break / continue】");

        // break：遇到 5 就退出整个循环
        for (int i = 1; i <= 10; i++) {
            if (i == 5) break;
            System.out.print(i + " ");
        }
        System.out.println("← break 在 5 退出");

        // continue：跳过偶数，只打印奇数
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;
            System.out.print(i + " ");
        }
        System.out.println("← continue 跳过偶数");
    }
}
