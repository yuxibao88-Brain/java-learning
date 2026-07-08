package stage1_basics;

import java.util.Arrays;

/**
 * L05 数组
 *
 * 核心知识：
 *   1. 创建：int[] arr = {1, 2, 3};
 *   2. 遍历：增强 for 或普通 for
 *   3. 工具：Arrays.sort() 排序 / Arrays.toString() 打印
 *
 * 实际开发更常用 ArrayList（后面会学）
 */
public class L05_Arrays {

    public static void main(String[] args) {

        // 1. 创建和访问

        int[] scores = {95, 88, 76, 92, 85};
        System.out.println("长度: " + scores.length);
        System.out.println("第1个: " + scores[0]);           // 索引从 0 开始
        System.out.println("最后: " + scores[scores.length - 1]);


        // 2. 遍历

        // 增强 for（推荐）
        for (int s : scores) {
            System.out.print(s + " ");
        }
        System.out.println();


        // 3. Arrays 工具类

        int[] nums = {5, 2, 8, 1, 9, 3};
        System.out.println("原数组: " + Arrays.toString(nums));

        Arrays.sort(nums);  // 升序排序
        System.out.println("排序后: " + Arrays.toString(nums));
        System.out.println("最小: " + nums[0] + "，最大: " + nums[nums.length - 1]);

        // 求和
        int sum = 0;
        for (int n : nums) sum += n;
        System.out.println("总和: " + sum);
        System.out.println("平均: " + (double) sum / nums.length);


        // 练习：
        // 1) 找出数组 {34, 12, 56, 78, 45, 23, 89} 中的最大值和最小值
        int[] arr1 = {34, 12, 56, 78, 45, 23, 89};
        int max = arr1[0];
        int min = arr1[0];
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] > max) max = arr1[i];
            if (arr1[i] < min) min = arr1[i];
        }
        System.out.println("最大值: " + max + "，最小值: " + min);

        // 2) 把数组 {1, 2, 3, 4, 5} 反转成 {5, 4, 3, 2, 1}（交换首尾元素）
        int[] arr2 = {1, 2, 3, 4, 5};
        int left = 0, right = arr2.length - 1;
        while (left < right) {
            int temp = arr2[left];
            arr2[left] = arr2[right];
            arr2[right] = temp;
            left++;
            right--;
        }
        System.out.println("反转后: " + Arrays.toString(arr2));

        // 3) 统计数组 {85, 92, 67, 43, 78, 55, 91, 60} 中及格（>=60）的人数
        int[] arr3 = {85, 92, 67, 43, 78, 55, 91, 60};
        int count = 0;
        for (int score : arr3) {
            if (score >= 60) count++;
        }
        System.out.println("及格人数: " + count);
    }
}
