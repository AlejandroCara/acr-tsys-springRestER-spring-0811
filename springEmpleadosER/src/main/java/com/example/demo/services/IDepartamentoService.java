package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Departamento;

public interface IDepartamentoService {
	
	//Metodos del CRUD
	public List<Departamento> listAll();
	
	public Departamento add(Departamento departamento);	
	
	public Departamento getOne(int codigo);
	
	public Departamento update(Departamento departamento); 
	
	public void eliminar(int codigo);
}
