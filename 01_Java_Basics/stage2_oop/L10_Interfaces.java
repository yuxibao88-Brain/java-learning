package stage2_oop;

/**
 * L10 接口（Interface）
 *
 * 核心知识：
 *   1. interface 定义接口，implements 实现接口
 *   2. 一个类可以实现多个接口（弥补单继承限制）
 *
 * Spring Boot 经典模式：UserService(接口) -> UserServiceImpl(实现)
 */

// -- 定义接口 --

@SuppressWarnings("all")
interface Flyable {
    void fly();  // 接口方法：只有签名，没有方法体
}

interface Swimmable {
    void swim();
}

// -- 实现接口 --

// Bird 能飞
class Bird implements Flyable {
    private String name;
    public Bird(String name) { this.name = name; }

    @Override
    public void fly() { System.out.println(name + " 在飞"); }
}

// Duck 能飞也能游（实现多个接口）
class Duck implements Flyable, Swimmable {
    private String name;
    public Duck(String name) { this.name = name; }

    @Override
    public void fly() { System.out.println(name + " 笨拙地飞"); }

    @Override
    public void swim() { System.out.println(name + " 在水上游"); }
}

// Fish 只能游
class Fish implements Swimmable {
    private String name;
    public Fish(String name) { this.name = name; }

    @Override
    public void swim() { System.out.println(name + " 在水里游"); }
}

// -- 演示 --

public class L10_Interfaces {

    public static void main(String[] args) {

        // 1. 实现接口

        Bird bird = new Bird("小麻雀");
        Duck duck = new Duck("唐老鸭");
        Fish fish = new Fish("小金鱼");

        bird.fly();
        duck.fly();
        duck.swim();  // Duck 实现了两个接口，既能飞又能游
        fish.swim();


        // 2. 接口多态：统一处理

        // Flyable 类型可以指向任何"能飞的"对象
        Flyable[] flyers = {new Bird("燕子"), new Duck("绿头鸭")};
        for (Flyable f : flyers) {
            f.fly();
        }

        System.out.println("\nSpring Boot 模式：");
        System.out.println("  interface UserService -> class UserServiceImpl");


        // 练习：
        // 1) 新增 Runnable 接口，让 Duck 同时实现 Flyable、Swimmable、Runnable
        // 2) 写一个方法 testFly(Flyable f)，传入 Bird 和 Duck 测试
        // 3) 创建 Flyable[] 数组，放入所有能飞的对象，遍历调用 fly()
    }
}
