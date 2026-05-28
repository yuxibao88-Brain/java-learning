package stage3_advanced;

import java.io.*;
import java.util.Scanner;

/**
 * ============================================
 * 📖 Java 学习第十二课：异常处理与文件 IO
 * ============================================
 *
 * 【异常体系】
 *   Throwable
 *     ├── Error（系统错误，不用处理）
 *     └── Exception
 *           ├── RuntimeException（运行时异常，可以不处理）
 *           │     ├── NullPointerException
 *           │     ├── ArrayIndexOutOfBoundsException
 *           │     └── ArithmeticException
 *           └── 检查型异常（必须处理：try-catch 或 throws）
 *                 ├── IOException
 *                 └── FileNotFoundException
 *
 * 【处理方式】
 *   1. try-catch-finally：自己捕获处理
 *   2. throws：向上抛出，让调用者处理
 *
 * 【try-with-resources（Java 7+）】
 *   自动关闭资源（实现了 AutoCloseable 接口的类）
 */
public class L12_Exceptions {

    public static void main(String[] args) {
        // ==================== 1. try-catch 基本用法 ====================
        System.out.println("【try-catch 捕获异常】");

        try {
            int result = 10 / 0;  // 除零错误
            System.out.println("这行不会执行");
        } catch (ArithmeticException e) {
            System.out.println("捕获到异常: " + e.getMessage());
            System.out.println("异常类型: " + e.getClass().getSimpleName());
        }

        System.out.println("程序继续执行（没有被中断）");

        // ==================== 2. 多个 catch 块 ====================
        System.out.println("\n【多个 catch 块】");

        String[] arr = {"苹果", "香蕉"};
        try {
            System.out.println(arr[5]);  // 数组越界
            int num = Integer.parseInt("abc");  // 这行不会执行
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界！索引超出范围");
        } catch (NumberFormatException e) {
            System.out.println("数字格式错误！");
        } catch (Exception e) {
            // 捕获所有其他异常，必须放在最后
            System.out.println("其他异常: " + e);
        }

        // ==================== 3. finally 块 ====================
        System.out.println("\n【finally — 一定会执行】");

        try {
            System.out.println("打开资源...");
            throw new RuntimeException("处理中出错！");
        } catch (RuntimeException e) {
            System.out.println("捕获: " + e.getMessage());
        } finally {
            // finally 无论是否异常，都会执行
            System.out.println("关闭资源（finally 块总是执行）✅");
        }

        // ==================== 4. 自定义异常 ====================
        System.out.println("\n【自定义异常】");

        try {
            checkAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("自定义异常: " + e.getMessage());
        }

        // ==================== 5. 文件写入 ====================
        System.out.println("\n【文件写入】");

        String filePath = "test_output.txt";

        // try-with-resources：自动关闭资源
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Hello, Java IO!");
            writer.newLine();
            writer.write("这是第二行内容");
            writer.newLine();
            writer.write("Java 文件 IO 学习笔记");
            System.out.println("写入成功: " + filePath);
        } catch (IOException e) {
            System.out.println("写入失败: " + e.getMessage());
        }

        // ==================== 6. 文件读取 ====================
        System.out.println("\n【文件读取】");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("读取: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("读取失败: " + e.getMessage());
        }

        // ==================== 7. 综合：用户输入 ====================
        System.out.println("\n【Scanner — 用户输入】");

        Scanner scanner = new Scanner(System.in);

        // 安全地读取整数
        int age = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("请输入你的年龄: ");
                // 模拟输入（实际会等待用户输入，这里用默认值演示）
                // age = scanner.nextInt();
                System.out.println("(模拟输入: 25)");
                age = 25;
                valid = true;
                break;  // 演示用，跳出循环
            } catch (Exception e) {
                System.out.println("输入无效，请输入数字！");
                scanner.nextLine();  // 清除缓冲区
            }
        }

        System.out.println("你的年龄是: " + age);
        System.out.println("\n✅ 异常处理与 IO 学习完成！");
    }

    // ========== 自定义异常类 ==========
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("年龄不能为负数: " + age);
        }
        if (age > 150) {
            throw new InvalidAgeException("年龄不可能超过150: " + age);
        }
        System.out.println("年龄 " + age + " 验证通过");
    }
}

// ========== 自定义异常类（继承 Exception） ==========
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
