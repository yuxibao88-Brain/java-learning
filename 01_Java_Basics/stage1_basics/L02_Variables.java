package stage1_basics;

/**
 * ============================================
 * 📖 Java 学习第二课：变量与数据类型
 * ============================================
 *
 * 【Java 的 8 种基本数据类型】
 *   - 整数型：byte(1字节), short(2), int(4), long(8)
 *   - 浮点型：float(4), double(8)
 *   - 字符型：char(2)
 *   - 布尔型：boolean(1位)
 *
 * 【引用类型】
 *   - String（字符串）、数组、类、接口等
 *
 * 【命名规范】
 *   - 类名：大驼峰（HelloWorld）
 *   - 变量/方法名：小驼峰（userName, getUserName）
 *   - 常量：全大写下划线（MAX_VALUE）
 */
public class L02_Variables {

    public static void main(String[] args) {
        // ========== 1. 整数类型 ==========
        System.out.println("【整数类型】");
        byte b = 127;          // -128 ~ 127
        short s = 32767;       // -32768 ~ 32767
        int i = 2147483647;    // 最常用，约 ±21亿
        long l = 9223372036854775807L;  // 后面加 L 表示 long 类型

        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);

        // ========== 2. 浮点类型 ==========
        System.out.println("\n【浮点类型】");
        float f = 3.14f;       // 后面加 f 表示 float
        double d = 3.141592653589793;  // 默认小数是 double，精度更高

        System.out.println("float: " + f);
        System.out.println("double: " + d);

        // ========== 3. 字符与布尔 ==========
        System.out.println("\n【字符与布尔】");
        char letter = 'A';     // 单引号，只能一个字符
        char chinese = '中';   // Java 使用 Unicode，支持中文
        boolean isJavaFun = true;  // 只有 true 或 false

        System.out.println("字符: " + letter + " " + chinese);
        System.out.println("Java 有趣吗？" + isJavaFun);

        // ========== 4. 字符串（引用类型） ==========
        System.out.println("\n【字符串】");
        String name = "小明";
        String greeting = "你好，";  // String 不是基本类型，但使用像基本类型一样方便
        System.out.println(greeting + name + "！");  // + 号拼接字符串

        // ========== 5. 类型转换 ==========
        System.out.println("\n【类型转换】");
        // 自动转换（小 → 大）：byte → short → int → long → float → double
        int autoInt = 100;
        double autoDouble = autoInt;  // 自动转换，不丢数据
        System.out.println("int → double (自动): " + autoDouble);

        // 强制转换（大 → 小）：可能丢失数据
        double bigDouble = 3.99;
        int smallInt = (int) bigDouble;  // 小数部分被截断，结果为 3
        System.out.println("double → int (强制): " + smallInt);

        // ========== 6. 常量 ==========
        System.out.println("\n【常量】");
        final double PI = 3.14159;  // final 关键字定义常量，不可修改
        // PI = 3.14;  // ❌ 编译错误！常量不能被重新赋值
        System.out.println("圆周率 PI = " + PI);
    }
}
