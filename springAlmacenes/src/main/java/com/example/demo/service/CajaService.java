package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICajaDAO;
import com.example.demo.dto.Caja;

@Service
public class CajaService implements ICajaService{

	@Autowired(required = true)
	ICajaDAO iCajaDAO;	
	
	@Override
	public List<Caja> listAll() {
		return iCajaDAO.findAll();
	}

	@Override
	public Caja add(Caja caja) {
		return iCajaDAO.save(caja);
	}

	@Override
	public Caja getOne(String num_referencia) {
		return iCajaDAO.findById(num_referencia).get();
	}

	@Override
	public Caja update(Caja caja) {
		return iCajaDAO.save(caja);
	}

	@Override
	public void eliminar(String num_referencia) {
		iCajaDAO.deleteById(num_referencia);
	}

}
