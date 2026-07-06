package stage1_basics;

/**
 * ===================================
 * 📖 Java 学习第七课：方法（Method）
 * ===================================
 *
 * ⭐ 核心知识（3 个就够）：
 *   1. 定义方法：返回值类型 + 方法名 + 参数
 *   2. 有返回值用 return，没返回值用 void
 *   3. 方法重载：同名方法，参数不同
 *
 * 💡 方法 = 把重复的代码打包成一个"工具"，随时调用
 */
public class L07_Methods {

    public static void main(String[] args) {

        // ========== ⭐ 1. 无返回值方法（void）==========
        System.out.println("【无返回值方法】");

        // 直接调用，不接收返回值
        greet("小明");
        greet("小红");
        // → 你好，小明！欢迎学 Java！
        // → 你好，小红！欢迎学 Java！

        // ========== ⭐ 2. 有返回值方法（return）==========
        System.out.println("\n【有返回值方法】");

        int result = add(10, 20);
        System.out.println("10 + 20 = " + result);

        // 也可以直接用在表达式里
        System.out.println("3 + 7 = " + add(3, 7));

        // 实用例子：计算数组总和
        int[] scores = {95, 88, 76, 92, 85};
        System.out.println("总分: " + sum(scores));
        System.out.printf("平均: %.1f\n", average(scores));

        // ========== ⭐ 3. 方法重载（同名不同参）==========
        System.out.println("\n【方法重载】");

        // 同一个方法名 "info"，传不同参数，调用不同版本
        info("小明");             // 1个参数版本
        info("小红", 20);        // 2个参数版本
        // Java 自动根据参数类型和个数，选择正确的方法
    }

    // ---------- 定义方法（写在 main 外面）----------

    /**
     * 无返回值方法：打招呼
     * void = 不返回任何东西，只执行动作
     */
    static void greet(String name) {
        System.out.println("你好，" + name + "！欢迎学 Java！");
    }

    /**
     * 有返回值方法：两数相加
     * int = 返回一个整数
     */
    static int add(int a, int b) {
        return a + b;  // return 把结果"交出去"
    }

    /**
     * 实用方法：求数组总和
     */
    static int sum(int[] arr) {
        int total = 0;
        for (int n : arr) {
            total += n;
        }
        return total;
    }

    /**
     * 实用方法：求数组平均值
     * 注意返回 double，因为平均值可能有小数
     */
    static double average(int[] arr) {
        return (double) sum(arr) / arr.length;  // 复用 sum 方法！
    }

    /**
     * 方法重载 ①：只传名字
     */
    static void info(String name) {
        System.out.println("姓名: " + name);
    }

    /**
     * 方法重载 ②：传名字 + 年龄
     * 方法名相同，但参数不同 → 这就是"重载"
     */
    static void info(String name, int age) {
        System.out.println("姓名: " + name + "，年龄: " + age);
    }

    // ========== 🏋️ 动手练习 ==========
    // 练习 1：写一个方法 max(int a, int b) 返回两个数中较大的那个
    // 练习 2：写一个方法 isEven(int n) 判断一个数是否为偶数，返回 boolean
    // 练习 3：写一个方法 printStars(int n) 打印 n 行星号三角形
    //   n=4 时输出：
    //   *
    //   **
    //   ***
    //   ****
}
