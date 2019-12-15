/*
 Navicat Premium Data Transfer

 Source Server         : mall
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : mall

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 15/12/2019 16:22:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`  (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `brand_code` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`brand_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES (1, 'Apple', 1);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `category_code` int(11) NULL DEFAULT NULL,
  `level` int(11) NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '手机', 1, 0, 5);
INSERT INTO `category` VALUES (2, '手机通讯', 2, 1, 1);
INSERT INTO `category` VALUES (3, '手机配件', 3, 1, 1);
INSERT INTO `category` VALUES (4, '家居', 4, 0, 6);
INSERT INTO `category` VALUES (5, '移动设备', 5, -1, -1);
INSERT INTO `category` VALUES (6, '家具', 6, -1, -1);
INSERT INTO `category` VALUES (7, '数码', 7, 0, 5);
INSERT INTO `category` VALUES (8, '家具', 8, 0, 6);
INSERT INTO `category` VALUES (9, '家装', 9, 0, 6);
INSERT INTO `category` VALUES (10, '厨具', 10, 0, 6);
INSERT INTO `category` VALUES (11, '游戏手机', 11, 2, 2);
INSERT INTO `category` VALUES (12, '老人机', 12, 2, 2);
INSERT INTO `category` VALUES (13, '手机壳', 13, 2, 3);
INSERT INTO `category` VALUES (14, '家用-电器', 14, -1, -1);
INSERT INTO `category` VALUES (15, '空调', 15, 1, 18);
INSERT INTO `category` VALUES (16, '洗衣机', 16, 1, 18);
INSERT INTO `category` VALUES (17, '冰箱', 17, 1, 18);
INSERT INTO `category` VALUES (18, '家用电器', 18, 0, 14);
INSERT INTO `category` VALUES (19, '超薄电视', 19, 2, 20);
INSERT INTO `category` VALUES (20, '电视', 20, 1, 18);
INSERT INTO `category` VALUES (21, '全面屏电视', 21, 2, 20);
INSERT INTO `category` VALUES (22, '空调挂机', 22, 2, 15);
INSERT INTO `category` VALUES (23, '空调柜机', 23, 2, 15);
INSERT INTO `category` VALUES (24, '厨具', NULL, 1, 4);
INSERT INTO `category` VALUES (25, '家纺', NULL, 1, 4);
INSERT INTO `category` VALUES (26, '生活日用', NULL, 1, 4);
INSERT INTO `category` VALUES (27, '家装软饰', NULL, 1, 4);
INSERT INTO `category` VALUES (28, '灯具', NULL, 1, 4);
INSERT INTO `category` VALUES (29, '水具酒具', NULL, 2, 24);
INSERT INTO `category` VALUES (30, '烹饪锅具', NULL, 2, 24);
INSERT INTO `category` VALUES (31, '炒锅', NULL, 2, 24);
INSERT INTO `category` VALUES (32, '四件套', NULL, 2, 25);
INSERT INTO `category` VALUES (33, '被子', NULL, 2, 25);
INSERT INTO `category` VALUES (34, '枕芯', NULL, 2, 25);
INSERT INTO `category` VALUES (35, '电脑', 1, 0, 37);
INSERT INTO `category` VALUES (36, '办公', 2, 0, 37);
INSERT INTO `category` VALUES (37, '办公设备', 3, -1, -1);
INSERT INTO `category` VALUES (38, '电脑整机', NULL, 1, 35);
INSERT INTO `category` VALUES (39, '电脑配件', NULL, 1, 35);
INSERT INTO `category` VALUES (40, '笔记本', NULL, 2, 38);
INSERT INTO `category` VALUES (41, '游戏本', NULL, 2, 38);
INSERT INTO `category` VALUES (42, '显示器', NULL, 2, 39);
INSERT INTO `category` VALUES (43, 'CPU', NULL, 2, 39);
INSERT INTO `category` VALUES (44, '主板', NULL, 2, 39);
INSERT INTO `category` VALUES (45, '显卡', NULL, 2, 39);
INSERT INTO `category` VALUES (46, '办公设备', NULL, 1, 36);
INSERT INTO `category` VALUES (47, '文具', NULL, 1, 36);
INSERT INTO `category` VALUES (48, '耗材', NULL, 1, 36);
INSERT INTO `category` VALUES (49, '投影机', NULL, 2, 46);
INSERT INTO `category` VALUES (50, '打印机', NULL, 2, 46);
INSERT INTO `category` VALUES (51, '扫描设备', NULL, 2, 46);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reviewer` int(11) NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  `topic_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, '宫本要出肉', '2019-12-13 11:15:28', 2);
INSERT INTO `comment` VALUES (2, 2, '宫本纯输出就可以了', '2019-12-13 11:16:09', 2);
INSERT INTO `comment` VALUES (5, 1, '我的虞姬很厉害的', '2019-12-13 14:51:39', 1);
INSERT INTO `comment` VALUES (6, 1, '你好', '2019-12-13 14:53:21', 1);
INSERT INTO `comment` VALUES (7, 1, '赵云非常好玩，很爽', '2019-12-14 02:25:47', 3);

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  `author` int(11) NULL DEFAULT NULL,
  `comment_num` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forum
-- ----------------------------
INSERT INTO `forum` VALUES (1, '关于虞姬的打法', '2019-12-13 10:10:09', 1, 1009);
INSERT INTO `forum` VALUES (2, '关于宫本的玩法', '2019-12-13 10:11:07', 1, 10000);
INSERT INTO `forum` VALUES (3, '关于赵云的玩法', '2019-12-13 10:11:09', 1, 101);
INSERT INTO `forum` VALUES (11, '你好', '2019-12-13 04:33:50', 1, 0);
INSERT INTO `forum` VALUES (12, '大家好', '2019-12-13 04:35:05', 1, 0);

-- ----------------------------
-- Table structure for indent
-- ----------------------------
DROP TABLE IF EXISTS `indent`;
CREATE TABLE `indent`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` decimal(10, 0) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `sku_item` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `retailer_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of indent
-- ----------------------------
INSERT INTO `indent` VALUES (45, 6999, 0, '2019-12-14 07:37:57', 1, '1_1_0#', 0);
INSERT INTO `indent` VALUES (46, 6999, 0, '2019-12-14 08:37:45', 2, '1_1_0#', 0);
INSERT INTO `indent` VALUES (47, 9999, 0, '2019-12-14 14:57:31', 1, '19_1_0#', 0);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `p_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `p_price` decimal(10, 0) NULL DEFAULT NULL,
  `p_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `c_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (2, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (3, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (4, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (5, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (6, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (7, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (8, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (9, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (10, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (11, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (12, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (13, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (14, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (15, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (16, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (17, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (18, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (19, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (20, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (21, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (22, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (23, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (24, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (25, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (26, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (27, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (28, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (29, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);
INSERT INTO `product` VALUES (30, 'iphone', '苹果', 6999, 'http://localhost:8081/mall/static/images/iphone.png', 1);

-- ----------------------------
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property`  (
  `property_id` int(11) NOT NULL AUTO_INCREMENT,
  `property_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `property_category_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`property_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of property
-- ----------------------------
INSERT INTO `property` VALUES (1, '颜色', 1);
INSERT INTO `property` VALUES (2, '内存', 1);

-- ----------------------------
-- Table structure for property_item
-- ----------------------------
DROP TABLE IF EXISTS `property_item`;
CREATE TABLE `property_item`  (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `item_property_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of property_item
-- ----------------------------
INSERT INTO `property_item` VALUES (1, '白色', 1);
INSERT INTO `property_item` VALUES (2, '黑色', 1);
INSERT INTO `property_item` VALUES (3, '64G', 2);
INSERT INTO `property_item` VALUES (4, '128G', 2);
INSERT INTO `property_item` VALUES (5, '256G', 2);

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sender` int(11) NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  `comment_id` int(11) NULL DEFAULT NULL,
  `receiver` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES (6, 1, '是吗', '2019-12-13 15:15:59', 5, 1);
INSERT INTO `reply` VALUES (7, 1, '不要吹牛', '2019-12-13 15:17:35', 5, 1);
INSERT INTO `reply` VALUES (8, 1, '骗人的', '2019-12-13 15:26:20', 5, 1);
INSERT INTO `reply` VALUES (9, 1, '我觉得也是', '2019-12-13 15:27:08', 5, 1);
INSERT INTO `reply` VALUES (10, 1, 'Hello,Good Morning!', '2019-12-13 15:27:33', 6, 1);
INSERT INTO `reply` VALUES (11, 1, '我的赵云是省级赵云', '2019-12-14 02:26:18', 7, 1);
INSERT INTO `reply` VALUES (12, 1, '你好', '2019-12-14 03:15:59', 6, 1);

-- ----------------------------
-- Table structure for retailer
-- ----------------------------
DROP TABLE IF EXISTS `retailer`;
CREATE TABLE `retailer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `found_time` datetime(0) NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `founder` int(11) NULL DEFAULT NULL,
  `rate` int(11) NULL DEFAULT 5,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `logo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `founder_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of retailer
-- ----------------------------
INSERT INTO `retailer` VALUES (4, 'Apple产品', '2019-12-12 00:00:00', NULL, 1, 5, 'Apple官方旗舰店', 'http://localhost:8081/mall/upload/1576335315147logo.jpg', 'root', 1);
INSERT INTO `retailer` VALUES (5, 'Samsung各类产品', '2019-12-13 01:14:41', NULL, 3, 5, '三星官方旗舰店', 'http://localhost:8081/mall/upload/1576396666179logo.jpeg', 'rain', 1);
INSERT INTO `retailer` VALUES (7, '华为产品', '2019-12-13 01:23:15', NULL, 2, 5, '华为官方旗舰店', 'http://localhost:8081/mall/upload/1576335607655hw.jpg', 'fog', 1);

-- ----------------------------
-- Table structure for rotation_chart
-- ----------------------------
DROP TABLE IF EXISTS `rotation_chart`;
CREATE TABLE `rotation_chart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `images` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `type` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rotation_chart
-- ----------------------------
INSERT INTO `rotation_chart` VALUES (3, 'http://localhost:8081/mall/upload/1576376200024lbt1.webp,http://localhost:8081/mall/upload/1576376202475lbt2.webp,http://localhost:8081/mall/upload/1576376205183lbt3.webp,', 0);

-- ----------------------------
-- Table structure for sku
-- ----------------------------
DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku`  (
  `sku_id` int(11) NOT NULL AUTO_INCREMENT,
  `sku_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sku_code` int(11) NULL DEFAULT NULL,
  `sku_price` decimal(10, 0) NULL DEFAULT NULL,
  `sku_spu_id` int(11) NULL DEFAULT NULL,
  `sku_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sku_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `sku_specification` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `sku_category` int(11) NULL DEFAULT NULL,
  `sku_bulletin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `retailer_id` int(11) NULL DEFAULT NULL,
  `sku_num` int(11) NULL DEFAULT NULL,
  `sku_status` int(11) NULL DEFAULT 1,
  `sale_num` int(11) NULL DEFAULT 0,
  `rate` double NULL DEFAULT 5,
  `introduce_images` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`sku_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sku
-- ----------------------------
INSERT INTO `sku` VALUES (1, 'iphone11', 1, 6999, 1, 'http://localhost:8081/mall/static/images/iphone.png', 'iPhoneXSMax限时特惠来袭，OLED超视网膜大屏，颜值抗打，性能强劲！', 'Apple iPhone 11 (A2223) 128GB 黑色 移动联通电信4G手机 双卡双待', 11, '128G 黑色', 4, 988, 1, 3, 2.3333333333333335, NULL);
INSERT INTO `sku` VALUES (2, 'iphone11', 2, 7999, 1, 'http://localhost:8081/mall/static/images/iphone.png', 'iPhoneXSMax限时特惠来袭，OLED超视网膜大屏，颜值抗打，性能强劲！', 'Apple iPhone 11 (A2223) 256GB 黑色 移动联通电信4G手机 双卡双待', 11, '256G 黑色', 4, 998, 1, 0, 5, NULL);
INSERT INTO `sku` VALUES (14, '华为Mate30', 3, 4999, 1, 'http://localhost:8081/mall/static/images/iphone.png', '华为Mate30震撼来袭', '华为Mate30 OLED大屏幕', 11, '128G 8G 蓝色', 7, 998, 1, 0, 5, NULL);
INSERT INTO `sku` VALUES (15, '华为 Mate 30 Pro', 100, 6899, NULL, 'http://localhost:8081/mall/upload/1576214398019huawei.jpg', '\n温馨提示\n\n    ·支持7天无理由退货\n    ·此商品不可使用京券东券\n\n', '8GB+256GB丹霞橙', 11, '麒麟990 OLED环幕屏双4000万徕卡电影四摄8GB+256GB丹霞橙5G全网通手机 ', 7, 997, 1, 1, 5, NULL);
INSERT INTO `sku` VALUES (16, '小米CC9 Pro', 101, 3099, NULL, 'http://localhost:8081/mall/upload/1576215604417xiaomi.jpg', '\n\n入网型号\n    LIO-AN00\n\n品牌\n    华为（HUAWEI）\n\n产品名称\n    HUAWEI Mate 30 Pro 5G\n\n上市年份\n    2019年\n\n上市月份\n    11月\n\n', '5G 麒麟990 OLED环幕屏双4000万徕卡电影四摄8GB+256GB丹霞橙5G全网通手机 ', 11, '魔法绿镜 8GB+128GB', 5, 999, 1, 0, 5, NULL);
INSERT INTO `sku` VALUES (17, '木月 床', 111, 1599, NULL, 'http://localhost:8081/mall/upload/1576229253207bed.jpg', '\n    商品名称：【物流停运，详询客服】木月 床 北欧简约双人床高箱储物床布艺软靠床婚床 雅致 【木纹灰色】高箱床 1.5*2.0米\n', '【木纹灰色】高箱床 1.5*2.0米 ', 29, '北欧简约双人床高箱储物床布艺软靠床婚床', 4, 998, 1, 0, 5, NULL);
INSERT INTO `sku` VALUES (19, 'iphone11 pro', 111, 9999, NULL, 'http://localhost:8081/mall/upload/1576324411906sm.jpg', '典旗舰机型推荐：iPhoneXSMax性能强劲，样样出色，限时抢券低至5699元！', '256GB 暗夜绿色 移动联通电信4G手机 双卡双待 ', 11, ' 购买1件可优惠换购热销商品', 4, 998, 1, 1, 5, NULL);
INSERT INTO `sku` VALUES (20, ' Apple AirPods Pro', 112, 2199, NULL, 'http://localhost:8081/mall/upload/1576324847765ej.jpg', '即刻连接，静享你的世界！二代无线充电款AirPods低至1399元！', 'AirPods Pro*1、无线充电盒、硅胶耳塞 (三种尺寸)、闪电转 USB-C 连接线、资料', 13, '主动降噪无线蓝牙耳机 ', 4, 999, 1, 0, 5, 'http://localhost:8081/mall/upload/157632490123801587e901af36baf.png,http://localhost:8081/mall/upload/1576324908123ced4494971256537.png,');

-- ----------------------------
-- Table structure for sku_comment
-- ----------------------------
DROP TABLE IF EXISTS `sku_comment`;
CREATE TABLE `sku_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `sku_id` int(11) NULL DEFAULT NULL,
  `rate` float NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sku_comment
-- ----------------------------
INSERT INTO `sku_comment` VALUES (2, '还可以', '2019-12-14 08:15:12', 1, 1, 3);
INSERT INTO `sku_comment` VALUES (3, '不错哦！', '2019-12-14 08:19:31', 1, 1, 3);
INSERT INTO `sku_comment` VALUES (4, '不行，太差了。。。', '2019-12-14 08:38:05', 2, 1, 1);
INSERT INTO `sku_comment` VALUES (5, '非常好用', '2019-12-14 14:57:43', 1, 19, 5);

-- ----------------------------
-- Table structure for sku_property
-- ----------------------------
DROP TABLE IF EXISTS `sku_property`;
CREATE TABLE `sku_property`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sku_id` int(11) NULL DEFAULT NULL,
  `property_item_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sku_property
-- ----------------------------
INSERT INTO `sku_property` VALUES (1, 1, 1);
INSERT INTO `sku_property` VALUES (2, 1, 3);

-- ----------------------------
-- Table structure for spu
-- ----------------------------
DROP TABLE IF EXISTS `spu`;
CREATE TABLE `spu`  (
  `spu_id` int(11) NOT NULL AUTO_INCREMENT,
  `spu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `spu_code` int(11) NULL DEFAULT NULL,
  `spu_bulletin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `spu_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `spu_category_id` int(11) NULL DEFAULT NULL,
  `spu_brand_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`spu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of spu
-- ----------------------------
INSERT INTO `spu` VALUES (1, 'iphone11', 1, 'iphone', 'iphone11 最新A2212处理器', 1, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '新用户',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `identity` int(11) NULL DEFAULT 0,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_retailer` int(11) NULL DEFAULT 0,
  `is_speak` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'peppa', 'http://localhost:8081/mall/upload/1576330818413head.jpg', 1, '2019-12-12 00:00:00', 'root', 'root', 1, 0);
INSERT INTO `user` VALUES (2, '吃货', 'http://localhost:8081/mall/upload/1576335542165h1.jpg', 0, '2019-12-12 00:00:00', 'fog', '123', 1, 0);
INSERT INTO `user` VALUES (3, '天线宝宝', 'http://localhost:8081/mall/upload/1576396492783head.jpg', 0, '2019-12-13 00:00:00', 'rain', '123', 1, 0);
INSERT INTO `user` VALUES (4, '新用户', NULL, 0, '2019-12-11 00:00:00', 'sunny', '123', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
