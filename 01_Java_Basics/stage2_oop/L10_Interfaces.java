package stage2_oop;

/**
 * ============================================
 * 📖 Java 学习第十课：接口（Interface）
 * ============================================
 *
 * 【接口 vs 抽象类】
 *   接口：
 *     - 用 interface 关键字定义
 *     - 只有抽象方法（Java 8+ 可以有 default/static 方法）
 *     - 一个类可以实现多个接口（弥补单继承的限制）
 *     - 表示"能做什么"的能力
 *   抽象类：
 *     - 可以有普通方法和字段
 *     - 只能单继承
 *     - 表示"是什么"
 */

// ========== 接口1：飞行能力 ==========
interface Flyable {
    // 接口中的方法默认是 public abstract
    void fly();

    // Java 8+ 可以有 default 方法（带方法体的默认实现）
    default void takeOff() {
        System.out.println("准备起飞... 🛫");
    }
}

// ========== 接口2：游泳能力 ==========
interface Swimmable {
    void swim();

    default void dive() {
        System.out.println("潜入水中... 🌊");
    }
}

// ========== 接口3：叫声能力 ==========
interface Speakable {
    String speak();  // 返回值是 String
}

// ========== 鸟：实现多个接口 ==========
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

// ========== 鸭子：实现多个接口 ==========
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

// ========== 鱼：只实现游泳接口 ==========
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
        System.out.println("【接口示例】");

        // ==================== 1. 实现多个接口 ====================
        Bird bird = new Bird("小麻雀");
        Duck duck = new Duck("唐老鸭");
        Fish fish = new Fish("小金鱼");

        // 调用接口方法
        bird.takeOff();
        bird.fly();
        System.out.println(bird.speak());

        System.out.println();

        duck.takeOff();
        duck.fly();
        duck.swim();
        duck.dive();
        System.out.println(duck.speak());

        System.out.println();

        fish.swim();
        fish.dive();

        // ==================== 2. 接口多态 ====================
        System.out.println("\n【接口多态】");

        // Flyable 类型可以指向任何实现了 Flyable 的对象
        Flyable[] flyers = { new Bird("燕子"), new Duck("绿头鸭") };

        for (Flyable f : flyers) {
            f.takeOff();
            f.fly();
        }

        // 但 Flyable 类型无法调用 Swimmable 或 Speakable 的方法
        // flyers[1].swim();  // ❌ 编译错误！Flyable 没有 swim 方法

        // 需要先转型
        if (flyers[1] instanceof Swimmable) {
            ((Swimmable) flyers[1]).swim();  // 强制转型后可以调用
        }

        System.out.println("\n✅ 接口让 Java 可以'多继承'能力！");
    }
}
