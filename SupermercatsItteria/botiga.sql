-- MySQL dump 10.13  Distrib 5.6.14, for Win32 (x86)
--
-- Host: localhost    Database: botiga
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Current Database: `botiga`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `botiga` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `botiga`;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `nomproducte` varchar(50) DEFAULT NULL,
  `idusuari` varchar(50) DEFAULT NULL,
  `quantitat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comandes`
--

DROP TABLE IF EXISTS `comandes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comandes` (
  `id` int(11) NOT NULL DEFAULT '0',
  `idusuari` varchar(50) NOT NULL DEFAULT '',
  `nomproducte` varchar(50) NOT NULL DEFAULT '',
  `quantitat` int(11) DEFAULT NULL,
  `pagat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`idusuari`,`nomproducte`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comandes`
--

LOCK TABLES `comandes` WRITE;
/*!40000 ALTER TABLE `comandes` DISABLE KEYS */;
INSERT INTO `comandes` VALUES (1,'fran','manzana',5,1),(2,'fran','manzana',44,1),(3,'fran','manzana',4,0),(3,'fran','pera',5,0);
/*!40000 ALTER TABLE `comandes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productes`
--

DROP TABLE IF EXISTS `productes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productes` (
  `url` varchar(200) DEFAULT NULL,
  `nom` varchar(50) NOT NULL DEFAULT '',
  `preu` float DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productes`
--

LOCK TABLES `productes` WRITE;
/*!40000 ALTER TABLE `productes` DISABLE KEYS */;
INSERT INTO `productes` VALUES ('http://www.keepflowers.ru/wp-content/uploads/2008/09/small-cactus-299x300.jpg','cactus',225.67,3000),('http://otcasea.gob.do/wp-content/uploads/2012/06/mango.jpeg','mango',17.75,17),('http://static2.lasrecetascocina.com/wp-content/uploads/2008/12/pera-150x150.jpg','pera',10.5,200),('http://blogs.funiber.org/wp-content/uploads/2013/05/banana1.jpg','platan',28.97,26),('http://dat.etsit.upm.es/~luciano/blog/wp-content/uploads/2010/09/manzana-150x150.png','poma',5.7,50);
/*!40000 ALTER TABLE `productes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuaris`
--

DROP TABLE IF EXISTS `usuaris`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuaris` (
  `nick` varchar(50) NOT NULL DEFAULT '',
  `pass` varchar(50) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `edat` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefon` varchar(50) DEFAULT NULL,
  `compteb` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nick`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuaris`
--

LOCK TABLES `usuaris` WRITE;
/*!40000 ALTER TABLE `usuaris` DISABLE KEYS */;
INSERT INTO `usuaris` VALUES ('fran','1234','fran',12,'asasas','123513','compte'),('fran2','1234567','1234',18,'ddasasdas@adkaf.com','123456789',NULL),('fran3','1234567','1234',18,'ddasasdas@adkaf.com','123456789',NULL);
/*!40000 ALTER TABLE `usuaris` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-28 12:13:40
