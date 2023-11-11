create table departamento(
	codigo int auto_increment,
	nombre varchar(100),
	presupuesto int,
	primary key (codigo)
);

create table empelados(
	dni varchar(8),
	nombre varchar(100),
	apellidos varchar(255),
	departamento int not null,
	primary key (dni),
	foreign key (departamento) references departamento(codigo)
	on delete no action on update cascade
);