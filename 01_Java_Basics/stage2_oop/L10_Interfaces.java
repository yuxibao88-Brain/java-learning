package stage2_oop;

/**
 * ===================================
 * 📖 Java 学习第十课：接口（Interface）
 * ===================================
 *
 * ⭐ 必须掌握：
 *   - interface 定义接口，implements 实现接口
 *   - 一个类可以实现多个接口（弥补 Java 单继承的限制）
 *   - 接口中的方法默认是 public abstract（只有方法签名，没有方法体）
 *   - 接口 = 定义"能做什么"的规范/契约
 *
 * ⭐ 接口 vs 抽象类（面试常问）：
 *   接口：表示"能力"（Flyable = 能飞的），可以多实现
 *   抽象类：表示"是什么"（Animal = 是动物），只能单继承
 *
 * 💡 了解即可：
 *   - default 方法（Java 8+）：接口中可以有默认实现
 *   - 接口多态：用接口类型引用具体实现
 *
 * 💡 实际开发提示：
 *   Spring Boot 中大量使用接口！
 *   典型模式：UserService(接口) → UserServiceImpl(实现类)
 */

// ========== ⭐ 定义接口：飞行能力 ==========
@SuppressWarnings("all")
interface Flyable {
    // 接口方法默认 public abstract，不需要写方法体
    void fly();

    // Java 8+ 可以有默认实现（子类可以直接用，也可以重写）
    default void takeOff() {
        System.out.println("准备起飞... 🛫");
    }
}

// ========== ⭐ 定义接口：游泳能力 ==========
@SuppressWarnings("all")
interface Swimmable {
    void swim();

    default void dive() {
        System.out.println("潜入水中... 🌊");
    }
}

// ========== 定义接口：叫声能力 ==========
interface Speakable {
    String speak();
}

// ========== ⭐ 实现接口：一个类可以实现多个接口 ==========

// Bird 实现了 Flyable + Speakable
class Bird implements Flyable, Speakable {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println(name + " 在天空中飞翔 🐦");
    }

    @Override
    public String speak() {
        return name + "：叽叽喳喳！";
    }
}

// Duck 实现了三个接口！（多继承能力）
class Duck implements Flyable, Swimmable, Speakable {
    private String name;

    public Duck(String name) {
        this.name = name;
    }

    @Override
    public void fly() {
        System.out.println(name + " 笨拙地飞起来 🦆");
    }

    @Override
    public void swim() {
        System.out.println(name + " 在水面上游来游去");
    }

    @Override
    public String speak() {
        return name + "：嘎嘎嘎！";
    }
}

// Fish 只实现游泳接口
class Fish implements Swimmable {
    private String name;

    public Fish(String name) {
        this.name = name;
    }

    @Override
    public void swim() {
        System.out.println(name + " 在水里自由游动 🐟");
    }
}

// ========== 演示类 ==========
public class L10_Interfaces {

    public static void main(String[] args) {
        // ==================== ⭐ 1. 实现接口 ====================
        System.out.println("【接口 — 定义能力规范】");

        Bird bird = new Bird("小麻雀");
        Duck duck = new Duck("唐老鸭");
        Fish fish = new Fish("小金鱼");

        // Bird 能飞、能叫
        bird.takeOff();               // default 方法，不用重写就能用
        bird.fly();
        System.out.println(bird.speak());

        System.out.println();

        // Duck 能飞、能游、能叫（实现了三个接口！）
        duck.takeOff();
        duck.fly();
        duck.swim();
        duck.dive();                  // default 方法
        System.out.println(duck.speak());

        System.out.println();

        // Fish 只能游
        fish.swim();
        fish.dive();

        // ==================== ⭐ 2. 接口多态 ====================
        System.out.println("\n【接口多态 — 用接口类型统一处理】");

        // Flyable 类型可以指向任何"能飞的"对象
        Flyable[] flyers = { new Bird("燕子"), new Duck("绿头鸭") };

        for (Flyable f : flyers) {
            f.takeOff();
            f.fly();
        }

        // ⚠️ 但 Flyable 类型不能调用 swim()
        // flyers[1].swim();  // ❌ 编译错误！Flyable 接口没有 swim 方法

        // 💡 需要先用 instanceof 判断，再强转
        if (flyers[1] instanceof Swimmable) {
            ((Swimmable) flyers[1]).swim();
        }

        // ==================== 💡 3. 实际开发中的接口模式 ====================
        System.out.println("\n【💡 实际开发中的接口用法】");
        System.out.println("Spring Boot 典型模式：");
        System.out.println("  interface UserService { User findById(int id); }");
        System.out.println("  class UserServiceImpl implements UserService { ... }");
        System.out.println("→ 面向接口编程，方便替换实现和单元测试！");
    }
}
