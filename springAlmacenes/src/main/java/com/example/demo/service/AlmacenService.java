package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAlmacenDAO;
import com.example.demo.dto.Almacen;

@Service
public class AlmacenService implements IAlmacenService{
	
	@Autowired(required = true)
	IAlmacenDAO iAlmacenDAO;
	
	@Override
	public List<Almacen> listAll() {
		return iAlmacenDAO.findAll();
	}

	@Override
	public Almacen add(Almacen almacen) {
		return iAlmacenDAO.save(almacen);
	}

	@Override
	public Almacen getOne(int codigo) {
		return iAlmacenDAO.findById(codigo).get();
	}

	@Override
	public Almacen update(Almacen almacen) {
		return iAlmacenDAO.save(almacen);
	}

	@Override
	public void eliminar(int codigo) {
		iAlmacenDAO.deleteById(codigo);
	}

}
