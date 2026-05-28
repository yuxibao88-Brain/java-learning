package stage1_basics;

import java.util.Arrays;  // 导入数组工具类

/**
 * ============================================
 * 📖 Java 学习第五课：数组
 * ============================================
 *
 * 【数组的特点】
 *   - 存放相同类型的多个数据
 *   - 长度固定，创建后不可改变
 *   - 索引从 0 开始
 *
 * 【数组的创建方式】
 *   1. int[] arr = new int[5];              // 先声明，后赋值
 *   2. int[] arr = {1, 2, 3, 4, 5};        // 声明同时赋值
 *   3. int[] arr = new int[]{1, 2, 3};     // 匿名数组
 *
 * 【常见操作】
 *   - arr.length：获取数组长度
 *   - arr[i]：访问第 i 个元素（索引从 0 开始）
 *   - Arrays.sort(arr)：排序
 *   - Arrays.toString(arr)：转成字符串显示
 */
public class L05_Arrays {

    public static void main(String[] args) {
        // ==================== 1. 一维数组 ====================
        System.out.println("【一维数组】");

        // 方式1：先创建，再逐个赋值
        int[] scores = new int[5];  // 长度为 5 的整型数组，默认值都是 0
        scores[0] = 95;
        scores[1] = 88;
        scores[2] = 76;
        scores[3] = 92;
        scores[4] = 85;

        System.out.println("数组长度: " + scores.length);
        System.out.println("第1个元素: " + scores[0]);

        // 遍历数组打印
        System.out.print("成绩: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();

        // 方式2：声明同时赋值（最常用）
        String[] names = {"张三", "李四", "王五", "赵六"};
        System.out.println("学生: " + Arrays.toString(names));  // 快速打印数组

        // ==================== 2. 数组常见操作 ====================
        System.out.println("\n【数组常见操作】");

        int[] nums = {5, 2, 8, 1, 9, 3};

        // 排序
        Arrays.sort(nums);
        System.out.println("排序后: " + Arrays.toString(nums));

        // 求和
        int sum = 0;
        for (int n : nums) {  // 增强 for 循环
            sum += n;
        }
        System.out.println("总和: " + sum);

        // 求和、平均值
        double avg = (double) sum / nums.length;
        System.out.println("平均值: " + avg);

        // 最大值、最小值（排序后很方便）
        System.out.println("最小值: " + nums[0]);
        System.out.println("最大值: " + nums[nums.length - 1]);

        // ==================== 3. 二维数组（矩阵） ====================
        System.out.println("\n【二维数组（矩阵）】");

        // 3行4列的矩阵
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        System.out.println("矩阵: " + matrix.length + " 行 × " + matrix[0].length + " 列");
        System.out.println("第2行第3列: " + matrix[1][2]);  // 值为 7

        // 遍历二维数组
        System.out.println("完整矩阵:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // ==================== 4. 数组练习题：冒泡排序 ====================
        System.out.println("\n【冒泡排序（手写排序算法）】");

        int[] unsorted = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前: " + Arrays.toString(unsorted));

        // 冒泡排序：每次把最大的"冒"到最后面
        for (int i = 0; i < unsorted.length - 1; i++) {
            for (int j = 0; j < unsorted.length - 1 - i; j++) {
                if (unsorted[j] > unsorted[j + 1]) {
                    // 交换两个元素
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j + 1];
                    unsorted[j + 1] = temp;
                }
            }
        }
        System.out.println("排序后: " + Arrays.toString(unsorted));
    }
}
