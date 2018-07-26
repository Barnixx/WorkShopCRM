-- MySQL dump 10.13  Distrib 5.7.22, for Win64 (x86_64)
--
-- Host: localhost    Database: workshop
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `last_name` varchar(80) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Karol','Nowak','1985-10-24'),(2,'Dorota','Kowalska','1997-05-22'),(3,'Andrzej','Skoczek','1990-02-18');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `last_name` varchar(80) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `phone` char(9) DEFAULT NULL,
  `note` text,
  `man_hour` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Dariusz','Opona','Chłopska 54b/3 80-387 Gdańsk','651254789','Opierdolić za zjebanie roboty',25.00),(2,'Adam','Wachacz','ul. Powstańców Warszawskich 74b/4 80-089 Gdańsk','654824155','Diagnosta',18.50),(3,'Krzysztof','Poniewierski','ul. Słowackiego 34 80-234','512545872','Już nie kierownik',25.25);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date_of_accepting` datetime DEFAULT NULL,
  `planned_start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `description_of_the_problem` text,
  `repair_description` text,
  `status` enum('Przyjęty','Zatwierdzone koszty naprawy','W naprawie','Gotowy do odbioru','Rezygnacja') DEFAULT NULL,
  `repair_cost` decimal(7,2) DEFAULT NULL,
  `part_cost` decimal(7,2) DEFAULT NULL,
  `man_hours` int(11) DEFAULT NULL,
  `vehicle_id` int(10) unsigned NOT NULL,
  `customer_id` int(11) NOT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_vehicle_idx` (`vehicle_id`),
  KEY `fk_order_customer1_idx` (`customer_id`),
  KEY `fk_order_employee_idx` (`employee_id`),
  CONSTRAINT `fk_order_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_vehicle` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,'2018-07-19 18:54:01','2018-07-26',NULL,'Coś się zjebało','o chuj i to poważnie','Przyjęty',450.00,280.00,2,1,1,1),(2,'2018-07-17 11:33:27','2018-07-23','2018-07-24','Coś się zjebało znowu','ale zrobili mi','Rezygnacja',250.00,0.00,4,2,2,1),(3,'2018-07-19 13:26:35','2018-07-12','2018-07-27','znowu','zrobione','Gotowy do odbioru',45.60,5.00,4,1,1,1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `model` varchar(30) DEFAULT NULL,
  `brand` varchar(30) DEFAULT NULL,
  `year_of_production` year(4) DEFAULT NULL,
  `license_plate` char(7) DEFAULT NULL,
  `next_inspection` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `license_plate_UNIQUE` (`license_plate`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (1,'Insigni II','Opel',2014,'GD23658','2019-07-18'),(2,'Golf IV','Volkswagen',NULL,'GDA2654','2018-07-28');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `vorder`
--

DROP TABLE IF EXISTS `vorder`;
/*!50001 DROP VIEW IF EXISTS `vorder`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vorder` AS SELECT 
 1 AS `id`,
 1 AS `date_of_accepting`,
 1 AS `planned_start_date`,
 1 AS `end_date`,
 1 AS `description_of_the_problem`,
 1 AS `repair_description`,
 1 AS `status`,
 1 AS `repair_cost`,
 1 AS `part_cost`,
 1 AS `man_hours`,
 1 AS `cost_for_hours`,
 1 AS `employee_id`,
 1 AS `employee_name`,
 1 AS `employee_lastname`,
 1 AS `customer_id`,
 1 AS `customer_name`,
 1 AS `customer_lastname`,
 1 AS `vehicle_id`,
 1 AS `vehicle_brand`,
 1 AS `vehicle_model`,
 1 AS `vehilce_year`,
 1 AS `vehilce_license_plate`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vorder`
--

/*!50001 DROP VIEW IF EXISTS `vorder`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vorder` AS (select `order`.`id` AS `id`,`order`.`date_of_accepting` AS `date_of_accepting`,`order`.`planned_start_date` AS `planned_start_date`,`order`.`end_date` AS `end_date`,`order`.`description_of_the_problem` AS `description_of_the_problem`,`order`.`repair_description` AS `repair_description`,`order`.`status` AS `status`,`order`.`repair_cost` AS `repair_cost`,`order`.`part_cost` AS `part_cost`,`order`.`man_hours` AS `man_hours`,(`employee`.`man_hour` * `order`.`man_hours`) AS `cost_for_hours`,`order`.`employee_id` AS `employee_id`,`employee`.`name` AS `employee_name`,`employee`.`last_name` AS `employee_lastname`,`order`.`customer_id` AS `customer_id`,`customer`.`name` AS `customer_name`,`customer`.`last_name` AS `customer_lastname`,`order`.`vehicle_id` AS `vehicle_id`,`vehicle`.`brand` AS `vehicle_brand`,`vehicle`.`model` AS `vehicle_model`,`vehicle`.`year_of_production` AS `vehilce_year`,`vehicle`.`license_plate` AS `vehilce_license_plate` from (((`order` join `vehicle` on((`order`.`vehicle_id` = `vehicle`.`id`))) join `customer` on((`order`.`customer_id` = `customer`.`id`))) join `employee` on((`order`.`employee_id` = `employee`.`id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-26 20:03:16
