package stage2_oop;

/**
 * L08 继承
 *
 * 核心知识：
 *   1. extends 继承父类（子类自动拥有父类方法）
 *   2. super() 调用父类构造（必须放第一行）
 *   3. @Override 重写父类方法（同名同参，不同实现）
 *
 * Spring Boot 中继承用得不多，更多用接口
 */

// -- 父类 --

@SuppressWarnings("all")
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " 在吃东西");
    }

    public void makeSound() {
        System.out.println(name + " 发出了声音...");
    }
}

// -- 子类 Dog --

class Dog extends Animal {

    public Dog(String name) {
        super(name);  // 调用父类构造（必须第一行）
    }

    @Override
    public void makeSound() {
        System.out.println(name + "：汪汪汪！");
    }
}

// -- 子类 Cat --

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + "：喵喵喵~");
    }
}

// -- 演示 --

public class L08_Inheritance {

    public static void main(String[] args) {

        // 1. 继承：子类复用父类代码

        Dog dog = new Dog("旺财");
        Cat cat = new Cat("咪咪");

        dog.eat();        // 继承自父类，不用重写
        cat.eat();


        // 2. 方法重写

        dog.makeSound();  // 汪汪汪（Dog 自己的版本）
        cat.makeSound();  // 喵喵喵（Cat 自己的版本）


        // 练习：
        // 1) 新增一个 Fish 类继承 Animal，重写 makeSound() 输出 "咕噜咕噜~"
        // 2) 给 Dog 类加一个 fetch() 方法，测试只有 Dog 能调用
        // 3) 在 Dog 的 makeSound() 里先调用 super.makeSound()，再输出自己的内容
    }
}
