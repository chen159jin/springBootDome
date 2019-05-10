/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50723
Source Host           : 127.0.0.1:3306
Source Database       : jin

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-05-10 16:39:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
                                     `username` varchar(64) NOT NULL,
                                     `series` varchar(64) NOT NULL,
                                     `token` varchar(64) NOT NULL,
                                     `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                     PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
                          `DEPT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
                          `PARENT_ID` bigint(20) NOT NULL COMMENT '上级部门ID',
                          `DEPT_NAME` varchar(100) NOT NULL COMMENT '部门名称',
                          `ORDER_NUM` bigint(20) DEFAULT NULL COMMENT '排序',
                          `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
                          PRIMARY KEY (`DEPT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('1', '0', '开发部', null, '2018-01-04 15:42:26');
INSERT INTO `t_dept` VALUES ('2', '1', '开发一部', null, '2018-01-04 15:42:34');
INSERT INTO `t_dept` VALUES ('3', '1', '开发二部', null, '2018-01-04 15:42:29');
INSERT INTO `t_dept` VALUES ('4', '0', '市场部', null, '2018-01-04 15:42:36');
INSERT INTO `t_dept` VALUES ('5', '0', '人事部', null, '2018-01-04 15:42:32');
INSERT INTO `t_dept` VALUES ('6', '0', '测试部', null, '2018-01-04 15:42:38');

