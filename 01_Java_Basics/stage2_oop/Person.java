package stage2_oop;

/**
 * ============================================
 * 📖 Person 类 — 配合第七课使用
 * ============================================
 *
 * ⭐ 必须掌握：
 *   - 类 = 模板/蓝图，对象 = 根据模板创建的实例
 *   - private 字段 + public getter/setter = 封装
 *   - 构造方法：创建对象时自动调用
 *   - this：指代当前对象自身
 *
 * 💡 了解即可：
 *   - 方法重载（同名方法参数不同）：知道概念即可
 *
 * 💡 实际开发提示：
 *   getter/setter 不用手写，IDEA 一键生成或让 AI 生成
 *   也可以用 Lombok 的 @Data 注解自动生成（后面会学到）
 */
public class Person {

    // ========== ⭐ 字段（成员变量）==========
    // private = 外部不能直接访问，必须通过 getter/setter
    private String name;
    private int age;
    private String phone;

    // ========== ⭐ 构造方法 ==========

    // 无参构造：new Person() 时调用
    public Person() {
        this.name = "无名";
        this.age = 0;
    }

    // 带参构造：new Person("小明", 18) 时调用
    // 💡 this.name 是成员变量，name 是传入的参数
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 全参构造：一次性设置所有字段
    public Person(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    // ========== ⭐ Getter / Setter（封装的关键）==========
    // 💡 实际开发中这些不用手写，IDEA 可以一键生成

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // setter 中可以做数据校验
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

    // ========== ⭐ 普通方法（行为）==========

    public void introduce() {
        System.out.println("大家好，我叫 " + name + "，今年 " + age + " 岁");
    }

    // 方法重载（Overload）：同名方法，参数不同
    public void introduce(String title) {
        System.out.println(title + "：我叫 " + name + "，今年 " + age + " 岁");
    }

    public void sayHello() {
        System.out.println(name + "：你好呀！👋");
    }
}
