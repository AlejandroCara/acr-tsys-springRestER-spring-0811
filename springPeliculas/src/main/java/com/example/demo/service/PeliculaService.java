package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPeliculaDAO;
import com.example.demo.dto.Pelicula;

@Service
public class PeliculaService implements IPeliculaService{

	@Autowired(required = true)
	IPeliculaDAO iPeliculaDAO;

	@Override
	public List<Pelicula> listAll() {
		return iPeliculaDAO.findAll();
	}

	@Override
	public Pelicula add(Pelicula pelicula) {
		return iPeliculaDAO.save(pelicula);
	}

	@Override
	public Pelicula getOne(int codigo) {
		return iPeliculaDAO.findById(codigo).get();
	}

	@Override
	public Pelicula update(Pelicula pelicula) {
		return iPeliculaDAO.save(pelicula);
	}

	@Override
	public void eliminar(int codigo) {
		iPeliculaDAO.deleteById(codigo);
	}
}
