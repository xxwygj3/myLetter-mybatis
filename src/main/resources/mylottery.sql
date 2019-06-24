drop table letternumber;
CREATE TABLE `letternumber` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `issue` varchar(255) NOT NULL COMMENT '期号',
  `numbers` varchar(11) NOT NULL COMMENT '开奖号码',
  `number_1` varchar(255) NOT NULL COMMENT '第一位',
  `number_2` varchar(255) NOT NULL COMMENT '第二位',
  `number_3` varchar(255) NOT NULL COMMENT '第三位',
  `number_4` varchar(255) NOT NULL COMMENT '第四位',
  `number_5` varchar(255) NOT NULL COMMENT '第五位',
  `number_6` varchar(255) NOT NULL COMMENT '第六位',
  `number_7` varchar(255) NOT NULL COMMENT '第七位',
	`sum_value` int(9) NOT NULL COMMENT '和值',
	`all_sub_numbers_list` longtext NOT NULL COMMENT '已开奖号码子串列表',
  PRIMARY KEY (`id`,`issue`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table letternumbersum;
CREATE TABLE `letternumbersum` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
`sum_value` varchar(255) NOT NULL COMMENT '和值',
`sum_times` int(9) NOT NULL COMMENT '已开奖和值出现次数',
`total_times` int(9) NOT NULL COMMENT '总和值次数',
`not_times` int(9) NOT NULL COMMENT '还未开奖和值次数',
`letter_numbers_list` longtext NULL COMMENT '已开奖号码列表',
`all_numbers_list` longtext NULL COMMENT '所有号码列表',
`not_letter_numbers_list` longtext NULL COMMENT '还未开奖号码列表',
PRIMARY KEY (`id`,`sum_value`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table letternumbersub;
CREATE TABLE `letternumbersub` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
`sub_numbers` varchar(11) NOT NULL COMMENT '开奖号码子串(2位至6位)',
`sub_times` int(9) NOT NULL COMMENT '开奖号码子串(2位至6位)出现次数',
PRIMARY KEY (`id`,`sub_numbers`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table letternumberendwise;
CREATE TABLE `letternumberendwise` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `endwise_numbers` varchar(11) NOT NULL COMMENT '纵向7位号码',
	`endwise_times` int(9) NOT NULL COMMENT '纵向7位号码出现次数',
	PRIMARY KEY (`id`,`endwise_numbers`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;





