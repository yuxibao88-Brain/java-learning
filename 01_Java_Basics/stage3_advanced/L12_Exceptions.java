package stage3_advanced;

import java.io.*;

/**
 * ===================================
 * 📖 Java 学习第十二课：异常处理
 * ===================================
 *
 * ⭐ 必须掌握：
 *   - try-catch：捕获异常，防止程序崩溃
 *   - 常见异常：NullPointerException、ArrayIndexOutOfBoundsException
 *   - throw：主动抛出异常
 *   - throws：在方法签名上声明可能抛出的异常
 *
 * ⭐ 需要掌握：
 *   - try-with-resources：自动关闭资源（文件、数据库连接等）
 *   - finally：无论是否异常都会执行（通常用于清理资源）
 *   - 多个 catch 块：精确捕获不同类型的异常
 *
 * 💡 了解即可：
 *   - 自定义异常类：知道怎么写就行，具体让 AI 帮生成
 *   - 异常体系树的细节（Error vs Exception vs RuntimeException）
 *
 * 💡 实际开发提示：
 *   Spring Boot 项目中通常有全局异常处理器 @ControllerAdvice
 *   不需要每个方法都 try-catch，统一处理即可
 */
public class L12_Exceptions {

    public static void main(String[] args) {
        // ==================== ⭐ 1. try-catch 基本用法 ====================
        System.out.println("【try-catch — 捕获异常，防崩溃】");

        // 没有 try-catch 的话，这行代码会导致程序崩溃
        try {
            int result = 10 / 0;  // 除零异常！
            System.out.println("这行不会执行");
        } catch (ArithmeticException e) {
            // 捕获到异常后程序继续运行
            System.out.println("捕获到异常: " + e.getMessage());   // / by zero
        }

        System.out.println("程序没有崩溃，继续执行 ✅");

        // ==================== ⭐ 2. 常见异常类型 ====================
        System.out.println("\n【常见异常类型】");

        // ⚠️ NullPointerException（NPE）— 开发中最常见的异常！
        try {
            String str = null;
            System.out.println(str.length());  // null 调用方法 → NPE！
        } catch (NullPointerException e) {
            System.out.println("空指针异常！变量是 null 就不能调方法");
        }

        // ⚠️ ArrayIndexOutOfBoundsException — 数组越界
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[10]);  // 索引超出范围
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界！最大索引是 " + (3 - 1));
        }

        // ⚠️ NumberFormatException — 类型转换错误
        try {
            int num = Integer.parseInt("abc");  // "abc" 不是数字
        } catch (NumberFormatException e) {
            System.out.println("数字格式错误！\"abc\" 不能转成 int");
        }

        // ==================== ⭐ 3. 多个 catch + 通用兜底 ====================
        System.out.println("\n【多个 catch — 精确处理不同异常】");

        String[] names = {"苹果", "香蕉"};
        try {
            System.out.println(names[5]);          // 数组越界
            int num = Integer.parseInt("abc");      // 这行不会执行
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界了！");
        } catch (NumberFormatException e) {
            System.out.println("数字格式错误！");
        } catch (Exception e) {
            // ⭐ 通用兜底：捕获所有其他异常（必须放在最后！）
            System.out.println("其他异常: " + e.getMessage());
        }

        // ==================== ⭐ 4. finally — 一定会执行 ====================
        System.out.println("\n【finally — 无论是否异常都执行】");

        try {
            System.out.println("打开数据库连接...");
            throw new RuntimeException("查询出错！");
        } catch (RuntimeException e) {
            System.out.println("捕获: " + e.getMessage());
        } finally {
            // 💡 finally 用于清理资源（关闭连接、释放文件等）
            System.out.println("关闭数据库连接 ✅（finally 总是执行）");
        }

        // ==================== ⭐ 5. throw / throws ====================
        System.out.println("\n【throw — 主动抛出异常】");

        try {
            checkAge(-5);  // 会抛出自定义异常
        } catch (InvalidAgeException e) {
            System.out.println("捕获自定义异常: " + e.getMessage());
        }

        try {
            checkAge(25);  // 正常，不会抛异常
        } catch (InvalidAgeException e) {
            System.out.println("不会到这里");
        }

        // ==================== ⭐ 6. try-with-resources（自动关闭资源）====================
        System.out.println("\n【try-with-resources — 自动关闭文件/连接】");

        String filePath = "test_output.txt";

        // ✅ 推荐写法：在 try() 中打开资源，结束后自动关闭
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Hello, Java IO!");
            writer.newLine();
            writer.write("这是自动关闭资源的示例");
            System.out.println("写入成功: " + filePath);
        } catch (IOException e) {
            System.out.println("写入失败: " + e.getMessage());
        }
        // 💡 不需要手动 writer.close()，try-with-resources 自动搞定！

        // 读取文件
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("读取: " + line);
            }
        } catch (IOException e) {
            System.out.println("读取失败: " + e.getMessage());
        }

        System.out.println("\n✅ 异常处理学习完成！");

        // ==================== 💡 总结速查 ====================
        // try-catch         → 捕获异常，防止崩溃
        // finally           → 无论如何都执行（清理资源）
        // throw             → 主动抛出异常
        // throws            → 方法签名上声明异常
        // try-with-resources → 自动关闭资源（推荐！）
    }

    // ========== ⭐ throw + throws 示例 ==========
    // throws：告诉调用者"这个方法可能抛异常，你要处理"
    // throw：在方法内主动抛出异常
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("年龄不能为负数: " + age);
        }
        if (age > 150) {
            throw new InvalidAgeException("年龄不可能超过150: " + age);
        }
        System.out.println("年龄 " + age + " 验证通过 ✅");
    }
}

// ========== 💡 自定义异常类（了解即可，AI 可帮生成）==========
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);  // 把错误信息传给父类 Exception
    }
}
