CREATE DATABASE `sisemp`;

CREATE TABLE `sisemp`.`departamentos` (
`id` int NOT NULL AUTO_INCREMENT,
`codigo` varchar(50) DEFAULT NULL,
`nombre` varchar(50) DEFAULT NULL,
PRIMARY KEY (`id`)
);
INSERT INTO `sisemp`.`departamentos` (codigo,nombre) VALUES
('TI','Tecnologica de la Informacion'),
('COM','Comercial'),
('RRHH','Recursos Humanos'),
('FIN','Finanzas'),
('VENT','Ventas'),
('DES','Desarrollo'),
('CAL','Calidad'),
('SOP','Soporte Técnico'),
('LOG','Logística'),
('ID','Investigación y Desarrollo');


CREATE TABLE `sisemp`.`empleado` (
`id` int NOT NULL AUTO_INCREMENT,
`codigo_empleado` varchar(150) NOT NULL,
`nombres` varchar(250) NOT NULL,
`apellido_pat` varchar(250) NOT NULL,
`apellido_mat` varchar(250) NOT NULL,
`id_departamento` int NOT NULL,
`correo` varchar(250) NOT NULL,
`salario` double NOT NULL,
`fecha_nacimiento` date NOT NULL,
`activo` tinyint(1) NOT NULL DEFAULT '1',
`fecha_creacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
`fecha_modificacion` timestamp NULL DEFAULT NULL,
PRIMARY KEY (`id`),
UNIQUE KEY `codigo_empleado` (`codigo_empleado`),
UNIQUE KEY `correo` (`correo`),
KEY `id_departamento` (`id_departamento`),
CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`id_departamento`) REFERENCES `departamentos` (`id`)
);

INSERT INTO `sisemp`.`empleado` (codigo_empleado,nombres,apellido_pat,apellido_mat,id_departamento,correo,salario,fecha_nacimiento,activo,fecha_creacion,fecha_modificacion) VALUES
('EMP001','José','García','Hernández',1,'jose.garcia@isil.pe',50000.0,'1990-05-15',1,'2024-04-30 22:11:50',NULL),
('EMP002','María','Rodríguez','López',2,'maria.rodriguez@isil.pe',55000.0,'1992-08-20',1,'2024-04-30 22:11:50',NULL),
('EMP003','Carlos','Martínez','González',3,'carlos.martinez@isil.pe',60000.0,'1985-03-10',1,'2024-04-30 22:11:50',NULL),
('EMP004','Laura','Hernández','Pérez',4,'laura.hernandez@isil.pe',48000.0,'1988-11-25',1,'2024-04-30 22:11:50',NULL),
('EMP005','Ana','Sánchez','Gómez',5,'ana.sanchez@isil.pe',52000.0,'1993-09-05',1,'2024-04-30 22:11:50',NULL),
('EMP0006','Eduardo','Zuniga','Santillan',1,'eduzsantillan@gmail.com',7500.0,'1992-09-05',1,'2024-05-08 11:36:37',NULL),
('EMP464879','Willie','Colon','',4,'willie@colon.com',8000.0,'1948-10-23',1,'2024-05-24 22:26:44',NULL),
('EMP709160','Rosa','Elvis','Martinez',1,'rosa@martins.pe',7000.0,'1997-05-30',1,'2024-05-24 23:00:35',NULL),
('EMP844715','Keanu','Reeves','Smith',1,'keanu.reeves@example.com',8000.0,'1964-09-02',1,'2024-05-24 23:12:27',NULL),
('EMP159169','Lionel','Messi','Cuccittini',2,'lionel.messi@example.com',9000.0,'1987-06-24',1,'2024-05-24 23:12:27',NULL),
('EMP861699','Diego','Maradona','Franco',3,'diego.maradona@example.com',8500.0,'1960-10-30',1,'2024-05-24 23:12:27',NULL),
('EMP130987','Bill','Gates','Trey',4,'bill.gates@example.com',9500.0,'1955-10-28',1,'2024-05-24 23:12:27',NULL),
('EMP669841','Linus','Torvalds','Lin',5,'linus.torvalds@example.com',8000.0,'1969-12-28',1,'2024-05-24 23:12:27',NULL),
('EMP233769','Elon','Musk','Reeve',9,'elon.musk@example.com',9900.0,'1971-06-28',1,'2024-05-24 23:12:27',NULL),
('EMP725647','Steve','Jobs','Paul',4,'steve.jobs@example.com',9600.0,'1955-02-24',1,'2024-05-24 23:12:27',NULL),
('EMP879522','Mark','Zuckerberg','Elliot',5,'mark.zuckerberg@example.com',8800.0,'1984-05-14',1,'2024-05-24 23:12:27',NULL),
('EMP320667','Jeff','Bezos','Jorgensen',6,'jeff.bezos@example.com',9700.0,'1964-01-12',1,'2024-05-24 23:12:27',NULL),
('EMP664771','Sundar','Pichai','Rajan',7,'sundar.pichai@example.com',9100.0,'1972-06-10',1,'2024-05-24 23:12:27',NULL),
('EMP461853','Satya','Nadella','Prabhu',8,'satya.nadella@example.com',9300.0,'1967-08-19',1,'2024-05-24 23:12:27',NULL),
('EMP214952','Larry','Page','Schmidt',9,'larry.page@example.com',9500.0,'1973-03-26',1,'2024-05-24 23:12:27',NULL),
('EMP489203','Sergey','Brin','Mikhaylovich',1,'sergey.brin@example.com',9400.0,'1973-08-21',1,'2024-05-24 23:12:27',NULL),
('EMP801158','Tim','Berners-Lee','Tim',2,'tim.berners-lee@example.com',9200.0,'1955-06-08',1,'2024-05-24 23:12:27',NULL);


CREATE TABLE `sisemp`.`roles` (
`id` int NOT NULL AUTO_INCREMENT,
`codigo` varchar(50) DEFAULT NULL,
`nombre` varchar(50) DEFAULT NULL,
PRIMARY KEY (`id`)
);

INSERT INTO `sisemp`.`roles` (codigo,nombre) VALUES
('ADMIN','Administrador del sistema'),
('USER','Usuario del sistema');


-- sisemp.usuario definition

CREATE TABLE `sisemp`.`usuario` (
`id` int NOT NULL AUTO_INCREMENT,
`nombre_usuario` varchar(255) NOT NULL,
`contrasena` varchar(255) DEFAULT NULL,
`contrasena_anterior` varchar(255) DEFAULT NULL,
`ultima_conexion` datetime DEFAULT NULL,
`fecha_creacion` datetime DEFAULT CURRENT_TIMESTAMP,
`fecha_modificacion` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`active` tinyint(1) DEFAULT NULL,
`primer_nombre` varchar(255) DEFAULT NULL,
`apellido_pat` varchar(255) DEFAULT NULL,
`foto_perfil` text,
`id_rol` int DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `fk_roles_usuario_id` (`id_rol`),
CONSTRAINT `fk_roles_usuario_id` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id`)
);

INSERT INTO `sisemp`.`usuario` (nombre_usuario,contrasena,contrasena_anterior,ultima_conexion,fecha_creacion,fecha_modificacion,active,primer_nombre,apellido_pat,foto_perfil,id_rol) VALUES
('luisdiaz','1',NULL,NULL,'2024-04-01 00:28:10','2024-04-30 22:23:24',1,'Luis','Diaz','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfAa8jqIy27-mEC9jJRTSQuEMDi_K1seaXrf8am-Cp0S9JVzjk',1),
('vinijr','1',NULL,NULL,'2024-04-30 23:16:42','2024-05-01 11:44:18',1,'Vinicious','Jr','https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcSdRoRs9TpZXYCR5PhYSArqFVoeYiG429QSKMRvLzu5Nx8yqpmBPhKb6WxBw6WICEhtlr0RaTmlmtEnoj0',2);