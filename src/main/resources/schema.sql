CREATE TABLE CHARA AS SELECT * FROM CSVREAD('src/main/resources/chara.csv');
CREATE TABLE EQUIP AS SELECT * FROM CSVREAD('src/main/resources/equip.csv');
CREATE TABLE [EVENT] AS SELECT * FROM CSVREAD('src/main/resources/event.csv');
CREATE TABLE SUPPORT AS SELECT * FROM CSVREAD('src/main/resources/support.csv');