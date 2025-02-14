/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80036
 Source Host           : localhost:3306
 Source Schema         : api-demo

 Target Server Type    : MySQL
 Target Server Version : 80036
 File Encoding         : 65001

 Date: 14/02/2025 11:53:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for areas
-- ----------------------------
DROP TABLE IF EXISTS `areas`;
CREATE TABLE `areas`  (
  `id` bigint NOT NULL COMMENT '区域住建',
  `country_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '国家代码',
  `province` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '省名称',
  `city` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '城市名称',
  `district` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '区（可选）',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_delete` int NOT NULL DEFAULT 0 COMMENT '删除标识',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_city`(`country_code` ASC, `province` ASC, `city` ASC, `district` ASC) USING BTREE COMMENT '地区唯一索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of areas
-- ----------------------------
INSERT INTO `areas` VALUES (1, 'CN', '四川省', '成都市', NULL, '2025-02-13 21:07:25', '2025-02-13 21:07:01', 0);
INSERT INTO `areas` VALUES (2, 'CN', '四川省', '广安市', NULL, '2025-02-13 22:01:56', '2025-02-13 22:01:56', 0);
INSERT INTO `areas` VALUES (3, 'CN', '广东省', NULL, NULL, '2025-02-14 11:44:34', '2025-02-14 11:44:36', 0);
INSERT INTO `areas` VALUES (4, 'CN', '浙江省', '杭州市', NULL, '2025-02-14 11:45:10', '2025-02-14 11:45:12', 0);

-- ----------------------------
-- Table structure for user_area
-- ----------------------------
DROP TABLE IF EXISTS `user_area`;
CREATE TABLE `user_area`  (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `area_id` bigint NOT NULL COMMENT '区域ID'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_area
-- ----------------------------
INSERT INTO `user_area` VALUES (1, 1);
INSERT INTO `user_area` VALUES (1, 2);
INSERT INTO `user_area` VALUES (1, 3);
INSERT INTO `user_area` VALUES (1, 4);

SET FOREIGN_KEY_CHECKS = 1;
