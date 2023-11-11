package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Pelicula;

public interface IPeliculaService {

	// Metodos del CRUD
	public List<Pelicula> listAll();

	public Pelicula add(Pelicula pelicula);

	public Pelicula getOne(int codigo);

	public Pelicula update(Pelicula pelicula);

	public void eliminar(int codigo);
		
}
