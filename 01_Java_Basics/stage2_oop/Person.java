package stage2_oop;

/**
 * ===================================
 * 📖 Person 类 — 配合第七课使用
 * ===================================
 *
 * ⭐ 核心概念：
 *   - private 字段 + public getter/setter = 封装
 *   - 构造方法：创建对象时自动调用
 *   - this：区分成员变量和参数
 *
 * 💡 实际开发中 getter/setter 用 IDEA 一键生成或 Lombok @Data
 */
public class Person {

    // ========== 字段（private 封装）==========
    private String name;
    private int age;

    // ========== 构造方法 ==========
    public Person() {
        this.name = "无名";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;   // this.name = 成员变量，name = 参数
        this.age = age;
    }

    // ========== Getter / Setter ==========
    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("⚠️ 名字不能为空！");
            return;
        }
        this.name = name;
    }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age < 0 || age > 150) {
            System.out.println("⚠️ 年龄不合理！");
            return;
        }
        this.age = age;
    }

    // ========== 方法 ==========
    public void introduce() {
        System.out.println("大家好，我叫 " + name + "，今年 " + age + " 岁");
    }
}
