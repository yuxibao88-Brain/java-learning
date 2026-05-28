package com.learn.stage2_oop;

/**
 * ============================================
 * 📖 Java 学习第七课：类与对象、封装
 * ============================================
 *
 * 【面向对象四大特性】
 *   1. 封装（Encapsulation）：隐藏内部细节，只暴露必要接口
 *   2. 继承（Inheritance）：子类复用父类的代码
 *   3. 多态（Polymorphism）：同一方法不同表现
 *   4. 抽象（Abstraction）：只关注接口，不关心实现
 *
 * 【类 vs 对象】
 *   类 = 蓝图/模板（class Person）
 *   对象 = 根据蓝图创建的实例（new Person()）
 *
 * 【封装】
 *   private 关键字隐藏字段，通过 getter/setter 访问
 *
 * 【方法重载（Overload）】
 *   同名方法，参数不同（个数/类型/顺序不同）
 */
public class Person {

    // ========== 字段（成员变量） ==========
    private String name;    // private：外部不能直接访问
    private int age;
    private String phone;

    // ========== 构造方法 ==========
    // 无参构造
    public Person() {
        this.name = "无名";
        this.age = 0;
    }

    // 带参构造（方法重载：参数个数不同）
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 三个参数的构造（方法重载：参数个数不同）
    public Person(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    // ========== Getter / Setter（封装的关键） ==========
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("⚠️ 名字不能为空！");
            return;
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 150) {
            System.out.println("⚠️ 年龄不合理！");
            return;
        }
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // ========== 普通方法（行为） ==========
    public void introduce() {
        System.out.println("大家好，我叫 " + name + "，今年 " + age + " 岁");
    }

    // 方法重载：同名方法，参数不同
    public void introduce(String title) {
        System.out.println(title + "：我叫 " + name + "，今年 " + age + " 岁");
    }

    public void sayHello() {
        System.out.println(name + "：你好呀！👋");
    }
}
