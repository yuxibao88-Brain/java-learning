package stage1_basics;

/**
 * ============================================
 * 📖 Java 学习第六课：字符串（String）
 * ============================================
 *
 * ⭐ 必须掌握：
 *   - 字符串比较用 .equals()，不能用 ==（第三课已学）
 *   - 常用方法：length() trim() contains() split() replace()
 *   - String.format() 格式化拼接
 *   - StringBuilder：循环中拼接字符串必须用它
 *
 * 💡 了解即可（用到再查）：
 *   - charAt() substring() indexOf() 等不太常用的方法
 *   - 不可变性原理（知道结论就行：String 每次修改都产生新对象）
 */
public class L06_Strings {

    public static void main(String[] args) {
        // ==================== ⭐ 1. 最常用的 String 方法 ====================
        System.out.println("【最常用的 String 方法】");

        String text = "  Hello Java World!  ";

        System.out.println("原字符串: \"" + text + "\"");
        System.out.println("长度: " + text.length());                    // 包含空格的长度
        System.out.println("去首尾空格: \"" + text.trim() + "\"");        // 开发中处理用户输入必用
        System.out.println("是否包含 Java: " + text.contains("Java"));   // 判断是否包含
        System.out.println("替换: " + text.replace("Java", "Python"));   // 替换内容
        System.out.println("转大写: " + text.toUpperCase());
        System.out.println("转小写: " + text.toLowerCase());

        // ==================== ⭐ 2. 字符串分割（开发超常用）====================
        System.out.println("\n【字符串分割 split()】");

        // 场景：后端返回逗号分隔的数据，需要拆开处理
        String csv = "苹果,香蕉,橙子,葡萄";
        String[] fruits = csv.split(",");  // 用逗号分割成数组

        for (String fruit : fruits) {
            System.out.println("→ " + fruit);
        }

        // 实际开发常见：按多种分隔符分割
        String data = "张三|25|北京";
        String[] parts = data.split("\\|");  // | 是特殊字符，需要 \\| 转义
        System.out.println("姓名: " + parts[0] + "，年龄: " + parts[1] + "，城市: " + parts[2]);

        // ==================== ⭐ 3. 字符串格式化（推荐！）====================
        System.out.println("\n【字符串格式化 String.format()】");

        String name = "小明";
        int age = 18;
        double score = 95.5;

        // String.format() 比 + 拼接更清晰，尤其变量多的时候
        // %s = 字符串，%d = 整数，%.1f = 保留1位小数
        String info = String.format("姓名: %s, 年龄: %d, 成绩: %.1f", name, age, score);
        System.out.println(info);

        // 也可以直接输出
        System.out.printf("我叫 %s，今年 %d 岁，考了 %.1f 分\n", name, age, score);

        // ==================== ⭐ 4. StringBuilder（循环拼接必用！）====================
        System.out.println("\n【StringBuilder（循环拼接必用！）】");

        // ❌ 错误写法：循环中用 + 拼接，每次都创建新对象，非常慢
        // String result = "";
        // for (...) { result += "a"; }  // 千万别这样写！

        // ✅ 正确写法：用 StringBuilder
        StringBuilder sb = new StringBuilder();
        String[] cities = {"北京", "上海", "广州", "深圳"};

        for (int i = 0; i < cities.length; i++) {
            sb.append(cities[i]);
            if (i < cities.length - 1) {
                sb.append("、");  // 最后一个不加顿号
            }
        }
        System.out.println("城市: " + sb.toString());
        // 输出：城市: 北京、上海、广州、深圳

        // ==================== 💡 5. 其它方法（了解即可）====================
        System.out.println("\n【其它方法（用到再查）】");

        String s = "Hello Java";
        System.out.println("第0个字符: " + s.charAt(0));              // H
        System.out.println("截取[6,10): " + s.substring(6, 10));     // Java
        System.out.println("Java的位置: " + s.indexOf("Java"));       // 6
        System.out.println("是否以Hello开头: " + s.startsWith("Hello")); // true
        System.out.println("是否以Java结尾: " + s.endsWith("Java"));     // true
        System.out.println("是否为空: " + s.isEmpty());               // false
    }
}
