package stage1_basics;

/**
 * L04 循环
 *
 * 核心知识：
 * 1. for 循环：for (int i = 0; i < n; i++)
 * 2. 增强 for：for (元素 : 数组/集合) <- 开发最常用
 * 3. break 跳出循环 / continue 跳过本次
 */
public class L04_Loops {

    public static void main(String[] args) {

        // 1. for 循环

        for (int i = 1; i <= 5; i++) {
            System.out.println("第 " + i + " 次");
        }

        // 经典用法：累加求和
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1~100 求和: " + sum);


        // 2. 增强 for（开发最常用）

        String[] fruits = {"苹果", "香蕉", "橙子"};

        // 自动取出每个元素，不需要管索引
        for (String f : fruits) {
            System.out.println(f);
        }


        // 3. break / continue

        // break：遇到 5 就退出整个循环
        for (int i = 1; i <= 10; i++) {
            if (i == 5) break;
            System.out.print(i + " ");
        }
        System.out.println("<- break 在 5 退出");

        // continue：跳过偶数，只打印奇数
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;
            System.out.print(i + " ");
        }
        System.out.println("<- continue 跳过偶数");


        // 练习：
        // 1) 打印 9x9 乘法表（提示：嵌套 for 循环）
        System.out.println("\n=== 练习1: 9x9 乘法表 ===");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "x" + i + "=" + (i * j) + "  ");
            }
            System.out.println();
        }

        // 2) 用 for 循环计算 10 的阶乘（10! = 10 x 9 x 8 x ... x 1）
        System.out.println("\n=== 练习2: 10的阶乘 ===");
        long factorial = 1;
        for (int i = 10; i >= 1; i--) {
            factorial *= i;
        }
        System.out.println("10! = " + factorial);

        // 3) 用增强 for 遍历 {"Java", "Python", "Go", "Rust"}，打印每个语言和索引
        System.out.println("\n=== 练习3: 遍历数组带索引 ===");
        String[] languages = {"Java", "Python", "Go", "Rust"};
        for (int i = 0; i < languages.length; i++) {
            System.out.println(i + ": " + languages[i]);
        }
    }
}