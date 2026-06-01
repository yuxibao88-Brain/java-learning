-- ============================================
-- 📖 第二站 L04：进阶查询（联表、子查询）
-- ============================================
-- ⭐ 联表查询是后端开发的必备技能

USE java_learning;

-- 先准备测试数据
INSERT INTO user (username, password, nickname) VALUES
('zhangsan', '123456', '张三'),
('lisi', '123456', '李四'),
('wangwu', '123456', '王五')
ON DUPLICATE KEY UPDATE nickname = VALUES(nickname);

INSERT INTO article (title, content, user_id) VALUES
('Java 入门', 'Java 是一门面向对象的语言...', 1),
('Spring Boot 教程', 'Spring Boot 让开发变简单...', 1),
('MySQL 学习笔记', 'SQL 是操作数据库的语言...', 2),
('前端 Vue 入门', 'Vue 是一个前端框架...', 2),
('Docker 部署', 'Docker 让部署变简单...', 3);

-- ==================== ⭐ 1. 联表查询（JOIN）====================
-- 💡 JOIN = 把两张表关联起来查询

-- INNER JOIN：只查有匹配的数据（最常用 ✅）
SELECT a.title, a.create_time, u.nickname AS 作者
FROM article a
INNER JOIN user u ON a.user_id = u.id;

-- LEFT JOIN：左表全部 + 右表匹配的（左表为主）
-- 即使用户没有文章，也会显示
SELECT u.nickname, a.title
FROM user u
LEFT JOIN article a ON u.id = a.user_id;

-- 💡 实际开发中 LEFT JOIN 比 INNER JOIN 用得更多
--    因为经常需要"即使没有关联数据也要显示"

-- ==================== ⭐ 2. 联表 + 统计 ====================

-- 查询每个用户发了多少篇文章
SELECT u.nickname AS 用户, COUNT(a.id) AS 文章数
FROM user u
LEFT JOIN article a ON u.id = a.user_id
GROUP BY u.id, u.nickname;

-- ==================== ⭐ 3. 子查询 ====================
-- 💡 子查询 = 查询里面套查询（SQL 的嵌套）

-- 查询发文最多的用户的所有文章
SELECT * FROM article
WHERE user_id = (
    SELECT user_id FROM article
    GROUP BY user_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
);

-- IN 子查询：查询发过文章的用户信息
SELECT * FROM user
WHERE id IN (
    SELECT DISTINCT user_id FROM article
);

-- EXISTS 子查询（效率通常比 IN 更好）
SELECT * FROM user u
WHERE EXISTS (
    SELECT 1 FROM article a WHERE a.user_id = u.id
);

-- ==================== ⭐ 4. 常用函数 ====================

-- 字符串函数
SELECT CONCAT('Hello', ' ', 'World') AS 拼接;          -- Hello World
SELECT LENGTH('你好') AS 长度;                            -- 字节长度
SELECT CHAR_LENGTH('你好') AS 字符长度;                    -- 2
SELECT UPPER('hello') AS 大写;                           -- HELLO
SELECT TRIM('  hello  ') AS 去空格;                      -- hello
SELECT SUBSTRING('Hello World', 1, 5) AS 截取;          -- Hello

-- 日期函数
SELECT NOW() AS 当前时间;                                 -- 当前日期时间
SELECT CURDATE() AS 今天;                                -- 当前日期
SELECT DATE_FORMAT(NOW(), '%Y-%m-%d %H:%i') AS 格式化;   -- 2026-06-01 15:00
SELECT DATEDIFF('2026-12-31', NOW()) AS 剩余天数;        -- 距离年底的天数

-- 条件函数（开发常用！）
SELECT name,
    CASE
        WHEN age >= 22 THEN '大学毕业'
        WHEN age >= 18 THEN '大学在读'
        ELSE '未成年'
    END AS 阶段
FROM student;

-- IF 函数（简单条件）
SELECT name,
    IF(gender = '男', '♂', '♀') AS 性别符号
FROM student;

-- IFNULL（空值处理，开发超常用！）
SELECT name,
    IFNULL(email, '未填写') AS 邮箱
FROM student;
