package stage1_basics;

/**
 * L03 条件判断
 *
 * 核心知识：
 * 1. if / else if / else 条件分支
 * 2. && (与) || (或) ! (非)
 * 3. 字符串比较必须用 .equals()，不能用 ==
 */
public class L03_Conditionals {

    public static void main(String[] args) {

        // 1. if-else（最常用）

        int score = 85;
        if (score >= 90) {
            System.out.println("优秀");
        } else if (score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

        // 2. 逻辑运算符

        int age = 25;
        boolean hasTicket = true;

        // && 与：都满足才行
        if (age >= 18 && hasTicket) {
            System.out.println("成年 + 有票 -> 可以入场");
        }

        // || 或：满足一个就行
        if (age < 12 || age >= 65) {
            System.out.println("免票");
        }

        // 3. 字符串比较（必须记住！）

        String a = "hello";
        String b = new String("hello");

        System.out.println("== 比较: " + (a == b)); // false（比的是地址）
        System.out.println("equals: " + a.equals(b)); // true（比的是内容）

        // 安全写法：常量放前面，防止 null 报错
        String input = null;
        System.out.println("安全写法: " + "hello".equals(input)); // false，不报错

        // 练习：
        // 1) 写一个成绩评级程序
        // score >= 90 -> "A"，>= 80 -> "B"，>= 70 -> "C"，>= 60 -> "D"，< 60 -> "F"
        double score1 = 100;
        if (score1 >= 90) {
            System.out.println("你的成绩是A");
        } else if (score1 >= 80) {
            System.out.println("你的成绩是B");
        }

        else if (score1 >= 70) {
            System.out.println("你的成绩是C");
        }

        else if (score1 >= 60) {
            System.out.println("你的成绩是D");
        }

        else {
            System.out.println("你的成绩是F");
        }
        // 2) 写一个判断闰年的程序（能被4整除且不能被100整除，或者能被400整除）
        int year = 2026;
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("今年是闰年");
        } else {
            System.out.println("今年不是闰年");
        }

        // 3) 定义 String password = "123456"，用 equals 判断用户输入是否匹配
        String password = "123456";
        String userInput = "123456";
        if (password.equals(userInput)) {
            System.out.println("输入符合");
        } else {
            System.out.println("输入不符合");
        }
    }
}
