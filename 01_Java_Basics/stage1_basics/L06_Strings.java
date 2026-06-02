package stage1_basics;

/**
 * ===================================
 * 📖 Java 学习第六课：字符串（String）
 * ===================================
 *
 * ⭐ 核心知识（3 个就够）：
 *   1. 比较用 .equals()，不能用 ==
 *   2. 常用方法：trim() split() replace() contains()
 *   3. 循环拼接用 StringBuilder，别用 +=
 *
 * 💡 其它方法（charAt/substring/indexOf 等）用到让 AI 帮查
 */
public class L06_Strings {

    public static void main(String[] args) {

        // ========== ⭐ 1. 常用方法（开发天天用）==========
        System.out.println("【常用方法】");

        String input = "  Hello Java  ";
        System.out.println("去空格: " + input.trim());           // 处理用户输入必用
        System.out.println("包含Java? " + input.contains("Java"));
        System.out.println("替换: " + input.replace("Java", "Python"));

        // 分割：后端经常返回逗号分隔的数据，需要拆开
        String csv = "苹果,香蕉,橙子";
        String[] fruits = csv.split(",");
        for (String f : fruits) {
            System.out.println("  → " + f);
        }

        // ========== ⭐ 2. 格式化拼接（比 + 号更清晰）==========
        System.out.println("\n【格式化】");

        String name = "小明";
        int age = 18;
        // %s=字符串  %d=整数  %.1f=保留1位小数
        System.out.printf("我叫 %s，今年 %d 岁\n", name, age);

        // ========== ⭐ 3. StringBuilder（循环拼接必用）==========
        System.out.println("\n【StringBuilder】");

        // ❌ 循环中用 += 拼接 → 每次都创建新对象，很慢
        // ✅ 用 StringBuilder → 只有一个对象，性能好
        StringBuilder sb = new StringBuilder();
        String[] cities = {"北京", "上海", "广州", "深圳"};
        for (int i = 0; i < cities.length; i++) {
            sb.append(cities[i]);
            if (i < cities.length - 1) sb.append("、");
        }
        System.out.println("城市: " + sb);
        // 输出：城市: 北京、上海、广州、深圳
    }
}
