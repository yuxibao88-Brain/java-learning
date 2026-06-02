package stage2_oop;

/**
 * ===================================
 * 📖 Java 学习第七课：类与对象、封装
 * ===================================
 *
 * ⭐ 核心知识（3 个就够）：
 *   1. new 创建对象，构造方法初始化数据
 *   2. private 封装 + getter/setter（IDEA/AI 自动生成）
 *   3. this 区分成员变量和参数
 *
 * 💡 实际开发中 getter/setter 用 Lombok @Data 自动生成
 */
public class L07_OOP_Basics {

    public static void main(String[] args) {

        // ========== ⭐ 1. 创建对象 ==========
        System.out.println("【创建对象】");

        Person p1 = new Person();                  // 无参构造
        Person p2 = new Person("小明", 18);         // 带参构造

        p1.introduce();  // 大家好，我叫 无名，今年 0 岁
        p2.introduce();  // 大家好，我叫 小明，今年 18 岁

        // ========== ⭐ 2. 封装：getter/setter ==========
        System.out.println("\n【封装】");

        Person p = new Person();
        // p.name = "张三";  // ❌ private 不能直接访问

        p.setName("张三");      // ✅ 通过 setter 设置
        p.setAge(25);
        System.out.println("姓名: " + p.getName());  // 通过 getter 获取
        System.out.println("年龄: " + p.getAge());

        p.setAge(-5);  // setter 里有校验，会提示错误
    }
}
