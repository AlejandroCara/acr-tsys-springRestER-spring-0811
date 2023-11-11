package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Sala;

public interface ISalaService {
	
	// Metodos del CRUD
	public List<Sala> listAll();

	public Sala add(Sala sala);

	public Sala getOne(int codigo);

	public Sala update(Sala sala);

	public void eliminar(int codigo);
}
