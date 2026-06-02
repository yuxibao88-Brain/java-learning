package stage2_oop;

/**
 * ===================================
 * 📖 Java 学习第八课：继承
 * ===================================
 *
 * ⭐ 核心知识（3 个就够）：
 *   1. extends 继承父类（子类自动拥有父类方法）
 *   2. super() 调用父类构造（必须放第一行）
 *   3. @Override 重写父类方法（同名同参，不同实现）
 *
 * 💡 Spring Boot 中继承用得不多，更多用接口
 */

// ========== 父类 ==========
@SuppressWarnings("all")
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " 在吃东西 🍽️");
    }

    public void makeSound() {
        System.out.println(name + " 发出了声音...");
    }
}

// ========== 子类 Dog ==========
class Dog extends Animal {

    public Dog(String name) {
        super(name);  // 调用父类构造（必须第一行！）
    }

    @Override  // 重写父类方法
    public void makeSound() {
        System.out.println(name + "：汪汪汪！🐶");
    }
}

// ========== 子类 Cat ==========
class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + "：喵喵喵~ 🐱");
    }
}

// ========== 演示 ==========
public class L08_Inheritance {

    public static void main(String[] args) {

        // ========== ⭐ 1. 继承：子类复用父类代码 ==========
        System.out.println("【继承】");

        Dog dog = new Dog("旺财");
        Cat cat = new Cat("咪咪");

        dog.eat();        // 继承自父类，不用重写
        cat.eat();

        // ========== ⭐ 2. 方法重写 ==========
        System.out.println("\n【方法重写】");

        dog.makeSound();  // 汪汪汪（Dog 自己的版本）
        cat.makeSound();  // 喵喵喵（Cat 自己的版本）
    }
}
