package stage2_oop;

/**
 * ============================================
 * 📖 Java 学习第九课：多态与抽象类
 * ============================================
 *
 * 【多态（Polymorphism）】
 *   父类引用指向子类对象：Animal a = new Dog()
 *   同一个方法调用，产生不同的行为
 *
 * 【抽象类（abstract class）】
 *   - 不能被实例化（不能 new）
 *   - 可以有抽象方法（没有方法体）和普通方法
 *   - 子类必须实现所有抽象方法
 */

// ========== 抽象类：形状 ==========
abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    // 抽象方法：子类必须实现
    public abstract double getArea();
    public abstract double getPerimeter();

    // 普通方法：所有子类共享
    public void printInfo() {
        System.out.printf("%s → 面积: %.2f, 周长: %.2f\n",
            name, getArea(), getPerimeter());
    }
}

// ========== 子类：圆 ==========
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("圆形");
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

// ========== 子类：矩形 ==========
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super("矩形");
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

// ========== 子类：三角形 ==========
class Triangle extends Shape {
    private double a, b, c;  // 三条边

    public Triangle(double a, double b, double c) {
        super("三角形");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        // 海伦公式
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
}

// ========== 演示类 ==========
public class L09_Polymorphism {

    public static void main(String[] args) {
        System.out.println("【多态示例】");

        // ==================== 1. 多态：父类引用指向子类对象 ====================
        // 声明为 Shape 类型，实际是不同子类实例
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(4, 6);
        Shape s3 = new Triangle(3, 4, 5);

        // 同一个方法调用，产生不同的行为 —— 这就是多态！
        s1.printInfo();
        s2.printInfo();
        s3.printInfo();

        // ==================== 2. 多态的好处：用数组统一处理 ====================
        System.out.println("\n【多态的好处】");

        Shape[] shapes = {
            new Circle(3),
            new Rectangle(5, 8),
            new Triangle(6, 8, 10),
            new Circle(7)
        };

        double totalArea = 0;
        for (Shape shape : shapes) {
            shape.printInfo();
            totalArea += shape.getArea();
        }

        System.out.printf("\n总面积: %.2f\n", totalArea);

        // ==================== 3. 抽象类不能实例化 ====================
        // Shape s = new Shape("测试");  // ❌ 编译错误！抽象类不能 new

        // ==================== 4. static 与 final ====================
        System.out.println("\n【static 与 final】");

        // static：属于类，不属于对象
        MathUtils.sayHello();

        // final 类不能被继承
        FinalExample example = new FinalExample();
        example.show();
    }
}

// ========== static 示例 ==========
class MathUtils {
    // static 常量：类级别的常量
    public static final double PI = 3.14159;

    // static 方法：可以通过类名直接调用
    public static void sayHello() {
        System.out.println("Hello from static method!");
    }

    // static 方法中不能访问非 static 成员
    // 因为 static 方法属于类，没有 this 对象
}

// ========== final 示例 ==========
final class FinalExample {
    // final 变量：不能重新赋值
    private final String name = "不变的名称";

    // final 方法：子类不能重写
    public final void show() {
        System.out.println("final 类: " + name);
        System.out.println("final 类不能被继承，final 方法不能被重写");
    }
}
