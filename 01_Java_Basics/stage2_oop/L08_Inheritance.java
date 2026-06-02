package stage2_oop;

/**
 * ===================================
 * 📖 Java 学习第八课：继承（Inheritance）
 * ===================================
 *
 * ⭐ 必须掌握：
 *   - extends：子类继承父类（子类拥有父类的所有 public/protected 成员）
 *   - super()：在子类构造中调用父类构造（必须放第一行）
 *   - @Override：子类重写父类方法（方法名、参数、返回类型必须一致）
 *   - Java 只支持单继承（一个子类只能有一个父类）
 *
 * 💡 了解即可：
 *   - protected 访问修饰符：子类可访问，外部不可
 *   - instanceof：判断对象是什么类型
 *
 * 💡 实际开发提示：
 *   Spring Boot 中继承用得不多（更多用接口和组合）
 *   但理解继承是理解框架源码的基础！
 */

// ========== ⭐ 父类 ==========
@SuppressWarnings("all")
class Animal {
    protected String name;  // protected：子类可以访问，外部不行
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 父类的通用方法（子类自动继承）
    public void eat() {
        System.out.println(name + " 在吃东西 🍽️");
    }

    public void sleep() {
        System.out.println(name + " 在睡觉 😴");
    }

    // 这个方法会被子类重写
    public void makeSound() {
        System.out.println(name + " 发出了声音...");
    }
}

// ========== ⭐ 子类 Dog（继承 Animal）==========
class Dog extends Animal {
    private String breed;  // Dog 特有的属性

    public Dog(String name, int age, String breed) {
        super(name, age);  // ⭐ 调用父类构造（必须放在第一行！）
        this.breed = breed;
    }

    // ⭐ 重写父类方法：加上 @Override 注解
    @Override
    public void makeSound() {
        System.out.println(name + "：汪汪汪！🐶");
    }

    // Dog 特有的方法
    public void wagTail() {
        System.out.println(name + " 在摇尾巴 🐕");
    }

    public void showInfo() {
        System.out.println("🐶 " + name + " | 年龄: " + age + " | 品种: " + breed);
    }
}

// ========== ⭐ 子类 Cat（继承 Animal）==========
class Cat extends Animal {
    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println(name + "：喵喵喵~ 🐱");
    }

    public void scratch() {
        System.out.println(name + " 在磨爪子 🔪");
    }

    public void showInfo() {
        System.out.println("🐱 " + name + " | 年龄: " + age + " | 颜色: " + color);
    }
}

// ========== 演示类 ==========
public class L08_Inheritance {

    public static void main(String[] args) {
        // ==================== ⭐ 1. 继承基本用法 ====================
        System.out.println("【继承 — 子类复用父类代码】");

        Dog dog = new Dog("旺财", 3, "金毛");
        Cat cat = new Cat("咪咪", 2, "白色");

        // ✅ 调用从父类继承来的方法（不用重写就能用）
        dog.eat();         // 旺财 在吃东西 🍽️
        cat.eat();         // 咪咪 在吃东西 🍽️

        // ==================== ⭐ 2. 方法重写（Override）====================
        System.out.println("\n【方法重写 — 同一方法，不同行为】");

        // ✅ 调用子类重写后的方法
        dog.makeSound();   // 旺财：汪汪汪！🐶（Dog 重写的版本）
        cat.makeSound();   // 咪咪：喵喵喵~ 🐱（Cat 重写的版本）

        // ==================== ⭐ 3. 子类特有方法 ====================
        System.out.println("\n【子类特有的方法】");

        dog.wagTail();     // Dog 独有
        cat.scratch();     // Cat 独有

        // 显示完整信息
        System.out.println();
        dog.showInfo();    // 🐶 旺财 | 年龄: 3 | 品种: 金毛
        cat.showInfo();    // 🐱 咪咪 | 年龄: 2 | 颜色: 白色

        // ==================== 💡 4. instanceof（了解即可）====================
        System.out.println("\n【instanceof — 判断对象类型】");

        System.out.println("dog 是 Dog 吗？ " + (dog instanceof Dog));       // true
        System.out.println("dog 是 Animal 吗？ " + (dog instanceof Animal)); // true（子类也是父类类型）

        Animal aDog = dog;  // 子类对象可以赋值给父类引用
        System.out.println("aDog 是 Cat 吗？ " + (aDog instanceof Cat));     // false
    }
}
