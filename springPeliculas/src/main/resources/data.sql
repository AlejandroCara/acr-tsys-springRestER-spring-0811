create table peliculas(
	codigo int auto_increment,
	nombre varchar(100) not null,
	calificacion_edad int not null,
    primary key (codigo)
);

create table sala(
	codigo int auto_increment,
	nombre varchar(100) not null,
	pelicula int,
	primary key (codigo),
	foreign key (pelicula) references peliculas(codigo)
	on delete cascade on update cascade
);