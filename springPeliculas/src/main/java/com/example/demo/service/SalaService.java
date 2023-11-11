package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ISalaDAO;
import com.example.demo.dto.Sala;

@Service
public class SalaService implements ISalaService{
	
	@Autowired(required = true)
	ISalaDAO iSalaDAO;
	
	@Override
	public List<Sala> listAll() {
		return iSalaDAO.findAll();
	}

	@Override
	public Sala add(Sala sala) {
		return iSalaDAO.save(sala);
	}

	@Override
	public Sala getOne(int codigo) {
		return iSalaDAO.findById(codigo).get();
	}

	@Override
	public Sala update(Sala sala) {
		return iSalaDAO.save(sala);
	}

	@Override
	public void eliminar(int codigo) {
		iSalaDAO.deleteById(codigo);
	}

}
