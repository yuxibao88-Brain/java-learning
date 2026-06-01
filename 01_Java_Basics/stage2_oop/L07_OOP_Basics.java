package stage2_oop;

/**
 * ============================================ 📖 Java 学习第七课：类与对象、封装
 * ============================================
 *
 * ⭐ 必须掌握（OOP 是 Java 的核心灵魂）： - 类 vs 对象：类是蓝图，对象是实例 - new 关键字创建对象 - private 封装 +
 * getter/setter 访问 - 构造方法：创建对象时初始化数据 - this：代表当前对象
 *
 * 💡 了解即可： - 方法重载（Overload）：同名方法、不同参数
 *
 * 💡 实际开发提示： 实际项目中会大量使用类和对象 Controller、Service、Entity 等全都是类 理解这节课 = 能看懂项目代码的基础！
 */
public class L07_OOP_Basics {

    public static void main(String[] args) {
        // ==================== ⭐ 1. 创建对象（用 new）====================
        System.out.println("【创建对象】");

        // new = 根据 Person 蓝图创建一个实例
        Person p1 = new Person();                         // 无参构造 → 默认值
        Person p2 = new Person("小明", 18);                // 两个参数
        Person p3 = new Person("小红", 22, "13800138000"); // 全参数

        p1.introduce();  // 输出：大家好，我叫 无名，今年 0 岁
        p2.introduce();  // 输出：大家好，我叫 小明，今年 18 岁
        p3.introduce();  // 输出：大家好，我叫 小红，今年 22 岁

        // ==================== ⭐ 2. 封装：通过 getter/setter 访问 ====================
        System.out.println("\n【封装 — private + getter/setter】");

        Person person = new Person();
        // person.name = "张三";  // ❌ 编译错误！name 是 private，不能直接访问

        // ✅ 通过 setter 设置值
        person.setName("张三");
        person.setAge(25);

        // ✅ 通过 getter 获取值
        System.out.println("姓名: " + person.getName());
        System.out.println("年龄: " + person.getAge());

        // setter 中的数据校验起作用了
        person.setAge(-5);   // 输出：⚠️ 年龄不合理！（不会赋值）
        person.setName("");  // 输出：⚠️ 名字不能为空！（不会赋值）

        // 值没有被错误修改
        System.out.println("校验后姓名: " + person.getName());  // 还是 张三
        System.out.println("校验后年龄: " + person.getAge());    // 还是 25

        // ==================== 💡 3. 方法重载（了解即可）====================
        System.out.println("\n【方法重载 — 同名不同参】");

        Person p = new Person("李四", 30);
        p.introduce();           // 调用 introduce()         → 无参版本
        p.introduce("🎓 自我介绍"); // 调用 introduce(String) → 带参版本

        // ==================== ⭐ 4. this 关键字 ====================
        System.out.println("\n【this 关键字】");

        // 看 Person.java 的构造方法：
        //   this.name = name;
        //   ↑ 成员变量    ↑ 传入的参数
        // this 用来区分"自己的字段"和"传进来的参数"
        System.out.println("✅ 类与对象、封装、构造方法 学习完成！");
    }
}
