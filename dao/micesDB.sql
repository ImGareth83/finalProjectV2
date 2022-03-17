-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: localhost    Database: micesDB
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `micesDB`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `micesDB` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `micesDB`;

--
-- Table structure for table `Items`
--

DROP TABLE IF EXISTS `Items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) NOT NULL,
  `imageUrl` varchar(200) NOT NULL,
  `price` double NOT NULL,
  `style` varchar(200) NOT NULL,
  `sold` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Items`
--

LOCK TABLES `Items` WRITE;
/*!40000 ALTER TABLE `Items` DISABLE KEYS */;
INSERT INTO `Items` VALUES (29,'Cat Tee Black T-Shirt','4 MSL','productImages/images/t-shirt1.jpg',20,'Black with custom print'),(30,'Dark Thug Blue-Navy T-Shirt','Thug Blue-Navy','productImages/images/t-shirt2.png',10,'Front print and paisley print'),(31,'Sphynx Tie Dye Wine T-Shirt','GPX Poly 1','productImages/images/t-shirt3.png',80,'Front tie dye print'),(32,'Skuul','Training 2014','productImages/images/t-shirt4.jpg',140,'Black T-Shirt with front print'),(33,'Wine Skul T-Shirt','Skul T-Shirt','productImages/images/t-shirt5.png',13,'Wine'),(34,'update1','aaa','productImages/image/t-shirt1.jpg',10,'aaa'),(35,'Cat Tee Black T-Shirt','4 MSL','productImages/images/t-shirt1.jpg',20,'Black with custom print'),(36,'Dark Thug Blue-Navy T-Shirt','Thug Blue-Navy','productImages/images/t-shirt2.png',10,'Front print and paisley print'),(37,'Sphynx Tie Dye Wine T-Shirt','GPX Poly 1','productImages/images/t-shirt3.png',80,'Front tie dye print'),(38,'Skuul','Training 2014','productImages/images/t-shirt4.jpg',140,'Black T-Shirt with front print'),(39,'Wine Skul T-Shirt','Skul T-Shirt','productImages/images/t-shirt5.png',13,'Wine'),(40,'update1','aaa','productImages/images/t-shirt1.jpg',10,'aaa');
/*!40000 ALTER TABLE `Items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items_has_users`
--

DROP TABLE IF EXISTS `items_has_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items_has_users` (
  `items_id` int NOT NULL,
  `users_user_id` int NOT NULL,
  PRIMARY KEY (`items_id`,`users_user_id`),
  KEY `fk_items_has_users_users1_idx` (`users_user_id`),
  KEY `fk_items_has_users_items_idx` (`items_id`),
  CONSTRAINT `fk_items_has_users_items` FOREIGN KEY (`items_id`) REFERENCES `items` (`id`),
  CONSTRAINT `fk_items_has_users_users1` FOREIGN KEY (`users_user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items_has_users`
--

LOCK TABLES `items_has_users` WRITE;
/*!40000 ALTER TABLE `items_has_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `items_has_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` varchar(45) NOT NULL,
  `enabled` tinyint DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'namhm','$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu','ROLE_USER',1),(2,'admin','$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy','ROLE_ADMIN',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-10 18:27:57
