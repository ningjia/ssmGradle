
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id,自增长',
  `name` char(40) DEFAULT NULL COMMENT '用户名',
  `password` char(50) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户表';

INSERT INTO `user` VALUES (1, '赚啦', '艾尔文');
INSERT INTO `user` VALUES (2, '理财', 'gogogogo');
INSERT INTO `user` VALUES (3, '图震', '小米豌豆荚市场可以下载');
INSERT INTO `user` VALUES (6, 'www.aoeai.com', '代码生成器');
INSERT INTO `user` VALUES (7, '更上7层楼', 'kukucaou');
