package stage3_advanced;

import java.util.*;

/**
 * ===================================
 * 📖 Java 学习第十一课：集合框架
 * ===================================
 *
 * ⭐⭐⭐ 开发中用得最多的课！比数组重要 100 倍！
 *
 * ⭐ 核心知识（2 个就够）：
 *   1. ArrayList：动态数组，增删改查
 *   2. HashMap：键值对，根据 key 查 value
 *
 * 💡 HashSet/TreeMap/LinkedList 等用到让 AI 帮查
 */
public class L11_Collections {

    public static void main(String[] args) {

        // ========== ⭐ 1. ArrayList（最常用！）==========
        System.out.println("【ArrayList】");

        List<String> names = new ArrayList<>();

        names.add("张三");           // 增
        names.add("李四");
        names.add("王五");
        System.out.println("列表: " + names);
        System.out.println("大小: " + names.size());   // 注意是 size() 不是 length
        System.out.println("第2个: " + names.get(1));   // 李四

        names.remove("王五");        // 删
        names.set(0, "张三丰");       // 改
        boolean has = names.contains("李四");  // 查
        System.out.println("修改后: " + names + "，包含李四? " + has);

        // 遍历（增强 for 最常用）
        for (String name : names) {
            System.out.println("  → " + name);
        }

        // ========== ⭐ 2. HashMap（键值对）==========
        System.out.println("\n【HashMap】");

        Map<String, Integer> scores = new HashMap<>();

        scores.put("张三", 95);      // 存
        scores.put("李四", 88);
        scores.put("王五", 76);

        System.out.println("张三: " + scores.get("张三"));        // 取
        System.out.println("有李四? " + scores.containsKey("李四"));

        // 取不到时给默认值（避免 null）
        int s = scores.getOrDefault("不存在", 0);
        System.out.println("不存在: " + s);

        // 遍历 HashMap
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("  " + entry.getKey() + " → " + entry.getValue());
        }
    }
}
