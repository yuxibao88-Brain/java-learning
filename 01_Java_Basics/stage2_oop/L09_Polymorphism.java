package stage2_oop;

/**
 * ============================================
 * 📖 Java 学习第九课：多态与抽象类
 * ============================================
 *
 * ⭐ 必须掌握：
 *   - 多态：父类引用指向子类对象 → Animal a = new Dog()
 *   - 同一个方法调用，产生不同的行为 ← 这就是多态的威力
 *   - abstract 抽象类：不能 new，子类必须实现抽象方法
 *   - static 方法：属于类，通过类名直接调用
 *
 * 💡 了解即可：
 *   - final 类/方法/变量（不能继承/重写/修改）
 *   - 向上转型/向下转型的细节
 *
 * 💡 实际开发提示：
 *   多态在 Spring 中无处不在！
 *   比如 Service 接口有多个实现类，框架会根据配置选择具体用哪个
 */

// ========== ⭐ 抽象类：形状 ==========
// abstract = 不能被 new，只能被继承
abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    // ⭐ 抽象方法：只有方法签名，没有方法体
    // 子类必须实现这些方法，否则编译报错
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
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        super("三角形");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
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
        // ==================== ⭐ 1. 多态：父类引用 → 子类对象 ====================
        System.out.println("【多态 — 同一方法，不同行为】");

        // 声明为 Shape 类型，但实际是不同的子类
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(4, 6);
        Shape s3 = new Triangle(3, 4, 5);

        // 同一个 printInfo()，但内部调用的 getArea() 各不相同 ← 多态！
        s1.printInfo();  // 圆形 → 面积: 78.54, 周长: 31.42
        s2.printInfo();  // 矩形 → 面积: 24.00, 周长: 20.00
        s3.printInfo();  // 三角形 → 面积: 6.00, 周长: 12.00

        // ==================== ⭐ 2. 多态的好处：统一处理 ====================
        System.out.println("\n【多态的好处 — 用数组/集合统一处理】");

        // 不管是圆、矩形还是三角形，都放在 Shape 数组里统一处理
        Shape[] shapes = {
            new Circle(3),
            new Rectangle(5, 8),
            new Triangle(6, 8, 10),
            new Circle(7)
        };

        double totalArea = 0;
        for (Shape shape : shapes) {
            shape.printInfo();         // 每个形状自己决定怎么计算
            totalArea += shape.getArea();
        }
        System.out.printf("\n总面积: %.2f\n", totalArea);

        // ⚠️ 抽象类不能实例化
        // Shape s = new Shape("测试");  // ❌ 编译错误！不能 new 抽象类

        // ==================== ⭐ 3. static 静态方法 ====================
        System.out.println("\n【static — 属于类，不属于对象】");

        // static 方法通过类名直接调用，不需要 new 对象
        MathUtils.sayHello();
        System.out.println("PI = " + MathUtils.PI);

        // 💡 实际开发中，工具类的方法通常都是 static 的
        // 比如 StringUtils.isEmpty()、Collections.sort() 等

        // ==================== 💡 4. final（了解即可）====================
        System.out.println("\n【final — 不可变】");

        FinalExample example = new FinalExample();
        example.show();
        // final class → 不能被继承
        // final method → 不能被重写
        // final variable → 不能重新赋值（等同于常量）
    }
}

// ========== static 工具类示例 ==========
class MathUtils {
    // static 常量
    public static final double PI = 3.14159;

    // static 方法：不需要 new，通过类名调用
    public static void sayHello() {
        System.out.println("Hello from MathUtils.sayHello()!");
    }
}

// ========== final 类示例（了解即可）==========
final class FinalExample {
    private final String name = "不变的名称";

    public final void show() {
        System.out.println("final 类: " + name);
        System.out.println("→ final class 不能被继承，final method 不能被重写");
    }
}
