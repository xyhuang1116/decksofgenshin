CREATE TABLE CHARA (
 id VARCHAR(55) NOT NULL,
 code_name VARCHAR(55),
 name VARCHAR(55),
 hp INT,
 element ENUM('CRYO', 'HYDRO', 'PYRO', 'ELECTRO', 'ANEMO', 'GEO', 'DENDRO'),
 weapon ENUM('Bow', 'Sword', 'Claymore', 'Catalyst', 'Pole', 'Other Weapons'),
 nation_or_camp ENUM('MONDSTADT', 'LIYUE', 'INAZUMA', 'SUMERU', 'FATUI', 'HILICHURL', 'MONSTER'),
 desc VARCHAR(255),
 PRIMARY KEY (id)
) AS SELECT * FROM CSVREAD('src/main/resources/chara.csv');
-- CREATE TABLE EQUIP AS SELECT * FROM CSVREAD('src/main/resources/equip.csv');
-- CREATE TABLE EVENT AS SELECT * FROM CSVREAD('src/main/resources/event.csv');
-- CREATE TABLE SUPPORT AS SELECT * FROM CSVREAD('src/main/resources/support.csv');