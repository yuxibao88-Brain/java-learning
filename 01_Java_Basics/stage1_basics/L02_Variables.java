package stage1_basics;

/**
 * ===================================
 * 📖 Java 学习第二课：变量与数据类型
 * ===================================
 *
 * ⭐ 必须掌握（开发天天用）：
 *   - int      整数（年龄、数量、ID）
 *   - double   小数（价格、坐标）
 *   - boolean  真/假（开关、状态判断）
 *   - String   文本（名字、地址、描述）
 *
 * 💡 了解即可（遇到再查）：
 *   - long     超大整数（时间戳、大 ID）
 *   - byte/short/float/char   用得极少，知道存在即可
 *
 * ⭐ 必须掌握：
 *   - 类型转换：小 → 大自动转，大 → 小需要 (类型) 强转
 *   - 常量：final 修饰，定义后不可修改
 */
public class L02_Variables {

    public static void main(String[] args) {
        // ==================== ⭐ 1. 四大常用类型 ====================
        System.out.println("=== 1. 四大常用类型（开发中 90% 用这四个）===");

        int age = 18;                   // 整数
        double price = 9.99;            // 小数
        boolean isLogin = true;         // 布尔值 (true / false)
        String name = "小明";            // 字符串（最常用！）

        System.out.println("姓名: " + name);
        System.out.println("年龄: " + age);
        System.out.println("价格: " + price);
        System.out.println("是否登录: " + isLogin);

        // ==================== 💡 2. 其它类型（了解即可）====================
        System.out.println("\n=== 2. 其它类型（了解即可）===");

        long timestamp = 1717200000000L;  // 时间戳、大 ID 才用 long（末尾加 L）
        char letter = 'A';               // 单个字符，用单引号（实际开发很少单独用）

        System.out.println("long 时间戳: " + timestamp);
        System.out.println("char 字符: " + letter);

        // ==================== ⭐ 3. 类型转换 ====================
        System.out.println("\n=== 3. 类型转换 ===");

        // 自动转换：小类型 → 大类型（安全，不丢数据）
        int num = 10;
        double autoDouble = num;        // int → double，自动转，值变成 10.0
        System.out.println("int → double: " + autoDouble);

        // 强制转换：大类型 → 小类型（可能丢精度！）
        double pi = 3.99;
        int forcedInt = (int) pi;       // double → int，小数直接丢弃（不是四舍五入！），值为 3
        System.out.println("double → int: " + forcedInt + "（小数被丢弃，不是四舍五入！）");

        // ==================== ⭐ 4. 常量 ====================
        System.out.println("\n=== 4. 常量（final）===");

        final double PI = 3.1415926;    // final 定义常量，值不可修改
        final int MAX_RETRY = 3;        // 常量命名习惯：全大写 + 下划线
        // PI = 3.14;                   // ❌ 取消注释会报错：常量不可修改

        System.out.println("PI = " + PI);
        System.out.println("最大重试次数: " + MAX_RETRY);

        // ==================== ✍️ 你的练习 ====================
        System.out.println("\n=== 5. 你的动手练习 ===");

        int a = 123;
        System.out.println(a);

        double bb = 1.23213;
        System.out.println(bb);

        boolean isFun = true;
        System.out.println(isFun);

        String realName = "小明";
        System.out.println(realName);
    }
}
