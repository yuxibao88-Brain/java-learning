package stage1_basics;

/**
 * ===================================
 * 📖 Java 学习第三课：条件判断
 * ===================================
 *
 * ⭐ 必须掌握：
 *   - if / else if / else：最常用的条件判断
 *   - 比较运算符：== != > < >= <=
 *   - 逻辑运算符：&& (与) || (或) ! (非)
 *   - 字符串比较必须用 .equals()，不能用 ==
 *
 * 💡 了解即可（AI 可帮写）：
 *   - switch：多分支精确匹配时用
 *   - 三元运算符：简单的 if-else 简写
 */
@SuppressWarnings("all")  // 本文件有意使用 new String() 和 null 来演示对比
public class L03_Conditionals {

    public static void main(String[] args) {
        // ==================== ⭐ 1. if-else（最常用） ====================
        System.out.println("【if-else 条件判断】");

        int score = 85;

        if (score >= 90) {
            System.out.println("成绩: " + score + " → 优秀 🏆");
        } else if (score >= 80) {
            System.out.println("成绩: " + score + " → 良好 👍");
        } else if (score >= 60) {
            System.out.println("成绩: " + score + " → 及格");
        } else {
            System.out.println("成绩: " + score + " → 不及格，继续加油！");
        }

        // ==================== ⭐ 2. 逻辑运算符 ====================
        System.out.println("\n【逻辑运算符】");

        int age = 25;
        boolean hasTicket = true;

        // && 与：两个条件都必须满足
        if (age >= 18 && hasTicket) {
            System.out.println("成年 + 有票 → 可以入场！");
        }

        // || 或：满足一个即可
        boolean isVIP = false;
        if (isVIP || hasTicket) {
            System.out.println("VIP 或有票 → 可以入场！");
        }

        // ! 非：取反
        boolean isWeekend = false;
        if (!isWeekend) {
            System.out.println("不是周末 → 要上班 😅");
        }

        // ==================== ⚠️ 3. 字符串比较（重要！） ====================
        System.out.println("\n【⚠️ 字符串比较：必须用 equals()】");

        String str1 = "hello";
        String str2 = new String("hello");

        // ❌ == 比较的是内存地址，不是内容
        System.out.println("== 比较: " + (str1 == str2));           // false

        // ✅ equals() 比较的是内容
        System.out.println("equals() 比较: " + str1.equals(str2));  // true

        // 💡 实际开发中的安全写法：把常量放前面，防止 NullPointerException
        String input = null;
        // input.equals("hello")   // ❌ 如果 input 是 null 会报错
        // "hello".equals(input)   // ✅ 安全！返回 false
        System.out.println("安全写法: " + "hello".equals(input));    // false，不报错

        // ==================== 💡 4. 三元运算符（简单 if-else 简写）====================
        System.out.println("\n【三元运算符】");

        int num = 7;
        // 条件 ? 成立时的值 : 不成立时的值
        String result = (num % 2 == 0) ? "偶数" : "奇数";
        System.out.println(num + " 是 " + result);

        // ==================== 💡 5. switch（精确匹配多个值）====================
        System.out.println("\n【switch 多分支】");

        String day = "Monday";

        switch (day) {
            case "Monday":
                System.out.println("星期一：新的一周！💪");
                break;  // 必须有 break，否则会穿透到下一个 case
            case "Friday":
                System.out.println("星期五：快到周末了！🎉");
                break;
            case "Saturday":
            case "Sunday":
                System.out.println("周末：休息！😎");
                break;
            default:
                System.out.println("工作日，加油！");
                break;
        }
    }
}
