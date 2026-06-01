-- ============================================
-- 📖 第二站 L02：增删改查（CRUD）
-- ============================================
-- ⭐⭐⭐ 这是 SQL 最核心的内容！开发中 90% 的 SQL 都是这些

-- 先创建数据库和表
CREATE DATABASE IF NOT EXISTS java_learning DEFAULT CHARACTER SET utf8mb4;
USE java_learning;

-- ==================== ⭐ 1. 创建表（CREATE TABLE）====================

CREATE TABLE IF NOT EXISTS student (
    id          INT PRIMARY KEY AUTO_INCREMENT,   -- 主键，自增
    name        VARCHAR(50) NOT NULL,              -- 姓名，不能为空
    age         INT,                               -- 年龄
    gender      VARCHAR(10) DEFAULT '未知',         -- 性别，默认值
    email       VARCHAR(100),                      -- 邮箱
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP -- 创建时间，自动填入
);

-- 💡 常用字段类型：
--   INT          整数
--   BIGINT       大整数（ID、时间戳）
--   VARCHAR(n)   可变长度字符串（n 是最大长度）
--   TEXT         长文本
--   DECIMAL(10,2) 精确小数（金额必须用这个！不要用 float/double）
--   DATETIME     日期时间
--   TINYINT      0/1（常用来表示布尔值）

-- ==================== ⭐ 2. 插入数据（INSERT）====================

-- 插入单条
INSERT INTO student (name, age, gender, email)
VALUES ('张三', 20, '男', 'zhangsan@example.com');

-- 插入多条（一次性）
INSERT INTO student (name, age, gender, email) VALUES
('李四', 22, '男', 'lisi@example.com'),
('王五', 21, '女', 'wangwu@example.com'),
('赵六', 23, '男', 'zhaoliu@example.com'),
('小红', 20, '女', 'xiaohong@example.com'),
('小明', 24, '男', 'xiaoming@example.com');

-- ==================== ⭐ 3. 查询数据（SELECT）— 用得最多！ ====================

-- 查询所有
SELECT * FROM student;

-- 查询指定列
SELECT name, age, email FROM student;

-- 条件查询（WHERE）
SELECT * FROM student WHERE age >= 22;
SELECT * FROM student WHERE gender = '女';
SELECT * FROM student WHERE age >= 20 AND gender = '男';
SELECT * FROM student WHERE age < 21 OR age > 23;

-- 模糊查询（LIKE）
SELECT * FROM student WHERE name LIKE '小%';   -- 以"小"开头
SELECT * FROM student WHERE email LIKE '%example%';  -- 包含"example"

-- 排序（ORDER BY）
SELECT * FROM student ORDER BY age ASC;        -- 按年龄升序（默认）
SELECT * FROM student ORDER BY age DESC;       -- 按年龄降序

-- 限制数量（LIMIT）— 分页必用！
SELECT * FROM student LIMIT 3;                 -- 只取前3条
SELECT * FROM student LIMIT 2, 3;              -- 跳过2条，取3条（分页）

-- 去重（DISTINCT）
SELECT DISTINCT gender FROM student;

-- 统计函数
SELECT COUNT(*) AS 总人数 FROM student;                     -- 计数
SELECT AVG(age) AS 平均年龄 FROM student;                    -- 平均值
SELECT MAX(age) AS 最大年龄, MIN(age) AS 最小年龄 FROM student;  -- 最大最小
SELECT SUM(age) AS 年龄总和 FROM student;                    -- 求和

-- 分组统计（GROUP BY）
SELECT gender, COUNT(*) AS 人数, AVG(age) AS 平均年龄
FROM student
GROUP BY gender;

-- 分组后过滤（HAVING）
SELECT gender, COUNT(*) AS 人数
FROM student
GROUP BY gender
HAVING COUNT(*) >= 3;    -- 只要人数 >= 3 的组

-- 💡 WHERE vs HAVING：
--   WHERE 在分组前过滤（过滤行）
--   HAVING 在分组后过滤（过滤组）

-- ==================== ⭐ 4. 更新数据（UPDATE）====================

-- ⚠️ UPDATE 一定要带 WHERE，否则会修改所有行！！！
UPDATE student SET age = 25 WHERE name = '张三';
UPDATE student SET age = age + 1, email = 'new@example.com' WHERE id = 1;

-- ==================== ⭐ 5. 删除数据（DELETE）====================

-- ⚠️ DELETE 一定要带 WHERE，否则会删除所有数据！！！
DELETE FROM student WHERE name = '赵六';

-- 💡 实际开发中很少真的删除数据，通常用"逻辑删除"：
--   给表加一个 is_deleted 字段（0=正常，1=已删除）
--   "删除"时：UPDATE student SET is_deleted = 1 WHERE id = ?
--   查询时：SELECT * FROM student WHERE is_deleted = 0

-- ==================== ⭐ 6. 别名（AS）====================

-- 给列起别名（让输出更易读）
SELECT name AS 姓名, age AS 年龄, email AS 邮箱
FROM student;

-- 给表起别名（联表查询时常用）
SELECT s.name, s.age FROM student s WHERE s.age > 20;

-- ==================== 查看最终结果 ====================
SELECT * FROM student;
