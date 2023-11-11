package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDepartamentoDAO;
import com.example.demo.dto.Departamento;

@Service
public class DepartamentoService implements IDepartamentoService{
	
	@Autowired(required=true)
	IDepartamentoDAO iDepartamentoDAO;

	@Override
	public List<Departamento> listAll() {
		return iDepartamentoDAO.findAll();
	}

	@Override
	public Departamento add(Departamento departamento) {
		return iDepartamentoDAO.save(departamento);
	}

	@Override
	public Departamento getOne(int codigo) {
		return iDepartamentoDAO.findById(codigo).get();
	}

	@Override
	public Departamento update(Departamento departamento) {
		return iDepartamentoDAO.save(departamento);
	}

	@Override
	public void eliminar(int codigo) {
		iDepartamentoDAO.deleteById(codigo);
	}


}
