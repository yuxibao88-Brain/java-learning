package stage1_basics;

/**
 * ============================================
 * 📖 Java 学习第四课：循环
 * ============================================
 *
 * 【三种循环】
 * 1. for：知道循环次数时使用
 *    for (初始化; 条件; 更新) { 循环体 }
 *
 * 2. while：不知道循环次数，先判断再执行
 *    while (条件) { 循环体 }
 *
 * 3. do-while：至少执行一次，先执行再判断
 *    do { 循环体 } while (条件);
 *
 * 【控制关键字】
 *   break：立即结束循环
 *   continue：跳过本次循环，继续下一次
 */
public class L04_Loops {

    public static void main(String[] args) {
        // ==================== 1. for 循环 ====================
        System.out.println("【for 循环 — 打印 1~5】");

        for (int i = 1; i <= 5; i++) {
            // i++ 等价于 i = i + 1
            System.out.println("第 " + i + " 次循环");
        }

        // ==================== 2. for 循环 — 累加求和 ====================
        System.out.println("\n【for 循环 — 计算 1 到 100 的和】");

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;  // 等价于 sum = sum + i
        }
        System.out.println("1 + 2 + ... + 100 = " + sum);

        // 高斯公式验证
        System.out.println("高斯公式验证: " + (1 + 100) * 100 / 2);

        // ==================== 3. for 循环 — 九九乘法表 ====================
        System.out.println("\n【九九乘法表】");

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {  // 嵌套循环
                System.out.print(j + "×" + i + "=" + (i * j) + "\t");
            }
            System.out.println();  // 换行
        }

        // ==================== 4. while 循环 ====================
        System.out.println("\n【while 循环 — 猜数字模拟】");

        int target = 7;
        int guess = 1;
        while (guess != target) {
            System.out.println("猜 " + guess + " → 不对，再试试！");
            guess++;
        }
        System.out.println("猜 " + guess + " → 猜对了！🎯");

        // ==================== 5. do-while 循环 ====================
        System.out.println("\n【do-while 循环 — 至少执行一次】");

        int count = 0;
        do {
            System.out.println("count = " + count + "（至少会打印一次）");
            count++;
        } while (count < 3);

        // ==================== 6. break 和 continue ====================
        System.out.println("\n【break — 遇到 5 就停止】");

        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("遇到 5，break！");
                break;  // 立即跳出循环
            }
            System.out.print(i + " ");
        }

        System.out.println("\n\n【continue — 跳过偶数】");

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;  // 跳过本次循环，进入下一次
            }
            System.out.print(i + " ");
        }

        // ==================== 7. 增强 for 循环（foreach） ====================
        System.out.println("\n\n【增强 for 循环 — 遍历数组】");

        String[] fruits = {"🍎 苹果", "🍌 香蕉", "🍊 橙子", "🍇 葡萄"};
        // 语法：for (元素类型 变量名 : 数组或集合)
        for (String fruit : fruits) {
            System.out.println("水果: " + fruit);
        }
    }
}
