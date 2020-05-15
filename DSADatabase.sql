DROP DATABASE IF EXISTS DSAGame;
CREATE DATABASE DSAGame;

USE DSAGame;


CREATE TABLE User (
					id VARCHAR(255),
					name VARCHAR(255) NOT NULL,
					password VARCHAR(255) NOT NULL,
					email VARCHAR(255) NOT NULL,
					exp INT,
					PRIMARY KEY (id)
					);

CREATE TABLE Item (
					id VARCHAR(255),
					name VARCHAR(255),
					PRIMARY KEY (id)
					);

CREATE TABLE npc (
						id VARCHAR(255),
						name VARCHAR(255),
						hp INT,
						class VARCHAR(255),
						PRIMARY KEY (id)
						);

CREATE TABLE Level ( 
						id VARCHAR(255),
						matrixMap VARCHAR(4096),
						PRIMARY KEY(id)
					);

CREATE TABLE Game (
					id VARCHAR(255),
					idUser VARCHAR(255),
					score INT,
					startDate VARCHAR(255),
					endDate VARCHAR(255),
					idLevel VARCHAR(255),
					PRIMARY KEY (id),
					FOREIGN KEY (idUser) REFERENCES User(id),
					FOREIGN KEY (idLevel) REFERENCES Level(id)
					);

CREATE TABLE Level_Item (
							idItem VARCHAR(255),
							idLevel VARCHAR(255),

							FOREIGN KEY (idItem) REFERENCES Item(id),
							FOREIGN KEY (idLevel) REFERENCES Level(id)

);

CREATE TABLE Level_npc (

							idLevel VARCHAR(255),
							idNPC VARCHAR (255),

							FOREIGN KEY (idLevel) REFERENCES Level(id),
							FOREIGN KEY (idNPC) REFERENCES npc(id)

);

CREATE TABLE Token (
                            id VARCHAR(255),
                            idUser VARCHAR(255),
                            admin VARCHAR(6),
                            PRIMARY KEY (id),
                            FOREIGN KEY (idUser) REFERENCES User(id)
)

