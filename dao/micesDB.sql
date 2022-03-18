-- MySQL dump 10.13  Distrib 8.0.28, for macos11 (x86_64)
--
-- Host: localhost    Database: micesdb
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
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) NOT NULL,
  `imageUrl` varchar(200) NOT NULL,
  `price` double NOT NULL,
  `style` varchar(200) NOT NULL,
  `quantity` int DEFAULT NULL,
  `sold` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (29,'Cat Tee Black T-Shirt','4 MSL','imgs/products/amd3200G.jpg',20,'Black with custom print',0,0),(30,'Dark Thug Blue-Navy T-Shirt','Thug Blue-Navy','imgs/products/amd5600G.jpg',10,'Front print and paisley print',0,0),(31,'Sphynx Tie Dye Wine T-Shirt','GPX Poly 1','imgs/products/amd5700G.jpg',80,'Front tie dye print',0,0),(32,'Skuul','Training 2014','imgs/products/amd5950x.jpg',140,'Black T-Shirt with front print',0,0),(33,'Wine Skul T-Shirt','Skul T-Shirt','imgs/products/asusGTX3090.jpg',13,'Wine',0,0),(34,'update1','aaa','imgs/products/evgaGTX3090.jpg',10,'aaa',0,0),(35,'Cat Tee Black T-Shirt','4 MSL','imgs/products/gigabyteGTX3090.jpg',20,'Black with custom print',0,0),(36,'Dark Thug Blue-Navy T-Shirt','Thug Blue-Navy','imgs/products/msiGTX3090.jpg',10,'Front print and paisley print',0,0),(37,'Sphynx Tie Dye Wine T-Shirt','GPX Poly 1','productImages/images/t-shirt3.png',80,'Front tie dye print',0,0),(38,'Skuul','Training 2014','productImages/images/t-shirt4.jpg',140,'Black T-Shirt with front print',0,0),(39,'Wine Skul T-Shirt','Skul T-Shirt','productImages/images/t-shirt5.png',13,'Wine',0,0),(40,'update1','aaa','productImages/images/t-shirt1.jpg',10,'aaa',0,0),(46,'aaa','ddd','bb',123,'ccc',0,0);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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

-- Dump completed on 2022-03-18  9:44:07
