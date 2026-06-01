package stage1_basics;

/**
 * ============================================
 * 📖 Java 学习第四课：循环
 * ============================================
 *
 * ⭐ 必须掌握：
 *   - for 循环：for (初始化; 条件; 更新) { ... }
 *   - 增强 for（foreach）：for (元素 : 数组/集合) { ... }  ← 开发最常用！
 *   - break：跳出整个循环
 *   - continue：跳过本次，进入下一次
 *
 * 💡 了解即可：
 *   - while / do-while：用得较少，遇到再查
 *   - 嵌套循环：理解概念即可，复杂逻辑让 AI 帮写
 */
public class L04_Loops {

    public static void main(String[] args) {
        // ==================== ⭐ 1. 基础 for 循环 ====================
        System.out.println("=== 1. 基础 for 循环 ===");

        // for (起点; 终点条件; 每次怎么变)
        for (int i = 1; i <= 5; i++) {
            System.out.println("第 " + i + " 次循环");
        }

        // ==================== ⭐ 2. 累加求和（for 经典用法）====================
        System.out.println("\n=== 2. 累加求和 (1~100) ===");

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;  // 等价于 sum = sum + i
        }
        System.out.println("1 + 2 + ... + 100 = " + sum);

        // ==================== ⭐ 3. 增强 for（开发最常用！）====================
        System.out.println("\n=== 3. 增强 for 循环（开发最常用！）===");

        String[] fruits = {"🍎 苹果", "🍌 香蕉", "🍊 橙子", "🍇 葡萄"};

        // 语法：for (元素类型 变量名 : 数组或集合)
        // 自动取出每个元素，不需要手动管理索引
        for (String fruit : fruits) {
            System.out.println("水果: " + fruit);
        }

        // 💡 对比：普通 for 需要手动管 i（需要索引时才用）
        System.out.println("\n--- 普通 for 对比（需要索引时用）---");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("第" + (i + 1) + "个: " + fruits[i]);
        }

        // ==================== ⭐ 4. break 和 continue ====================
        System.out.println("\n=== 4. break（退出循环）===");

        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("遇到 5，break 退出！");
                break;  // 直接跳出整个循环
            }
            System.out.print(i + " ");
        }

        System.out.println("\n\n=== 5. continue（跳过一次）===");

        // 只打印奇数
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;  // 跳过偶数，进入下一次循环
            }
            System.out.print(i + " ");
        }

        // ==================== 💡 6. 嵌套循环（了解即可）====================
        System.out.println("\n\n=== 6. 嵌套循环 — 九九乘法表（了解即可）===");

        // 外层走一步，内层走一圈
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}
