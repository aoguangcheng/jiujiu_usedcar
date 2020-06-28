/*
 Navicat MySQL Data Transfer

 Source Server         : zyk
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 123.56.26.127:3306
 Source Schema         : jiujiuusedcar

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 28/06/2020 11:52:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(10) NOT NULL AUTO_INCREMENT,
  `admin_name` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_password` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE INDEX `admin_name`(`admin_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin');
INSERT INTO `admin` VALUES (2, 'root', 'root');
INSERT INTO `admin` VALUES (3, 'ao', 'ao');

-- ----------------------------
-- Table structure for browse_record
-- ----------------------------
DROP TABLE IF EXISTS `browse_record`;
CREATE TABLE `browse_record`  (
  `recordid` int(10) NOT NULL AUTO_INCREMENT,
  `good_num` int(10) NULL DEFAULT NULL,
  `telenum` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`recordid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of browse_record
-- ----------------------------
INSERT INTO `browse_record` VALUES (1, 1, 'admin');
INSERT INTO `browse_record` VALUES (2, 1, 'root');
INSERT INTO `browse_record` VALUES (3, 4, 'admin');
INSERT INTO `browse_record` VALUES (4, 4, 'root');
INSERT INTO `browse_record` VALUES (5, 2, 'admin');
INSERT INTO `browse_record` VALUES (6, 2, 'root');
INSERT INTO `browse_record` VALUES (7, 3, 'admin');
INSERT INTO `browse_record` VALUES (8, 5, 'admin');
INSERT INTO `browse_record` VALUES (9, 19, 'root');
INSERT INTO `browse_record` VALUES (10, 22, 'root');
INSERT INTO `browse_record` VALUES (11, 16, 'root');
INSERT INTO `browse_record` VALUES (12, 11, 'root');
INSERT INTO `browse_record` VALUES (13, 1, '*');
INSERT INTO `browse_record` VALUES (14, 15, '*');
INSERT INTO `browse_record` VALUES (15, 6, 'ao');
INSERT INTO `browse_record` VALUES (16, 2, 'ao');
INSERT INTO `browse_record` VALUES (17, 24, 'ao');
INSERT INTO `browse_record` VALUES (18, 23, 'root');
INSERT INTO `browse_record` VALUES (19, 24, 'root');
INSERT INTO `browse_record` VALUES (20, 23, 'admin');
INSERT INTO `browse_record` VALUES (21, 8, 'root');
INSERT INTO `browse_record` VALUES (22, 26, 'root');
INSERT INTO `browse_record` VALUES (23, 2, 'lirui');
INSERT INTO `browse_record` VALUES (24, 2, '123456');
INSERT INTO `browse_record` VALUES (25, 2, 'hyy');
INSERT INTO `browse_record` VALUES (26, 3, 'root');
INSERT INTO `browse_record` VALUES (27, 2, '岳云鹏');
INSERT INTO `browse_record` VALUES (28, 20, 'admin');
INSERT INTO `browse_record` VALUES (29, 16, 'admin');
INSERT INTO `browse_record` VALUES (30, 25, 'admin');
INSERT INTO `browse_record` VALUES (31, 26, 'admin');
INSERT INTO `browse_record` VALUES (32, 5, 'root');
INSERT INTO `browse_record` VALUES (33, 6, 'root');
INSERT INTO `browse_record` VALUES (34, 3, 'ao');
INSERT INTO `browse_record` VALUES (35, 1, 'ao');
INSERT INTO `browse_record` VALUES (36, 5, 'ao');

-- ----------------------------
-- Table structure for detail_classify
-- ----------------------------
DROP TABLE IF EXISTS `detail_classify`;
CREATE TABLE `detail_classify`  (
  `detail_num` int(3) NOT NULL AUTO_INCREMENT,
  `detail_classifyname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `summary_classifyname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`detail_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of detail_classify
-- ----------------------------
INSERT INTO `detail_classify` VALUES (1, '手机数码', '耳机');
INSERT INTO `detail_classify` VALUES (2, '手机数码', '手环');
INSERT INTO `detail_classify` VALUES (3, '手机数码', '手机');
INSERT INTO `detail_classify` VALUES (4, '生活百货', '五金工具');
INSERT INTO `detail_classify` VALUES (5, '生活百货', '办公用品');
INSERT INTO `detail_classify` VALUES (6, '生活百货', '日护洗化');
INSERT INTO `detail_classify` VALUES (7, '美妆', '护肤');
INSERT INTO `detail_classify` VALUES (8, '美妆', '彩妆');
INSERT INTO `detail_classify` VALUES (9, '美妆', '香水');
INSERT INTO `detail_classify` VALUES (10, '美妆', '卸妆');
INSERT INTO `detail_classify` VALUES (11, '短袖', '男装');
INSERT INTO `detail_classify` VALUES (12, '计算机类', '书本');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `good_num` int(5) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(8, 2) NULL DEFAULT NULL,
  `summary_classifyname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail_classifyname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(2) NULL DEFAULT 1,
  `owner` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `star_count` int(8) NULL DEFAULT 0,
  `pur_comment` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '商品还没有人购买，所以没有评价哦',
  PRIMARY KEY (`good_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '手机,这是一对毫无意义的废话用来测试字符串长度对主页展示的影响。手机,这是一对毫无意义的废话用来测试字符串长度对主页展示的影响。手机,这是一对毫无意义的废话用来测试字符串长度对主页展示的影响', 2000.00, '数码电子', '耳机', '/images/rotPhoto/gbdkgrjzvcsvdvrskj-1001660.jpg', '/images/rotPhoto/bgpknwtpyldzqqedqw-wallhaven-j5vwdy.jpg', '/images/rotPhoto/vfnkpzrquvudcajawb-wallhaven-r2okx1.png', 1, 'admin', 112, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (2, '华为手机', 8999.00, '数码电子', '耳机', '/images/rotPhoto/lujulnptcmoeiwgyoi-1001622.jpg', '/images/rotPhoto/yoyvtyzepywlydjzpn-324269.jpg', '/images/rotPhoto/asinumahkuwkwrugww-wallhaven-j5vwdy.jpg', 1, 'admin', 31, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (3, '手机', 2000.00, '数码电子', '手机', '/images/rotPhoto/nykgbretbmqjvnqzeb-wallhaven-dgegxl.jpg', '/images/rotPhoto/mwcsexkfzdnxtavhfc-thD4K93FQ9.jpg', '/images/rotPhoto/mwcsexkfzdnxtavhfc-thD4K93FQ9.jpg', 1, 'admin', 33, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (4, '手机', 2000.00, '数码电子', '手机', '/images/rotPhoto/nykgbretbmqjvnqzeb-wallhaven-dgegxl.jpg', '/images/rotPhoto/mwcsexkfzdnxtavhfc-thD4K93FQ9.jpg', '/images/rotPhoto/mwcsexkfzdnxtavhfc-thD4K93FQ9.jpg', 2, 'admin', 0, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (5, '手机', 2000.00, '数码电子', '手机', '/images/rotPhoto/nykgbretbmqjvnqzeb-wallhaven-dgegxl.jpg', '/images/rotPhoto/mwcsexkfzdnxtavhfc-thD4K93FQ9.jpg', '/images/rotPhoto/mwcsexkfzdnxtavhfc-thD4K93FQ9.jpg', 1, 'admin', 5, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (6, '手机', 2000.00, '数码电子', '手机', '/images/rotPhoto/nykgbretbmqjvnqzeb-wallhaven-dgegxl.jpg', '/images/rotPhoto/mwcsexkfzdnxtavhfc-thD4K93FQ9.jpg', '/images/rotPhoto/mwcsexkfzdnxtavhfc-thD4K93FQ9.jpg', 1, 'admin', 0, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (7, '手机', 2000.00, '数码电子', '手机', '/images/rotPhoto/nykgbretbmqjvnqzeb-wallhaven-dgegxl.jpg', '/images/rotPhoto/mwcsexkfzdnxtavhfc-thD4K93FQ9.jpg', '/images/rotPhoto/mwcsexkfzdnxtavhfc-thD4K93FQ9.jpg', 1, 'admin', 45, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (8, '为', 30.00, '数码电子', '耳机', '/images/rotPhoto/jfmydbefncssqmacto-wallhaven-dgegxl.jpg', '/images/rotPhoto/ypupkcmxnlpufmkgmm-wallhaven-dgegxl.jpg', '/images/rotPhoto/recmlevzdbappusgzy-wallhaven-dgegxl.jpg', 3, 'admin', 12, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (9, '无', 30000.00, '数码电子', '耳机', '/images/rotPhoto/ztfczphvobrcxwzhor-wallhaven-r2okx1.png', '/images/rotPhoto/okhvyngjcrotglyigf-wallhaven-r2okx1.png', '/images/rotPhoto/xwroetsdpzdftzwmkr-wallhaven-r2okx1.png', 1, 'admin', 23, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (10, '特价全新', 9998.00, '数码电子', '耳机', '/images/rotPhoto/jqdroomccfcxwdtvte-wallhaven-j5vwdy.jpg', '/images/rotPhoto/aqctbmxwgoyzucbbho-wallhaven-j5vwdy.jpg', '/images/rotPhoto/hwpybhmzaboeflksii-wallhaven-j5vwdy.jpg', 1, 'admin', 23, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (11, '无', 8988.00, '数码电子', '耳机', '/images/rotPhoto/yjphzxknmqubdbpqhq-wallhaven-r2okx1.png', '/images/rotPhoto/ejxwiavmzieogycpty-thD4K93FQ9.jpg', '/images/rotPhoto/aniaqpoyhjcxtrqgzw-wallhaven-j5vwdy.jpg', 1, 'admin', 35, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (14, '傻逼李锐', 788908.00, '数码电子', '耳机', '/images/rotPhoto/ilttnmzvdyfdunfnwm-wallhaven-lmwegp.png', '/images/rotPhoto/mfqacfjebumdqqwxss-wallhaven-lmwegp.png', '/images/rotPhoto/blzvwqhbjilbrmraud-wallhaven-lmwegp.png', 1, 'admin', 45, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (15, 'aoguangc\r\n', 11.00, '女装', '手环', '/images/rotPhoto/xdxuqyoozsitpsztaq-welcome.png', '/images/rotPhoto/lomcentmweblhjyahr-welcome.png', '/images/rotPhoto/bqcebgzovfgyjjowkc-welcome.png', 1, '1', 51, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (16, '壁纸库', 9909.00, '数码电子', '耳机', '/images/rotPhoto/hzazjbnsvtiyghpofd-324269.jpg', '/images/rotPhoto/dfkeprhqtwsnhcysxf-wallhaven-dgegxl.jpg', '/images/rotPhoto/hqibmfvqdqwvsxkmsd-wallhaven-lmwegp.png', 1, 'admin', 45, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (17, '字迹清晰，绝对正版', 38.99, '书本', '计算机类', NULL, NULL, NULL, 2, NULL, NULL, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (18, '字迹清晰，绝对正版', 38.99, '书本', '计算机类', NULL, NULL, NULL, 2, NULL, NULL, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (19, '壁纸', 909.00, '数码电子', '耳机', '/images/rotPhoto/icfiuhahsohzqcndqr-1001040.jpg', '/images/rotPhoto/bdwykusqckrbfesavf-wallhaven-dgegxl.jpg', '/images/rotPhoto/wrsruollwsuwpkwsle-wallhaven-lmwegp.png', 1, 'admin', 4, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (20, '为', 30.00, '数码电子', '耳机', '/images/rotPhoto/jfmydbefncssqmacto-wallhaven-dgegxl.jpg', '/images/rotPhoto/ypupkcmxnlpufmkgmm-wallhaven-dgegxl.jpg', '/images/rotPhoto/recmlevzdbappusgzy-wallhaven-dgegxl.jpg', 3, 'admin', 12, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (21, '字迹清晰，绝对正版', 38.99, '书本', '计算机类', NULL, NULL, NULL, 3, NULL, NULL, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (22, '壁纸库', 9981.00, '数码电子', '耳机', '/images/rotPhoto/wcfdrdzuwakyjtyzng-1001402.jpg', '/images/rotPhoto/qqxxhnrntsivehsuxt-wallhaven-j5vwdy.jpg', '/images/rotPhoto/rcukiihbbekyczhpne-wallhaven-lmwegp.png', 2, 'root', 0, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (24, '手机', 9899.00, '数码电子', '手机', '/images/rotPhoto/qzkwbyoererqcppoyp-1001622.jpg', '/images/rotPhoto/zxkyfpxzzdfjvnfize-1001040.jpg', '/images/rotPhoto/mjaolzudjguzbwxjze-wallhaven-j5vwdy.jpg', 1, 'ao', 0, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (25, '手机', 9899.00, '数码电子', '手机', '/images/rotPhoto/ndgxykiwspzxnlusng-wallhaven-r2okx1.png', '/images/rotPhoto/donvvtoquhlkwaqbwy-wallhaven-j5vwdy.jpg', '/images/rotPhoto/slexgeycyhahymnxal-桌面.PNG', 1, 'ao', 0, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (26, '专业课\r\n', 9899.00, '数码电子', '耳机', '/images/rotPhoto/nqzmptkuhgmacdzdkq-324269.jpg', '/images/rotPhoto/aizllqblwefrizhkuf-1001040.jpg', '/images/rotPhoto/yefylkwkeuvjtlivkl-wallhaven-lmwegp.png', 1, 'root', 0, '商品还没有人购买，所以没有评价哦');
INSERT INTO `goods` VALUES (27, '只是测试数据，还没有具体描述', 199.00, '数码电子', '请选择分类', '/images/rotPhoto/abbngwxkfxxlgtjhiz-C:\\Users\\AoGua\\Desktop\\LearnMaterials\\软件测试\\性能分类.PNG', '/images/rotPhoto/txugpamrflcfjsbcth-C:\\Users\\AoGua\\Desktop\\LearnMaterials\\软件测试\\jmeter体系结构.jpg', '/images/rotPhoto/onsyzbngtraksfgpeb-C:\\Users\\AoGua\\Desktop\\LearnMaterials\\软件测试\\性能分类.PNG', 1, 'ao', 0, '商品还没有人购买，所以没有评价哦');

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------

-- ----------------------------
-- Table structure for leave_message
-- ----------------------------
DROP TABLE IF EXISTS `leave_message`;
CREATE TABLE `leave_message`  (
  `messageid` int(10) NOT NULL AUTO_INCREMENT,
  `good_num` int(10) NULL DEFAULT NULL,
  `telenum` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `message` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`messageid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of leave_message
-- ----------------------------
INSERT INTO `leave_message` VALUES (1, 1, 'admin', '2019-12-21', '好东西');
INSERT INTO `leave_message` VALUES (2, 1, 'admin', '2019-12-21', '垃圾东西');
INSERT INTO `leave_message` VALUES (4, 1, 'admin', '2019-12-21', '各位都是弟弟');
INSERT INTO `leave_message` VALUES (5, 1, 'admin', '2019-12-21', '我错了');
INSERT INTO `leave_message` VALUES (6, 1, 'admin', '2019-12-21', '快点改掉');
INSERT INTO `leave_message` VALUES (7, 1, 'admin', '2019-12-21', '我是弟弟');
INSERT INTO `leave_message` VALUES (8, 1, 'admin', '2019-12-21', '我是XXXXX');
INSERT INTO `leave_message` VALUES (9, 1, 'admin', '2019-12-21', '张岩珂');
INSERT INTO `leave_message` VALUES (10, 1, 'admin', '2019-12-21', '我是XXXXXXX');
INSERT INTO `leave_message` VALUES (11, 1, 'admin', '2019-12-21', '你是XXXX');
INSERT INTO `leave_message` VALUES (12, 3, 'admin', '2019-12-21', '我终于完成了留言的制作');
INSERT INTO `leave_message` VALUES (13, 16, 'admin', '2019-12-21', '奇了怪了没反应？');
INSERT INTO `leave_message` VALUES (14, 16, 'admin', '2019-12-21', '为什么表单没有提交');
INSERT INTO `leave_message` VALUES (15, 8, 'admin', '2019-12-21', '商品已出售');
INSERT INTO `leave_message` VALUES (16, 16, 'admin', '2019-12-21', '啊啊啊，表单提交不了');
INSERT INTO `leave_message` VALUES (17, 16, 'admin', '2019-12-21', '啊啊啊啊，还是不行');
INSERT INTO `leave_message` VALUES (18, 2, 'admin', '2019-12-21 19:20:20', '我的收藏可以自己改哦');
INSERT INTO `leave_message` VALUES (19, 1, '888', '2019-12-21 20:00:38', '444');
INSERT INTO `leave_message` VALUES (20, 2, 'admin', '2019-12-21 23:01:40', '这个手机是真的棒！');
INSERT INTO `leave_message` VALUES (21, 1, 'root', '2019-12-22 09:29:59', '另外一个用户发言');
INSERT INTO `leave_message` VALUES (22, 19, 'root', '2019-12-22 15:17:24', 'hobbitao发布的第一件物品');
INSERT INTO `leave_message` VALUES (23, 22, 'root', '2019-12-22 16:06:06', '用户名为root 的用户留言');
INSERT INTO `leave_message` VALUES (24, 15, '*', '2019-12-22 22:39:00', '我想要');
INSERT INTO `leave_message` VALUES (25, 1, 'root', '2019-12-22 23:54:44', '有很多人留言哦');
INSERT INTO `leave_message` VALUES (26, 1, 'admin', '2019-12-23 14:34:06', '李锐傻逼');
INSERT INTO `leave_message` VALUES (27, 2, '123456', '2019-12-24 15:01:08', '666666');
INSERT INTO `leave_message` VALUES (28, 26, 'root', '2019-12-25 13:00:22', '我想买这个东西，一块钱出吗');
INSERT INTO `leave_message` VALUES (29, 1, 'ao', '2020-06-27 12:15:42', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (30, 1, 'ao', '2020-06-27 12:22:26', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (31, 1, 'ao', '2020-06-27 12:22:47', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (32, 1, 'ao', '2020-06-27 12:22:52', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (33, 1, 'ao', '2020-06-27 12:23:53', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (34, 1, 'ao', '2020-06-27 12:24:25', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (35, 1, 'ao', '2020-06-27 12:24:31', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (36, 1, 'ao', '2020-06-27 15:29:32', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (37, 1, 'ao', '2020-06-27 15:33:55', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (38, 1, 'ao', '2020-06-27 15:33:57', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (39, 1, 'ao', '2020-06-27 15:33:57', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (40, 1, 'ao', '2020-06-27 15:33:59', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (41, 1, 'ao', '2020-06-27 15:34:00', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (42, 1, 'ao', '2020-06-27 15:34:01', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (43, 1, 'ao', '2020-06-27 15:34:03', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (44, 1, 'ao', '2020-06-27 15:34:03', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (45, 1, 'ao', '2020-06-27 15:34:08', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (46, 1, 'ao', '2020-06-27 15:34:15', '这是在badboy上的测试');
INSERT INTO `leave_message` VALUES (47, 1, 'ao', '2020-06-27 15:48:03', '这是一个测试视力');
INSERT INTO `leave_message` VALUES (48, 5, 'ao', '2020-06-27 22:05:33', '这是一个badboy录制');
INSERT INTO `leave_message` VALUES (49, 6, 'ao', '2020-06-27 22:11:26', '我的badboy测试');
INSERT INTO `leave_message` VALUES (50, 6, 'ao', '2020-06-27 22:28:21', '这是一个测试记录');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo`  (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `buyer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodnum` int(11) NULL DEFAULT NULL,
  `price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `seller` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `pic` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`orderid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES (1, 'root', '2019-12-23', '无', 1, '8999', 'admin', 4, '/images/rotPhoto/gbdkgrjzvcsvdvrskj-1001660.jpg');
INSERT INTO `orderinfo` VALUES (2, 'admin', 'root', 'wu', 3, '32', 'root', 4, '/images/rotPhoto/gbdkgrjzvcsvdvrskj-1001660.jpg');
INSERT INTO `orderinfo` VALUES (3, 'root', 'root', 'we', 4, '32', 'admin', 4, '/images/rotPhoto/gbdkgrjzvcsvdvrskj-1001660.jpg');
INSERT INTO `orderinfo` VALUES (4, 'root', 'admin', 'we', 2, '12', 'ao', 4, '/images/rotPhoto/gbdkgrjzvcsvdvrskj-1001660.jpg');
INSERT INTO `orderinfo` VALUES (5, 'ao', '2019-12-23 11-18:49', '手机', 1, '989', 'admin', 2, '/images/rotPhoto/gbdkgrjzvcsvdvrskj-1001660.jpg');
INSERT INTO `orderinfo` VALUES (6, 'ao', '2019-12-23 12-35:42', '手机', 1, '898', 'admin', 4, NULL);
INSERT INTO `orderinfo` VALUES (7, 'root', '2019-12-23 12-35:49', '手机', 1, '778', 'admin', 4, NULL);
INSERT INTO `orderinfo` VALUES (8, 'root', '2019-12-23 13-02:11', '手机', 1, '9899.99', 'admin', 2, NULL);
INSERT INTO `orderinfo` VALUES (9, 'admin', '2019-12-25 13-20:09', '手机', 25, '9899.00', 'ao', 5, '/images/rotPhoto/ndgxykiwspzxnlusng-wallhaven-r2okx1.png');
INSERT INTO `orderinfo` VALUES (10, 'admin', '2019-12-25 13-39:20', '专业课\r\n', 26, '9899.00', 'root', 2, '/images/rotPhoto/nqzmptkuhgmacdzdkq-324269.jpg');
INSERT INTO `orderinfo` VALUES (11, 'root', '2019-12-25 14-07:32', '壁纸', 19, '909.00', 'admin', 3, '/images/rotPhoto/icfiuhahsohzqcndqr-1001040.jpg');
INSERT INTO `orderinfo` VALUES (12, 'root', '2019-12-25 14-16:04', '手机', 5, '2000.00', 'admin', 3, '/images/rotPhoto/nykgbretbmqjvnqzeb-wallhaven-dgegxl.jpg');
INSERT INTO `orderinfo` VALUES (13, 'root', '2019-12-25 14-17:21', '手机', 6, '2000.00', 'admin', 1, '/images/rotPhoto/nykgbretbmqjvnqzeb-wallhaven-dgegxl.jpg');

-- ----------------------------
-- Table structure for star
-- ----------------------------
DROP TABLE IF EXISTS `star`;
CREATE TABLE `star`  (
  `starid` int(10) NOT NULL AUTO_INCREMENT,
  `good_num` int(10) NULL DEFAULT NULL,
  `telenum` char(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`starid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of star
-- ----------------------------
INSERT INTO `star` VALUES (1, 1, 'admin');
INSERT INTO `star` VALUES (2, 1, '1');
INSERT INTO `star` VALUES (3, 1, '2');
INSERT INTO `star` VALUES (8, 2, 'admin');
INSERT INTO `star` VALUES (11, 11, 'root');
INSERT INTO `star` VALUES (13, 1, '*');
INSERT INTO `star` VALUES (15, 2, 'ao');
INSERT INTO `star` VALUES (18, 1, 'root');
INSERT INTO `star` VALUES (22, 2, '123456');
INSERT INTO `star` VALUES (23, 2, '岳云鹏');

-- ----------------------------
-- Table structure for summary_classify
-- ----------------------------
DROP TABLE IF EXISTS `summary_classify`;
CREATE TABLE `summary_classify`  (
  `summary_num` int(3) NOT NULL AUTO_INCREMENT,
  `summary_classifyname` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`summary_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of summary_classify
-- ----------------------------
INSERT INTO `summary_classify` VALUES (1, '手机数码');
INSERT INTO `summary_classify` VALUES (2, '生活百货');
INSERT INTO `summary_classify` VALUES (3, '美妆');
INSERT INTO `summary_classify` VALUES (4, '女装');
INSERT INTO `summary_classify` VALUES (5, '男装');
INSERT INTO `summary_classify` VALUES (6, '运动户外');
INSERT INTO `summary_classify` VALUES (7, '书本');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `telenum` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `headicon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dwells` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `college` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `major` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `balance` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `dormitory` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info_integrity` int(11) NULL DEFAULT 88,
  `hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`telenum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('15327662224', '111111', '111', '/images/rotPhoto/ugnvmymzmxcgywrrvc-u=3404138371,2236112659&fm=26&gp=0.jpg', '女', '1999-08-03', '湖北宜昌', '计算机与信息学院', '计科', '17', '0', '欣苑1#', 88, NULL);
INSERT INTO `user` VALUES ('admin', 'admin', '敖光成', '/images/rotPhoto/xztuyqfhecuxljztzc-1001660.jpg', '女', '2019-12-12', '湖北宜昌', '理学院', '数学', '19', '4358955.0', '南苑4#', 90, NULL);
INSERT INTO `user` VALUES ('ao', 'ao', '敖', '/images/rotPhoto/vrhlfoqeaxgihiuape-桌面.PNG', '女', '2019-12-04', '北京朝阳区', '计算机与信息学院', '数媒', '17', '899.0', '南苑2#', 88, NULL);
INSERT INTO `user` VALUES ('cxk', 'cxk', '蔡徐坤', '/images/rotPhoto/kgyfrechsktkpcxhoj-timg (1).gif', '女', '2019-12-04', '北京东城区', '理学院', '数学', '18', '0', '欣苑3#', 88, NULL);
INSERT INTO `user` VALUES ('lyl', 'lyl', '李云龙', '/images/rotPhoto/shmfpjefimdaxkdsqy-timg.jfif', '女', '2019-12-14', '湖北武汉', '医学院', '中医学', '17', '0', '南苑4#', 88, NULL);
INSERT INTO `user` VALUES ('root', 'root', 'hobbitao', '/images/rotPhoto/khzdxfcqsqvttcwurs-1001040.jpg', '女', '2019-12-07', '江苏柳州', '理学院', '物理学', '18', '85439.0', '南苑3#', 88, NULL);
INSERT INTO `user` VALUES ('yyp', 'yyp', '岳云鹏', '/images/rotPhoto/quumgzqukhcxrqljlw-timg (1).jfif', '女', '2019-12-12', '河南郑州', '理学院', '数学', '17', '8989.0', '欣苑3#', 88, NULL);
INSERT INTO `user` VALUES ('zzc', 'zzc', '郑子成', '/images/rotPhoto/tvusjhwtsrcybuaxxw-timg.gif', '男', '1997-12-24', '湖北襄阳', '理学院', '数学', '18', '0', '欣苑3#', 88, NULL);

SET FOREIGN_KEY_CHECKS = 1;
