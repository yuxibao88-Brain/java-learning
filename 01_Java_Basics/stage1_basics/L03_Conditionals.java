package stage1_basics;

/**
 * ===================================
 * 📖 Java 学习第三课：条件判断
 * ===================================
 *
 * ⭐ 核心知识（3 个就够）：
 *   1. if / else if / else 条件分支
 *   2. && (与) || (或) ! (非)
 *   3. 字符串比较必须用 .equals()，不能用 ==
 *
 * 💡 switch、三元运算符用到让 AI 帮写
 */
public class L03_Conditionals {

    public static void main(String[] args) {

        // ========== ⭐ 1. if-else（最常用）==========
        System.out.println("【if-else】");

        int score = 85;
        if (score >= 90) {
            System.out.println("优秀 🏆");
        } else if (score >= 60) {
            System.out.println("及格 👍");
        } else {
            System.out.println("不及格");
        }

        // ========== ⭐ 2. 逻辑运算符 ==========
        System.out.println("\n【逻辑运算符】");

        int age = 25;
        boolean hasTicket = true;

        // && 与：都满足才行
        if (age >= 18 && hasTicket) {
            System.out.println("成年 + 有票 → 可以入场");
        }

        // || 或：满足一个就行
        if (age < 12 || age >= 65) {
            System.out.println("免票");
        }

        // ========== ⚠️ 3. 字符串比较（必须记住！）==========
        System.out.println("\n【字符串比较】");

        String a = "hello";
        String b = new String("hello");

        System.out.println("== 比较: " + (a == b));          // false（比的是地址）
        System.out.println("equals: " + a.equals(b));        // true（比的是内容 ✅）

        // 安全写法：常量放前面，防止 null 报错
        String input = null;
        System.out.println("安全写法: " + "hello".equals(input));  // false，不报错

        // ========== 🏋️ 动手练习 ==========
        // 练习 1：写一个成绩评级程序
        //   score >= 90 → "A"，>= 80 → "B"，>= 70 → "C"，>= 60 → "D"，< 60 → "F"
        // 练习 2：写一个判断闰年的程序（能被4整除且不能被100整除，或者能被400整除）
        // 练习 3：定义 String password = "123456"，用 equals 判断用户输入是否匹配
    }
}
