/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : Demo

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 08/03/2019 23:14:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `v_id` int(11) DEFAULT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resources
-- ----------------------------
BEGIN;
INSERT INTO `resources` VALUES (13, 37, 'http://bpic.588ku.com/element_origin_min_pic/17/12/25/42dd7bab7fac39100f146ef62865116b.jpg', 'ss<br>ww', '{\"start_time\":\"11:00\", \"end_time\":\"11:00\"}');
INSERT INTO `resources` VALUES (14, 38, 'http://www.hinews.cn/pic/0/15/39/56/15395644_560435.jpg', '22<br>22', '{\"start_time\":\"11:00\", \"end_time\":\"11:00\"}');
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `permisson` int(1) DEFAULT '0',
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('admin', 'admin', 3, 0);
INSERT INTO `users` VALUES ('test', 'test', 4, 1);
INSERT INTO `users` VALUES ('test1', 'test1', 5, 0);
INSERT INTO `users` VALUES ('11', '11', 6, 1);
COMMIT;

-- ----------------------------
-- Table structure for videos
-- ----------------------------
DROP TABLE IF EXISTS `videos`;
CREATE TABLE `videos` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `is_full` int(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `descr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cover` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of videos
-- ----------------------------
BEGIN;
INSERT INTO `videos` VALUES (4, 6, '/user/xx.mp4', 1, '11', '11', '/user/xx.png');
INSERT INTO `videos` VALUES (37, 6, NULL, 0, NULL, NULL, NULL);
INSERT INTO `videos` VALUES (38, 6, NULL, 0, NULL, NULL, NULL);
INSERT INTO `videos` VALUES (39, 6, NULL, 0, NULL, NULL, NULL);
INSERT INTO `videos` VALUES (40, 6, NULL, 0, NULL, NULL, NULL);
INSERT INTO `videos` VALUES (41, 6, NULL, 0, NULL, NULL, NULL);
INSERT INTO `videos` VALUES (42, 6, NULL, 0, NULL, NULL, NULL);
INSERT INTO `videos` VALUES (43, 6, NULL, 0, NULL, NULL, NULL);
INSERT INTO `videos` VALUES (44, 6, NULL, 0, NULL, NULL, NULL);
INSERT INTO `videos` VALUES (45, 6, NULL, 0, NULL, NULL, NULL);
INSERT INTO `videos` VALUES (46, 6, NULL, 0, NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
