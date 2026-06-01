package stage1_basics;

import java.util.Arrays;  // 导入数组工具类

/**
 * ============================================
 * 📖 Java 学习第五课：数组
 * ============================================
 *
 * ⭐ 必须掌握：
 *   - 数组创建：int[] arr = {1, 2, 3};（最常用写法）
 *   - 访问元素：arr[0]（索引从 0 开始！）
 *   - 数组长度：arr.length
 *   - 遍历数组：for 循环 或 增强 for
 *   - 工具方法：Arrays.sort()、Arrays.toString()
 *
 * 💡 了解即可：
 *   - 二维数组：实际开发用得不多，遇到再查
 *   - 手写排序算法：面试可能问，开发中直接用 Arrays.sort()
 *
 * 💡 预告：
 *   实际开发中更常用 ArrayList（可变长度），后面会学到
 */
public class L05_Arrays {

    public static void main(String[] args) {
        // ==================== ⭐ 1. 创建数组 ====================
        System.out.println("【创建数组】");

        // ✅ 方式1（最常用）：直接赋值
        int[] scores = {95, 88, 76, 92, 85};
        String[] names = {"张三", "李四", "王五"};

        // 方式2：先创建空数组，再赋值（知道长度但不知道值时用）
        int[] data = new int[3];  // 默认值都是 0
        data[0] = 10;
        data[1] = 20;
        data[2] = 30;

        // ==================== ⭐ 2. 访问和遍历 ====================
        System.out.println("\n【访问和遍历】");

        System.out.println("数组长度: " + scores.length);     // 5
        System.out.println("第1个元素: " + scores[0]);         // 95（索引从 0 开始！）
        System.out.println("最后一个: " + scores[scores.length - 1]);  // 85

        // 遍历方式1：普通 for（需要索引时用）
        System.out.print("普通for: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();

        // 遍历方式2：增强 for（不需要索引时用，更简洁 ✅）
        System.out.print("增强for: ");
        for (int s : scores) {
            System.out.print(s + " ");
        }
        System.out.println();

        // ==================== ⭐ 3. 常用工具方法（Arrays 类）====================
        System.out.println("\n【Arrays 工具方法】");

        int[] nums = {5, 2, 8, 1, 9, 3};

        // 快速打印数组（调试必备！）
        System.out.println("原数组: " + Arrays.toString(nums));

        // 排序（从小到大，原地修改）
        Arrays.sort(nums);
        System.out.println("排序后: " + Arrays.toString(nums));

        // 排序后，最小值和最大值一目了然
        System.out.println("最小值: " + nums[0]);
        System.out.println("最大值: " + nums[nums.length - 1]);

        // ==================== ⭐ 4. 数组常见操作 ====================
        System.out.println("\n【常见操作：求和、平均值】");

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        System.out.println("总和: " + sum);

        // ⚠️ 注意：两个 int 相除会丢失小数！要用 (double) 强转
        double avg = (double) sum / nums.length;
        System.out.println("平均值: " + avg);

        // ==================== ⚠️ 5. 常见错误：数组越界 ====================
        System.out.println("\n【⚠️ 常见错误】");
        System.out.println("数组长度: " + scores.length);
        System.out.println("最大索引: " + (scores.length - 1));
        // scores[5]  // ❌ 长度为5，索引范围是 0~4，访问 5 会报 ArrayIndexOutOfBoundsException！
        System.out.println("提示: 长度为5的数组，索引范围是 0~4，访问 5 会报错！");

        // ==================== 💡 6. 二维数组（了解即可）====================
        System.out.println("\n【二维数组（了解即可）】");

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("行数: " + matrix.length);          // 3
        System.out.println("列数: " + matrix[0].length);       // 3
        System.out.println("第2行第3列: " + matrix[1][2]);      // 6

        // 遍历二维数组：双重 for 循环
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}
