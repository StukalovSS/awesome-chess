USE [master]
GO

CREATE DATABASE [Ñhess] ON
( NAME = N'Ñhess', 
  FILENAME = N'ñ:\ChessDB\Ñhess.mdf' ,
  SIZE = 3072KB ,
  MAXSIZE = UNLIMITED,
  FILEGROWTH = 1024KB )
LOG ON 
( NAME = N'Ñhess_log',
  FILENAME = N'ñ:\ChessDB\Ñhess_log.ldf' ,
  SIZE = 1024KB ,
  MAXSIZE = 2048GB ,
  FILEGROWTH = 10%)
GO

USE [Ñhess]
GO

CREATE TABLE UserData(
	id int PRIMARY KEY IDENTITY(1,1) NOT NULL,
	nickname varchar(20) UNIQUE NOT NULL,
	[password] varchar(20) NOT NULL,
 )
GO

USE [Ñhess]
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

