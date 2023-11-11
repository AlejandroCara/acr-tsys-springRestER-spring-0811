create table almacen(
	codigo int auto_increment,
	lugar varchar(100) not null,
	capacidad int not null,
	primary key (codigo)
);

create table caja(
	num_referencia char(5),
	contenido varchar(100),
	valor int,
	almacen int not null,
	primary key (num_referencia),
	foreign key (almacen) references almacen(codigo)
	on delete cascade on update cascade
);
