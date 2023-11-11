package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Articulo;

public interface IArticuloService {
	
	//Metodos del CRUD
	public List<Articulo> listAll(); //Listar All 
	
	public Articulo add(Articulo articulo);	//Guarda un Curso CREATE
	
	public Articulo getOne(int id); //Leer datos de un Curso READ
	
	public Articulo update(Articulo articulo); //Actualiza datos del Curso UPDATE
	
	public void eliminar(int id);// Elimina el Curso DELETE
}
