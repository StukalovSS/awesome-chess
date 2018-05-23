USE [master]
GO

CREATE DATABASE [�hess] ON
( NAME = N'�hess', 
  FILENAME = N'�:\ChessDB\�hess.mdf' ,
  SIZE = 3072KB ,
  MAXSIZE = UNLIMITED,
  FILEGROWTH = 1024KB )
LOG ON 
( NAME = N'�hess_log',
  FILENAME = N'�:\ChessDB\�hess_log.ldf' ,
  SIZE = 1024KB ,
  MAXSIZE = 2048GB ,
  FILEGROWTH = 10%)
GO

USE [�hess]
GO

CREATE TABLE UserData(
	id int PRIMARY KEY IDENTITY(1,1) NOT NULL,
	nickname varchar(20) UNIQUE NOT NULL,
	[password] varchar(20) NOT NULL,
 )
GO

USE [�hess]
GO

CREATE TABLE UserScores(
	id int PRIMARY KEY IDENTITY(1,1) NOT NULL,
	idUser int NOT NULL,
	numberOfWin int NULL CHECK (numberOfWin >= 0),
	numberOfLosses int NULL CHECK (numberOfLosses >= 0),
	numberInDraw int NULL CHECK (numberInDraw >= 0),
  CONSTRAINT has FOREIGN KEY (idUser) REFERENCES UserData(id),
)
GO

