package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Empleado;

public interface IEmpleadoService {
	
	//Metodos del CRUD
	public List<Empleado> listAll();
	
	public Empleado add(Empleado empleado);	
	
	public Empleado getOne(String dni);
	
	public Empleado update(Empleado empleado); 
	
	public void eliminar(String dni);
}
