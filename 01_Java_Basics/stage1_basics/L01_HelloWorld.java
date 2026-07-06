package stage1_basics;

/**
 * L01 Hello World
 *
 * 核心知识：
 *   1. main 方法是程序入口（固定写法，记住就行）
 *   2. System.out.println() 打印输出
 */
public class L01_HelloWorld {

    public static void main(String[] args) {

        // println = 打印并换行（最常用）
        System.out.println("Hello World!");
        System.out.println("开始学 Java！");


        // 练习：
        // 1) 把 "Hello World!" 改成输出你自己的名字
        // 2) 再写 3 行 println，输出你最喜欢的三样东西
        // 3) 试试 System.out.print()（不换行），对比和 println 的区别

        System.out.println("你好，Java 世界1！");
        System.out.println("开始学 Java！2");
        System.out.print("你好，Java 世界3！");
    }
}
