drop database if exists agenda_DB;
create database agenda_DB;
use agenda_DB;

create table Contactos(
	codigo_contacto integer auto_increment,
    nombre varchar(64),
    telefono varchar(16),
    correo varchar(64),
    constraint pk_contacto primary key (codigo_contacto)
);

select * from contactos;