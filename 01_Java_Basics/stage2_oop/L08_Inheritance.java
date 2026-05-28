package stage2_oop;

/**
 * ============================================
 * 📖 Java 学习第八课：继承（Inheritance）
 * ============================================
 *
 * 【继承】
 *   - 使用 extends 关键字
 *   - 子类继承父类的所有 public/protected 成员
 *   - Java 只支持单继承（一个子类只能有一个父类）
 *
 * 【super 关键字】
 *   - super()：调用父类构造方法
 *   - super.方法()：调用父类的方法
 *
 * 【方法重写（Override）】
 *   - 子类重写父类的方法，加上 @Override 注解
 *   - 方法名、参数、返回类型必须一致
 */

// ========== 父类（基类） ==========
class Animal {
    protected String name;  // protected：子类可以访问
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

// ========== 子类 Dog ==========
class Dog extends Animal {
    private String breed;  // 品种（Dog 特有的属性）

    public Dog(String name, int age, String breed) {
        super(name, age);  // 调用父类构造方法（必须放在第一行）
        this.breed = breed;
    }

    // 重写父类方法
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

// ========== 子类 Cat ==========
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

    // Cat 特有的方法
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
        System.out.println("【继承示例】");

        Dog dog = new Dog("旺财", 3, "金毛");
        Cat cat = new Cat("咪咪", 2, "白色");

        // 调用继承自父类的方法
        dog.eat();
        cat.eat();

        // 调用重写后的方法（多态！）
        dog.makeSound();   // 汪汪汪
        cat.makeSound();   // 喵喵喵

        // 调用子类特有的方法
        dog.wagTail();
        cat.scratch();

        // 显示完整信息
        System.out.println();
        dog.showInfo();
        cat.showInfo();

        // ========== instanceof 运算符 ==========
        System.out.println("\n【instanceof — 判断对象类型】");

        System.out.println("dog 是 Dog 吗？ " + (dog instanceof Dog));      // true
        System.out.println("dog 是 Animal 吗？ " + (dog instanceof Animal)); // true（子类也是父类类型）
        Animal aDog = dog;  // 转为父类引用
        System.out.println("dog (作为Animal) 是 Cat 吗？ " + (aDog instanceof Cat));  // false
    }
}
