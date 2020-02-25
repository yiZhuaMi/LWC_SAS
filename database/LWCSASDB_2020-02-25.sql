# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.12)
# Database: LWCSASDB
# Generation Time: 2020-02-25 12:56:42 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table attendsInfo
# ------------------------------------------------------------

DROP TABLE IF EXISTS `attendsInfo`;

CREATE TABLE `attendsInfo` (
  `Sid` int(11) unsigned NOT NULL,
  `Cid` int(11) NOT NULL,
  `AInfo` varchar(12) NOT NULL DEFAULT '',
  `Date` date NOT NULL,
  `Cname` varchar(11) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `attendsInfo` WRITE;
/*!40000 ALTER TABLE `attendsInfo` DISABLE KEYS */;

INSERT INTO `attendsInfo` (`Sid`, `Cid`, `AInfo`, `Date`, `Cname`)
VALUES
	(2014214199,2,'attend','2016-03-15','数据结构'),
	(2014214199,3,'attend','2016-03-22','高等数学'),
	(2015212073,1,'attend','2016-03-18','java'),
	(2015212073,2,'attend','2016-03-11','数据结构'),
	(2015212073,3,'attend','2016-03-28','高等数学'),
	(2014214001,1,'absence','2016-03-18','java'),
	(2014214001,2,'absence','2016-03-15','数据结构'),
	(2014214001,3,'absence','2016-03-22','高等数学'),
	(2015212442,1,'absence','2016-03-18','java'),
	(2015212442,2,'absence','2016-03-15','数据结构'),
	(2015212442,3,'absence','2016-03-22','高等数学'),
	(2010614787,2,'attend','2016-06-24','数据结构'),
	(2014214001,2,'attend','2016-06-24','数据结构'),
	(2014214199,2,'attend','2016-06-24','数据结构'),
	(2014214777,2,'attend','2016-06-24','数据结构'),
	(2015212442,2,'absence','2016-06-24','数据结构'),
	(2010614787,1,'attend','2016-06-24','java'),
	(2014214001,1,'attend','2016-06-24','java'),
	(2014214199,1,'attend','2016-06-24','java'),
	(2014214777,1,'absense','2016-06-24','java'),
	(2014214001,1,'attend','2016-06-26','java'),
	(2010614787,1,'attend','2016-07-12','java'),
	(2015212073,1,'absence','2016-07-12','java'),
	(2014214199,3,'absence','2017-07-11','高等数学'),
	(2014214199,3,'absence','2017-07-10','高等数学'),
	(2014214199,3,'absence','2017-07-09','高等数学'),
	(2014214199,3,'absence','2017-07-08','高等数学'),
	(2014214199,3,'absence','2017-07-07','高等数学');

/*!40000 ALTER TABLE `attendsInfo` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ClassTeacher
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ClassTeacher`;

CREATE TABLE `ClassTeacher` (
  `ClassId` int(11) NOT NULL,
  `Tid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `ClassTeacher` WRITE;
/*!40000 ALTER TABLE `ClassTeacher` DISABLE KEYS */;

INSERT INTO `ClassTeacher` (`ClassId`, `Tid`)
VALUES
	(1301411,10001),
	(1301411,10002),
	(1301411,10003),
	(1301411,10004),
	(1301411,10005),
	(1511502,10006),
	(1511502,10002);

/*!40000 ALTER TABLE `ClassTeacher` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table CourseTeacher
# ------------------------------------------------------------

DROP TABLE IF EXISTS `CourseTeacher`;

CREATE TABLE `CourseTeacher` (
  `Cid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Cname` varchar(12) NOT NULL DEFAULT '',
  `Tname` varchar(12) NOT NULL DEFAULT '',
  `Tid` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `CourseTeacher` WRITE;
/*!40000 ALTER TABLE `CourseTeacher` DISABLE KEYS */;

INSERT INTO `CourseTeacher` (`Cid`, `Cname`, `Tname`, `Tid`)
VALUES
	(1,'java','肖云鹏',10002),
	(2,'数据结构','肖云鹏',10002),
	(3,'高等数学','徐荣先',10001),
	(4,'英语语法','林忠',10006);

/*!40000 ALTER TABLE `CourseTeacher` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table studentCourse
# ------------------------------------------------------------

DROP TABLE IF EXISTS `studentCourse`;

CREATE TABLE `studentCourse` (
  `Sid` int(11) unsigned NOT NULL,
  `Cid` int(11) NOT NULL,
  `grade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `studentCourse` WRITE;
/*!40000 ALTER TABLE `studentCourse` DISABLE KEYS */;

INSERT INTO `studentCourse` (`Sid`, `Cid`, `grade`)
VALUES
	(2014214199,1,99),
	(2014214199,2,88),
	(2014214199,3,77),
	(2015212073,1,77),
	(2015212073,2,88),
	(2015212073,3,99),
	(2014214001,1,77),
	(2014214001,2,87),
	(2014214001,3,67),
	(2015212442,1,76),
	(2015212442,2,98),
	(2015212442,3,69),
	(2010614787,1,22),
	(2010614787,2,33),
	(2010614787,3,44);

/*!40000 ALTER TABLE `studentCourse` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table studentInfo
# ------------------------------------------------------------

DROP TABLE IF EXISTS `studentInfo`;

CREATE TABLE `studentInfo` (
  `Sid` int(10) unsigned NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT '',
  `acdamic` varchar(12) NOT NULL DEFAULT '',
  `profession` varchar(12) NOT NULL DEFAULT '',
  `email` varchar(20) NOT NULL DEFAULT '',
  `ClassId` int(20) NOT NULL,
  `logo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `studentInfo` WRITE;
/*!40000 ALTER TABLE `studentInfo` DISABLE KEYS */;

INSERT INTO `studentInfo` (`Sid`, `name`, `acdamic`, `profession`, `email`, `ClassId`, `logo`)
VALUES
	(2010614787,'小红','外国语','英语','xiaohong@162.com',1511502,'src/material/userlogo/4.jpg'),
	(2014214001,'朱豪','软件工程','软件工程','zhSB@outlook.com',1301411,'src/material/userlogo/7.jpg'),
	(2014214199,'小白云','软件工程','软件工程','ttmarff@163.com',1301411,'src/material/userlogo/1.jpg'),
	(2014214777,'小明','光电工程','卖五金','xiaoming@qq.com',1301411,'src/material/userlogo/10.jpg'),
	(2015212073,'傻白甜','外国语','英语','425811061@qq.com',1511502,'src/material/userlogo/6.jpg'),
	(2015212442,'周锋锐','软件工程','软件工程','zfrSGB@gmail.com',1301411,'src/material/userlogo/2.jpg');

/*!40000 ALTER TABLE `studentInfo` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table studentList
# ------------------------------------------------------------

DROP TABLE IF EXISTS `studentList`;

CREATE TABLE `studentList` (
  `Sid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`Sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `studentList` WRITE;
/*!40000 ALTER TABLE `studentList` DISABLE KEYS */;

INSERT INTO `studentList` (`Sid`, `username`, `password`)
VALUES
	(2010614787,'小红','920725'),
	(2014214001,'朱豪','920725'),
	(2014214199,'小白云','920725'),
	(2014214777,'小明','920725'),
	(2015212073,'傻白甜','920725'),
	(2015212442,'周锋锐','920725');

/*!40000 ALTER TABLE `studentList` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table teacherInfo
# ------------------------------------------------------------

DROP TABLE IF EXISTS `teacherInfo`;

CREATE TABLE `teacherInfo` (
  `Tid` int(11) unsigned NOT NULL,
  `name` varchar(12) NOT NULL DEFAULT '',
  `acdamic` varchar(12) NOT NULL DEFAULT '',
  `department` varchar(12) NOT NULL DEFAULT '',
  `email` varchar(20) DEFAULT '',
  `logo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `teacherInfo` WRITE;
/*!40000 ALTER TABLE `teacherInfo` DISABLE KEYS */;

INSERT INTO `teacherInfo` (`Tid`, `name`, `acdamic`, `department`, `email`, `logo`)
VALUES
	(10001,'徐荣先','数理学院','A214','xrx@163.com','src/material/userlogo/6.jpg'),
	(10002,'肖云鹏修改测试','软件工程','B131','xyp@163.com','src/material/userlogo/8.jpg'),
	(10003,'彭国芳','体育学院','D114','pgf@163.com','src/material/userlogo/5.jpg'),
	(10004,'赵春泽','软件工程','B111','zcz@163.com','src/material/userlogo/9.jpg'),
	(10005,'耿金灵','数理学院','A213','gjl@163.com','src/material/userlogo/3.jpg'),
	(10006,'林忠','外国语','D301','linzhong@163.com','src/material/userlogo/11.jpg');

/*!40000 ALTER TABLE `teacherInfo` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table teacherList
# ------------------------------------------------------------

DROP TABLE IF EXISTS `teacherList`;

CREATE TABLE `teacherList` (
  `Tid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`Tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `teacherList` WRITE;
/*!40000 ALTER TABLE `teacherList` DISABLE KEYS */;

INSERT INTO `teacherList` (`Tid`, `username`, `password`)
VALUES
	(10001,'徐荣先','920725'),
	(10002,'肖云鹏','920725'),
	(10003,'彭国芳','920725'),
	(10004,'赵春泽','920725'),
	(10005,'耿金灵','920725'),
	(10006,'林忠','920725');

/*!40000 ALTER TABLE `teacherList` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
