create database if not exists EscuelaWeb;
use EscuelaWeb;

drop table if exists Carreras;
create table Carreras(
	idCarrera int not null auto_increment primary key, 
	nombreCarrera nvarchar(70) not null,
    descripcionCarrera nvarchar(100) not null
);


select * from Carreras;
