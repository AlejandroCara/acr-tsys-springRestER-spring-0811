package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IArticuloDAO;
import com.example.demo.dto.Articulo;

@Service
public class ArticuloService implements IArticuloService{
	
	@Autowired
	IArticuloDAO iArticuloDAO;
	
	@Override
	public List<Articulo> listAll() {
		return iArticuloDAO.findAll();
	}

	@Override
	public Articulo add(Articulo articulo) {
		return iArticuloDAO.save(articulo);
	}

	@Override
	public Articulo getOne(int codigo) {
		return iArticuloDAO.findById(codigo).get();
	}

	@Override
	public Articulo update(Articulo articulo) {
		return iArticuloDAO.save(articulo);
	}

	@Override
	public void eliminar(int codigo) {
		iArticuloDAO.deleteById(codigo);
		
	}


}