-- ----------------------------
-- Table structure for t_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict` (
                          `DICT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典ID',
                          `KEYY` bigint(20) NOT NULL COMMENT '键',
                          `VALUEE` varchar(100) NOT NULL COMMENT '值',
                          `FIELD_NAME` varchar(100) NOT NULL COMMENT '字段名称',
                          `TABLE_NAME` varchar(100) NOT NULL COMMENT '表名',
                          PRIMARY KEY (`DICT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dict
-- ----------------------------
INSERT INTO `t_dict` VALUES ('1', '0', '男', 'ssex', 't_user');
INSERT INTO `t_dict` VALUES ('2', '1', '女', 'ssex', 't_user');
INSERT INTO `t_dict` VALUES ('3', '2', '保密', 'ssex', 't_user');
INSERT INTO `t_dict` VALUES ('4', '1', '有效', 'status', 't_user');
INSERT INTO `t_dict` VALUES ('5', '0', '锁定', 'status', 't_user');
INSERT INTO `t_dict` VALUES ('6', '0', '菜单', 'type', 't_menu');
INSERT INTO `t_dict` VALUES ('7', '1', '按钮', 'type', 't_menu');
INSERT INTO `t_dict` VALUES ('30', '0', '正常', 'status', 't_job');
INSERT INTO `t_dict` VALUES ('31', '1', '暂停', 'status', 't_job');
INSERT INTO `t_dict` VALUES ('32', '0', '成功', 'status', 't_job_log');
INSERT INTO `t_dict` VALUES ('33', '1', '失败', 'status', 't_job_log');

-- ----------------------------
-- Table structure for t_job
-- ----------------------------
DROP TABLE IF EXISTS `t_job`;
CREATE TABLE `t_job` (
                         `JOB_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
                         `BEAN_NAME` varchar(100) NOT NULL COMMENT 'spring bean名称',
                         `METHOD_NAME` varchar(100) NOT NULL COMMENT '方法名',
                         `PARAMS` varchar(200) DEFAULT NULL COMMENT '参数',
                         `CRON_EXPRESSION` varchar(100) NOT NULL COMMENT 'cron表达式',
                         `STATUS` char(2) NOT NULL COMMENT '任务状态  0：正常  1：暂停',
                         `REMARK` varchar(200) DEFAULT NULL COMMENT '备注',
                         `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
                         PRIMARY KEY (`JOB_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_job
-- ----------------------------
INSERT INTO `t_job` VALUES ('1', 'testTask', 'test', 'mrbird', '0/1 * * * * ?', '1', '有参任务调度测试', '2018-02-24 16:26:14');
INSERT INTO `t_job` VALUES ('2', 'testTask', 'test1', null, '0/10 * * * * ?', '1', '无参任务调度测试', '2018-02-24 17:06:23');
INSERT INTO `t_job` VALUES ('3', 'testTask', 'test', 'hello world', '0/1 * * * * ?', '1', '有参任务调度测试,每隔一秒触发', '2018-02-26 09:28:26');
INSERT INTO `t_job` VALUES ('11', 'testTask', 'test2', null, '0/5 * * * * ?', '1', '测试异常', '2018-02-26 11:15:30');

-- ----------------------------
-- Table structure for t_job_log
-- ----------------------------
DROP TABLE IF EXISTS `t_job_log`;
CREATE TABLE `t_job_log` (
                             `LOG_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
                             `JOB_ID` bigint(20) NOT NULL COMMENT '任务id',
                             `BEAN_NAME` varchar(100) NOT NULL COMMENT 'spring bean名称',
                             `METHOD_NAME` varchar(100) NOT NULL COMMENT '方法名',
                             `PARAMS` varchar(200) DEFAULT NULL COMMENT '参数',
                             `STATUS` char(2) NOT NULL COMMENT '任务状态    0：成功    1：失败',
                             `ERROR` text COMMENT '失败信息',
                             `TIMES` decimal(11,0) DEFAULT NULL COMMENT '耗时(单位：毫秒)',
                             `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
                             PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2485 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_job_log
-- ----------------------------
INSERT INTO `t_job_log` VALUES ('2448', '3', 'testTask', 'test', 'hello world', '0', null, '0', '2018-03-20 15:31:50');
INSERT INTO `t_job_log` VALUES ('2449', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:51');
INSERT INTO `t_job_log` VALUES ('2450', '3', 'testTask', 'test', 'hello world', '0', null, '2', '2018-03-20 15:31:52');
INSERT INTO `t_job_log` VALUES ('2451', '3', 'testTask', 'test', 'hello world', '0', null, '0', '2018-03-20 15:31:53');
INSERT INTO `t_job_log` VALUES ('2452', '3', 'testTask', 'test', 'hello world', '0', null, '2', '2018-03-20 15:31:54');
INSERT INTO `t_job_log` VALUES ('2453', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:55');
INSERT INTO `t_job_log` VALUES ('2454', '3', 'testTask', 'test', 'hello world', '0', null, '0', '2018-03-20 15:31:56');
INSERT INTO `t_job_log` VALUES ('2455', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:57');
INSERT INTO `t_job_log` VALUES ('2456', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:59');
INSERT INTO `t_job_log` VALUES ('2457', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:59');
INSERT INTO `t_job_log` VALUES ('2458', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:00');
INSERT INTO `t_job_log` VALUES ('2459', '3', 'testTask', 'test', 'hello world', '0', null, '0', '2018-03-20 15:32:01');
INSERT INTO `t_job_log` VALUES ('2460', '3', 'testTask', 'test', 'hello world', '0', null, '5', '2018-03-20 15:32:02');
INSERT INTO `t_job_log` VALUES ('2461', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:03');
INSERT INTO `t_job_log` VALUES ('2462', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:04');
INSERT INTO `t_job_log` VALUES ('2463', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:05');
INSERT INTO `t_job_log` VALUES ('2464', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:06');
INSERT INTO `t_job_log` VALUES ('2465', '11', 'testTask', 'test2', null, '1', 'java.lang.NoSuchMethodException: cc.mrbird.job.task.TestTask.test2()', '0', '2018-03-20 15:32:26');
INSERT INTO `t_job_log` VALUES ('2466', '2', 'testTask', 'test1', null, '0', null, '1', '2018-04-02 15:26:40');
INSERT INTO `t_job_log` VALUES ('2467', '2', 'testTask', 'test1', null, '0', null, '1', '2018-04-02 15:26:50');
INSERT INTO `t_job_log` VALUES ('2468', '2', 'testTask', 'test1', null, '0', null, '1', '2018-04-02 15:27:20');
INSERT INTO `t_job_log` VALUES ('2469', '2', 'testTask', 'test1', null, '0', null, '3', '2018-04-02 17:29:20');
INSERT INTO `t_job_log` VALUES ('2470', '2', 'testTask', 'test1', null, '0', null, '1', '2018-04-02 17:29:30');
INSERT INTO `t_job_log` VALUES ('2471', '2', 'testTask', 'test1', null, '0', null, '1', '2018-04-02 17:29:40');
INSERT INTO `t_job_log` VALUES ('2472', '2', 'testTask', 'test1', null, '0', null, '14', '2018-04-02 17:29:50');
INSERT INTO `t_job_log` VALUES ('2473', '2', 'testTask', 'test1', null, '0', null, '1', '2018-04-02 17:30:00');
INSERT INTO `t_job_log` VALUES ('2474', '2', 'testTask', 'test1', null, '0', null, '0', '2018-04-02 17:30:10');
INSERT INTO `t_job_log` VALUES ('2475', '2', 'testTask', 'test1', null, '0', null, '1', '2018-04-02 17:30:20');
INSERT INTO `t_job_log` VALUES ('2476', '3', 'testTask', 'test', 'hello world', '0', null, '4', '2018-09-06 14:15:40');
INSERT INTO `t_job_log` VALUES ('2477', '11', 'testTask', 'test2', null, '1', 'java.lang.NoSuchMethodException: cc.mrbird.quartz.task.TestTask.test2()', '11', '2018-09-06 14:15:50');
INSERT INTO `t_job_log` VALUES ('2478', '2', 'testTask', 'test1', null, '0', null, '1', '2018-09-06 14:16:10');
INSERT INTO `t_job_log` VALUES ('2479', '2', 'testTask', 'test1', null, '0', null, '1', '2018-09-06 14:16:19');
INSERT INTO `t_job_log` VALUES ('2480', '2', 'testTask', 'test1', null, '0', null, '1', '2018-09-06 14:16:20');
INSERT INTO `t_job_log` VALUES ('2481', '2', 'testTask', 'test1', null, '0', null, '1', '2018-09-06 14:16:30');
INSERT INTO `t_job_log` VALUES ('2482', '2', 'testTask', 'test1', null, '0', null, '1', '2018-09-06 14:16:40');
INSERT INTO `t_job_log` VALUES ('2483', '2', 'testTask', 'test1', null, '0', null, '1', '2018-09-06 14:16:50');
INSERT INTO `t_job_log` VALUES ('2484', '2', 'testTask', 'test1', null, '0', null, '1', '2018-09-06 14:17:00');

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
                         `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
                         `USERNAME` varchar(50) DEFAULT NULL COMMENT '操作用户',
                         `OPERATION` text COMMENT '操作内容',
                         `TIME` decimal(11,0) DEFAULT NULL COMMENT '耗时',
                         `METHOD` text COMMENT '操作方法',
                         `PARAMS` text COMMENT '方法参数',
                         `IP` varchar(64) DEFAULT NULL COMMENT '操作者IP',
                         `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
                         `location` varchar(50) DEFAULT NULL COMMENT '操作地点',
                         PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
                          `MENU_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单/按钮ID',
                          `PARENT_ID` bigint(20) NOT NULL COMMENT '上级菜单ID',
                          `MENU_NAME` varchar(50) NOT NULL COMMENT '菜单/按钮名称',
                          `URL` varchar(100) DEFAULT NULL COMMENT '菜单URL',
                          `PERMS` text COMMENT '权限标识',
                          `ICON` varchar(50) DEFAULT NULL COMMENT '图标',
                          `TYPE` char(2) NOT NULL COMMENT '类型 0菜单 1按钮',
                          `ORDER_NUM` bigint(20) DEFAULT NULL COMMENT '排序',
                          `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
                          `MODIFY_TIME` datetime DEFAULT NULL COMMENT '修改时间',
                          PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '0', '系统管理', null, null, 'zmdi zmdi-settings', '0', '1', '2017-12-27 16:39:07', null);
INSERT INTO `t_menu` VALUES ('2', '0', '系统监控', null, null, 'zmdi zmdi-shield-security', '0', '2', '2017-12-27 16:45:51', '2018-01-17 17:08:28');
INSERT INTO `t_menu` VALUES ('3', '1', '用户管理', 'user', 'user:list', '', '0', '1', '2017-12-27 16:47:13', '2018-04-25 09:00:01');
INSERT INTO `t_menu` VALUES ('4', '1', '角色管理', 'role', 'role:list', '', '0', '2', '2017-12-27 16:48:09', '2018-04-25 09:01:12');
INSERT INTO `t_menu` VALUES ('5', '1', '菜单管理', 'menu', 'menu:list', '', '0', '3', '2017-12-27 16:48:57', '2018-04-25 09:01:30');
INSERT INTO `t_menu` VALUES ('6', '1', '部门管理', 'dept', 'dept:list', '', '0', '4', '2017-12-27 16:57:33', '2018-04-25 09:01:40');
INSERT INTO `t_menu` VALUES ('8', '2', '在线用户', 'session', 'session:list', '', '0', '1', '2017-12-27 16:59:33', '2018-04-25 09:02:04');
INSERT INTO `t_menu` VALUES ('10', '2', '系统日志', 'log', 'log:list', '', '0', '3', '2017-12-27 17:00:50', '2018-04-25 09:02:18');
INSERT INTO `t_menu` VALUES ('11', '3', '新增用户', null, 'user:add', null, '1', null, '2017-12-27 17:02:58', null);
INSERT INTO `t_menu` VALUES ('12', '3', '修改用户', null, 'user:update', null, '1', null, '2017-12-27 17:04:07', null);
INSERT INTO `t_menu` VALUES ('13', '3', '删除用户', null, 'user:delete', null, '1', null, '2017-12-27 17:04:58', null);
INSERT INTO `t_menu` VALUES ('14', '4', '新增角色', null, 'role:add', null, '1', null, '2017-12-27 17:06:38', null);
INSERT INTO `t_menu` VALUES ('15', '4', '修改角色', null, 'role:update', null, '1', null, '2017-12-27 17:06:38', null);
INSERT INTO `t_menu` VALUES ('16', '4', '删除角色', null, 'role:delete', null, '1', null, '2017-12-27 17:06:38', null);
INSERT INTO `t_menu` VALUES ('17', '5', '新增菜单', null, 'menu:add', null, '1', null, '2017-12-27 17:08:02', null);
INSERT INTO `t_menu` VALUES ('18', '5', '修改菜单', null, 'menu:update', null, '1', null, '2017-12-27 17:08:02', null);
INSERT INTO `t_menu` VALUES ('19', '5', '删除菜单', null, 'menu:delete', null, '1', null, '2017-12-27 17:08:02', null);
INSERT INTO `t_menu` VALUES ('20', '6', '新增部门', null, 'dept:add', null, '1', null, '2017-12-27 17:09:24', null);
INSERT INTO `t_menu` VALUES ('21', '6', '修改部门', null, 'dept:update', null, '1', null, '2017-12-27 17:09:24', null);
INSERT INTO `t_menu` VALUES ('22', '6', '删除部门', null, 'dept:delete', null, '1', null, '2017-12-27 17:09:24', null);
INSERT INTO `t_menu` VALUES ('23', '8', '踢出用户', '', 'session:kickout', '', '1', null, '2017-12-27 17:11:13', '2018-09-06 18:45:27');
INSERT INTO `t_menu` VALUES ('24', '10', '删除日志', null, 'log:delete', null, '1', null, '2017-12-27 17:11:45', null);
INSERT INTO `t_menu` VALUES ('58', '0', '网络资源', null, null, 'zmdi zmdi-globe-alt', '0', null, '2018-01-12 15:28:48', '2018-01-22 19:49:26');
INSERT INTO `t_menu` VALUES ('59', '58', '天气查询', 'weather', 'weather:list', '', '0', null, '2018-01-12 15:40:02', '2018-04-25 09:02:57');
INSERT INTO `t_menu` VALUES ('61', '58', '每日一文', 'article', 'article:list', '', '0', null, '2018-01-15 17:17:14', '2018-04-25 09:03:08');
INSERT INTO `t_menu` VALUES ('64', '1', '字典管理', 'dict', 'dict:list', '', '0', null, '2018-01-18 10:38:25', '2018-09-07 21:23:58');
INSERT INTO `t_menu` VALUES ('65', '64', '新增字典', null, 'dict:add', null, '1', null, '2018-01-18 19:10:08', null);
INSERT INTO `t_menu` VALUES ('66', '64', '修改字典', null, 'dict:update', null, '1', null, '2018-01-18 19:10:27', null);
INSERT INTO `t_menu` VALUES ('67', '64', '删除字典', null, 'dict:delete', null, '1', null, '2018-01-18 19:10:47', null);
INSERT INTO `t_menu` VALUES ('81', '58', '影视资讯', null, null, null, '0', null, '2018-01-22 14:12:59', null);
INSERT INTO `t_menu` VALUES ('82', '81', '正在热映', 'movie/hot', 'movie:hot', '', '0', null, '2018-01-22 14:13:47', '2018-04-25 09:03:48');
INSERT INTO `t_menu` VALUES ('83', '81', '即将上映', 'movie/coming', 'movie:coming', '', '0', null, '2018-01-22 14:14:36', '2018-04-25 09:04:05');
INSERT INTO `t_menu` VALUES ('101', '0', '任务调度', null, null, 'zmdi zmdi-alarm', '0', null, '2018-02-24 15:52:57', null);
INSERT INTO `t_menu` VALUES ('102', '101', '定时任务', 'job', 'job:list', '', '0', null, '2018-02-24 15:53:53', '2018-04-25 09:05:12');
INSERT INTO `t_menu` VALUES ('103', '102', '新增任务', null, 'job:add', null, '1', null, '2018-02-24 15:55:10', null);
INSERT INTO `t_menu` VALUES ('104', '102', '修改任务', null, 'job:update', null, '1', null, '2018-02-24 15:55:53', null);
INSERT INTO `t_menu` VALUES ('105', '102', '删除任务', null, 'job:delete', null, '1', null, '2018-02-24 15:56:18', null);
INSERT INTO `t_menu` VALUES ('106', '102', '暂停任务', null, 'job:pause', null, '1', null, '2018-02-24 15:57:08', null);
INSERT INTO `t_menu` VALUES ('107', '102', '恢复任务', null, 'job:resume', null, '1', null, '2018-02-24 15:58:21', null);
INSERT INTO `t_menu` VALUES ('108', '102', '立即执行任务', null, 'job:run', null, '1', null, '2018-02-24 15:59:45', null);
INSERT INTO `t_menu` VALUES ('109', '101', '调度日志', 'jobLog', 'jobLog:list', '', '0', null, '2018-02-24 16:00:45', '2018-04-25 09:05:25');
INSERT INTO `t_menu` VALUES ('110', '109', '删除日志', null, 'jobLog:delete', null, '1', null, '2018-02-24 16:01:21', null);
INSERT INTO `t_menu` VALUES ('113', '2', 'Redis监控', 'redis/info', 'redis:list', '', '0', null, '2018-06-28 14:29:42', null);
INSERT INTO `t_menu` VALUES ('114', '2', 'Redis终端', 'redis/terminal', 'redis:terminal', '', '0', null, '2018-06-28 15:35:21', null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
                          `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                          `ROLE_NAME` varchar(100) NOT NULL COMMENT '角色名称',
                          `REMARK` varchar(100) DEFAULT NULL COMMENT '角色描述',
                          `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
                          `MODIFY_TIME` datetime DEFAULT NULL COMMENT '修改时间',
                          PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '管理员', '管理员', '2017-12-27 16:23:11', '2018-02-24 16:01:45');
INSERT INTO `t_role` VALUES ('2', '注册用户', '注册用户', '2018-09-04 16:23:09', '2018-09-15 14:56:53');

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
                               `id` bigint(10) NOT NULL AUTO_INCREMENT,
                               `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
                               `MENU_ID` bigint(20) NOT NULL COMMENT '菜单/按钮ID',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES ('1', '1', '59');
INSERT INTO `t_role_menu` VALUES ('2', '1', '2');
INSERT INTO `t_role_menu` VALUES ('3', '1', '3');
INSERT INTO `t_role_menu` VALUES ('4', '1', '67');
INSERT INTO `t_role_menu` VALUES ('5', '1', '1');
INSERT INTO `t_role_menu` VALUES ('6', '1', '4');
INSERT INTO `t_role_menu` VALUES ('7', '1', '5');
INSERT INTO `t_role_menu` VALUES ('8', '1', '6');
INSERT INTO `t_role_menu` VALUES ('9', '1', '20');
INSERT INTO `t_role_menu` VALUES ('10', '1', '21');
INSERT INTO `t_role_menu` VALUES ('11', '1', '22');
INSERT INTO `t_role_menu` VALUES ('12', '1', '10');
INSERT INTO `t_role_menu` VALUES ('13', '1', '8');
INSERT INTO `t_role_menu` VALUES ('14', '1', '58');
INSERT INTO `t_role_menu` VALUES ('15', '1', '66');
INSERT INTO `t_role_menu` VALUES ('16', '1', '11');
INSERT INTO `t_role_menu` VALUES ('17', '1', '12');
INSERT INTO `t_role_menu` VALUES ('18', '1', '64');
INSERT INTO `t_role_menu` VALUES ('19', '1', '13');
INSERT INTO `t_role_menu` VALUES ('20', '1', '14');
INSERT INTO `t_role_menu` VALUES ('21', '1', '65');
INSERT INTO `t_role_menu` VALUES ('22', '1', '15');
INSERT INTO `t_role_menu` VALUES ('23', '1', '16');
INSERT INTO `t_role_menu` VALUES ('24', '1', '17');
INSERT INTO `t_role_menu` VALUES ('25', '1', '18');
INSERT INTO `t_role_menu` VALUES ('26', '1', '23');
INSERT INTO `t_role_menu` VALUES ('27', '1', '81');
INSERT INTO `t_role_menu` VALUES ('28', '1', '82');
INSERT INTO `t_role_menu` VALUES ('29', '1', '83');
INSERT INTO `t_role_menu` VALUES ('30', '1', '19');
INSERT INTO `t_role_menu` VALUES ('31', '1', '24');
INSERT INTO `t_role_menu` VALUES ('32', '1', '61');
INSERT INTO `t_role_menu` VALUES ('33', '1', '101');
INSERT INTO `t_role_menu` VALUES ('34', '1', '102');
INSERT INTO `t_role_menu` VALUES ('35', '1', '103');
INSERT INTO `t_role_menu` VALUES ('36', '1', '104');
INSERT INTO `t_role_menu` VALUES ('37', '1', '105');
INSERT INTO `t_role_menu` VALUES ('38', '1', '106');
INSERT INTO `t_role_menu` VALUES ('39', '1', '107');
INSERT INTO `t_role_menu` VALUES ('40', '1', '108');
INSERT INTO `t_role_menu` VALUES ('41', '1', '109');
INSERT INTO `t_role_menu` VALUES ('42', '1', '110');
INSERT INTO `t_role_menu` VALUES ('43', '1', '113');
INSERT INTO `t_role_menu` VALUES ('44', '1', '114');
INSERT INTO `t_role_menu` VALUES ('45', '2', '1');
INSERT INTO `t_role_menu` VALUES ('46', '2', '3');
INSERT INTO `t_role_menu` VALUES ('47', '2', '4');
INSERT INTO `t_role_menu` VALUES ('48', '2', '2');
INSERT INTO `t_role_menu` VALUES ('49', '2', '8');
INSERT INTO `t_role_menu` VALUES ('50', '2', '11');
INSERT INTO `t_role_menu` VALUES ('51', '2', '14');
INSERT INTO `t_role_menu` VALUES ('52', '2', '5');
INSERT INTO `t_role_menu` VALUES ('53', '2', '17');
INSERT INTO `t_role_menu` VALUES ('54', '2', '6');
INSERT INTO `t_role_menu` VALUES ('55', '2', '20');
INSERT INTO `t_role_menu` VALUES ('56', '2', '64');
INSERT INTO `t_role_menu` VALUES ('57', '2', '65');
INSERT INTO `t_role_menu` VALUES ('58', '2', '10');
INSERT INTO `t_role_menu` VALUES ('59', '2', '113');
INSERT INTO `t_role_menu` VALUES ('60', '2', '114');
INSERT INTO `t_role_menu` VALUES ('61', '2', '58');
INSERT INTO `t_role_menu` VALUES ('62', '2', '59');
INSERT INTO `t_role_menu` VALUES ('63', '2', '61');
INSERT INTO `t_role_menu` VALUES ('64', '2', '81');
INSERT INTO `t_role_menu` VALUES ('65', '2', '82');
INSERT INTO `t_role_menu` VALUES ('66', '2', '83');
INSERT INTO `t_role_menu` VALUES ('67', '2', '101');
INSERT INTO `t_role_menu` VALUES ('68', '2', '102');
INSERT INTO `t_role_menu` VALUES ('69', '2', '103');
INSERT INTO `t_role_menu` VALUES ('70', '2', '109');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
                          `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                          `USERNAME` varchar(50) NOT NULL COMMENT '用户名',
                          `PASSWORD` varchar(128) NOT NULL COMMENT '密码',
                          `DEPT_ID` bigint(20) DEFAULT NULL COMMENT '部门ID',
                          `EMAIL` varchar(128) DEFAULT NULL COMMENT '邮箱',
                          `MOBILE` varchar(20) DEFAULT NULL COMMENT '联系电话',
                          `STATUS` char(1) NOT NULL COMMENT '状态 0锁定 1有效',
                          `CRATE_TIME` datetime NOT NULL COMMENT '创建时间',
                          `MODIFY_TIME` datetime DEFAULT NULL COMMENT '修改时间',
                          `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最近访问时间',
                          `SSEX` char(1) DEFAULT NULL COMMENT '性别 0男 1女',
                          `THEME` varchar(10) DEFAULT NULL COMMENT '主题',
                          `AVATAR` varchar(100) DEFAULT NULL COMMENT '头像',
                          `DESCRIPTION` varchar(100) DEFAULT NULL COMMENT '描述',
                          PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'mrbird', '$2a$10$WRUqPfZUAhRgwaiuBPE0XeUoPZKFgGTkRjaU04dHnL99leE4kBv1W', '1', 'mrbird@qq.com', '17788888888', '1', '2018-08-22 11:37:47', '2018-09-15 14:53:52', '2018-08-27 21:27:18', '2', 'green', '20180414165909.jpg', '我是创始人');
INSERT INTO `t_user` VALUES ('2', 'scott', '$2a$10$vtf0gsIpFnzs3x9kA/2fW.oV41aAXFt4e4S0vBURGuFdLJ5F7xx2W', '2', 'scott@qq.com', '', '1', '2018-08-22 11:37:47', '2018-09-15 14:54:36', '2018-08-27 21:27:18', '1', 'red', '20180414170003.jpg', '');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT,
                               `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
                               `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1');
INSERT INTO `t_user_role` VALUES ('2', '2', '2');
