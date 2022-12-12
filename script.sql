CREATE SCHEMA challenge_ibm;

CREATE TABLE `challenge_ibm`.`proveedores`(
  `proveedor_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `fecha_de_alta` datetime NOT NULL,
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`proveedor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO
`challenge_ibm`.`proveedores`
(`proveedor_id`,`nombre`,`fecha_de_alta`,`id_cliente`)
VALUES
(1,"Quilmes","2022-11-12 00:00:00",1),
(2,"Pepsi","2022-11-12 00:00:00",5),
(3,"Ford","2022-11-12 00:00:00",1),
(4,"Renault","2022-11-12 00:00:00",5),
(5,"Sony","2022-11-12 00:00:00",5),
(6,"Yamaha","2022-11-12 00:00:00",1),
(7,"Honda","2022-11-12 00:00:00",2),
(8,"Lenovo","2022-11-12 00:00:00",2),
(9,"Apple","2022-11-12 00:00:00",2),
(10,"Jbl","2022-11-12 00:00:00",2),
(11,"Sennheiser","2022-11-12 00:00:00",2),
(12,"RedBull","2022-11-12 00:00:00",3)
(13,"Hacendado","2022-11-12 00:00:00",3)
(14,"Cabrinha","2022-11-12 00:00:00",3);
