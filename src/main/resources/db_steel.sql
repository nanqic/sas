/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : db_steel

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 19/04/2021 10:41:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `uid` int DEFAULT NULL COMMENT '用户id',
  `pid` int DEFAULT NULL COMMENT '商品id',
  `rid` tinyint DEFAULT NULL COMMENT '仓库地区id',
  `amount` int DEFAULT NULL COMMENT '数量',
  `remark` varchar(255) DEFAULT NULL COMMENT '订单备注',
  `order_time` datetime DEFAULT NULL COMMENT '下单时间',
  `status` tinyint DEFAULT '1' COMMENT '订单状态 -0 已取消 -1 进行中 -2 已完成',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `pid` (`pid`),
  KEY `rid` (`rid`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`),
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `t_product` (`pid`),
  CONSTRAINT `t_order_ibfk_3` FOREIGN KEY (`rid`) REFERENCES `t_region` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES (1, 8, 4, 1, 7, '123', '2021-04-17 18:05:39', 0);
INSERT INTO `t_order` VALUES (2, 7, 4, 1, 22, '1', '2021-04-17 18:05:39', 1);
INSERT INTO `t_order` VALUES (3, 10, 4, 1, 10, '1', '2021-04-17 18:05:39', 0);
INSERT INTO `t_order` VALUES (4, 10, 4, 1, 10, '', '2021-04-10 18:05:39', 2);
INSERT INTO `t_order` VALUES (5, 11, 15, 4, 20, '我在你们这买的20件热轧产品', '2021-04-01 01:14:09', 2);
INSERT INTO `t_order` VALUES (6, 10, 6, 3, 20, '', '2021-04-17 18:40:55', 0);
INSERT INTO `t_order` VALUES (7, 7, 4, 1, 50, '', '2021-01-18 09:58:19', 2);
INSERT INTO `t_order` VALUES (8, 17, 4, 1, 68, '', '2021-02-18 09:58:37', 2);
INSERT INTO `t_order` VALUES (9, 7, 4, 1, 30, '', '2021-03-18 09:58:51', 2);
INSERT INTO `t_order` VALUES (10, 19, 4, 1, 27, '', '2021-04-11 09:59:16', 2);
INSERT INTO `t_order` VALUES (11, 11, 4, 1, 50, '', '2021-04-18 10:37:47', 1);
INSERT INTO `t_order` VALUES (12, 12, 5, 1, 30, '', '2021-04-18 10:44:09', 1);
INSERT INTO `t_order` VALUES (13, 7, 6, 1, 60, '', '2021-04-18 10:47:58', 1);
INSERT INTO `t_order` VALUES (14, 12, 16, 1, 50, '', '2021-04-18 13:30:55', 1);
INSERT INTO `t_order` VALUES (15, 10, 16, 1, 60, '', '2021-04-18 18:25:57', 1);
INSERT INTO `t_order` VALUES (16, 12, 16, 2, 90, '', '2021-04-18 18:26:20', 1);
INSERT INTO `t_order` VALUES (17, 12, 16, 3, 70, '', '2021-04-18 18:26:33', 1);
INSERT INTO `t_order` VALUES (18, 13, 16, 4, 66, '', '2021-04-18 18:26:46', 1);
INSERT INTO `t_order` VALUES (19, 7, 15, 4, 20, '谢谢', '2021-04-18 18:46:34', 1);
INSERT INTO `t_order` VALUES (20, 7, 4, 2, 11, '11', '2021-04-19 10:22:53', 0);
COMMIT;

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` int DEFAULT NULL,
  `sort_id` tinyint DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `describes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `on_sale` tinyint(1) DEFAULT '1',
  `added_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE,
  KEY `sort_id` (`sort_id`),
  CONSTRAINT `t_product_ibfk_1` FOREIGN KEY (`sort_id`) REFERENCES `t_sort` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
BEGIN;
INSERT INTO `t_product` VALUES (4, '冷轧产品', 5000, 2, '870a1831-4c6d-41e5-b0be-2eeccb656717.jpeg', '111', 1, '2021-01-11 10:09:08');
INSERT INTO `t_product` VALUES (5, '特钢产品', 6000, 3, '6323f386-65f4-4231-85bd-b4622f79731f.jpeg', '555', 1, '2021-01-01 10:09:13');
INSERT INTO `t_product` VALUES (6, '高速线材产品', 5500, 2, '09eeba60-bdcc-4fc8-a873-7966d9d58400.jpeg', '666', 1, '2021-01-01 10:09:13');
INSERT INTO `t_product` VALUES (15, '热轧产品', 2000, 2, '33500725-3309-4320-b80e-b31ffa9b9628.jpeg', '141', 1, '2021-01-01 10:09:31');
INSERT INTO `t_product` VALUES (16, '测试商品', 3200, 1, '1d28bfb9-716c-4293-b30a-fdd9f0434538.png', '123', 1, '2021-01-01 10:09:31');
INSERT INTO `t_product` VALUES (25, 'teste', 111, 1, '0fe71ee7-8782-4f4b-ad0b-0cbb6fff43ee.png', '111', 1, '2021-04-19 10:12:42');
COMMIT;

-- ----------------------------
-- Table structure for t_region
-- ----------------------------
DROP TABLE IF EXISTS `t_region`;
CREATE TABLE `t_region` (
  `rid` tinyint NOT NULL AUTO_INCREMENT,
  `name` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_region
-- ----------------------------
BEGIN;
INSERT INTO `t_region` VALUES (1, '华北');
INSERT INTO `t_region` VALUES (2, '华南');
INSERT INTO `t_region` VALUES (3, '华中');
INSERT INTO `t_region` VALUES (4, '华东');
COMMIT;

-- ----------------------------
-- Table structure for t_sale
-- ----------------------------
DROP TABLE IF EXISTS `t_sale`;
CREATE TABLE `t_sale` (
  `pid` int NOT NULL COMMENT '商品id, 联合主键',
  `rid` tinyint NOT NULL COMMENT '区域id，联合主键',
  `sold_amount` int DEFAULT NULL COMMENT '已售总数',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`pid`,`rid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sale
-- ----------------------------
BEGIN;
INSERT INTO `t_sale` VALUES (4, 1, 247, '2021-04-18 10:38:58');
INSERT INTO `t_sale` VALUES (4, 2, 0, '2021-04-19 10:23:07');
INSERT INTO `t_sale` VALUES (5, 1, 30, '2021-02-18 10:47:08');
INSERT INTO `t_sale` VALUES (6, 1, 60, '2021-03-18 10:47:57');
INSERT INTO `t_sale` VALUES (6, 3, 0, '2021-02-17 21:50:04');
INSERT INTO `t_sale` VALUES (15, 4, 28, '2021-02-01 18:46:33');
INSERT INTO `t_sale` VALUES (16, 1, 110, '2021-04-18 18:25:57');
INSERT INTO `t_sale` VALUES (16, 2, 90, '2021-01-18 18:26:20');
INSERT INTO `t_sale` VALUES (16, 3, 70, '2021-02-18 18:26:32');
INSERT INTO `t_sale` VALUES (16, 4, 66, '2021-03-18 18:26:45');
INSERT INTO `t_sale` VALUES (19, 19, 1, '2021-03-17 21:36:48');
COMMIT;

-- ----------------------------
-- Table structure for t_sort
-- ----------------------------
DROP TABLE IF EXISTS `t_sort`;
CREATE TABLE `t_sort` (
  `sid` tinyint NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sort
-- ----------------------------
BEGIN;
INSERT INTO `t_sort` VALUES (1, '生铁');
INSERT INTO `t_sort` VALUES (2, '粗钢');
INSERT INTO `t_sort` VALUES (3, '钢材');
COMMIT;

-- ----------------------------
-- Table structure for t_stock
-- ----------------------------
DROP TABLE IF EXISTS `t_stock`;
CREATE TABLE `t_stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pid` int DEFAULT NULL,
  `amount` int unsigned DEFAULT NULL,
  `rid` tinyint DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  CONSTRAINT `t_stock_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `t_region` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stock
-- ----------------------------
BEGIN;
INSERT INTO `t_stock` VALUES (1, 4, 803, 1, '2021-04-18 10:38:05');
INSERT INTO `t_stock` VALUES (2, 5, 500, 2, '2021-04-17 10:45:08');
INSERT INTO `t_stock` VALUES (3, 6, 580, 3, '2021-04-17 18:40:55');
INSERT INTO `t_stock` VALUES (4, 15, 15, 4, '2021-04-18 18:46:33');
INSERT INTO `t_stock` VALUES (5, 4, 990, 2, '2021-04-19 10:23:07');
INSERT INTO `t_stock` VALUES (6, 4, 889, 3, '2021-04-18 10:07:01');
INSERT INTO `t_stock` VALUES (7, 4, 700, 4, '2021-04-18 10:06:57');
INSERT INTO `t_stock` VALUES (8, 5, 770, 1, '2021-04-18 10:44:08');
INSERT INTO `t_stock` VALUES (9, 6, 540, 1, '2021-04-18 10:47:57');
INSERT INTO `t_stock` VALUES (10, 16, 390, 1, '2021-04-18 18:25:57');
INSERT INTO `t_stock` VALUES (11, 16, 810, 2, '2021-04-18 18:26:20');
INSERT INTO `t_stock` VALUES (12, 16, 929, 3, '2021-04-18 18:26:32');
INSERT INTO `t_stock` VALUES (13, 16, 933, 4, '2021-04-18 18:26:45');
INSERT INTO `t_stock` VALUES (14, 6, 500, 3, NULL);
INSERT INTO `t_stock` VALUES (15, 4, 11, 1, NULL);
INSERT INTO `t_stock` VALUES (16, 25, 22, 1, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `city` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `county` varchar(12) DEFAULT NULL,
  `province` varchar(12) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `experience` int DEFAULT '100',
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, '用户1', '女', '郑州市', '金水区', '河南省', '39023456@qq.com', '15903713050', 100, 0);
INSERT INTO `t_user` VALUES (2, '用户2', '女', '郑州市', '金水区', '河南省', '39023456@qq.com', '15903713050', 100, 0);
INSERT INTO `t_user` VALUES (3, '用户3', '女', '郑州市', '金水区', '河南省', '39023456@qq.com', '15903713050', 100, 0);
INSERT INTO `t_user` VALUES (4, '用户4', '女', '郑州市', '金水区', '河南省', '39023456@qq.com', '15903713050', 100, 0);
INSERT INTO `t_user` VALUES (5, '用户5', '女', '郑州市', '金水区', '河南省', '39023456@qq.com', '15903713050', 100, 0);
INSERT INTO `t_user` VALUES (6, '用户6', '女', '郑州市', '金水区', '河南省', '39023456@qq.com', '15903713050', 100, 0);
INSERT INTO `t_user` VALUES (7, '用户7', '女', '郑州市', '金水区', '河南省', '39023456@qq.com', '15903713050', 800, 1);
INSERT INTO `t_user` VALUES (8, '用户8', '女', '郑州市', '金水区', '河南省', '39023456@qq.com', '15903713050', 300, 1);
INSERT INTO `t_user` VALUES (9, '用户9', '女', '郑州市', '金水区', '河南省', '39023456@qq.com', '15903713050', 500, 1);
INSERT INTO `t_user` VALUES (10, '用户10', '女', '郑州市', '金水区', '河南省', '39023456@qq.com', '15903713050', 1000, 1);
INSERT INTO `t_user` VALUES (11, '用户11', '男', '青岛市', '市南区', '山东省', '1223456@qq.com', '13503713050', 600, 1);
INSERT INTO `t_user` VALUES (12, '用户12', '男', '青岛市', '市南区', '山东省', '1223456@qq.com', '13503713050', 100, 1);
INSERT INTO `t_user` VALUES (13, '用户13', '男', '青岛市', '市南区', '山东省', '1223456@qq.com', '13503713050', 100, 1);
INSERT INTO `t_user` VALUES (14, '用户14', '男', '青岛市', '市南区', '山东省', '1223456@qq.com', '13503713050', 100, 1);
INSERT INTO `t_user` VALUES (15, '用户15', '男', '青岛市', '市南区', '山东省', '1223456@qq.com', '13503713050', 100, 1);
INSERT INTO `t_user` VALUES (16, '用户16', '男', '青岛市', '市南区', '山东省', '1223456@qq.com', '13503713050', 100, 1);
INSERT INTO `t_user` VALUES (17, '用户17', '男', '青岛市', '市南区', '山东省', '1223456@qq.com', '13503713050', 100, 1);
INSERT INTO `t_user` VALUES (18, '用户18', '男', '青岛市', '市南区', '山东省', '1223456@qq.com', '13503713050', 100, 1);
INSERT INTO `t_user` VALUES (19, '用户19', '男', '青岛市', '市南区', '山东省', '1223456@qq.com', '13503713050', 100, 1);
INSERT INTO `t_user` VALUES (20, '用户20', '男', '青岛市', '市南区', '山东省', '1223456@qq.com', '13503713050', 100, 1);
INSERT INTO `t_user` VALUES (21, '测试用户123', '女', '包头市', '东河区', '内蒙古自治区', '34222@qq.com', '13401119999', 100, 0);
INSERT INTO `t_user` VALUES (22, '用户-19', '女', '朔州市', '怀仁县', '山西省', '23344123@qq.com', '13522333221', 100, 1);
COMMIT;

-- ----------------------------
-- View structure for v_order
-- ----------------------------
DROP VIEW IF EXISTS `v_order`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_order` AS select `o`.`id` AS `id`,`u`.`username` AS `username`,`p`.`name` AS `product`,`p`.`img` AS `img`,`o`.`amount` AS `amount`,`r`.`name` AS `region`,`o`.`remark` AS `remark`,`o`.`order_time` AS `order_time` from (((`t_order` `o` join `t_user` `u` on((`o`.`uid` = `u`.`uid`))) join `t_product` `p` on((`o`.`pid` = `p`.`pid`))) join `t_region` `r` on((`o`.`rid` = `r`.`rid`))) where (`o`.`status` = 1);

-- ----------------------------
-- View structure for v_order_history
-- ----------------------------
DROP VIEW IF EXISTS `v_order_history`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_order_history` AS select `o`.`id` AS `id`,`u`.`username` AS `username`,`p`.`name` AS `product`,`p`.`img` AS `img`,`o`.`amount` AS `amount`,`r`.`name` AS `region`,`o`.`remark` AS `remark`,`o`.`order_time` AS `order_time`,`o`.`status` AS `status` from (((`t_order` `o` join `t_user` `u` on((`o`.`uid` = `u`.`uid`))) join `t_product` `p` on((`o`.`pid` = `p`.`pid`))) join `t_region` `r` on((`o`.`rid` = `r`.`rid`))) where (`o`.`status` <> 1);

-- ----------------------------
-- View structure for v_sale
-- ----------------------------
DROP VIEW IF EXISTS `v_sale`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_sale` AS select `p`.`name` AS `product`,`r`.`name` AS `region`,`s`.`sold_amount` AS `sold_amount`,`s`.`update_time` AS `update_time` from ((`t_sale` `s` join `t_product` `p` on((`s`.`pid` = `p`.`pid`))) join `t_region` `r` on((`s`.`rid` = `r`.`rid`)));

-- ----------------------------
-- View structure for v_sale_ana_region
-- ----------------------------
DROP VIEW IF EXISTS `v_sale_ana_region`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_sale_ana_region` AS select `t_region`.`name` AS `name`,sum(`t_sale`.`sold_amount`) AS `sold_amount` from (`t_sale` join `t_region` on((`t_region`.`rid` = `t_sale`.`rid`))) where `t_sale`.`pid` in (select `t_product`.`pid` from `t_product` where (`t_product`.`sort_id` = 2)) group by `t_region`.`name`;

-- ----------------------------
-- View structure for v_sale_ana_sort
-- ----------------------------
DROP VIEW IF EXISTS `v_sale_ana_sort`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_sale_ana_sort` AS select `t_sort`.`name` AS `name`,`t_sale`.`sold_amount` AS `sold_amount`,`t_sale`.`update_time` AS `update_time` from ((`t_sort` join `t_product` `p` on((`t_sort`.`sid` = `p`.`sort_id`))) join `t_sale` on((`p`.`pid` = `t_sale`.`pid`))) where ((`t_sale`.`rid` = 1) and `p`.`pid` in (select `t_sale`.`pid` from `t_sale` where (`t_sale`.`rid` = 1)));

-- ----------------------------
-- Event structure for event_user
-- ----------------------------
DROP EVENT IF EXISTS `event_user`;
delimiter ;;
CREATE EVENT `event_user`
ON SCHEDULE
EVERY '5' SECOND STARTS '2021-04-17 18:13:14'
ON COMPLETION PRESERVE
COMMENT '更新订单状态定时任务'
DO UPDATE t_order SET `status`= IF(TO_DAYS( NOW() )- TO_DAYS( order_time )>=7,2,1) WHERE status=1
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
