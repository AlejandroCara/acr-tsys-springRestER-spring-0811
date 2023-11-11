package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Caja;

public interface ICajaService {
	
	// Metodos del CRUD
	public List<Caja> listAll();

	public Caja add(Caja caja);

	public Caja getOne(String num_referencia);

	public Caja update(Caja caja);

	public void eliminar(String num_referencia);
}
