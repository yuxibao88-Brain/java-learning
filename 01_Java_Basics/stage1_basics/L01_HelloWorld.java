package stage1_basics;

/**
 * ============================================
 * 📖 Java 学习第一课：Hello World
 * ============================================
 *
 * ⭐ 必须掌握：
 *   1. main 方法是程序入口（固定写法，记住就行）
 *   2. System.out.println() 打印并换行
 *   3. System.out.print()   打印不换行
 *   4. 类名必须和文件名一致
 *
 * 💡 了解即可：
 *   - package：声明类属于哪个包（类似文件夹归类）
 */
public class L01_HelloWorld {

    public static void main(String[] args) {
        // println = print + line（打印后自动换行）
        System.out.println("Hello World!");
        System.out.println("Java is fun!");

        // print 不换行，后面的内容会紧跟其后
        System.out.print("Hello, ");
        System.out.print("Antigravity!");
        // 输出结果：Hello, Antigravity!（在同一行）
    }
}
