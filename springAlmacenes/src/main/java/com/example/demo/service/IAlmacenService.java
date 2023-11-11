package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Almacen;

public interface IAlmacenService {

	// Metodos del CRUD
	public List<Almacen> listAll();

	public Almacen add(Almacen almacen);

	public Almacen getOne(int codigo);

	public Almacen update(Almacen almacen);

	public void eliminar(int codigo);
}
