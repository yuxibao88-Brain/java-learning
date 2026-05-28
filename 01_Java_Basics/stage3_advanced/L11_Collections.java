package stage3_advanced;

import java.util.*;

/**
 * ============================================
 * 📖 Java 学习第十一课：集合框架与泛型
 * ============================================
 *
 * 【数组 vs 集合】
 *   数组：长度固定、可以存基本类型
 *   集合：长度可变、只能存对象（自动装箱）
 *
 * 【常用集合】
 *   List（有序，可重复）
 *     - ArrayList：底层数组，查询快，增删慢
 *     - LinkedList：底层链表，增删快，查询慢
 *
 *   Set（无序，不可重复）
 *     - HashSet：基于 HashMap，O(1) 查找
 *     - TreeSet：有序，红黑树
 *
 *   Map（键值对）
 *     - HashMap：基于哈希表，O(1) 查找
 *     - TreeMap：有序，红黑树
 *
 * 【泛型】
 *   - List<String>：指定集合中存放的类型
 *   - 编译期类型检查，避免 ClassCastException
 */
public class L11_Collections {

    public static void main(String[] args) {
        // ==================== 1. ArrayList（最常用） ====================
        System.out.println("【ArrayList — 动态数组】");

        // 泛型 <> 指定元素类型（只能是引用类型）
        List<String> names = new ArrayList<>();  // Java 7+ 后面的 <> 可以省略类型

        // 添加元素
        names.add("张三");
        names.add("李四");
        names.add("王五");
        names.add("赵六");

        System.out.println("列表: " + names);
        System.out.println("大小: " + names.size());
        System.out.println("第2个: " + names.get(1));  // 索引从0开始

        // 遍历方式1：for 循环
        System.out.print("遍历1: ");
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + " ");
        }
        System.out.println();

        // 遍历方式2：增强 for
        System.out.print("遍历2: ");
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();

        // 遍历方式3：forEach + Lambda（Java 8+）
        System.out.print("遍历3: ");
        names.forEach(name -> System.out.print(name + " "));
        System.out.println();

        // 常用操作
        names.remove("王五");           // 删除元素
        names.add(1, "新同学");         // 在索引1插入
        boolean has = names.contains("张三");  // 是否包含
        System.out.println("修改后: " + names);
        System.out.println("包含张三? " + has);

        // ==================== 2. 基本类型与包装类 ====================
        System.out.println("\n【包装类 — 自动装箱/拆箱】");

        // 基本类型 → 包装类（自动装箱）
        // int → Integer, double → Double, boolean → Boolean, char → Character
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);    // 自动装箱：int → Integer
        numbers.add(20);
        numbers.add(30);

        int sum = 0;
        for (int n : numbers) {  // 自动拆箱：Integer → int
            sum += n;
        }
        System.out.println("整数列表: " + numbers);
        System.out.println("总和: " + sum);

        // ==================== 3. HashSet（去重） ====================
        System.out.println("\n【HashSet — 去重】");

        Set<String> set = new HashSet<>();
        set.add("苹果");
        set.add("香蕉");
        set.add("苹果");   // 重复的不会添加
        set.add("橙子");
        set.add("香蕉");   // 重复的不会添加

        System.out.println("集合(去重后): " + set + " 大小: " + set.size());

        // ==================== 4. HashMap（键值对，最常用） ====================
        System.out.println("\n【HashMap — 键值对】");

        Map<String, Integer> scores = new HashMap<>();
        scores.put("张三", 95);
        scores.put("李四", 88);
        scores.put("王五", 76);
        scores.put("赵六", 92);

        System.out.println("成绩表: " + scores);
        System.out.println("张三的成绩: " + scores.get("张三"));
        System.out.println("是否有李四? " + scores.containsKey("李四"));

        // 遍历 HashMap
        System.out.println("\n遍历方式1 — keySet:");
        for (String key : scores.keySet()) {
            System.out.println("  " + key + " → " + scores.get(key));
        }

        System.out.println("遍历方式2 — entrySet:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("  " + entry.getKey() + " → " + entry.getValue());
        }

        // ==================== 5. Collections 工具类 ====================
        System.out.println("\n【Collections 工具类】");

        List<Integer> nums = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 3));

        Collections.sort(nums);                          // 排序
        System.out.println("排序: " + nums);

        Collections.reverse(nums);                       // 反转
        System.out.println("反转: " + nums);

        Collections.shuffle(nums);                       // 打乱
        System.out.println("打乱: " + nums);

        int max = Collections.max(nums);                 // 最大值
        int min = Collections.min(nums);                 // 最小值
        System.out.println("最大值: " + max + ", 最小值: " + min);

        // ==================== 6. 综合练习：学生管理系统模拟 ====================
        System.out.println("\n【综合练习 — 学生管理】");

        // 用 Map 存储学生信息
        Map<String, List<Integer>> studentGrades = new HashMap<>();

        // 添加学生成绩
        studentGrades.put("张三", Arrays.asList(95, 88, 92));
        studentGrades.put("李四", Arrays.asList(78, 85, 80));
        studentGrades.put("王五", Arrays.asList(88, 92, 96));

        // 计算每个学生的平均分
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
