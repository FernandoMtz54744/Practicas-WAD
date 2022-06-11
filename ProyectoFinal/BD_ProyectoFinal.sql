create database PF_WAD;
use PF_WAD;

create table Usuario(
	id int auto_increment primary key not null,
    usuario varchar(50) not null, 
    pass varchar(50) not null,
    correo varchar(50) not null
);

select * from Usuario;	