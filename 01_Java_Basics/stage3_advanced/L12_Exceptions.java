package stage3_advanced;

/**
 * ===================================
 * 📖 Java 学习第十二课：异常处理
 * ===================================
 *
 * ⭐ 核心知识（2 个就够）：
 *   1. try-catch：捕获异常，防止程序崩溃
 *   2. throw/throws：主动抛出异常
 *
 * 💡 Spring Boot 有全局异常处理器，不需要到处写 try-catch
 * 💡 自定义异常类让 AI 帮生成
 */
public class L12_Exceptions {

    public static void main(String[] args) {

        // ========== ⭐ 1. try-catch ==========
        System.out.println("【try-catch】");

        try {
            int result = 10 / 0;  // 除零异常！
        } catch (ArithmeticException e) {
            System.out.println("捕获: " + e.getMessage());
        }
        System.out.println("程序没崩溃，继续执行 ✅");

        // ========== ⭐ 2. 常见异常 ==========
        System.out.println("\n【常见异常】");

        // NullPointerException（最常见！）
        try {
            String str = null;
            str.length();  // null 调方法 → NPE
        } catch (NullPointerException e) {
            System.out.println("空指针！变量是 null 不能调方法");
        }

        // NumberFormatException
        try {
            int n = Integer.parseInt("abc");  // "abc" 不是数字
        } catch (NumberFormatException e) {
            System.out.println("格式错误！\"abc\" 不能转 int");
        }

        // ========== ⭐ 3. throw / throws ==========
        System.out.println("\n【throw 主动抛异常】");

        try {
            checkAge(-5);
        } catch (Exception e) {
            System.out.println("捕获: " + e.getMessage());
        }

        checkAge(25);  // 正常通过
    }

    // throws：告诉调用者这个方法可能抛异常
    // throw：在方法内主动抛出
    static void checkAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("年龄不能为负: " + age);
        }
        System.out.println("年龄 " + age + " 验证通过 ✅");
    }
}
