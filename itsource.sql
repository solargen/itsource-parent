/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50724
Source Host           : 127.0.0.1:3306
Source Database       : itsource

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-06-10 10:38:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `manager_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `dirPath` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', 'dept1', '总经办', '1', '0', '1', '1');

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `realname` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `tel` varchar(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `dept_id` bigint(20) DEFAULT NULL,
  `inputtime` date DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('1', 'admin', '李树根', '48d05cc43f3bfe2510394e8dfcef919a', '13333333333', null, '1', '2019-06-05', '1');

-- ----------------------------
-- Table structure for t_employee_role
-- ----------------------------
DROP TABLE IF EXISTS `t_employee_role`;
CREATE TABLE `t_employee_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee_role
-- ----------------------------
INSERT INTO `t_employee_role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `parent_id` bigint(20) unsigned zerofill DEFAULT '00000000000000000000',
  `icon` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `component` varchar(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', 'system', '系统管理', '00000000000000000000', 'el-icon-setting', '/', null, null);
INSERT INTO `t_menu` VALUES ('2', 'employee', '员工管理', '00000000000000000007', null, '/employee', 'Employee', null);
INSERT INTO `t_menu` VALUES ('3', 'department', '部门管理', '00000000000000000007', null, '/department', 'Department', null);
INSERT INTO `t_menu` VALUES ('4', 'role', '角色管理', '00000000000000000001', null, '/role', 'Role', null);
INSERT INTO `t_menu` VALUES ('5', 'permission', '权限管理', '00000000000000000001', null, '/permission', 'Permission', null);
INSERT INTO `t_menu` VALUES ('6', 'menu', '菜单管理', '00000000000000000001', null, '/menu', 'Menu', null);
INSERT INTO `t_menu` VALUES ('7', 'institution', '组织机构', '00000000000000000000', null, '/', null, null);

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  `ismenu` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('7', 'employee:save', '保存员工', '/employee/save', '2', '0');
INSERT INTO `t_permission` VALUES ('8', 'employee:delete', '删除员工', '/employee/delete', '2', '0');
INSERT INTO `t_permission` VALUES ('9', 'employee:getById', '员工编号查询', '/employee/getById', '2', '0');
INSERT INTO `t_permission` VALUES ('10', 'employee:list', '员工列表', '/employee/list', '2', '0');
INSERT INTO `t_permission` VALUES ('11', 'employee:query', '员工高级查询', '/employee/query', '2', '0');
INSERT INTO `t_permission` VALUES ('13', 'role:save', '保存角色', '/role/save', '4', '0');
INSERT INTO `t_permission` VALUES ('14', 'role:delete', '删除角色', '/role/delete', '4', '0');
INSERT INTO `t_permission` VALUES ('15', 'role:query', '角色高级查询', '/role/query', '4', '0');
INSERT INTO `t_permission` VALUES ('16', 'permission:save', '保存权限', '/permission/save', '5', '0');
INSERT INTO `t_permission` VALUES ('17', 'permission:delete', '删除权限', '/permission/delete', '5', '0');
INSERT INTO `t_permission` VALUES ('18', 'permission:query', '权限高级查询', '/permission/query', '5', '0');
INSERT INTO `t_permission` VALUES ('19', 'permission:list', '列表权限', '/permission/list', '5', '0');
INSERT INTO `t_permission` VALUES ('20', 'menu:save', '保存菜单', '/menu/save', '6', '0');
INSERT INTO `t_permission` VALUES ('21', 'menu:delete', '删除菜单', '/menu/delete', '6', '0');
INSERT INTO `t_permission` VALUES ('22', 'menu:query', '菜单高级查询', '/menu/query', '6', '0');
INSERT INTO `t_permission` VALUES ('23', 'menu:list', '列表菜单', '/menu/list', '6', '0');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `intro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin', '管理员', '超级管理员，用用所有的角色');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('1', '1', '1');
INSERT INTO `t_role_permission` VALUES ('2', '1', '2');
INSERT INTO `t_role_permission` VALUES ('3', '1', '3');
INSERT INTO `t_role_permission` VALUES ('4', '1', '4');
INSERT INTO `t_role_permission` VALUES ('5', '1', '5');
INSERT INTO `t_role_permission` VALUES ('6', '1', '6');
INSERT INTO `t_role_permission` VALUES ('7', '1', '7');
INSERT INTO `t_role_permission` VALUES ('8', '1', '8');
INSERT INTO `t_role_permission` VALUES ('9', '1', '9');
INSERT INTO `t_role_permission` VALUES ('10', '1', '10');
INSERT INTO `t_role_permission` VALUES ('11', '1', '11');
INSERT INTO `t_role_permission` VALUES ('12', '1', '12');
INSERT INTO `t_role_permission` VALUES ('13', '1', '13');
INSERT INTO `t_role_permission` VALUES ('14', '1', '14');
INSERT INTO `t_role_permission` VALUES ('15', '1', '15');
INSERT INTO `t_role_permission` VALUES ('16', '1', '16');
INSERT INTO `t_role_permission` VALUES ('17', '1', '17');
INSERT INTO `t_role_permission` VALUES ('18', '1', '18');
INSERT INTO `t_role_permission` VALUES ('19', '1', '19');
INSERT INTO `t_role_permission` VALUES ('20', '1', '20');
INSERT INTO `t_role_permission` VALUES ('21', '1', '21');
INSERT INTO `t_role_permission` VALUES ('22', '1', '22');
INSERT INTO `t_role_permission` VALUES ('23', '1', '23');
