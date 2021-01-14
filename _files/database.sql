CREATE DATABASE  IF NOT EXISTS `cem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cem`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: cem
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'DESKTOP'),(4,'HD'),(3,'MEMORIA'),(5,'MONITOR'),(2,'NOTEBOOK'),(6,'PROCESSADOR');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_person` int NOT NULL,
  `id_occupation` int NOT NULL,
  `id_created_user` int NOT NULL,
  `id_updated_user` int NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `id_person_UNIQUE` (`id_person`),
  KEY `fk_occupation_idx` (`id_occupation`),
  KEY `fk_created_employee_idx` (`id_created_user`),
  KEY `fk_updated_employee_idx` (`id_updated_user`),
  CONSTRAINT `fk_created_employee` FOREIGN KEY (`id_created_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_occupation` FOREIGN KEY (`id_occupation`) REFERENCES `occupation` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_person_employee` FOREIGN KEY (`id_person`) REFERENCES `person` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_updated_employee` FOREIGN KEY (`id_updated_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipament`
--

DROP TABLE IF EXISTS `equipament`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipament` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_invoice` int NOT NULL,
  `id_model` int NOT NULL,
  `id_equipament_status` int NOT NULL,
  `serial_number` varchar(20) NOT NULL,
  `id_created_user` int NOT NULL,
  `id_updated_user` int NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `serial_number_UNIQUE` (`serial_number`),
  KEY `fk_invoice_idx` (`id_invoice`),
  KEY `fk_model_idx` (`id_model`),
  KEY `fk_createduser_idx` (`id_created_user`),
  KEY `fk_updateduser_idx` (`id_updated_user`),
  KEY `fk_status_idx` (`id_equipament_status`),
  CONSTRAINT `fk_createduser` FOREIGN KEY (`id_created_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_invoice` FOREIGN KEY (`id_invoice`) REFERENCES `invoice` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_model` FOREIGN KEY (`id_model`) REFERENCES `model` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_status_equipament` FOREIGN KEY (`id_equipament_status`) REFERENCES `equipament_status` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_updateduser` FOREIGN KEY (`id_updated_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipament`
--

LOCK TABLES `equipament` WRITE;
/*!40000 ALTER TABLE `equipament` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipament` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipament_historic`
--

DROP TABLE IF EXISTS `equipament_historic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipament_historic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_equipament` int NOT NULL,
  `id_employee` int NOT NULL,
  `date_output` date NOT NULL,
  `date_input` date DEFAULT NULL,
  `id_created_user` int NOT NULL,
  `id_updated_user` int NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_equipament_idx` (`id_equipament`),
  KEY `fk_employee_historic_idx` (`id_employee`),
  KEY `fk_created_historic_idx` (`id_created_user`),
  KEY `fk_updated_historic_idx` (`id_updated_user`),
  CONSTRAINT `fk_created_historic` FOREIGN KEY (`id_created_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_employee_historic` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_equipament` FOREIGN KEY (`id_equipament`) REFERENCES `equipament` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_updated_historic` FOREIGN KEY (`id_updated_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipament_historic`
--

LOCK TABLES `equipament_historic` WRITE;
/*!40000 ALTER TABLE `equipament_historic` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipament_historic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipament_status`
--

DROP TABLE IF EXISTS `equipament_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipament_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipament_status`
--

LOCK TABLES `equipament_status` WRITE;
/*!40000 ALTER TABLE `equipament_status` DISABLE KEYS */;
INSERT INTO `equipament_status` VALUES (1,'DISPONÍVEL'),(2,'INDISPONÍVEL'),(3,'MANUTENÇÃO');
/*!40000 ALTER TABLE `equipament_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_provider` int NOT NULL,
  `number` varchar(45) NOT NULL,
  `access_key` varchar(70) NOT NULL,
  `date_issue` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `access_key_UNIQUE` (`access_key`),
  KEY `fk_provider_idx` (`id_provider`),
  CONSTRAINT `fk_provider` FOREIGN KEY (`id_provider`) REFERENCES `provider` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_brand` int NOT NULL,
  `id_category` int NOT NULL,
  `partnumber` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `partnumber_UNIQUE` (`partnumber`),
  KEY `fk_brand_idx` (`id_brand`),
  KEY `fk_category_idx` (`id_category`),
  CONSTRAINT `fk_brand` FOREIGN KEY (`id_brand`) REFERENCES `brand` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_category` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `occupation`
--

DROP TABLE IF EXISTS `occupation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `occupation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `occupation`
--

LOCK TABLES `occupation` WRITE;
/*!40000 ALTER TABLE `occupation` DISABLE KEYS */;
/*!40000 ALTER TABLE `occupation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peripheral`
--

DROP TABLE IF EXISTS `peripheral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peripheral` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_category` int NOT NULL,
  `name` varchar(70) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_category_idx` (`id_category`),
  CONSTRAINT `fk_category_peripheral` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peripheral`
--

LOCK TABLES `peripheral` WRITE;
/*!40000 ALTER TABLE `peripheral` DISABLE KEYS */;
INSERT INTO `peripheral` VALUES (1,3,'DDR3 8 GB'),(2,3,'DDR4 8 GB'),(3,3,'DDR4 16 GB'),(4,5,'LCD 21 POLEGADAS'),(5,5,'LCD 24 POLEGADAS'),(6,5,'LCD 27 POLEGADAS'),(8,4,'SATA 1 TB'),(9,4,'SATA 2 TB'),(10,4,'SATA 4 TB'),(11,4,'SATA 8 TB'),(12,4,'SSD 240 GB');
/*!40000 ALTER TABLE `peripheral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,'ADMIN','ACESSO DE ADMINISTRADOR'),(2,'MANAGER','ACESSO DE GERENTE');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_person_type` int NOT NULL,
  `name` varchar(70) NOT NULL,
  `document` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `document_UNIQUE` (`document`),
  KEY `fk_type_idx` (`id_person_type`),
  CONSTRAINT `fk_type` FOREIGN KEY (`id_person_type`) REFERENCES `person_type` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_type`
--

DROP TABLE IF EXISTS `person_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_type`
--

LOCK TABLES `person_type` WRITE;
/*!40000 ALTER TABLE `person_type` DISABLE KEYS */;
INSERT INTO `person_type` VALUES (1,'PESSOA FISICA'),(2,'PESSOA JURÍDICA');
/*!40000 ALTER TABLE `person_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provider`
--

DROP TABLE IF EXISTS `provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provider` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_person` int NOT NULL,
  `id_created_user` int NOT NULL,
  `id_updated_user` int NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `id_person_UNIQUE` (`id_person`),
  KEY `fk_createduser_provider_idx` (`id_created_user`),
  KEY `fk_updateduser_provider_idx` (`id_updated_user`),
  CONSTRAINT `fk_createduser_provider` FOREIGN KEY (`id_created_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_person_provider` FOREIGN KEY (`id_person`) REFERENCES `person` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_updateduser_provider` FOREIGN KEY (`id_updated_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provider`
--

LOCK TABLES `provider` WRITE;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_employee` int NOT NULL,
  `id_user_status` int NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(70) NOT NULL,
  `avatar` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `avatar_UNIQUE` (`avatar`),
  KEY `fk_status_idx` (`id_user_status`),
  KEY `fk_employee_idx` (`id_employee`),
  CONSTRAINT `fk_employee` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_status` FOREIGN KEY (`id_user_status`) REFERENCES `user_status` (`id`) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_permission_has`
--

DROP TABLE IF EXISTS `user_permission_has`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_permission_has` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `id_permission` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `id_user_UNIQUE` (`id_user`),
  KEY `fk_permission_idx` (`id_permission`),
  CONSTRAINT `fk_permission` FOREIGN KEY (`id_permission`) REFERENCES `permission` (`id`) ON DELETE RESTRICT,
  CONSTRAINT `fk_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_permission_has`
--

LOCK TABLES `user_permission_has` WRITE;
/*!40000 ALTER TABLE `user_permission_has` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_permission_has` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_status`
--

DROP TABLE IF EXISTS `user_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_status`
--

LOCK TABLES `user_status` WRITE;
/*!40000 ALTER TABLE `user_status` DISABLE KEYS */;
INSERT INTO `user_status` VALUES (1,'ATIVO'),(2,'BLOQUEADO');
/*!40000 ALTER TABLE `user_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-04  0:25:25
