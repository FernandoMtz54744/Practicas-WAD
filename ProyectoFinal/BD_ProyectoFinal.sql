drop database if exists pf_wad;
create database PF_WAD;
use PF_WAD;

create table Usuario(
	idUsuario int auto_increment primary key not null,
    usuario varchar(50) not null, 
    pass varchar(50) not null,
    correo varchar(50) not null
);

create table Restaurante(
	idRestaurante int auto_increment primary key not null,
    nombre varchar(50) not null,
    correo varchar(50) not null, 
    pass varchar(50) not null, 
    descripcion varchar(100) not null, 
    web varchar(50) not null, 
    horario varchar(50) not null,
    telefono varchar(50) not null
);

create table Categoria(
	idCategoria int auto_increment primary key not null,
    categoria varchar(50) not null
);

create table Platillo(
	idPlatillo int auto_increment primary key not null,
    nombre varchar(50) not null, 
    descripcion varchar(50) not null,
    foto mediumblob,
    nombreFoto varchar(50) not null,
    idRestaurante int not null,
    idCategoria int not null,
    foreign key (idRestaurante) references Restaurante(idRestaurante),
    foreign key (idCategoria) references Categoria(idCategoria)
);

create table Comentario(
	idComentario int auto_increment primary key not null,
    comentario varchar(100) not null,
    idUsuario int not null,
    idPlatillo int not null,
    foreign key (idUsuario) references Usuario(idUsuario),
    foreign key (idPlatillo) references Platillo(idPlatillo) ON DELETE CASCADE
);

insert into Categoria(categoria) values('Rapida');
insert into Categoria(categoria) values('Mexicana');
insert into Categoria(categoria) values('Italiana');
insert into Categoria(categoria) values('Asiatica');
insert into Categoria(categoria) values('Postres');
insert into Categoria(categoria) values('Vegetariana');
insert into Categoria(categoria) values('Brasileña');
insert into Categoria(categoria) values('Carnes');
insert into Categoria(categoria) values('Gourmet');
insert into Categoria(categoria) values('Mariscos');
insert into Categoria(categoria) values('Desayunos');