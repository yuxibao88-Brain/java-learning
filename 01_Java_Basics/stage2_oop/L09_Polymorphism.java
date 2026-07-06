package stage2_oop;

/**
 * ===================================
 * 📖 Java 学习第九课：多态与抽象类
 * ===================================
 *
 * ⭐ 核心知识（2 个就够）：
 *   1. 多态：父类引用指向子类对象，同一方法不同行为
 *   2. abstract 抽象类：不能 new，子类必须实现抽象方法
 *
 * 💡 static/final 用到让 AI 帮查
 * 💡 多态在 Spring 中无处不在（Service 接口 → 不同实现类）
 */

// ========== 抽象类：形状 ==========
@SuppressWarnings("all")
abstract class Shape {
    protected String name;

    public Shape(String name) { this.name = name; }

    // 抽象方法：子类必须实现
    public abstract double getArea();

    public void printInfo() {
        System.out.printf("%s → 面积: %.2f\n", name, getArea());
    }
}

// ========== 子类 ==========
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("圆形");
        this.radius = radius;
    }

    @Override
    public double getArea() { return Math.PI * radius * radius; }
}

class Rectangle extends Shape {
    private double w, h;

    public Rectangle(double w, double h) {
        super("矩形");
        this.w = w;
        this.h = h;
    }

    @Override
    public double getArea() { return w * h; }
}

// ========== 演示 ==========
public class L09_Polymorphism {

    public static void main(String[] args) {

        // ========== ⭐ 1. 多态：父类引用 → 子类对象 ==========
        System.out.println("【多态】");

        Shape s1 = new Circle(5);        // Shape 类型，实际是 Circle
        Shape s2 = new Rectangle(4, 6);  // Shape 类型，实际是 Rectangle

        s1.printInfo();  // 圆形 → 面积: 78.54
        s2.printInfo();  // 矩形 → 面积: 24.00

        // ========== ⭐ 2. 多态的好处：统一处理 ==========
        System.out.println("\n【统一处理不同类型】");

        Shape[] shapes = {new Circle(3), new Rectangle(5, 8), new Circle(7)};

        double total = 0;
        for (Shape s : shapes) {
            s.printInfo();           // 每个形状自己决定怎么算面积
            total += s.getArea();
        }
        System.out.printf("总面积: %.2f\n", total);

        // ========== 🏋️ 动手练习 ==========
        // 练习 1：新增 Triangle 类继承 Shape，实现 getArea()（面积 = 底 x 高 / 2）
        // 练习 2：在 shapes 数组里加入一个 Triangle，验证多态能正常工作
        // 练习 3：给 Shape 加一个抽象方法 getPerimeter()（周长），让所有子类实现
    }
}
