package stage3_advanced;

import java.util.*;

/**
 * ===================================
 * 📖 Java 学习第十一课：集合框架（Collections）
 * ===================================
 *
 * ⭐⭐⭐ 这是开发中用得最多的课！比数组重要 100 倍！
 *
 * ⭐ 必须掌握（天天用）：
 *   - ArrayList：动态数组，最常用的集合，可以增删改查
 *   - HashMap：键值对，根据 key 快速查找 value
 *   - 泛型 <String>：指定集合存放的类型
 *   - 遍历方式：增强 for、forEach + Lambda
 *
 * ⭐ 需要掌握：
 *   - HashSet：去重集合
 *   - Collections 工具类：排序、最大值等
 *   - 包装类：int ↔ Integer 自动装箱/拆箱
 *
 * 💡 了解即可：
 *   - LinkedList、TreeSet、TreeMap（知道存在就行，用到再查）
 *   - 底层原理（数组/链表/哈希表/红黑树）
 */
public class L11_Collections {

    public static void main(String[] args) {
        // ==================== ⭐ 1. ArrayList（开发最常用！）====================
        System.out.println("【ArrayList — 可变长度的数组】");

        // 创建一个存放 String 的列表（泛型 <String> 指定类型）
        List<String> names = new ArrayList<>();

        // 增
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");

        System.out.println("列表: " + names);             // [张三, 李四, 王五, 赵六]
        System.out.println("大小: " + names.size());       // 4（不是 length，是 size()！）
        System.out.println("第2个: " + names.get(1));      // 李四（索引从 0 开始）

        // 删
        names.remove("王五");                              // 按值删除
        // names.remove(0);                                // 按索引删除

        // 改
        names.set(0, "张三丰");                             // 修改第1个元素

        // 查
        boolean has = names.contains("李四");               // 是否包含
        int idx = names.indexOf("李四");                    // 查找索引位置

        System.out.println("修改后: " + names);
        System.out.println("包含李四? " + has + "，位置: " + idx);

        // ==================== ⭐ 遍历 ArrayList ====================
        System.out.println("\n【遍历方式】");

        // 方式1：增强 for（最常用 ✅）
        System.out.print("增强for: ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();

        // 方式2：forEach + Lambda（Java 8+，简洁 ✅）
        System.out.print("Lambda: ");
        names.forEach(name -> System.out.print(name + " "));
        System.out.println();

        // 方式3：普通 for（需要索引时用）
        System.out.print("普通for: ");
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + " ");
        }
        System.out.println();

        // ==================== ⭐ 2. 包装类（集合只能存对象）====================
        System.out.println("\n【包装类 — int ↔ Integer 自动转换】");

        // 集合不能存 int，要用 Integer（包装类）
        // int → Integer：自动装箱 | Integer → int：自动拆箱
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);    // 自动装箱：int → Integer
        numbers.add(20);
        numbers.add(30);

        int sum = 0;
        for (int n : numbers) {  // 自动拆箱：Integer → int
            sum += n;
        }
        System.out.println("整数列表: " + numbers + "，总和: " + sum);

        // 💡 常见包装类：int→Integer, double→Double, boolean→Boolean, char→Character

        // ==================== ⭐ 3. HashMap（键值对，超常用！）====================
        System.out.println("\n【HashMap — 根据 key 查 value】");

        Map<String, Integer> scores = new HashMap<>();

        // 存
        scores.put("张三", 95);
        scores.put("李四", 88);
        scores.put("王五", 76);
        scores.put("赵六", 92);

        // 取
        System.out.println("成绩表: " + scores);
        System.out.println("张三的成绩: " + scores.get("张三"));        // 95
        System.out.println("是否有李四? " + scores.containsKey("李四")); // true

        // 取不到时给默认值（避免 null）
        int score = scores.getOrDefault("不存在的人", 0);
        System.out.println("不存在的人: " + score);   // 0

        // ⭐ 遍历 HashMap（entrySet 最常用）
        System.out.println("\n遍历 HashMap:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("  " + entry.getKey() + " → " + entry.getValue());
        }

        // ==================== ⭐ 4. HashSet（去重）====================
        System.out.println("\n【HashSet — 自动去重】");

        Set<String> set = new HashSet<>();
        set.add("苹果");
        set.add("香蕉");
        set.add("苹果");   // 重复！不会添加
        set.add("橙子");
        set.add("香蕉");   // 重复！不会添加

        System.out.println("去重后: " + set + "，大小: " + set.size());  // 3

        // 💡 实际场景：去重用户ID、去重标签等

        // ==================== ⭐ 5. Collections 工具类 ====================
        System.out.println("\n【Collections 工具类】");

        List<Integer> nums = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 3));

        Collections.sort(nums);          // 排序
        System.out.println("排序: " + nums);

        Collections.reverse(nums);       // 反转
        System.out.println("反转: " + nums);

        System.out.println("最大值: " + Collections.max(nums));
        System.out.println("最小值: " + Collections.min(nums));

        // ==================== 💡 6. 综合练习 ====================
        System.out.println("\n【综合 — Map + List 嵌套】");

        // 实际场景：每个学生有多门课的成绩
        Map<String, List<Integer>> studentGrades = new HashMap<>();
        studentGrades.put("张三", Arrays.asList(95, 88, 92));
        studentGrades.put("李四", Arrays.asList(78, 85, 80));
        studentGrades.put("王五", Arrays.asList(88, 92, 96));

        for (Map.Entry<String, List<Integer>> entry : studentGrades.entrySet()) {
            String student = entry.getKey();
            List<Integer> grades = entry.getValue();

            double avg = 0;
            for (int g : grades) {
                avg += g;
            }
            avg /= grades.size();

            System.out.printf("%s 的成绩: %s → 平均分: %.1f\n", student, grades, avg);
        }
    }
}
