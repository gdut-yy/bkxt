-- MySQL dump 10.13  Distrib 5.1.68, for Win64 (unknown)
--
-- Host: localhost    Database: bkxt
-- ------------------------------------------------------
-- Server version	5.1.68-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adminuser`
--

DROP TABLE IF EXISTS `adminuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adminuser` (
  `adminid` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '//管理员id',
  `adminname` varchar(40) NOT NULL COMMENT '//管理员用户名',
  `adminpass` varchar(40) NOT NULL COMMENT '//密码',
  `admingroup` varchar(40) NOT NULL COMMENT '//所在组',
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='//管理员信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminuser`
--

LOCK TABLES `adminuser` WRITE;
/*!40000 ALTER TABLE `adminuser` DISABLE KEYS */;
INSERT INTO `adminuser` VALUES (2,'sadmin','c984aed014aec7623a54f0591da07a85fd4b762d','系统管理员'),(13,'jiaowu','c984aed014aec7623a54f0591da07a85fd4b762d','教务管理员'),(15,'zhaoban','c984aed014aec7623a54f0591da07a85fd4b762d','招生管理员');
/*!40000 ALTER TABLE `adminuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `ccode` varchar(10) NOT NULL COMMENT '//课程编号',
  `cname` varchar(40) NOT NULL COMMENT '//考试科目名称',
  `cmname` varchar(40) NOT NULL COMMENT '//所属专业代码',
  `cstarttime` datetime NOT NULL COMMENT '//考试开始时间',
  `cendtime` datetime NOT NULL COMMENT '//考试结束时间',
  PRIMARY KEY (`ccode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='//考试科目信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('101','计算机文化基础','计算机科学与技术','2015-12-11 08:00:00','2015-12-11 10:00:00'),('102','计算机组成原理','计算机科学与技术','2015-12-11 14:00:00','2015-12-11 16:00:00'),('103','计算机平面设计','计算机科学与技术（动漫设计方向）','2015-12-11 08:00:00','2015-12-11 10:00:00'),('104','艺术概论','计算机科学与技术（动漫设计方向）','2015-12-11 14:00:00','2015-12-11 16:00:00'),('105','软件工程','软件工程','2015-12-11 08:00:00','2015-12-11 10:00:00'),('106','Java语言程序设计','软件工程','2015-12-11 14:00:00','2015-12-11 16:00:00'),('201','管理学','物流管理','2015-12-11 08:00:00','2015-12-11 10:00:00'),('202','物流管理','物流管理','2015-12-11 14:00:00','2015-12-11 16:00:00'),('203','财务管理','财务管理（信用管理方向）','2015-12-11 08:00:00','2015-12-11 10:00:00'),('204','会计学原理','财务管理（信用管理方向）','2015-12-11 14:00:00','2015-12-11 16:00:00');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currstage`
--

DROP TABLE IF EXISTS `currstage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currstage` (
  `configid` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '//配置信息id',
  `adminname` varchar(40) NOT NULL COMMENT '//更改配置管理员用户名',
  `settime` datetime NOT NULL COMMENT '//更改配置时间',
  `stagename` varchar(40) NOT NULL COMMENT '//更改状态',
  PRIMARY KEY (`configid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='//配置信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currstage`
--

LOCK TABLES `currstage` WRITE;
/*!40000 ALTER TABLE `currstage` DISABLE KEYS */;
INSERT INTO `currstage` VALUES (1,'zhaoban','2015-10-19 13:47:12','招考信息发布'),(2,'zhaoban','2015-10-19 13:48:19','招考信息发布'),(3,'zhaoban','2015-10-19 13:48:47','招考信息发布'),(4,'zhaoban','2015-10-19 13:56:59','在线报名'),(5,'zhaoban','2015-10-19 14:10:27','现场确认'),(6,'zhaoban','2015-10-19 14:10:38','考号与考场分配'),(7,'zhaoban','2015-10-19 14:10:52','准考证打印与考试'),(8,'zhaoban','2015-10-19 14:10:56','成绩录入'),(9,'zhaoban','2015-10-19 14:10:58','在线报名'),(10,'zhaoban','2015-10-19 16:34:49','现场确认'),(11,'zhaoban','2015-10-19 16:34:58','在线报名'),(12,'zhaoban','2015-10-20 09:56:15','现场确认'),(13,'zhaoban','2015-10-20 13:53:00','招考信息发布'),(14,'zhaoban','2015-12-02 11:50:51','在线报名'),(15,'zhaoban','2015-12-02 11:50:58','现场确认'),(16,'zhaoban','2015-12-02 11:51:07','考号与考场分配'),(17,'zhaoban','2015-12-02 11:51:11','准考证打印与考试'),(18,'zhaoban','2015-12-02 11:51:14','招考信息发布'),(19,'zhaoban','2016-01-06 10:09:42','在线报名');
/*!40000 ALTER TABLE `currstage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade` (
  `gradeid` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '//成绩编号id',
  `testcardnum` varchar(12) NOT NULL COMMENT '//准考证号',
  `ccode` varchar(10) DEFAULT NULL COMMENT '//考试科目',
  `score` tinyint(4) DEFAULT NULL COMMENT '//该科目成绩',
  `note` enum('正常','缺考','作弊') DEFAULT NULL COMMENT '//备注',
  `status` enum('0','1') DEFAULT NULL COMMENT '//成绩是否可修改 0 不可修改 1 可修改',
  PRIMARY KEY (`gradeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='//成绩信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `major` (
  `mcode` varchar(10) NOT NULL COMMENT '//专业代码',
  `mname` varchar(40) NOT NULL COMMENT '//报考专业名称',
  `plannum` smallint(6) DEFAULT NULL COMMENT '//计划招生数',
  `applynum` smallint(6) DEFAULT NULL COMMENT '//实际报考人数',
  `passcore` tinyint(4) DEFAULT NULL COMMENT '//录取分数线',
  `admitnum` smallint(6) DEFAULT NULL COMMENT '//录取人数',
  PRIMARY KEY (`mcode`),
  UNIQUE KEY `mname` (`mname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='//报考专业信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES ('11','计算机科学与技术',80,NULL,NULL,NULL),('12','计算机科学与技术（动漫设计方向）',100,NULL,NULL,NULL),('13','软件工程',100,NULL,NULL,NULL),('21','物流管理',100,NULL,NULL,NULL),('22','财务管理（信用管理方向）',50,NULL,NULL,NULL);
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `rid` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '//日志id',
  `logname` varchar(40) NOT NULL COMMENT '//登录人姓名',
  `usergroup` varchar(40) NOT NULL COMMENT '//所在组',
  `logtime` datetime NOT NULL COMMENT '//登录时间',
  `logip` varchar(128) NOT NULL COMMENT '//登录ip',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=288 DEFAULT CHARSET=utf8 COMMENT='//日志信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (1,'admin','系统管理员','2015-10-15 10:43:56','172.16.36.209'),(2,'admin','系统管理员','2015-10-15 10:44:57','172.16.36.209'),(3,'admin','系统管理员','2015-10-15 10:46:58','172.16.36.209'),(4,'admin','系统管理员','2015-10-15 10:56:00','172.16.36.209'),(5,'admin','系统管理员','2015-10-15 10:56:14','172.16.36.209'),(6,'admin','系统管理员','2015-10-15 10:56:51','172.16.36.209'),(7,'zjfhit','学生','2015-10-15 10:57:50','172.16.36.209'),(8,'zjfhit','学生','2015-10-15 10:58:12','172.16.36.209'),(9,'admin','系统管理员','2015-10-15 10:58:59','172.16.36.209'),(10,'zhaoban','招生管理员','2015-10-15 11:00:32','172.16.36.209'),(11,'admin','系统管理员','2015-10-15 11:24:21','172.16.36.209'),(12,'admin','系统管理员','2015-10-15 15:20:12','172.16.36.209'),(13,'admin','系统管理员','2015-10-15 15:28:50','172.16.36.209'),(14,'admin','系统管理员','2015-10-15 15:35:36','172.16.36.209'),(15,'admin','系统管理员','2015-10-15 15:42:34','172.16.36.209'),(16,'admin','系统管理员','2015-10-15 15:48:14','172.16.36.209'),(17,'admin','系统管理员','2015-10-15 15:49:07','172.16.36.209'),(18,'admin','系统管理员','2015-10-15 16:27:52','172.16.36.209'),(19,'admin','系统管理员','2015-10-15 16:35:03','172.16.36.209'),(20,'admin','系统管理员','2015-10-15 16:37:12','172.16.36.209'),(21,'admin','系统管理员','2015-10-15 16:38:55','172.16.36.209'),(22,'admin','系统管理员','2015-10-15 16:42:01','172.16.36.209'),(23,'admin','系统管理员','2015-10-15 16:43:44','172.16.36.209'),(24,'admin','系统管理员','2015-10-16 08:01:04','172.16.36.209'),(25,'admin','系统管理员','2015-10-16 08:12:10','172.16.36.209'),(26,'admin','系统管理员','2015-10-16 08:15:01','172.16.36.209'),(27,'admin','系统管理员','2015-10-16 08:18:42','172.16.36.209'),(28,'admin','系统管理员','2015-10-16 08:20:48','172.16.36.209'),(29,'admin','系统管理员','2015-10-16 08:22:42','172.16.36.209'),(30,'admin','系统管理员','2015-10-16 08:29:53','172.16.36.209'),(31,'admin','系统管理员','2015-10-16 08:36:36','172.16.36.209'),(32,'admin','系统管理员','2015-10-16 08:39:08','172.16.36.209'),(33,'admin','系统管理员','2015-10-16 08:43:22','172.16.36.209'),(34,'admin','系统管理员','2015-10-16 08:45:19','172.16.36.209'),(35,'admin','系统管理员','2015-10-16 09:16:30','172.16.36.209'),(36,'admin','系统管理员','2015-10-16 09:19:30','172.16.36.209'),(37,'admin','系统管理员','2015-10-16 09:20:34','172.16.36.209'),(38,'admin','系统管理员','2015-10-16 09:20:50','172.16.36.209'),(39,'zjfhit','学生','2015-10-16 09:41:09','172.16.36.209'),(40,'zjfhit','学生','2015-10-16 09:44:25','172.16.36.209'),(41,'zjfhit','学生','2015-10-16 10:00:11','172.16.36.209'),(42,'admin','系统管理员','2015-10-16 10:01:25','172.16.36.209'),(43,'zjfhit','学生','2015-10-16 10:04:33','172.16.36.209'),(44,'zjfhit','学生','2015-10-16 10:15:43','172.16.36.209'),(45,'zjfhit','学生','2015-10-16 10:16:18','172.16.36.209'),(46,'admin','系统管理员','2015-10-16 10:45:24','172.16.36.209'),(47,'admin','系统管理员','2015-10-16 10:45:53','172.16.36.209'),(48,'jiaowu','教务管理员','2015-10-16 10:46:09','172.16.36.209'),(49,'jiaowu','教务管理员','2015-10-16 10:46:40','172.16.36.209'),(50,'admin','系统管理员','2015-10-16 10:47:14','172.16.36.209'),(51,'jiaowu','教务管理员','2015-10-16 10:47:45','172.16.36.209'),(52,'admin','系统管理员','2015-10-16 10:52:44','172.16.36.209'),(53,'jiaowu','教务管理员','2015-10-16 10:52:55','172.16.36.209'),(54,'jiaowu','教务管理员','2015-10-16 10:54:43','172.16.36.209'),(55,'jiaowu','教务管理员','2015-10-16 10:57:54','172.16.36.209'),(56,'admin','系统管理员','2015-10-16 10:58:36','172.16.36.209'),(57,'jiaowu','教务管理员','2015-10-16 11:01:03','172.16.36.209'),(58,'jiaowu','教务管理员','2015-10-16 11:01:45','172.16.36.209'),(59,'admin','系统管理员','2015-10-16 12:49:55','172.16.36.209'),(60,'zhaoban','招生管理员','2015-10-16 15:33:39','172.16.36.209'),(61,'jiaowu','教务管理员','2015-10-16 15:37:11','172.16.36.209'),(62,'admin','系统管理员','2015-10-16 15:37:28','172.16.36.209'),(63,'zhaoban','招生管理员','2015-10-16 15:52:41','172.16.36.209'),(64,'zhaoban','招生管理员','2015-10-16 15:55:29','172.16.36.209'),(65,'zhaoban','招生管理员','2015-10-16 15:56:10','172.16.36.209'),(66,'admin','系统管理员','2015-10-19 08:47:23','127.0.0.1'),(67,'zhaoban','招生管理员','2015-10-19 08:48:29','127.0.0.1'),(68,'zhaoban','招生管理员','2015-10-19 13:22:22','127.0.0.1'),(69,'zhaoban','招生管理员','2015-10-19 13:35:02','127.0.0.1'),(70,'zhaoban','招生管理员','2015-10-19 13:48:43','127.0.0.1'),(71,'admin','系统管理员','2015-10-19 14:56:43','127.0.0.1'),(72,'jiaowu','教务管理员','2015-10-19 14:57:32','127.0.0.1'),(73,'zhaoban','招生管理员','2015-10-19 14:59:21','127.0.0.1'),(74,'admin','系统管理员','2015-10-19 15:00:42','127.0.0.1'),(75,'zhaoban','招生管理员','2015-10-19 15:01:26','127.0.0.1'),(76,'zjfhit','学生','2015-10-19 15:02:06','127.0.0.1'),(77,'zhaoban','招生管理员','2015-10-19 15:26:06','127.0.0.1'),(78,'admin','系统管理员','2015-10-19 16:06:53','127.0.0.1'),(79,'zhaoban','招生管理员','2015-10-19 16:26:17','127.0.0.1'),(80,'admin','系统管理员','2015-10-20 09:54:10','127.0.0.1'),(81,'zhaoban','招生管理员','2015-10-20 09:55:26','127.0.0.1'),(82,'zhaoban','招生管理员','2015-10-20 10:08:56','127.0.0.1'),(83,'zhaoban','招生管理员','2015-10-20 10:32:12','127.0.0.1'),(84,'admin','系统管理员','2015-10-20 10:49:31','0:0:0:0:0:0:0:1'),(85,'zhaoban','招生管理员','2015-10-20 10:54:04','0:0:0:0:0:0:0:1'),(86,'zhaoban','招生管理员','2015-10-20 11:23:06','127.0.0.1'),(87,'zhaoban','招生管理员','2015-10-20 11:39:38','127.0.0.1'),(88,'zhaoban','招生管理员','2015-10-20 11:42:29','127.0.0.1'),(89,'zhaoban','招生管理员','2015-10-20 11:43:28','127.0.0.1'),(90,'zhaoban','招生管理员','2015-10-20 11:44:18','127.0.0.1'),(91,'zhaoban','招生管理员','2015-10-20 11:45:33','127.0.0.1'),(92,'zhaoban','招生管理员','2015-10-20 11:47:52','127.0.0.1'),(93,'zhaoban','招生管理员','2015-10-20 13:48:40','172.16.36.209'),(94,'zhaoban','招生管理员','2015-10-20 13:49:51','172.16.36.209'),(95,'zhaoban','招生管理员','2015-10-20 13:50:31','172.16.36.209'),(96,'zhaoban','招生管理员','2015-10-20 16:16:57','172.16.36.209'),(97,'zjfhit','学生','2015-10-20 16:18:39','172.16.36.209'),(98,'admin','系统管理员','2015-10-21 09:15:19','172.16.36.209'),(99,'zhaoban','招生管理员','2015-10-21 09:17:55','172.16.36.209'),(100,'admin','系统管理员','2015-10-21 09:18:24','172.16.36.209'),(101,'zhaoban','招生管理员','2015-10-21 09:20:08','172.16.36.209'),(102,'jiaowu','教务管理员','2015-10-21 09:22:24','172.16.36.209'),(103,'zjfhit','学生','2015-10-21 09:24:22','172.16.36.209'),(104,'zjfhit','学生','2015-10-21 13:55:05','172.16.36.209'),(105,'zhaoban','招生管理员','2015-10-21 15:29:25','172.16.36.209'),(106,'admin','系统管理员','2015-10-28 14:10:35','127.0.0.1'),(107,'zhaoban','招生管理员','2015-10-28 14:12:43','127.0.0.1'),(108,'admin','系统管理员','2015-10-28 14:13:29','127.0.0.1'),(109,'zjfhit','学生','2015-10-28 14:51:26','127.0.0.1'),(110,'admin','系统管理员','2015-10-30 09:02:46','127.0.0.1'),(111,'admin','系统管理员','2015-10-30 09:48:41','127.0.0.1'),(112,'zhaoban','招生管理员','2015-10-30 11:38:14','127.0.0.1'),(113,'admin','系统管理员','2015-11-04 11:05:39','127.0.0.1'),(114,'zjfhit','学生','2015-11-04 11:11:32','127.0.0.1'),(115,'admin','系统管理员','2015-11-04 11:20:04','127.0.0.1'),(116,'admin','系统管理员','2015-11-04 14:27:32','127.0.0.1'),(117,'zjfhit','学生','2015-11-05 08:19:29','172.16.36.209'),(118,'zjfhit','学生','2015-11-05 08:26:03','127.0.0.1'),(119,'zjfhit','学生','2015-11-05 09:49:17','127.0.0.1'),(120,'zjfhit','学生','2015-11-05 09:52:46','127.0.0.1'),(121,'zjfhit','学生','2015-11-05 10:00:47','127.0.0.1'),(122,'zjfhit','学生','2015-11-05 10:54:34','127.0.0.1'),(123,'admin','系统管理员','2015-11-05 11:32:49','127.0.0.1'),(124,'zjfhit','学生','2015-11-05 11:33:36','172.16.36.209'),(125,'zjfhit','学生','2015-11-05 11:38:04','172.16.36.209'),(126,'zjfhit','学生','2015-11-05 14:48:02','172.16.36.209'),(127,'admin','系统管理员','2015-11-05 15:12:31','172.16.36.209'),(128,'testWYW','学生','2015-11-16 14:19:24','127.0.0.1'),(129,'testWYW','学生','2015-11-16 14:43:30','127.0.0.1'),(130,'testWYW','学生','2015-11-16 14:45:56','127.0.0.1'),(131,'testWYW','学生','2015-11-16 14:49:24','127.0.0.1'),(132,'testWYW','学生','2015-11-16 14:53:00','127.0.0.1'),(133,'testWYW','学生','2015-11-16 14:57:50','127.0.0.1'),(134,'testWYW','学生','2015-11-16 15:03:24','127.0.0.1'),(135,'testWYW','学生','2015-11-16 15:06:26','127.0.0.1'),(136,'zjfhit','学生','2015-11-16 16:29:04','127.0.0.1'),(137,'testWYW','学生','2015-11-17 10:21:16','127.0.0.1'),(138,'testWYW','学生','2015-11-17 10:22:53','127.0.0.1'),(139,'weiyinwei','学生','2015-11-17 10:24:02','127.0.0.1'),(140,'testWYW','学生','2015-11-17 10:37:13','127.0.0.1'),(141,'testWYW','学生','2015-11-17 10:37:59','127.0.0.1'),(142,'testWYW','学生','2015-11-17 10:39:38','127.0.0.1'),(143,'testWYW','学生','2015-11-17 10:41:46','127.0.0.1'),(144,'testWYW','学生','2015-11-17 10:44:30','127.0.0.1'),(145,'zjfhit','学生','2015-11-17 11:19:30','127.0.0.1'),(146,'zjfhit','学生','2015-11-17 11:52:12','127.0.0.1'),(147,'zjfhit','学生','2015-11-17 13:32:55','127.0.0.1'),(148,'zjfhit','学生','2015-11-17 13:36:24','127.0.0.1'),(149,'zjfhit','学生','2015-11-17 13:41:31','127.0.0.1'),(150,'zjfhit','学生','2015-11-17 13:42:17','127.0.0.1'),(151,'zhaoban','招生管理员','2015-11-17 14:12:20','127.0.0.1'),(152,'sadmin','系统管理员','2015-11-17 14:23:46','127.0.0.1'),(153,'sadmin','系统管理员','2015-11-17 14:25:53','127.0.0.1'),(154,'sadmin','系统管理员','2015-11-17 14:50:33','127.0.0.1'),(155,'testWYW','学生','2015-11-17 15:18:16','127.0.0.1'),(156,'sadmin','系统管理员','2015-11-17 15:19:00','127.0.0.1'),(157,'sadmin','系统管理员','2015-11-17 15:21:27','127.0.0.1'),(158,'testWYW','学生','2015-11-17 15:22:31','127.0.0.1'),(159,'zhaoban','招生管理员','2015-11-17 15:23:25','127.0.0.1'),(160,'testWYW','学生','2015-11-17 15:25:47','127.0.0.1'),(161,'zhaoban','招生管理员','2015-11-17 15:28:58','127.0.0.1'),(162,'zhaoban','招生管理员','2015-11-17 15:31:48','127.0.0.1'),(163,'testWYW','学生','2015-11-17 16:26:23','127.0.0.1'),(164,'testWYW','学生','2015-11-17 16:53:16','127.0.0.1'),(165,'zhaoban','招生管理员','2015-11-18 09:02:00','172.16.36.209'),(166,'zhaoban','招生管理员','2015-11-18 09:19:15','172.16.36.209'),(167,'zhaoban','招生管理员','2015-11-18 09:51:52','172.16.36.209'),(168,'sadmin','系统管理员','2015-11-18 09:58:16','172.16.36.209'),(169,'jiaowu','教务管理员','2015-11-18 09:59:06','172.16.36.209'),(170,'zjfhit','学生','2015-11-18 10:17:40','172.16.36.209'),(171,'zjfhit','学生','2015-11-18 10:19:03','172.16.36.209'),(172,'zjfhit','学生','2015-11-18 10:28:08','172.16.36.209'),(173,'zjfhit','学生','2015-11-18 10:29:46','172.16.36.209'),(174,'zjfhit','学生','2015-11-18 10:39:11','172.16.36.209'),(175,'zjfhit','学生','2015-11-18 10:40:55','127.0.0.1'),(176,'zjfhit','学生','2015-11-18 10:46:52','127.0.0.1'),(177,'zjfhit','学生','2015-11-18 10:50:07','127.0.0.1'),(178,'testWYW','学生','2015-11-18 14:29:25','127.0.0.1'),(179,'testWYW','学生','2015-11-18 14:35:13','127.0.0.1'),(180,'testWYW','学生','2015-11-18 14:40:14','127.0.0.1'),(181,'testWYW','学生','2015-11-18 14:42:01','127.0.0.1'),(182,'testWYW','学生','2015-11-18 14:47:51','127.0.0.1'),(183,'testWYW','学生','2015-11-18 14:49:51','127.0.0.1'),(184,'testWYW','学生','2015-11-18 14:51:01','127.0.0.1'),(185,'zjfhit','学生','2015-11-18 15:39:30','172.16.36.209'),(186,'testWYW','学生','2015-11-18 15:42:00','127.0.0.1'),(187,'testWYW','学生','2015-11-18 15:47:20','127.0.0.1'),(188,'testWYW','学生','2015-11-18 15:50:23','127.0.0.1'),(189,'testWYW','学生','2015-11-18 16:51:52','127.0.0.1'),(190,'testWYW','学生','2015-11-18 16:54:55','127.0.0.1'),(191,'testWYW','学生','2015-11-18 17:07:12','127.0.0.1'),(192,'testWYW','学生','2015-11-19 10:58:30','127.0.0.1'),(193,'testWYW','学生','2015-11-19 15:12:43','127.0.0.1'),(194,'testWYW','学生','2015-11-19 15:12:45','127.0.0.1'),(195,'testWYW','学生','2015-11-19 15:45:54','127.0.0.1'),(196,'testWYW','学生','2015-11-19 16:01:20','127.0.0.1'),(197,'testWYW','学生','2015-11-19 16:10:08','127.0.0.1'),(198,'testWYW','学生','2015-11-19 16:11:19','127.0.0.1'),(199,'testWYW','学生','2015-11-19 16:22:24','127.0.0.1'),(200,'testWYW','学生','2015-11-19 16:25:08','127.0.0.1'),(201,'testWYW','学生','2015-11-19 16:35:26','127.0.0.1'),(202,'testWYW','学生','2015-11-19 16:45:56','127.0.0.1'),(203,'testWYW','学生','2015-11-19 16:50:31','127.0.0.1'),(204,'testWYW','学生','2015-11-20 09:30:18','127.0.0.1'),(205,'testWYW','学生','2015-11-20 09:33:04','127.0.0.1'),(206,'testWYW','学生','2015-11-20 09:36:09','127.0.0.1'),(207,'testWYW','学生','2015-11-24 14:14:27','127.0.0.1'),(208,'testWYW','学生','2015-11-24 14:16:25','127.0.0.1'),(209,'testWYW','学生','2015-11-24 14:52:38','127.0.0.1'),(210,'sundaohe','学生','2015-11-24 15:11:52','127.0.0.1'),(211,'testWYW','学生','2015-11-24 15:20:30','127.0.0.1'),(212,'testWYW','学生','2015-11-24 15:36:48','127.0.0.1'),(213,'testWYW','学生','2015-11-24 15:43:09','127.0.0.1'),(214,'testWYW','学生','2015-11-24 15:44:55','127.0.0.1'),(215,'testWYW','学生','2015-11-24 15:47:26','127.0.0.1'),(216,'testWYW','学生','2015-11-24 15:53:14','127.0.0.1'),(217,'testWYW','学生','2015-11-24 16:06:22','127.0.0.1'),(218,'testWYW','学生','2015-11-24 16:07:22','127.0.0.1'),(219,'testWYW','学生','2015-11-24 16:29:16','127.0.0.1'),(220,'testWYW','学生','2015-11-24 16:33:54','127.0.0.1'),(221,'testWYW','学生','2015-11-24 16:38:13','127.0.0.1'),(222,'testWYW','学生','2015-11-24 16:42:07','127.0.0.1'),(223,'testWYW','学生','2015-11-24 16:47:21','127.0.0.1'),(224,'sundaohe','学生','2015-11-25 14:38:52','172.16.36.209'),(225,'daohesun','学生','2015-12-01 15:04:45','127.0.0.1'),(226,'zjfhit','学生','2015-12-01 15:06:15','127.0.0.1'),(227,'zjfhit','学生','2015-12-01 15:21:05','127.0.0.1'),(228,'weiyinwei','学生','2015-12-01 15:24:43','127.0.0.1'),(229,'zjfhit','学生','2015-12-01 15:32:14','127.0.0.1'),(230,'zhaoban','招生管理员','2015-12-01 15:32:27','127.0.0.1'),(231,'zhaoban','招生管理员','2015-12-01 15:33:56','127.0.0.1'),(232,'sadmin','系统管理员','2015-12-01 15:34:14','127.0.0.1'),(233,'zhaoban','招生管理员','2015-12-01 15:34:34','127.0.0.1'),(234,'sadmin','系统管理员','2015-12-01 15:48:52','127.0.0.1'),(235,'sadmin','系统管理员','2015-12-02 08:37:04','172.16.36.209'),(236,'zhaoban','招生管理员','2015-12-02 08:38:25','172.16.36.209'),(237,'sadmin','系统管理员','2015-12-02 08:42:25','172.16.36.209'),(238,'sadmin','系统管理员','2015-12-02 08:45:11','172.16.36.209'),(239,'sadmin','系统管理员','2015-12-02 08:50:52','172.16.36.209'),(240,'sadmin','系统管理员','2015-12-02 09:14:11','172.16.36.209'),(241,'sadmin','系统管理员','2015-12-02 09:25:47','172.16.36.209'),(242,'zhaoban','招生管理员','2015-12-02 11:50:19','172.16.36.209'),(243,'sadmin','系统管理员','2015-12-02 14:33:20','172.16.36.209'),(244,'sadmin','系统管理员','2015-12-02 15:13:31','172.16.36.209'),(245,'zhaoban','招生管理员','2015-12-02 15:13:58','172.16.36.209'),(246,'sadmin','系统管理员','2015-12-02 15:14:11','172.16.36.209'),(247,'zjfhit','学生','2015-12-02 15:29:21','172.16.36.209'),(248,'zhaoban','招生管理员','2015-12-02 16:26:40','172.16.36.209'),(249,'zhaoban','招生管理员','2015-12-07 14:00:48','172.16.36.209'),(250,'zhaoban','招生管理员','2015-12-07 14:42:21','172.16.36.209'),(251,'zjfhit','学生','2015-12-07 15:38:11','172.16.36.209'),(252,'zjfhit','学生','2015-12-14 15:24:15','127.0.0.1'),(253,'zjfhit','学生','2015-12-15 13:57:08','127.0.0.1'),(254,'zjfhit','学生','2015-12-15 15:36:57','127.0.0.1'),(255,'zjfhit','学生','2015-12-17 08:40:27','172.16.36.209'),(256,'zjfhit','学生','2015-12-17 09:46:01','172.16.36.209'),(257,'zjfhit','学生','2015-12-17 10:40:43','172.16.36.209'),(258,'sadmin','系统管理员','2015-12-23 08:20:09','127.0.0.1'),(259,'jiaowu','教务管理员','2015-12-23 08:21:38','127.0.0.1'),(260,'zhaoban','招生管理员','2015-12-23 08:22:02','127.0.0.1'),(261,'sadmin','系统管理员','2015-12-23 11:11:26','127.0.0.1'),(262,'zhaoban','招生管理员','2015-12-23 11:11:38','127.0.0.1'),(263,'sadmin','系统管理员','2015-12-28 13:43:59','127.0.0.1'),(264,'sadmin','系统管理员','2015-12-28 13:44:20','127.0.0.1'),(265,'zhaoban','招生管理员','2015-12-28 13:44:36','127.0.0.1'),(266,'sadmin','系统管理员','2015-12-28 13:47:52','127.0.0.1'),(267,'sadmin','系统管理员','2015-12-28 14:01:15','127.0.0.1'),(268,'zhaoban','招生管理员','2015-12-28 14:01:36','127.0.0.1'),(269,'sadmin','系统管理员','2015-12-28 14:07:13','127.0.0.1'),(270,'sadmin','系统管理员','2015-12-29 13:59:02','127.0.0.1'),(271,'zhaoban','招生管理员','2015-12-30 16:37:11','127.0.0.1'),(272,'zjfhit','学生','2016-01-05 14:25:50','127.0.0.1'),(273,'sadmin','系统管理员','2016-01-05 14:40:09','127.0.0.1'),(274,'sadmin','系统管理员','2016-01-05 16:13:10','127.0.0.1'),(275,'zhaoban','招生管理员','2016-01-05 16:16:02','127.0.0.1'),(276,'sadmin','系统管理员','2016-01-06 09:58:05','127.0.0.1'),(277,'zhaoban','招生管理员','2016-01-06 10:00:52','127.0.0.1'),(278,'zhaoban','招生管理员','2016-01-06 10:16:30','127.0.0.1'),(279,'zhaoban','招生管理员','2016-01-06 10:19:16','127.0.0.1'),(280,'zhaoban','招生管理员','2016-01-06 13:19:18','127.0.0.1'),(281,'sadmin','系统管理员','2016-01-19 10:06:10','127.0.0.1'),(282,'jiaowu','教务管理员','2016-01-19 10:06:52','127.0.0.1'),(283,'zhaoban','招生管理员','2016-01-19 10:07:10','127.0.0.1'),(284,'sadmin','系统管理员','2016-01-19 13:51:02','127.0.0.1'),(285,'zhaoban','招生管理员','2016-01-19 13:54:14','127.0.0.1'),(286,'zhaoban','招生管理员','2016-01-19 14:46:53','127.0.0.1'),(287,'sadmin','系统管理员','2016-01-19 15:01:17','127.0.0.1');
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reginfo`
--

DROP TABLE IF EXISTS `reginfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reginfo` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '//信息表id',
  `username` varchar(40) NOT NULL COMMENT '//用户名',
  `sname` varchar(40) DEFAULT NULL COMMENT '//学生姓名',
  `idcode` char(18) DEFAULT '' COMMENT '//身份证号',
  `ssex` enum('男','女') DEFAULT NULL COMMENT '//性别',
  `nation` varchar(40) DEFAULT NULL COMMENT '//民族',
  `political` varchar(40) DEFAULT NULL COMMENT '//政治面貌',
  `birthday` date DEFAULT NULL COMMENT '//出生日期',
  `homeaddr` varchar(100) DEFAULT NULL COMMENT '//家庭地址',
  `source` varchar(40) DEFAULT NULL COMMENT '//生源地',
  `school` varchar(100) DEFAULT NULL COMMENT '//毕业学校',
  `gradutetime` date DEFAULT NULL COMMENT '//毕业时间',
  `isnew` enum('往届','应届') DEFAULT NULL,
  `aos` enum('理科','文科') DEFAULT NULL,
  `major` varchar(40) DEFAULT NULL COMMENT '//原专业',
  `cet` enum('cet4','cet6','无') DEFAULT NULL,
  `mname` varchar(40) DEFAULT NULL COMMENT '//报考专业',
  `piclocation` varchar(128) DEFAULT NULL COMMENT '//照片位置',
  `mobile` char(11) DEFAULT NULL COMMENT '//手机号',
  `telphone` varchar(12) DEFAULT NULL COMMENT '//联系电话',
  `zipcode` char(6) DEFAULT NULL COMMENT '//邮编',
  `conaddr` varchar(100) DEFAULT NULL COMMENT '//联系地址',
  `receiver` varchar(20) DEFAULT NULL COMMENT '//接收人',
  `isconfirm` tinyint(1) NOT NULL DEFAULT '0' COMMENT '//是否确认 0未确认 1已确认',
  `testcardnum` varchar(12) DEFAULT NULL COMMENT '//准考证号',
  `examroom` varchar(20) DEFAULT NULL COMMENT '//考场号',
  `seatnum` int(11) DEFAULT NULL COMMENT '//座位号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='//用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reginfo`
--

LOCK TABLES `reginfo` WRITE;
/*!40000 ALTER TABLE `reginfo` DISABLE KEYS */;
INSERT INTO `reginfo` VALUES (15,'testWYW','wyw','14020219880428','男','满','群众',NULL,'天津','山西','tju','2015-09-01','往届','理科','cs','cet6','计算机科学与技术','testWYW.jpg',NULL,'','','','wyw',0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `reginfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school` (
  `shid` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `shcode` varchar(10) NOT NULL,
  `shname` varchar(100) NOT NULL COMMENT '//报考学校名称',
  `shaddr` varchar(100) NOT NULL COMMENT '//学校地址',
  `shzip` char(6) NOT NULL COMMENT '//学校邮编',
  `shtel` varchar(40) NOT NULL COMMENT '//学校联系电话',
  `shtest` varchar(40) NOT NULL COMMENT '//考试名称',
  `shyear` char(4) NOT NULL COMMENT '//招生年份',
  PRIMARY KEY (`shid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (1,'13897','天津理工大学中环信息学院','天津市西青区杨柳青镇柳口路99号','300380','022-86437877','高职升本','2015');
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stage`
--

DROP TABLE IF EXISTS `stage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stage` (
  `stagenum` tinyint(1) NOT NULL COMMENT '//阶段编号',
  `stagename` varchar(40) NOT NULL COMMENT '//状态名称',
  `starttime` datetime NOT NULL COMMENT '//开始时间',
  `endtime` datetime NOT NULL COMMENT '//结束时间',
  `note` text NOT NULL COMMENT '//阶段说明',
  PRIMARY KEY (`stagenum`),
  UNIQUE KEY `stagenum` (`stagenum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stage`
--

LOCK TABLES `stage` WRITE;
/*!40000 ALTER TABLE `stage` DISABLE KEYS */;
INSERT INTO `stage` VALUES (1,'招考信息发布','2015-10-20 08:00:00','2015-10-20 12:00:00','招生管理员录入招考学校信息、招考专业信息、考试课程等相关信息'),(2,'在线报名','2015-10-20 12:00:00','2015-10-30 17:00:00','学生在线填写报名信息、上传电子照片、打印报名表等相关操作'),(3,'现场确认','2015-10-30 08:00:00','2015-10-30 17:00:00','学生到报考院校确认个人填报信息并缴纳考试报名费用'),(4,'考号与考场分配','2015-10-30 17:00:00','2015-10-31 08:00:00','教务管理员根据报考情况为考生分配准考证号并安排考场'),(5,'准考证打印与考试','2015-10-31 08:00:00','2015-11-15 17:00:00','学生在线打印准考证并参加考试'),(6,'成绩录入','2015-11-21 08:00:00','2015-11-21 17:00:00','教务管理员录入学生考试成绩'),(7,'设置录取分数线','2015-11-21 17:00:00','2015-11-22 17:00:00','招生管理员设置各专业录取分数线'),(8,'成绩与录取查询','2015-11-23 08:00:00','2016-02-23 17:00:00','学生在线查询个人成绩与录取情况');
/*!40000 ALTER TABLE `stage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stu`
--

DROP TABLE IF EXISTS `stu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stu` (
  `userid` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '//注册用户id',
  `username` varchar(40) NOT NULL COMMENT '//用户名',
  `password` varchar(40) NOT NULL COMMENT '//密码',
  `regip` varchar(128) NOT NULL COMMENT '//注册时ip',
  `regtime` datetime NOT NULL COMMENT '//注册时间',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='//注册信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stu`
--

LOCK TABLES `stu` WRITE;
/*!40000 ALTER TABLE `stu` DISABLE KEYS */;
INSERT INTO `stu` VALUES (1,'zjfhit','c984aed014aec7623a54f0591da07a85fd4b762d','172.16.36.209','2015-10-15 08:35:21'),(2,'testWYW','c984aed014aec7623a54f0591da07a85fd4b762d','127.0.0.1','2015-11-16 14:19:16'),(3,'weiyinwei','c984aed014aec7623a54f0591da07a85fd4b762d','127.0.0.1','2015-11-17 10:22:32'),(4,'sundaohe','c984aed014aec7623a54f0591da07a85fd4b762d','127.0.0.1','2015-11-24 15:11:37'),(5,'daohesun','c984aed014aec7623a54f0591da07a85fd4b762d','127.0.0.1','2015-12-01 15:04:33');
/*!40000 ALTER TABLE `stu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-22 10:50:52
