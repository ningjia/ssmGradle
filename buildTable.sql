CREATE SCHEMA `ssmGradleTest` ;

--用户信息表
CREATE TABLE `ssmGradleTest`.`user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id,自增长',
  `name` char(40) DEFAULT NULL COMMENT '用户名',
  `password` char(50) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户表';

INSERT INTO `ssmGradleTest`.`user` VALUES (1, '赚啦', '艾尔文');
INSERT INTO `ssmGradleTest`.`user` VALUES (2, '理财', 'gogogogo');
INSERT INTO `ssmGradleTest`.`user` VALUES (3, '图震', '小米豌豆荚市场可以下载');
INSERT INTO `ssmGradleTest`.`user` VALUES (6, 'www.aoeai.com', '代码生成器');
INSERT INTO `ssmGradleTest`.`user` VALUES (7, '更上7层楼', 'kukucaou');


--学生信息表
CREATE TABLE `ssmGradleTest`.`student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id,自增长',
  `name` char(40) DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `remark` char(100) DEFAULT NULL COMMENT '个人描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='学生表';

INSERT INTO `ssmGradleTest`.`student` VALUES (1, '张三', 15, 1,'张三的描述');
INSERT INTO `ssmGradleTest`.`student` VALUES (2, '李四', 16, 0,'李四的描述');
INSERT INTO `ssmGradleTest`.`student` VALUES (3, '王五', 17, 1,'王五的描述');


--课程信息表
CREATE TABLE `ssmGradleTest`.`course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程id,自增长',
  `name` char(40) DEFAULT NULL COMMENT '课程名称',
  `remark` char(100) DEFAULT NULL COMMENT '课程描述',
  `t_id` INT COMMENT '教师id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='课程表';

INSERT INTO `ssmGradleTest`.`course` VALUES (1, '语文','语文的描述',1);
INSERT INTO `ssmGradleTest`.`course` VALUES (2, '数学','数学的描述',2);
INSERT INTO `ssmGradleTest`.`course` VALUES (3, '英语','英语的描述',3);


--学生课程对照表
CREATE TABLE `ssmGradleTest`.`student_course` (
  `s_id` INT NOT NULL COMMENT '学生id',
  `c_id` INT NOT NULL COMMENT '课程id',
  PRIMARY KEY (`s_id`, `c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生课程对照表';

INSERT INTO `ssmGradleTest`.`student_course` VALUES (1, 1);
INSERT INTO `ssmGradleTest`.`student_course` VALUES (1, 2);
INSERT INTO `ssmGradleTest`.`student_course` VALUES (1, 3);
INSERT INTO `ssmGradleTest`.`student_course` VALUES (2, 2);
INSERT INTO `ssmGradleTest`.`student_course` VALUES (2, 3);
INSERT INTO `ssmGradleTest`.`student_course` VALUES (3, 3);

--教师信息表
CREATE TABLE `ssmGradleTest`.`teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师id,自增长',
  `name` char(40) DEFAULT NULL COMMENT '教师姓名',
  `rank` char(40) DEFAULT NULL COMMENT '教师级别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='课程表';

INSERT INTO `ssmGradleTest`.`teacher` VALUES (1, 'Steve','教授');
INSERT INTO `ssmGradleTest`.`teacher` VALUES (2, 'Jessica','副教授');
INSERT INTO `ssmGradleTest`.`teacher` VALUES (3, 'Tom','专家');