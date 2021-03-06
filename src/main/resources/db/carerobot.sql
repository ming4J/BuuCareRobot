/*
 Navicat Premium Data Transfer

 Source Server         : lcoal
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : carerobot

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 13/11/2019 01:01:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lock
-- ----------------------------
DROP TABLE IF EXISTS `lock`;
CREATE TABLE `lock` (
  `count` int(1) NOT NULL,
  PRIMARY KEY (`count`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of lock
-- ----------------------------
BEGIN;
INSERT INTO `lock` VALUES (0);
COMMIT;

-- ----------------------------
-- Table structure for roomInfo
-- ----------------------------
DROP TABLE IF EXISTS `roomInfo`;
CREATE TABLE `roomInfo` (
  `roomId` char(3) COLLATE utf8mb4_general_ci NOT NULL,
  `roomName` char(40) COLLATE utf8mb4_general_ci NOT NULL,
  `pX` double(255,11) NOT NULL,
  `pY` double(255,11) NOT NULL,
  `pZ` double(255,11) NOT NULL,
  `oX` double(255,11) NOT NULL,
  `oY` double(255,11) NOT NULL,
  `oZ` double(255,11) NOT NULL,
  `oW` double(255,11) NOT NULL,
  PRIMARY KEY (`roomId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of roomInfo
-- ----------------------------
BEGIN;
INSERT INTO `roomInfo` VALUES ('100', '回去', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('101', '团委办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('102', '党委副书记办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('103', '实训基地办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('104', '副院长办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('105', '副院长办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('106', '党委书记办公室', 0.70000000000, -0.00400000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 1.00000000000);
INSERT INTO `roomInfo` VALUES ('107', '院长办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('108', '副院长办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('109', '教学科研办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('110', '大会议室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('113', '综合办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('115', '学生工作办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('135', '学生工作办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('136', '学生工作办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('137', '小会议室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('138', '教学科研办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('139', '教学科研办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('140', '研究生管理办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('141', '系部主任办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('142', '教学科研办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
INSERT INTO `roomInfo` VALUES ('143', '综合办公室', 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000, 0.00000000000);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
