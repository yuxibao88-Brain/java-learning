package com.learn.stage1_basics;

/**
 * ============================================
 * 📖 Java 学习第三课：条件判断
 * ============================================
 *
 * 【if-else】最常用的条件判断
 *   if (条件) { 条件成立时执行 }
 *   else if (条件2) { 条件2成立时执行 }
 *   else { 都不成立时执行 }
 *
 * 【switch】多分支选择（适合精确匹配的场景）
 *   switch (变量) {
 *       case 值1: ... break;
 *       case 值2: ... break;
 *       default: ...
 *   }
 *
 * 【比较运算符】
 *   == (等于), != (不等于), >, <, >=, <=
 *
 * 【逻辑运算符】
 *   && (与：两边都 true 才 true)
 *   || (或：一边 true 就 true)
 *   !  (非：取反)
 */
public class L03_Conditionals {

    public static void main(String[] args) {
        // ==================== 1. if-else 示例 ====================
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

        // ==================== 2. 逻辑运算符 ====================
        System.out.println("\n【逻辑运算符】");

        int age = 25;
        boolean hasTicket = true;

        // && 与：两个条件都必须满足
        if (age >= 18 && hasTicket) {
            System.out.println("成年人且有票，可以入场！");
        }

        // || 或：满足一个条件即可
        boolean isVIP = false;
        if (isVIP || hasTicket) {
            System.out.println("VIP 或有票，可以入场！");
        }

        // ! 非：取反
        boolean isWeekend = false;
        if (!isWeekend) {
            System.out.println("今天不是周末，要上班 😅");
        }

        // ==================== 3. 三元运算符（简化 if-else） ====================
        System.out.println("\n【三元运算符】");

        int num = 7;
        // 语法：条件 ? 成立时的值 : 不成立时的值
        String result = (num % 2 == 0) ? "偶数" : "奇数";
        System.out.println(num + " 是 " + result);

        // ==================== 4. switch 语句 ====================
        System.out.println("\n【switch 多分支选择】");

        String day = "Monday";

        switch (day) {
            case "Monday":
                System.out.println("星期一：新的一周开始了！💪");
                break;  // 重要！没有 break 会穿透到下一个 case
            case "Friday":
                System.out.println("星期五：马上周末了！🎉");
                break;
            case "Saturday":
            case "Sunday":
                System.out.println("周末：休息时间！😎");
                break;
            default:
                System.out.println("工作日，加油！");
                break;
        }

        // ==================== 5. 字符串比较（重点！） ====================
        System.out.println("\n【⚠️ 字符串比较必须用 equals()】");

        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");

        // ❌ 用 == 比较引用地址，str1 == str3 为 false！
        System.out.println("str1 == str2: " + (str1 == str2));       // true（常量池）
        System.out.println("str1 == str3: " + (str1 == str3));       // false（不同对象）

        // ✅ 用 equals() 比较内容
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true
    }
}
