package com.learn.stage2_oop;

/**
 * ============================================
 * 📖 使用 Person 类——演示类与对象、封装
 * ============================================
 */
public class L07_OOP_Basics {

    public static void main(String[] args) {
        // ==================== 1. 创建对象 ====================
        System.out.println("【创建对象】");

        // 使用 new 关键字创建对象
        Person p1 = new Person();                    // 无参构造
        Person p2 = new Person("小明", 18);           // 两个参数
        Person p3 = new Person("小红", 22, "13800138000"); // 三个参数

        p1.introduce();
        p2.introduce();
        p3.introduce();

        // ==================== 2. 封装：通过 getter/setter 访问 ====================
        System.out.println("\n【封装 — getter/setter】");

        Person person = new Person();
        // person.name = "张三";  // ❌ 编译错误！name 是 private

        // ✅ 正确方式：通过 setter 设置
        person.setName("张三");
        person.setAge(25);

        // ✅ 通过 getter 获取
        System.out.println("姓名: " + person.getName());
        System.out.println("年龄: " + person.getAge());

        // setter 中的数据校验
        person.setAge(-5);   // 会提示年龄不合理
        person.setName("");  // 会提示名字不能为空

        // ==================== 3. 方法重载 ====================
        System.out.println("\n【方法重载】");

        Person p = new Person("李四", 30);
        p.introduce();                    // 调用无参版本
        p.introduce("🎓");               // 调用带参数版本

        // ==================== 4. this 关键字 ====================
        System.out.println("\n【this 关键字】");

        // this.name = name
        //  this.name 是成员变量
        //  name 是参数

        System.out.println("✅ 学习完类与对象、封装、方法重载！");
    }
}
