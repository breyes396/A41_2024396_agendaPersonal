drop database if exists agenda_DB;
create database agenda_DB;
use agenda_DB;

create table Usuarios(
	codigo_usuario integer auto_increment,
    usuario varchar(64),
    telefono varchar(64),
    correo varchar(64),
    pass varchar(64),
    constraint pk_usuario primary key (codigo_usuario)
);

create table Contactos(
	codigo_contacto integer auto_increment,
    nombre varchar(64),
    telefono varchar(16),
    correo varchar(64),
    codigo_usuario integer,
    constraint pk_contacto primary key (codigo_contacto),
    constraint fk_contactos_usuarios foreign key (codigo_usuario)
		references Usuarios(codigo_usuario)
);

select * from contactos;
select * from usuarios;