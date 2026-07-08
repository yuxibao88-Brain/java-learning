package stage1_basics;

/**
 * L07 方法（Method）
 *
 * 核心知识：
 *   1. 定义方法：返回值类型 + 方法名 + 参数
 *   2. 有返回值用 return，没返回值用 void
 *   3. 方法重载：同名方法，参数不同
 *
 * 方法 = 把重复的代码打包成一个"工具"，随时调用
 */
public class L07_Methods {

    public static void main(String[] args) {

        // 1. 无返回值方法（void）

        greet("小明");
        greet("小红");


        // 2. 有返回值方法（return）

        int result = add(10, 20);
        System.out.println("10 + 20 = " + result);

        // 也可以直接用在表达式里
        System.out.println("3 + 7 = " + add(3, 7));

        // 实用例子：计算数组总和
        int[] scores = {95, 88, 76, 92, 85};
        System.out.println("总分: " + sum(scores));
        System.out.printf("平均: %.1f\n", average(scores));


        // 3. 方法重载（同名不同参）

        // 同一个方法名 "info"，传不同参数，调用不同版本
        info("小明");             // 1个参数版本
        info("小红", 20);        // 2个参数版本
        // Java 自动根据参数类型和个数，选择正确的方法


        // 练习：
        // 1) 写一个方法 max(int a, int b) 返回两个数中较大的那个
        System.out.println("max(5, 3) = " + max(5, 3));

        // 2) 写一个方法 isEven(int n) 判断一个数是否为偶数，返回 boolean
        System.out.println("isEven(4) = " + isEven(4) + "，isEven(7) = " + isEven(7));

        // 3) 写一个方法 printStars(int n) 打印 n 行星号三角形
        printStars(4);
    }


    // -- 方法定义（写在 main 外面）--

    /**
     * 无返回值方法：打招呼
     */
    static void greet(String name) {
        System.out.println("你好，" + name + "！欢迎学 Java！");
    }

    /**
     * 有返回值方法：两数相加
     */
    static int add(int a, int b) {
        return a + b;
    }

    /**
     * 求数组总和
     */
    static int sum(int[] arr) {
        int total = 0;
        for (int n : arr) {
            total += n;
        }
        return total;
    }

    /**
     * 求数组平均值（复用 sum 方法）
     */
    static double average(int[] arr) {
        return (double) sum(arr) / arr.length;
    }

    /**
     * 方法重载：只传名字
     */
    static void info(String name) {
        System.out.println("姓名: " + name);
    }

    /**
     * 方法重载：传名字 + 年龄
     */
    static void info(String name, int age) {
        System.out.println("姓名: " + name + "，年龄: " + age);
    }


    // -- 练习方法 --

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static void printStars(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
