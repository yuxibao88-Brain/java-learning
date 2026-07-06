package stage1_basics;

/**
 * ===================================
 * 📖 Java 学习第二课：变量与数据类型
 * ===================================
 *
 * ⭐ 核心知识（记住 4 个类型就够）：
 *   - int      整数（年龄、数量、ID）
 *   - double   小数（价格、坐标）
 *   - boolean  真/假（开关、状态）
 *   - String   文本（名字、地址）
 *
 * 💡 long/byte/short/float/char 遇到让 AI 帮查
 */
public class L02_Variables {

    public static void main(String[] args) {

        // ========== ⭐ 1. 四大常用类型（开发中 90% 用这四个）==========
        System.out.println("【四大常用类型】");

        int age = 18;
        double price = 9.99;
        boolean isLogin = true;
        String name = "小明";

        System.out.println("姓名: " + name);
        System.out.println("年龄: " + age);
        System.out.println("价格: " + price);
        System.out.println("登录: " + isLogin);

        // ========== ⭐ 2. 类型转换（知道这一个坑就行）==========
        System.out.println("\n【类型转换】");

        // 小 → 大：自动转（安全）
        double d = age;   // int → double，自动变成 18.0
        System.out.println("int → double: " + d);

        // 大 → 小：需要强转（可能丢精度！）
        int n = (int) 3.99;  // 小数直接丢弃，不是四舍五入！结果是 3
        System.out.println("double → int: " + n + "（小数被丢弃）");

        // ========== ⭐ 3. 常量 ==========
        System.out.println("\n【常量】");

        final int MAX_RETRY = 3;  // final = 不可修改，命名全大写
        System.out.println("最大重试: " + MAX_RETRY);

        // ========== 🏋️ 动手练习 ==========
        // 练习 1：定义 4 个变量存储你的个人信息（姓名、年龄、身高、是否学生）
        //   提示：String name = "xxx";  int age = xx;  double height = x.xx;  boolean isStudent = true/false;
        // 练习 2：用 println 拼出一句话："我叫xxx，今年xx岁，身高x.xx米"
        // 练习 3：试试 (int) 9.99 和 (int) 0.1 的结果，理解"强转丢弃小数"
    }
}
