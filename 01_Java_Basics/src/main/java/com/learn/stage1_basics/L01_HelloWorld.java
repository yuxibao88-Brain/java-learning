package com.learn.stage1_basics;

/**
 * ============================================ 📖 Java 学习第一课：Hello World
 * ============================================
 *
 * 【知识点】 1. package：声明该类属于哪个包（类似文件夹），方便组织代码 2. public class：定义一个公开的类，类名必须和文件名一致
 * 3. public static void main(String[] args)：Java 程序的入口方法（固定写法）
 *
 * 【运行方式】 编译：javac -d out src/main/java/com/learn/L01_HelloWorld.java 运行：java
 * -cp out com.learn.L01_HelloWorld
 */
public class L01_HelloWorld {

    public static void main(String[] args) {
        // 让电脑在屏幕上打印一句话
        System.out.println("Hello World!");

        System.out.println("Java is fun!");
    }
}
