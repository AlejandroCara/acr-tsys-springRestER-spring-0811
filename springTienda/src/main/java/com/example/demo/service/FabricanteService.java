package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IFabricanteDAO;
import com.example.demo.dto.Fabricante;
@Service	
public class FabricanteService implements IFabricanteService{

	@Autowired
	IFabricanteDAO iFabricanteDAO;

	@Override
	public List<Fabricante> listAll() {
		return iFabricanteDAO.findAll();
	}

	@Override
	public Fabricante add(Fabricante fabricante) {
		return iFabricanteDAO.save(fabricante);
	}

	@Override
	public Fabricante getOne(int codigo) {
		return iFabricanteDAO.findById(codigo).get();
	}

	@Override
	public Fabricante update(Fabricante fabricante) {
		return iFabricanteDAO.save(fabricante);
	}

	@Override
	public void eliminar(int codigo) {
		iFabricanteDAO.deleteById(codigo);
	}

}
