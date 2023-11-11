package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Fabricante;

public interface IFabricanteService {
	//Metodos del CRUD
		public List<Fabricante> listAll(); //Listar All 
		
		public Fabricante add(Fabricante fabricante);	//Guarda un Curso CREATE
		
		public Fabricante getOne(int id); //Leer datos de un Curso READ
		
		public Fabricante update(Fabricante fabricante); //Actualiza datos del Curso UPDATE
		
		public void eliminar(int id);// Elimina el Curso DELETE
}
