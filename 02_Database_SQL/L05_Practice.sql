-- ============================================
-- 📖 第二站 L05：综合练习 — 图书管理系统
-- ============================================
-- 🏆 通关任务：设计并操作一个图书管理数据库

USE java_learning;

-- ==================== 1. 建表 ====================

-- 图书分类表
DROP TABLE IF EXISTS book_borrow;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS book_category;
DROP TABLE IF EXISTS member;

CREATE TABLE book_category (
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL UNIQUE COMMENT '分类名称',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) COMMENT '图书分类表';

-- 图书表
CREATE TABLE book (
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    title         VARCHAR(200) NOT NULL COMMENT '书名',
    author        VARCHAR(100) COMMENT '作者',
    category_id   BIGINT COMMENT '分类ID',
    price         DECIMAL(10,2) COMMENT '价格',
    stock         INT DEFAULT 0 COMMENT '库存数量',
    status        TINYINT DEFAULT 1 COMMENT '状态：1上架 0下架',
    is_deleted    TINYINT DEFAULT 0,
    create_time   DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time   DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_category_id (category_id),
    INDEX idx_title (title)
) COMMENT '图书表';

-- 会员表
CREATE TABLE member (
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL COMMENT '会员姓名',
    phone       VARCHAR(20) UNIQUE COMMENT '手机号',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) COMMENT '会员表';

-- 借阅记录表（多对多关系：会员 ↔ 图书）
CREATE TABLE book_borrow (
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    member_id   BIGINT NOT NULL COMMENT '会员ID',
    book_id     BIGINT NOT NULL COMMENT '图书ID',
    borrow_date DATE NOT NULL COMMENT '借阅日期',
    return_date DATE COMMENT '归还日期（NULL 表示未归还）',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_member_id (member_id),
    INDEX idx_book_id (book_id)
) COMMENT '借阅记录表';

-- ==================== 2. 插入测试数据 ====================

INSERT INTO book_category (name) VALUES
('编程技术'), ('文学小说'), ('人文社科'), ('自然科学');

INSERT INTO book (title, author, category_id, price, stock) VALUES
('Java 核心技术', 'Cay Horstmann', 1, 119.00, 5),
('Spring Boot 实战', 'Craig Walls', 1, 89.00, 3),
('深入理解 JVM', '周志明', 1, 129.00, 2),
('MySQL 必知必会', 'Ben Forta', 1, 59.00, 8),
('三体', '刘慈欣', 2, 68.00, 10),
('活着', '余华', 2, 39.00, 6),
('百年孤独', '马尔克斯', 2, 55.00, 4),
('人类简史', '赫拉利', 3, 68.00, 5),
('时间简史', '霍金', 4, 45.00, 3);

INSERT INTO member (name, phone) VALUES
('张三', '13800001111'),
('李四', '13800002222'),
('王五', '13800003333');

INSERT INTO book_borrow (member_id, book_id, borrow_date, return_date) VALUES
(1, 1, '2026-05-01', '2026-05-15'),
(1, 5, '2026-05-10', NULL),
(2, 2, '2026-05-05', '2026-05-20'),
(2, 6, '2026-05-15', NULL),
(2, 8, '2026-05-20', NULL),
(3, 1, '2026-05-25', NULL),
(3, 9, '2026-05-28', '2026-06-01');

-- ==================== 3. 练习查询 ====================

-- 🎯 练习1：查询所有编程技术类的书
SELECT b.title, b.author, b.price
FROM book b
JOIN book_category c ON b.category_id = c.id
WHERE c.name = '编程技术' AND b.is_deleted = 0;

-- 🎯 练习2：查询每个分类有多少本书
SELECT c.name AS 分类, COUNT(b.id) AS 图书数量
FROM book_category c
LEFT JOIN book b ON c.id = b.category_id AND b.is_deleted = 0
GROUP BY c.id, c.name;

-- 🎯 练习3：查询当前未归还的借阅记录
SELECT m.name AS 会员, b.title AS 图书, bb.borrow_date AS 借阅日期
FROM book_borrow bb
JOIN member m ON bb.member_id = m.id
JOIN book b ON bb.book_id = b.id
WHERE bb.return_date IS NULL
ORDER BY bb.borrow_date;

-- 🎯 练习4：查询借书最多的会员
SELECT m.name AS 会员, COUNT(*) AS 借阅次数
FROM book_borrow bb
JOIN member m ON bb.member_id = m.id
GROUP BY m.id, m.name
ORDER BY 借阅次数 DESC;

-- 🎯 练习5：查询价格最高的3本书
SELECT title, author, price
FROM book
WHERE is_deleted = 0
ORDER BY price DESC
LIMIT 3;

-- 🎯 练习6：统计每个分类的平均价格和总库存
SELECT c.name AS 分类,
    COUNT(b.id) AS 图书数量,
    ROUND(AVG(b.price), 2) AS 平均价格,
    SUM(b.stock) AS 总库存
FROM book_category c
LEFT JOIN book b ON c.id = b.category_id AND b.is_deleted = 0
GROUP BY c.id, c.name;

-- 🎯 练习7：模拟归还图书（更新借阅记录 + 库存+1）
-- UPDATE book_borrow SET return_date = CURDATE() WHERE id = 2;
-- UPDATE book SET stock = stock + 1 WHERE id = 5;

-- ✅ 完成以上练习，恭喜通关第二站！
