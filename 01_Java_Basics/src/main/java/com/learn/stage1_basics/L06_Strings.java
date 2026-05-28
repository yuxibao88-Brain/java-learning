package com.learn.stage1_basics;

/**
 * ============================================ 📖 Java 学习第六课：字符串深入
 * ============================================
 *
 * 【String 特点】 - String 是不可变的（一旦创建，内容不能改） - 每次"修改"都会创建新的字符串对象
 *
 * 【StringBuilder】 - 可变的字符串，适合频繁拼接的场景 - 比 String + String 效率高很多
 *
 * 【常用 String 方法】 length() — 长度 charAt(i) — 第 i 个字符 substring(i, j) — 截取 [i, j)
 * 的子串 indexOf(s) — 查找子串位置 contains(s) — 是否包含 split(regex) — 分割 trim() — 去首尾空格
 * toLowerCase() — 转小写 toUpperCase() — 转大写 replace(a, b) — 替换
 */
public class L06_Strings {

    public static void main(String[] args) {
        // ==================== 1. 字符串不可变性 ====================
        System.out.println("【字符串不可变性】");

        String s1 = "Hello";
        String s2 = s1;         // s2 指向 s1 的同一个对象
        s1 = s1 + " World";     // s1 指向新对象，原来的 "Hello" 还在

        System.out.println("s1 = " + s1);  // "Hello World"
        System.out.println("s2 = " + s2);  // "Hello"（没变！证明不可变性）

        // ==================== 2. 常用 String 方法 ====================
        System.out.println("\n【常用 String 方法】");

        String text = "  Hello Java World!  ";

        System.out.println("原字符串: \"" + text + "\"");
        System.out.println("长度: " + text.length());
        System.out.println("第3个字符: " + text.charAt(3));
        System.out.println("去空格: \"" + text.trim() + "\"");
        System.out.println("转大写: " + text.toUpperCase());
        System.out.println("转小写: " + text.toLowerCase());
        System.out.println("截取[2,7): " + text.substring(2, 7));
        System.out.println("是否包含 Java: " + text.contains("Java"));
        System.out.println("Java 的位置: " + text.indexOf("Java"));
        System.out.println("替换: " + text.replace("Java", "Python"));

        // ==================== 3. 字符串分割 ====================
        System.out.println("\n【字符串分割】");

        String csv = "苹果,香蕉,橙子,葡萄";
        String[] fruits = csv.split(",");  // 用逗号分割

        for (int i = 0; i < fruits.length; i++) {
            System.out.println("第" + (i + 1) + "个: " + fruits[i]);
        }

        // ==================== 4. StringBuilder（高效拼接） ====================
        System.out.println("\n【StringBuilder 高效拼接】");

        // ❌ 低效方式：每次 + 都创建新对象
        long start1 = System.nanoTime();
        String result1 = "";
        for (int i = 0; i < 50000; i++) {
            result1 += "a";
        }
        long time1 = System.nanoTime() - start1;
        System.out.println("String + 耗时: " + time1 / 1000000.0 + " ms");

        // ✅ 高效方式：StringBuilder
        long start2 = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50000; i++) {
            sb.append("a");  // append 在同一个对象上追加
        }
        String result2 = sb.toString();  // 最后转成 String
        long time2 = System.nanoTime() - start2;
        System.out.println("StringBuilder 耗时: " + time2 / 1000000.0 + " ms");
        System.out.println("效率提升: " + (time1 / time2) + " 倍 🚀");

        // StringBuilder 常用方法
        StringBuilder builder = new StringBuilder("Hello");
        builder.append(" Java");        // 追加
        builder.append("!");            // 继续追加
        builder.insert(5, " Beautiful"); // 在位置5插入
        builder.replace(0, 5, "Hi");     // 替换 [0,5)
        builder.delete(3, 13);           // 删除 [3,13)

        System.out.println("\nStringBuilder 操作结果: " + builder.toString());

        // ==================== 5. 格式化字符串 ====================
        System.out.println("\n【字符串格式化】");

        String name = "小明";
        int age = 18;
        double score = 95.5;

        // String.format() 用法
        String formatted = String.format(
                "姓名: %s, 年龄: %d, 成绩: %.1f",
                name, age, score
        );
        System.out.println(formatted);

        // 也可以用 System.out.printf 直接输出
        System.out.printf("我叫 %s，今年 %d 岁，考了 %.1f 分\n", name, age, score);
    }
}
