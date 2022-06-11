create database ProyectoBase6;
use ProyectoBase6;

create table alumno(
	id int auto_increment not null primary key, 
    nombreAlumno varchar(50) not null, 
    paternoAlumno varchar(50) not null, 
    maternoAlumno varchar(50) not null, 
    emailAlumno varchar(100) not null,
    fechaCreacion timestamp not null
);

insert into alumno(nombreAlumno, paternoAlumno, maternoAlumno, emailAlumno, fechaCreacion) 
values('Esmeralda', 'Godinez', 'Montero', 'esmegod19@gmail.com', CURRENT_TIME());
|
select * from alumno;
