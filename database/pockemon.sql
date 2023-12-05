-- Generated using dbmodeller.net
--

CREATE TABLE `pockemon_entrenador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pockemon_id` int(11) NOT NULL,
  `entrenador_id` int(11) NOT NULL,
  `activo` int(11) NOT NULL DEFAULT 1,
  `energia` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;


CREATE TABLE `entrenador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `edad` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


CREATE TABLE `gimnasio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_medalla` varchar(255) NOT NULL,
  `nombre_gimnasio` varchar(255) NOT NULL,
  `alias_medalla` varchar(255) NOT NULL,
  `nombre_entrenador` varchar(255) NOT NULL,
  `tipo_pockemon` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


CREATE TABLE `pockemon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `energia` int(11) NOT NULL,
  `debilidad` varchar(255) NOT NULL,
  `ataque` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


CREATE TABLE `medalla_entrenador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `medalla_id` int(11) NOT NULL,
  `entrenador_id` int(11) NOT NULL,
  `activo` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


ALTER TABLE `pockemon_entrenador` ADD CONSTRAINT `pockemon_fk0` FOREIGN KEY (`pockemon_id`) REFERENCES `pockemon`(`id`);

ALTER TABLE `pockemon_entrenador` ADD CONSTRAINT `pockemon_fk1` FOREIGN KEY (`entrenador_id`) REFERENCES `entrenador`(`id`);
ALTER TABLE `medalla_entrenador` ADD CONSTRAINT `medalla_fk0` FOREIGN KEY (`medalla_id`) REFERENCES `medalla`(`id`);

ALTER TABLE `medalla_entrenador` ADD CONSTRAINT `medalla_fk1` FOREIGN KEY (`entrenador_id`) REFERENCES `entrenador`(`id`);

INSERT INTO pockemon (nombre, tipo, energia, debilidad, ataque) VALUES
('Geodude', 'Roca', 72, '{"tipo":"Agua", "debilidad":10}', '{"nombre":"Roca Afilada", "potencia":20}'),
('Onix', 'Roca', 65, '{"tipo":"Agua", "debilidad":10}', '{"nombre":"Terremoto", "potencia":20}'),
('Rhyhorn', 'Roca', 85, '{"tipo":"Agua", "debilidad":10}', '{"nombre":"Avalancha", "potencia":20}'),
('Staryu', 'Agua', 78, '{"tipo":"Eléctrico", "debilidad":10}', '{"nombre":"Hidrobomba", "potencia":20}'),
('Horsea', 'Agua', 59, '{"tipo":"Eléctrico", "debilidad":10}', '{"nombre":"Pistola Agua", "potencia":20}'),
('Psyduck', 'Agua', 64, '{"tipo":"Eléctrico", "debilidad":10}', '{"nombre":"Surf", "potencia":20}'),
('Pikachu', 'Eléctrico', 77, '{"tipo":"Tierra", "debilidad":10}', '{"nombre":"Impactrueno", "potencia":20}'),
('Magnemite', 'Eléctrico', 88, '{"tipo":"Tierra", "debilidad":10}', '{"nombre":"Rayo", "potencia":20}'),
('Voltorb', 'Eléctrico', 69, '{"tipo":"Tierra", "debilidad":10}', '{"nombre":"Chispa", "potencia":20}'),
('Oddish', 'Planta', 53, '{"tipo":"Fuego", "debilidad":10}', '{"nombre":"Hoja Afilada", "potencia":20}'),
('Bellsprout', 'Planta', 76, '{"tipo":"Fuego", "debilidad":10}', '{"nombre":"Látigo Cepa", "potencia":20}'),
('Exeggcute', 'Planta', 82, '{"tipo":"Fuego", "debilidad":10}', '{"nombre":"Drenadoras", "potencia":20}'),
('Golbat', 'Veneno', 68, '{"tipo":"Planta", "debilidad":10}', '{"nombre":"Tóxico", "potencia":20}'),
('Nidorina', 'Veneno', 74, '{"tipo":"Planta", "debilidad":10}', '{"nombre":"Picotazo Veneno", "potencia":20}'),
('Zubat', 'Veneno', 61, '{"tipo":"Planta", "debilidad":10}', '{"nombre":"Ataque Ala", "potencia":20}'),
('Abra', 'Psíquico', 80, '{"tipo":"Eléctrico", "debilidad":10}', '{"nombre":"Confusión", "potencia":20}'),
('Kadabra', 'Psíquico', 92, '{"tipo":"Eléctrico", "debilidad":10}', '{"nombre":"Psíquico", "potencia":20}'),
('Drowzee', 'Psíquico', 67, '{"tipo":"Eléctrico", "debilidad":10}', '{"nombre":"Hipnosis", "potencia":20}'),
('Vulpix', 'Fuego', 90, '{"tipo":"Agua", "debilidad":10}', '{"nombre":"Lanzallamas", "potencia":20}'),
('Charmander', 'Fuego', 75, '{"tipo":"Agua", "debilidad":10}', '{"nombre":"Ascuas", "potencia":20}'),
('Growlithe', 'Fuego', 84, '{"tipo":"Agua", "debilidad":10}', '{"nombre":"Fuego Fatuo", "potencia":20}'),
('Machop', 'Lucha', 70, '{"tipo":"Veneno", "debilidad":10}', '{"nombre":"Golpe Karate", "potencia":20}'),
('Mankey', 'Lucha', 65, '{"tipo":"Veneno", "debilidad":10}', '{"nombre":"Puñetazo", "potencia":20}'),
('Primeape', 'Lucha', 85, '{"tipo":"Veneno", "debilidad":10}', '{"nombre":"Golpe", "potencia":20}');

INSERT INTO gimnasio (nombre_medalla, alias_medalla, nombre_gimnasio, nombre_entrenador, tipo_pockemon) VALUES
('Roca', 'Boulder Badge', 'Gimnasio de Plateada','Brock','Roca'),
('Cascada', 'Cascade Badge', 'Gimnasio de Celeste', 'Misty','Agua'),
('Trueno', 'Thunder Badge', 'Gimnasio de Carmín', 'Teniente Surge','Eléctrico'),
('Arcoíris', 'Rainbow Badge', 'Gimnasio de Azulona','Erika','Planta'),
('Alma', 'Soul Badge', 'Gimnasio de Fucsia','Koga','Veneno'),
('Pantano', 'Marsh Badge', 'Gimnasio de Azafrán','Sabrina','Psíquico'),
('Volcán', 'Volcano Badge', 'Gimnasio de Canela','Blaine','Fuego'),
('Tierra', 'Earth Badge', 'Gimnasio de Verde','Giovanni','Tierra');