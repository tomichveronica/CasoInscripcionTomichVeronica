-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: inscripcion
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `curso` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `aula` varchar(255) DEFAULT NULL,
  `duracion` varchar(255) DEFAULT NULL,
  `cargaHoraria` varchar(255) DEFAULT NULL,
  `cupo` int(11) DEFAULT NULL,
  `profesorId` int(11) DEFAULT NULL,
  `tematicaId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlowwvixkvlgvxtsxxrlccnu0x` (`profesorId`),
  KEY `FKhtt0rpq54cpv1lj6usaf2l9jp` (`tematicaId`),
  CONSTRAINT `FKhtt0rpq54cpv1lj6usaf2l9jp` FOREIGN KEY (`tematicaId`) REFERENCES `tematica` (`id`),
  CONSTRAINT `FKlowwvixkvlgvxtsxxrlccnu0x` FOREIGN KEY (`profesorId`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Curso Algebra','1','4 meses','4 horas semanales',35,3,1),(2,'Curso Analisis Matemático','1','8 meses','4 horas semanales',30,3,1),(3,'Curso Ingles I','2','4 meses','5 horas semanales',35,4,2),(4,'Curso Ingles II','2','4 meses','5 horas semanales',35,4,2),(5,'Curso Programación I','3','8 meses','6 horas semanales',50,1,3),(6,'Curso Programación II','3','8 meses','6 horas semanales',50,1,3),(7,'Curso BdD I','4','4 meses','6 horas semanales',50,4,4),(8,'Curso BdD II','4','4 meses','6 horas semanales',50,4,4);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `estudiante` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `tutor` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` bigint(20) DEFAULT NULL,
  `fechaNac` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (1,'Juan','Perez','perezjuan@gmail.com',NULL,NULL,NULL,NULL),(2,'Maria','Alvarez','alvarezmaria@gmail.com',NULL,NULL,NULL,NULL),(3,'Mario','Gonzales','gonzalesmario@gmail.com',NULL,NULL,NULL,NULL),(4,'Ana','Fernandez','fernandezana@gmail.com',NULL,NULL,NULL,NULL),(5,'Lucas','Zalazar','zalazarlucas@gmail.com',NULL,NULL,NULL,NULL),(6,'Maria Marta','Rodriguez','rodriguezmariamarta@gmail.com','',NULL,NULL,NULL),(8,'Miriam','Ezquivel','ezquivelmiriam@gmail.com','',NULL,NULL,NULL),(9,'Laura','Perez','laura@perez.com','',NULL,NULL,NULL),(10,'Pablo','Palermo','pablo@palermo.com','','Juan B Justo 678',2235889966,'1986-10-26 00:00:00.000000'),(11,'Rodrigo','Perez','rodrigo@lopez.com','','Independencia 1290',2238993344,'1982-10-26 00:00:00.000000');
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `inscripcion` (
  `id` int(11) NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `cursoId` int(11) DEFAULT NULL,
  `estudianteId` int(11) DEFAULT NULL,
  `condicional` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl1ucruy34nu0m0o2tlvad0axv` (`cursoId`),
  KEY `FK33e37ott7otpqv4o3hrkyq51b` (`estudianteId`),
  CONSTRAINT `FK33e37ott7otpqv4o3hrkyq51b` FOREIGN KEY (`estudianteId`) REFERENCES `estudiante` (`id`),
  CONSTRAINT `FKl1ucruy34nu0m0o2tlvad0axv` FOREIGN KEY (`cursoId`) REFERENCES `curso` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
INSERT INTO `inscripcion` VALUES (1,'2018-10-23 21:20:29.945000',5,2,NULL),(2,'2018-10-24 09:39:47.423000',6,1,_binary '\0'),(3,'2018-10-24 10:58:24.302000',3,1,_binary '\0'),(4,'2018-10-24 10:58:38.684000',4,1,_binary '\0'),(5,'2018-10-24 21:05:43.385000',8,6,_binary '\0'),(6,'2018-10-24 22:25:10.640000',1,8,_binary '\0'),(7,'2018-10-24 22:27:49.098000',2,8,_binary '\0');
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `profesor` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'Natalia','Vega','',NULL,NULL),(2,'Gonzalo','Gimenez','',NULL,NULL),(3,'Rocio','Acosta','',NULL,NULL),(4,'Leandro','Puente','',NULL,NULL);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tematica`
--

DROP TABLE IF EXISTS `tematica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tematica` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tematica`
--

LOCK TABLES `tematica` WRITE;
/*!40000 ALTER TABLE `tematica` DISABLE KEYS */;
INSERT INTO `tematica` VALUES (1,'Matemática'),(2,'Ingles'),(3,'Programación'),(4,'Base de Datos');
/*!40000 ALTER TABLE `tematica` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-26  6:20:15
