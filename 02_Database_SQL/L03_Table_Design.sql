-- ============================================
-- 📖 第二站 L03：表设计、约束、索引
-- ============================================
-- ⭐ 好的表设计 = 项目成功的一半

USE java_learning;

-- ==================== ⭐ 1. 常用约束 ====================

-- 重新创建一个更规范的表
DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,       -- ⭐ 主键：唯一标识每一行
    username    VARCHAR(50) NOT NULL UNIQUE,              -- ⭐ NOT NULL + UNIQUE：不能空且不能重复
    password    VARCHAR(100) NOT NULL,                    -- ⭐ NOT NULL：不能为空
    nickname    VARCHAR(50) DEFAULT '新用户',              -- DEFAULT：默认值
    phone       VARCHAR(20),
    email       VARCHAR(100),
    status      TINYINT DEFAULT 1 COMMENT '状态：1正常 0禁用', -- COMMENT：字段注释
    is_deleted  TINYINT DEFAULT 0 COMMENT '逻辑删除：0正常 1已删除',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,       -- 创建时间
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  -- 修改时自动更新
) COMMENT '用户表';

-- 💡 约束速查：
--   PRIMARY KEY  主键（唯一 + 非空）
--   NOT NULL     不能为空
--   UNIQUE       不能重复
--   DEFAULT      默认值
--   AUTO_INCREMENT 自增（通常用在主键）
--   COMMENT      字段/表注释

-- ==================== ⭐ 2. 索引（提高查询速度）====================

-- 💡 索引 = 给表建目录，查询变快，但插入/更新会稍慢

-- 给 phone 加普通索引
CREATE INDEX idx_phone ON user(phone);

-- 给 email 加唯一索引（索引 + 不能重复）
CREATE UNIQUE INDEX idx_email ON user(email);

-- 给 status + is_deleted 加联合索引（多个字段一起查时用）
CREATE INDEX idx_status_deleted ON user(status, is_deleted);

-- 查看表的所有索引
SHOW INDEX FROM user;

-- 💡 什么时候加索引？
--   ✅ WHERE 条件经常用到的字段
--   ✅ 经常用来排序（ORDER BY）的字段
--   ✅ 经常用来关联（JOIN ON）的字段
--   ❌ 数据很少的表（没必要）
--   ❌ 经常大量插入/更新的字段（索引维护有成本）

-- ==================== ⭐ 3. 外键与表关系 ====================

-- 一对多关系：一个用户可以发多篇文章
DROP TABLE IF EXISTS article;

CREATE TABLE article (
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    title       VARCHAR(200) NOT NULL COMMENT '标题',
    content     TEXT COMMENT '正文内容',
    user_id     BIGINT NOT NULL COMMENT '作者ID',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_user_id (user_id)   -- ⭐ 给外键字段加索引（联表查询会快）
) COMMENT '文章表';

-- 💡 实际开发中通常 **不用外键约束**（FOREIGN KEY）
--   原因：外键会降低性能，且不方便分库分表
--   替代方案：在代码层面（Service 层）做关联逻辑

-- ==================== ⭐ 4. 修改表结构（ALTER TABLE）====================

-- 添加字段
ALTER TABLE user ADD COLUMN avatar VARCHAR(255) COMMENT '头像URL';

-- 修改字段类型
ALTER TABLE user MODIFY COLUMN nickname VARCHAR(100);

-- 重命名字段
ALTER TABLE user CHANGE COLUMN phone mobile VARCHAR(20);

-- 删除字段
-- ALTER TABLE user DROP COLUMN avatar;

-- 查看表结构
DESC user;

-- ==================== 💡 5. 表设计规范（了解即可）====================

-- 【命名规范】
--   表名：小写 + 下划线（user_order, user_address）
--   字段名：小写 + 下划线（user_id, create_time）
--   索引名：idx_字段名（idx_phone, idx_user_id）

-- 【必备字段】
--   id          BIGINT 主键自增
--   create_time DATETIME 创建时间
--   update_time DATETIME 更新时间
--   is_deleted  TINYINT 逻辑删除标记

-- 【数据类型选择】
--   金额 → DECIMAL(10,2)，绝对不要用 float/double！
--   布尔 → TINYINT (0/1)
--   ID → BIGINT（别用 INT，数据量大了不够用）
--   短文本 → VARCHAR(n)
--   长文本 → TEXT
