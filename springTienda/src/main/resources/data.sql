create table fabricante(
	codigo int auto_increment,
	nombre varchar(100),
	primary key (codigo)
);

create table articulo(
	codigo int auto_increment,
	nombre varchar(100),
    precio int,
	fabricante int,
	primary key (codigo),
	foreign key (fabricante) references fabricante(codigo)
	on delete cascade on update cascade
);
/*
insert into fabricante(nombre) values ('Alfonso'),
                                      ('Lucía');

insert into articulo (nombre, precio, fabricante) values ('Razer naga', 120, 1),
                                                        ('Razer Kraken', 220, 1),
                                                        ('Razer siren', 330, 1),
                                                        ('Steel Series actis pro 7', 200, 2),
                                                        ('Steel Series mouse', 34, 2);*/
