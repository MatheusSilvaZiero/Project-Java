-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: quesejadoce
-- ------------------------------------------------------
-- Server version	5.7.31

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
-- Table structure for table `cadastrocliente`
--

DROP TABLE IF EXISTS `cadastrocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cadastrocliente` (
  `nome` varchar(40) NOT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `complemento` varchar(40) DEFAULT NULL,
  `cidade` varchar(20) DEFAULT NULL,
  `bairro` varchar(20) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `pix` varchar(25) DEFAULT NULL,
  `chavepix` varchar(25) DEFAULT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastrocliente`
--

LOCK TABLES `cadastrocliente` WRITE;
/*!40000 ALTER TABLE `cadastrocliente` DISABLE KEYS */;
INSERT INTO `cadastrocliente` VALUES ('Matheus da Silva Souza','Rua Jackson de figueiredo','','São Gonçalo','laranjal','28','Cpf','15093788716',1),('Lucia','Rua sobe e Desce numero desaparece, 36','não tem','são Gonçalo','Boassu','0','e-mail','e-mail',2),('Maria','Rua das Marias','','Itaborai','centro','2196584','e-mail','maria@gmail.com',3),('Janete Faria Dias','Rua lacerda','nt','Niterói','Santa Barbara','0','Cpf','Cpf',4),('asdasd','asdasd','asdad','asdasd','asdasd','21970006289','Cpf','asdasd',6),('qeqwe','qweqweqwe','qweqwe','qweqwe','qweqew','(  )      -    ','Cpf','qweqwe',7),('ddwdqd','asssqqq','eeeewww','ttttt','ttttt','(21) 22336-6444','Cpf','55554444',8);
/*!40000 ALTER TABLE `cadastrocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cadastrofornecedor`
--

DROP TABLE IF EXISTS `cadastrofornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cadastrofornecedor` (
  `nomeforcedor` varchar(30) DEFAULT NULL,
  `endereco` varchar(30) DEFAULT NULL,
  `cep` int(11) DEFAULT NULL,
  `cnpj` int(11) DEFAULT NULL,
  `contato` int(11) DEFAULT NULL,
  `contato2` int(11) DEFAULT NULL,
  `cidade` varchar(15) DEFAULT NULL,
  `bairro` varchar(15) DEFAULT NULL,
  `datacad` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cadastrofornecedor`
--

LOCK TABLES `cadastrofornecedor` WRITE;
/*!40000 ALTER TABLE `cadastrofornecedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `cadastrofornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `despesas`
--

DROP TABLE IF EXISTS `despesas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `despesas` (
  `fornecedor` varchar(30) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `datadespesa` varchar(10) DEFAULT NULL,
  `mesdespesa` varchar(10) DEFAULT NULL,
  `anodespesa` varchar(5) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `despesas`
--

LOCK TABLES `despesas` WRITE;
/*!40000 ALTER TABLE `despesas` DISABLE KEYS */;
/*!40000 ALTER TABLE `despesas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `numeropedido`
--

DROP TABLE IF EXISTS `numeropedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `numeropedido` (
  `npedido` int(10) NOT NULL,
  PRIMARY KEY (`npedido`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `numeropedido`
--

LOCK TABLES `numeropedido` WRITE;
/*!40000 ALTER TABLE `numeropedido` DISABLE KEYS */;
INSERT INTO `numeropedido` VALUES (16);
/*!40000 ALTER TABLE `numeropedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `numeroPedido` int(11) NOT NULL,
  `codproduto` int(11) DEFAULT NULL,
  `qtd` int(10) DEFAULT NULL,
  `nomeproduto` varchar(30) DEFAULT NULL,
  `valorunit` float DEFAULT NULL,
  `valorpedido` float DEFAULT NULL,
  `nomecliente` varchar(40) NOT NULL,
  `datapedido` varchar(10) DEFAULT NULL,
  `mespedido` varchar(8) DEFAULT NULL,
  `anopedido` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,NULL,NULL,'copo da felicidade',NULL,10,'janaina',NULL,NULL,NULL),(2,NULL,NULL,'bolo de pote',NULL,10,'Ana Maria',NULL,NULL,NULL),(4,NULL,NULL,'Lucia',NULL,17,'Lucia',NULL,NULL,NULL),(4,NULL,NULL,'Janete Faria Dias',NULL,44,'Janete Faria Dias',NULL,NULL,NULL),(4,NULL,NULL,'Janete Faria Dias',NULL,44,'Janete Faria Dias',NULL,NULL,NULL),(4,10,1,'bolo de baunilha',25.5,25.5,'Lucia','2021-10-25',NULL,NULL),(4,13,2,'copo pudim',34,34,'Lucia','2021-10-25',NULL,NULL),(4,13,2,'copo pudim',34,60,'Lucia','2021-10-25',NULL,NULL),(4,11,1,'bolo de maracuja',26,60,'Lucia','2021-10-25',NULL,NULL),(4,10,1,'bolo de baunilha',25.5,42.5,'Janete Faria Dias','2021-10-25',NULL,NULL),(4,13,1,'copo pudim',17,42.5,'Janete Faria Dias','2021-10-25',NULL,NULL),(6,11,1,'bolo de maracuja',26,26,'Maria','2021-10-25',NULL,NULL),(7,12,1,'copo da felicidade',18,18,'asdasd','2021-10-25',NULL,NULL),(8,11,1,'bolo de maracuja',26,26,'Janete Faria Dias','2021-10-25',NULL,NULL),(9,8,1,'bolo de laranja ',10,10,'asdasd','2021-10-25',NULL,NULL),(10,13,1,'copo pudim',17,17,'Janete Faria Dias','2021-10-25',NULL,NULL),(11,11,1,'bolo de maracuja',26,52,'Maria','2021-10-25',NULL,NULL),(11,11,1,'bolo de maracuja',26,52,'Maria','2021-10-25',NULL,NULL),(12,12,1,'copo da felicidade',18,18,'Matheus da Silva Souza','2021-10-25',NULL,NULL),(13,13,1,'copo pudim',17,45,'asdasd','2021-10-25',NULL,NULL),(13,8,1,'bolo de laranja ',10,45,'asdasd','2021-10-25',NULL,NULL),(13,12,1,'copo da felicidade',18,45,'asdasd','2021-10-25',NULL,NULL),(14,10,2,'bolo de baunilha',51,304,'Lucia','2021-11-01',NULL,NULL),(14,12,5,'Copo Felicidade',90,304,'Lucia','2021-11-01',NULL,NULL),(14,10,6,'bolo de baunilha',153,304,'Lucia','2021-11-01',NULL,NULL),(14,8,1,'bolo de laranja ',10,304,'Lucia','2021-11-01',NULL,NULL),(15,12,4,'Copo Felicidad',72,108,'ddwdqd','14/12/2021','12','2021'),(15,6,3,'bolo de cenoura',36,108,'ddwdqd','14/12/2021','12','2021');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidofinalizado`
--

DROP TABLE IF EXISTS `pedidofinalizado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidofinalizado` (
  `numeroPedido` int(11) NOT NULL,
  `codproduto` int(11) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `nomeproduto` varchar(20) DEFAULT NULL,
  `valorunit` float DEFAULT NULL,
  `valorpedido` float DEFAULT NULL,
  `nomecliente` varchar(30) NOT NULL,
  `datapedido` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidofinalizado`
--

LOCK TABLES `pedidofinalizado` WRITE;
/*!40000 ALTER TABLE `pedidofinalizado` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidofinalizado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `codigoproduto` int(11) NOT NULL AUTO_INCREMENT,
  `nomeproduto` varchar(50) DEFAULT NULL,
  `valorproduto` double DEFAULT NULL,
  UNIQUE KEY `codigoproduto_UNIQUE` (`codigoproduto`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (6,'bolo de cenoura',12),(7,'bolo de banana',12),(8,'bolo de laranja ',10),(9,'bolo de chocolate',25),(10,'bolo de baunilha',25.5),(11,'bolo de maracuja',26),(12,'Copo Felicidad',18),(13,'copo pudim',17);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'quesejadoce'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-14 16:57:42
