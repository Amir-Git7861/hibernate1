DROP DATABASE cmsDB;


CREATE DATABASE cmsDB;

USE cmsDB;

CREATE TABLE Contacts(
	cid int primary key,
	cname varchar(20) not null,
	dob date not null,
	mobile char(10) unique
);

INSERT INTO Contacts VALUES
	(1,'Amir','1985-06-11',9948016004),
	(2,'Sohel','1986-05-11',9948016504),
	(3,'Sumit','1987-03-11',9949016004);
	