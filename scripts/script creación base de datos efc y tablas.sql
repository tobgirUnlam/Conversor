IF NOT  EXISTS(SELECT * FROM sys.databases WHERE name = 'efc')
	CREATE DATABASE efc
GO

USE efc
GO

DROP TABLE IF EXISTS  alumnos;
DROP TABLE IF EXISTS sexos;

CREATE TABLE  sexos  (
   ID  char(1) NOT NULL,
   DESCRIPCION  varchar(20) NOT NULL,
  PRIMARY KEY ( ID )
)

INSERT INTO sexos(ID,DESCRIPCION) 
VALUES('F','Femenino'),('M','Masculino'),('N','No binario')

CREATE TABLE  alumnos  (
   DNI  int NOT NULL,
   NOMBRE  nvarchar(30) NOT NULL,
   APELLIDO  nvarchar(20) NOT NULL,
   FECHA_NACIMIENTO  date NOT NULL DEFAULT '2000-01-01',
   FECHA_INGRESO  date NOT NULL DEFAULT '2000-01-01',
   MATERIAS_APROBADAS INT NOT NULL DEFAULT 0,
   SEXO  char(1) NOT NULL,
   PROMEDIO  decimal(4,2) NOT NULL,
   ACTIVO bit NOT NULL,
  PRIMARY KEY ( DNI ),
  CONSTRAINT FK_SEXO FOREIGN KEY(SEXO) References SEXOS(ID)  
)
--Verificaci�n
select * from sexos
select * from alumnos