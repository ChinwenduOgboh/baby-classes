-- MySQL dump 10.13  Distrib 8.4.5, for Win64 (x86_64)
--
-- Host: localhost    Database: babyclasseskent
-- ------------------------------------------------------
-- Server version	8.4.5

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
-- Table structure for table `class_schedule`
--

DROP TABLE IF EXISTS `class_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_schedule` (
  `id` binary(16) NOT NULL,
  `class_id` binary(16) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `baby_class_uuid` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `class_id` (`class_id`),
  KEY `class_schedule_ibfk_1` (`baby_class_uuid`),
  CONSTRAINT `class_schedule_ibfk_1` FOREIGN KEY (`baby_class_uuid`) REFERENCES `baby_class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_schedule`
--

LOCK TABLES `class_schedule` WRITE;
/*!40000 ALTER TABLE `class_schedule` DISABLE KEYS */;
INSERT INTO `class_schedule` VALUES (_binary '*DŠÿ‹c\ğš\0ÿ,Ô•\È',_binary 'û:Y†–\ğš\0ÿ,Ô•\È','2025-09-08 10:00:00','2025-09-08 11:00:00',_binary 'û:Y†–\ğš\0ÿ,Ô•\È'),(_binary '*DıØ‹c\ğš\0ÿ,Ô•\È',_binary 'û:Y†–\ğš\0ÿ,Ô•\È','2025-09-10 10:00:00','2025-09-10 11:00:00',_binary 'û:Y†–\ğš\0ÿ,Ô•\È'),(_binary '*E\0R‹c\ğš\0ÿ,Ô•\È',_binary 'û:Y†–\ğš\0ÿ,Ô•\È','2025-09-12 10:00:00','2025-09-12 11:00:00',_binary 'û:Y†–\ğš\0ÿ,Ô•\È'),(_binary '*EC‹c\ğš\0ÿ,Ô•\È',_binary 'ûP0†–\ğš\0ÿ,Ô•\È','2025-09-08 14:00:00','2025-09-08 15:00:00',_binary 'ûP0†–\ğš\0ÿ,Ô•\È'),(_binary '*E6‹c\ğš\0ÿ,Ô•\È',_binary 'ûP0†–\ğš\0ÿ,Ô•\È','2025-09-09 14:00:00','2025-09-09 15:00:00',_binary 'ûP0†–\ğš\0ÿ,Ô•\È'),(_binary '*E\ä‹c\ğš\0ÿ,Ô•\È',_binary 'ûP0†–\ğš\0ÿ,Ô•\È','2025-09-11 14:00:00','2025-09-11 15:00:00',_binary 'ûP0†–\ğš\0ÿ,Ô•\È'),(_binary '*E‰‹c\ğš\0ÿ,Ô•\È',_binary 'ûRe†–\ğš\0ÿ,Ô•\È','2025-09-08 09:30:00','2025-09-08 10:30:00',_binary 'ûRe†–\ğš\0ÿ,Ô•\È'),(_binary '*ED‹c\ğš\0ÿ,Ô•\È',_binary 'ûRe†–\ğš\0ÿ,Ô•\È','2025-09-10 09:30:00','2025-09-10 10:30:00',_binary 'ûRe†–\ğš\0ÿ,Ô•\È'),(_binary '*E\ò‹c\ğš\0ÿ,Ô•\È',_binary 'ûRe†–\ğš\0ÿ,Ô•\È','2025-09-12 09:30:00','2025-09-12 10:30:00',_binary 'ûRe†–\ğš\0ÿ,Ô•\È'),(_binary '*E˜‹c\ğš\0ÿ,Ô•\È',_binary 'ûSÉ†–\ğš\0ÿ,Ô•\È','2025-09-09 11:00:00','2025-09-09 12:00:00',_binary 'ûSÉ†–\ğš\0ÿ,Ô•\È'),(_binary '*EV‹c\ğš\0ÿ,Ô•\È',_binary 'ûSÉ†–\ğš\0ÿ,Ô•\È','2025-09-11 11:00:00','2025-09-11 12:00:00',_binary 'ûSÉ†–\ğš\0ÿ,Ô•\È'),(_binary '*E‹c\ğš\0ÿ,Ô•\È',_binary 'ûSÉ†–\ğš\0ÿ,Ô•\È','2025-09-13 11:00:00','2025-09-13 12:00:00',_binary 'ûSÉ†–\ğš\0ÿ,Ô•\È'),(_binary '*E§‹c\ğš\0ÿ,Ô•\È',_binary 'ûUf†–\ğš\0ÿ,Ô•\È','2025-09-08 10:30:00','2025-09-08 11:30:00',_binary 'ûUf†–\ğš\0ÿ,Ô•\È'),(_binary '*E	H‹c\ğš\0ÿ,Ô•\È',_binary 'ûUf†–\ğš\0ÿ,Ô•\È','2025-09-10 10:30:00','2025-09-10 11:30:00',_binary 'ûUf†–\ğš\0ÿ,Ô•\È'),(_binary '*E	ÿ‹c\ğš\0ÿ,Ô•\È',_binary 'ûUf†–\ğš\0ÿ,Ô•\È','2025-09-12 10:30:00','2025-09-12 11:30:00',_binary 'ûUf†–\ğš\0ÿ,Ô•\È'),(_binary '1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',_binary '1\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','2025-09-05 10:00:00','2025-09-05 11:00:00',NULL),(_binary '2\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',_binary '2\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','2025-09-07 09:30:00','2025-09-07 10:15:00',NULL),(_binary '3\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',_binary '3\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','2025-09-06 14:00:00','2025-09-06 15:00:00',NULL),(_binary '4\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',_binary '4\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','2025-09-08 11:00:00','2025-09-08 12:00:00',NULL),(_binary '5\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',_binary '5\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','2025-09-09 09:00:00','2025-09-09 11:00:00',NULL);
/*!40000 ALTER TABLE `class_schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-06 22:47:25
