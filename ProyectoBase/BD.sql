create database if not exists EscuelaWeb;
use EscuelaWeb;

drop table if exists Carreras;
create table Carreras(
	idCarrera int not null auto_increment primary key, 
	nombreCarrera nvarchar(70) not null,
    descripcionCarrera nvarchar(500) not null
);

drop table if exists Alumnos;
create table Alumnos(
	idAlumno int not null auto_increment primary key,
    nombreAlumno nvarchar(70) not null,
    paternoAlumno nvarchar(70) not null,
    maternoAlumno nvarchar(70) not null,
    emailAlumno nvarchar(70) not null,
    idCarrera int not null
)

select * from Alumnos;
