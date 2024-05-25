
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `nombre_usuario` varchar(255) NOT NULL,
                           `contrasena` varchar(255) NOT NULL,
                           `contrasena_anterior` varchar(255) DEFAULT NULL,
                           `ultima_conexion` datetime DEFAULT NULL,
                           `fecha_creacion` datetime DEFAULT CURRENT_TIMESTAMP,
                           `fecha_modificacion` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                           `active` tinyint(1) DEFAULT NULL,
                           `primer_nombre` varchar(255) DEFAULT NULL,
                           `apellido_pat` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `usuario` WRITE;
INSERT INTO `usuario` VALUES (1,'luisdiaz','$2a$10$Uv95YxVmPZj.X4IkmA1vCeh33R8GVHlv8r3sNnivStY9Wz9dB9hJO',NULL,NULL,'2024-04-01 00:28:10','2024-04-01 00:40:10',1,'Luis','Diaz');
UNLOCK TABLES;
