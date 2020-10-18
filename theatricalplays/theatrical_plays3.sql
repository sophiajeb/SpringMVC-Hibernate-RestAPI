CREATE DATABASE  IF NOT EXISTS `theatrical_plays3` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `theatrical_plays3`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: theatrical_plays3
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `play`
--

DROP TABLE IF EXISTS `play`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `play` (
  `play_id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  `start_date` varchar(45) DEFAULT NULL,
  `end_date` varchar(45) DEFAULT NULL,
  `room_no_seat` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`play_id`),
  UNIQUE KEY `id_UNIQUE` (`code`),
  KEY `play_idfk_1` (`room_no_seat`),
  CONSTRAINT `play_idfk_1` FOREIGN KEY (`room_no_seat`) REFERENCES `rooms` (`room_no_seat`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `play`
--

LOCK TABLES `play` WRITE;
/*!40000 ALTER TABLE `play` DISABLE KEYS */;
INSERT INTO `play` VALUES (1,'1','The Lord of the Rings: The Fellowship of the Ring','A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.','17/09/2020','17/10/2020','100'),(2,'2','The Lord of the Rings: The Two Towers','While Frodo and Sam edge closer to Mordor with the help of the shifty Gollum, the divided fellowship makes a stand against Sauron\'s new ally, Saruman, and his hordes of Isengard.','17/09/2020','17/10/2020','100'),(3,'3','The Lord of the Rings: The Return of the King','Gandalf and Aragorn lead the World of Men against Sauron\'s army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.','17/09/2020','17/10/2020','100'),(4,'4','The Hobbit: An Unexpected Journey','A reluctant Hobbit, Bilbo Baggins, sets out to the Lonely Mountain with a spirited group of dwarves to reclaim their mountain home, and the gold within it from the dragon Smaug.','25/10/2020','25/12/2020','100'),(5,'5','The Hobbit: The Desolation of Smaug','The dwarves, along with Bilbo Baggins and Gandalf the Grey, continue their quest to reclaim Erebor, their homeland, from Smaug. Bilbo Baggins is in possession of a mysterious and magical ring.','15/06/2020','17/07/2020','100'),(6,'6','The Hobbit: The Battle of the Five Armies','Bilbo and company are forced to engage in a war against an array of combatants and keep the Lonely Mountain from falling into the hands of a rising darkness.','17/05/2020','17/07/2020','100'),(7,'7','The Avengers','Earth\'s mightiest heroes must come together and learn to fight as a team if they are going to stop the mischievous Loki and his alien army from enslaving humanity.','17/07/2020','17/08/2020','100'),(8,'8','Avengers: Age of Ultron','When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it\'s up to Earth\'s mightiest heroes to stop the villainous Ultron from enacting his terrible plan.','17/11/2020','17/01/2021','100'),(9,'9','Captain America: Civil War','Political involvement in the Avengers\' affairs causes a rift between Captain America and Iron Man.','17/01/2021','17/02/2021','100'),(10,'10','Avengers: Infinity War','The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.','17/09/2020','17/10/2020','200'),(11,'11','Avengers: Endgame','After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos\' actions and restore balance to the universe.','17/09/2020','17/10/2020','200'),(12,'12','Captain America: The First Avenger','Steve Rogers, a rejected military soldier, transforms into Captain America after taking a dose of a \'Super-Soldier serum\'. But being Captain America comes at a price as he attempts to take down a war monger and a terrorist organization.','17/09/2020','17/10/2020','200'),(13,'13','Captain America: The Winter Soldier','As Steve Rogers struggles to embrace his role in the modern world, he teams up with a fellow Avenger and S.H.I.E.L.D agent, Black Widow, to battle a new threat from history: an assassin known as the Winter Soldier.','01/06/2020','01/07/2020','200'),(14,'14','Thor','The powerful but arrogant god Thor is cast out of Asgard to live amongst humans in Midgard (Earth), where he soon becomes one of their finest defenders.','17/06/2020','17/07/2020','200'),(15,'15','Thor: The Dark World','When the Dark Elves attempt to plunge the universe into darkness, Thor must embark on a perilous and personal journey that will reunite him with doctor Jane Foster.','17/09/2020','17/10/2020','200'),(16,'16','Thor: Ragnarok','Imprisoned on the planet Sakaar, Thor must race against time to return to Asgard and stop Ragnarok, the destruction of his world, at the hands of the powerful and ruthless villain Hela.','17/05/2020','17/06/2020','200'),(17,'17','Black Panther','T\'Challa, heir to the hidden but advanced kingdom of Wakanda, must step forward to lead his people into a new future and must confront a challenger from his country\'s past.','17/09/2020','17/10/2020','200'),(18,'18','Harry Potter and the Sorcerer\'s Stone','An orphaned boy enrolls in a school of wizardry, where he learns the truth about himself, his family and the terrible evil that haunts the magical world.','17/09/2020','17/10/2020','300'),(19,'19','Harry Potter and the Chamber of Secrets','An ancient prophecy seems to be coming true when a mysterious presence begins stalking the corridors of a school of magic and leaving its victims paralyzed.','17/09/2020','17/10/2020','300'),(20,'20','Harry Potter and the Prisoner of Azkaban','Harry Potter, Ron and Hermione return to Hogwarts School of Witchcraft and Wizardry for their third year of study, where they delve into the mystery surrounding an escaped prisoner who poses a dangerous threat to the young wizard.','17/06/2020','17/07/2020','300'),(21,'21','Harry Potter and the Goblet of Fire','Harry Potter finds himself competing in a hazardous tournament between rival schools of magic, but he is distracted by recurring nightmares.','17/09/2020','17/10/2020','300'),(22,'22','Harry Potter and the Order of the Phoenix','With their warning about Lord Voldemort\'s return scoffed at, Harry and Dumbledore are targeted by the Wizard authorities as an authoritarian bureaucrat slowly seizes power at Hogwarts.','17/09/2020','17/10/2020','300'),(23,'23','Harry Potter and the Half-Blood Prince','As Harry Potter begins his sixth year at Hogwarts, he discovers an old book marked as \'the property of the Half-Blood Prince\' and begins to learn more about Lord Voldemort\'s dark past.','22/10/2020','22/11/2020','300'),(24,'24','Harry Potter and the Deathly Hallows: Part 1','As Harry, Ron, and Hermione race against time and evil to destroy the Horcruxes, they uncover the existence of the three most powerful objects in the wizarding world: the Deathly Hallows.','17/11/2020','17/12/2020','300'),(25,'25','Harry Potter and the Deathly Hallows: Part 2','Harry, Ron, and Hermione search for Voldemort\'s remaining Horcruxes in their effort to destroy the Dark Lord as the final battle rages on at Hogwarts.','17/01/2021','17/02/2021','300'),(26,'26','Joker','In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.','22/09/2020','22/09/2021','100'),(27,'27','Inception','A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.','23/09/2020','30/10/2020','200'),(28,'28','Fight Club','An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.','18/11/2020','25/12/2020','300'),(29,'29','The Shawshank Redemption','Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.','29/09/2020','30/10/2020','100'),(30,'30','Pulp Fiction','The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.','23/09/2020','26/09/2020','200'),(31,'31','Aladdin','A kind-hearted street urchin and a power-hungry Grand Vizier vie for a magic lamp that has the power to make their deepest wishes come true.','01/10/2020','31/10/2020','300'),(32,'32','The Hangover','Three buddies wake up from a bachelor party in Las Vegas, with no memory of the previous night and the bachelor missing. They make their way around the city in order to find their friend before his wedding.','11/10/2020','11/12/2020','200');
/*!40000 ALTER TABLE `play` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `reservation_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `play_id` int(11) DEFAULT NULL,
  `room_no_seat` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  UNIQUE KEY `id_UNIQUE` (`reservation_id`),
  KEY `user_id` (`user_id`),
  KEY `play_id` (`play_id`),
  KEY `reservations_ibfk_3` (`room_no_seat`),
  CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `reservations_ibfk_2` FOREIGN KEY (`play_id`) REFERENCES `play` (`play_id`),
  CONSTRAINT `reservations_ibfk_3` FOREIGN KEY (`room_no_seat`) REFERENCES `rooms` (`room_no_seat`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (1,15,1,'150'),(2,15,2,'130'),(3,15,3,'160'),(4,15,12,'260'),(5,15,13,'270'),(6,15,24,'310'),(7,15,25,'315'),(9,17,1,'120'),(11,1,4,'102'),(12,1,4,'101'),(14,1,4,'130'),(15,1,4,'128'),(16,1,4,'129'),(17,1,4,'157'),(18,1,4,'156'),(19,1,4,'155'),(20,1,4,'184'),(21,1,4,'182'),(22,1,4,'183'),(23,1,4,'151'),(24,1,4,'142'),(25,1,4,'141'),(26,1,4,'196'),(27,1,4,'195'),(28,1,4,'197'),(29,1,4,'169'),(30,1,4,'177'),(31,1,4,'180'),(33,14,23,'350'),(34,14,29,'191'),(35,14,4,'123'),(36,1,28,'350'),(38,14,8,'141'),(39,14,28,'310'),(40,76,8,'178'),(41,76,32,'267'),(42,76,4,'136');
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_no_seat` varchar(45) NOT NULL,
  `seat_id` varchar(45) DEFAULT NULL,
  `room_no` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `room_no_seat_UNIQUE` (`room_no_seat`)
) ENGINE=InnoDB AUTO_INCREMENT=301 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,'100','00','1'),(2,'101','01','1'),(3,'102','02','1'),(4,'103','03','1'),(5,'104','04','1'),(6,'105','05','1'),(7,'106','06','1'),(8,'107','07','1'),(9,'108','08','1'),(10,'109','09','1'),(11,'110','10','1'),(12,'111','11','1'),(13,'112','12','1'),(14,'113','13','1'),(15,'114','14','1'),(16,'115','15','1'),(17,'116','16','1'),(18,'117','17','1'),(19,'118','18','1'),(20,'119','19','1'),(21,'120','20','1'),(22,'121','21','1'),(23,'122','22','1'),(24,'123','23','1'),(25,'124','24','1'),(26,'125','25','1'),(27,'126','26','1'),(28,'127','27','1'),(29,'128','28','1'),(30,'129','29','1'),(31,'130','30','1'),(32,'131','31','1'),(33,'132','32','1'),(34,'133','33','1'),(35,'134','34','1'),(36,'135','35','1'),(37,'136','36','1'),(38,'137','37','1'),(39,'138','38','1'),(40,'139','39','1'),(41,'140','40','1'),(42,'141','41','1'),(43,'142','42','1'),(44,'143','43','1'),(45,'144','44','1'),(46,'145','45','1'),(47,'146','46','1'),(48,'147','47','1'),(49,'148','48','1'),(50,'149','49','1'),(51,'150','50','1'),(52,'151','51','1'),(53,'152','52','1'),(54,'153','53','1'),(55,'154','54','1'),(56,'155','55','1'),(57,'156','56','1'),(58,'157','57','1'),(59,'158','58','1'),(60,'159','59','1'),(61,'160','60','1'),(62,'161','61','1'),(63,'162','62','1'),(64,'163','63','1'),(65,'164','64','1'),(66,'165','65','1'),(67,'166','66','1'),(68,'167','67','1'),(69,'168','68','1'),(70,'169','69','1'),(71,'170','70','1'),(72,'171','71','1'),(73,'172','72','1'),(74,'173','73','1'),(75,'174','74','1'),(76,'175','75','1'),(77,'176','76','1'),(78,'177','77','1'),(79,'178','78','1'),(80,'179','79','1'),(81,'180','80','1'),(82,'181','81','1'),(83,'182','82','1'),(84,'183','83','1'),(85,'184','84','1'),(86,'185','85','1'),(87,'186','86','1'),(88,'187','87','1'),(89,'188','88','1'),(90,'189','89','1'),(91,'190','90','1'),(92,'191','91','1'),(93,'192','92','1'),(94,'193','93','1'),(95,'194','94','1'),(96,'195','95','1'),(97,'196','96','1'),(98,'197','97','1'),(99,'198','98','1'),(100,'199','99','1'),(101,'200','00','2'),(102,'201','01','2'),(103,'202','02','2'),(104,'203','03','2'),(105,'204','04','2'),(106,'205','05','2'),(107,'206','06','2'),(108,'207','07','2'),(109,'208','08','2'),(110,'209','09','2'),(111,'210','10','2'),(112,'211','11','2'),(113,'212','12','2'),(114,'213','13','2'),(115,'214','14','2'),(116,'215','15','2'),(117,'216','16','2'),(118,'217','17','2'),(119,'218','18','2'),(120,'219','19','2'),(121,'220','20','2'),(122,'221','21','2'),(123,'222','22','2'),(124,'223','23','2'),(125,'224','24','2'),(126,'225','25','2'),(127,'226','26','2'),(128,'227','27','2'),(129,'228','28','2'),(130,'229','29','2'),(131,'230','30','2'),(132,'231','31','2'),(133,'232','32','2'),(134,'233','33','2'),(135,'234','34','2'),(136,'235','35','2'),(137,'236','36','2'),(138,'237','37','2'),(139,'238','38','2'),(140,'239','39','2'),(141,'240','40','2'),(142,'241','41','2'),(143,'242','42','2'),(144,'243','43','2'),(145,'244','44','2'),(146,'245','45','2'),(147,'246','46','2'),(148,'247','47','2'),(149,'248','48','2'),(150,'249','49','2'),(151,'250','50','2'),(152,'251','51','2'),(153,'252','52','2'),(154,'253','53','2'),(155,'254','54','2'),(156,'255','55','2'),(157,'256','56','2'),(158,'257','57','2'),(159,'258','58','2'),(160,'259','59','2'),(161,'260','60','2'),(162,'261','61','2'),(163,'262','62','2'),(164,'263','63','2'),(165,'264','64','2'),(166,'265','65','2'),(167,'266','66','2'),(168,'267','67','2'),(169,'268','68','2'),(170,'269','69','2'),(171,'270','70','2'),(172,'271','71','2'),(173,'272','72','2'),(174,'273','73','2'),(175,'274','74','2'),(176,'275','75','2'),(177,'276','76','2'),(178,'277','77','2'),(179,'278','78','2'),(180,'279','79','2'),(181,'280','80','2'),(182,'281','81','2'),(183,'282','82','2'),(184,'283','83','2'),(185,'284','84','2'),(186,'285','85','2'),(187,'286','86','2'),(188,'287','87','2'),(189,'288','88','2'),(190,'289','89','2'),(191,'290','90','2'),(192,'291','91','2'),(193,'292','92','2'),(194,'293','93','2'),(195,'294','94','2'),(196,'295','95','2'),(197,'296','96','2'),(198,'297','97','2'),(199,'298','98','2'),(200,'299','99','2'),(201,'300','00','3'),(202,'301','01','3'),(203,'302','02','3'),(204,'303','03','3'),(205,'304','04','3'),(206,'305','05','3'),(207,'306','06','3'),(208,'307','07','3'),(209,'308','08','3'),(210,'309','09','3'),(211,'310','10','3'),(212,'311','11','3'),(213,'312','12','3'),(214,'313','13','3'),(215,'314','14','3'),(216,'315','15','3'),(217,'316','16','3'),(218,'317','17','3'),(219,'318','18','3'),(220,'319','19','3'),(221,'320','20','3'),(222,'321','21','3'),(223,'322','22','3'),(224,'323','23','3'),(225,'324','24','3'),(226,'325','25','3'),(227,'326','26','3'),(228,'327','27','3'),(229,'328','28','3'),(230,'329','29','3'),(231,'330','30','3'),(232,'331','31','3'),(233,'332','32','3'),(234,'333','33','3'),(235,'334','34','3'),(236,'335','35','3'),(237,'336','36','3'),(238,'337','37','3'),(239,'338','38','3'),(240,'339','39','3'),(241,'340','40','3'),(242,'341','41','3'),(243,'342','42','3'),(244,'343','43','3'),(245,'344','44','3'),(246,'345','45','3'),(247,'346','46','3'),(248,'347','47','3'),(249,'348','48','3'),(250,'349','49','3'),(251,'350','50','3'),(252,'351','51','3'),(253,'352','52','3'),(254,'353','53','3'),(255,'354','54','3'),(256,'355','55','3'),(257,'356','56','3'),(258,'357','57','3'),(259,'358','58','3'),(260,'359','59','3'),(261,'360','60','3'),(262,'361','61','3'),(263,'362','62','3'),(264,'363','63','3'),(265,'364','64','3'),(266,'365','65','3'),(267,'366','66','3'),(268,'367','67','3'),(269,'368','68','3'),(270,'369','69','3'),(271,'370','70','3'),(272,'371','71','3'),(273,'372','72','3'),(274,'373','73','3'),(275,'374','74','3'),(276,'375','75','3'),(277,'376','76','3'),(278,'377','77','3'),(279,'378','78','3'),(280,'379','79','3'),(281,'380','80','3'),(282,'381','81','3'),(283,'382','82','3'),(284,'383','83','3'),(285,'384','84','3'),(286,'385','85','3'),(287,'386','86','3'),(288,'387','87','3'),(289,'388','88','3'),(290,'389','89','3'),(291,'390','90','3'),(292,'391','91','3'),(293,'392','92','3'),(294,'393','93','3'),(295,'394','94','3'),(296,'395','95','3'),(297,'396','96','3'),(298,'397','97','3'),(299,'398','98','3'),(300,'399','99','3');
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `mobile_phone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `role` varchar(64) DEFAULT NULL,
  `photo` varchar(65) DEFAULT NULL,
  `google_id` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'sophia_jeb','sophia16','Sophia','Tzempelikou','6987333333','sophiajeb93@gmail.com','USER','1.png',NULL),(4,'gar','123456','garufalia','tzemp','6987777777','gar@gmail.com','USER',NULL,NULL),(6,'hjbkj','25454','hgvjhgv','hgfjgf','6987777777','example@gmail.com','USER','6.png',NULL),(8,'jhgjh','fdgbszdgfb','zxdfbgszdf','dfbzdf','6985252','example@gmail.com','USER',NULL,NULL),(9,'bbb','bbb','bbb','bbb','12345','b@b','USER',NULL,NULL),(10,'Pasparakis','Pasparakis','George','Pasparakis','1111111111','fake@email.com','USER',NULL,'107240922717966810534'),(14,'laios.stavros','alimos123','stavros','stavros','6989864323','laios.stavros@gmail.com','ADMIN',NULL,NULL),(15,'glaios95','laios123','george','laios','6980666687','glaios95@gmail.com','USER',NULL,NULL),(17,'vlaios60','vasilis2','vasilis','laios','6972559922','vlaios@yahoo.gr','USER',NULL,NULL),(18,'test.test','test1234','test','test','1234567890','test@test.com','USER',NULL,NULL),(28,'maria.pap','maria123','maria','papadopoulou','6989865231','maria.pap@gmail.com','USER',NULL,NULL),(39,'kon.gakis','gakis123','konstantinos','gakis','2345678901','gakisk@gmail.com','USER',NULL,NULL),(41,'power.ranger','power123','power','ranger','6989864111','power.ranger@gmail.com','USER',NULL,NULL),(42,'nikos.tsekos','nikos123','nikos','tsekos','6989864777','nik.tsekos@yahoo.gr','USER',NULL,NULL),(43,'evelina.papal','papal123','evelina','papalexiou','6989864222','evelina.papal@gmail.com','USER',NULL,NULL),(76,'tselepi.margarita','tselepi1','Margarita','Tselepi','6977764617','tselepi.margarita@gmail.com','USER',NULL,NULL),(77,'laios','laios','stavros','laios','1111111111','fake@email.com','USER',NULL,'116551123624609792912'),(78,'tselepi','tselepi','margarita','tselepi','1111111111','fake@email.com','USER',NULL,'104328160060898028128');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-06 19:20:10
