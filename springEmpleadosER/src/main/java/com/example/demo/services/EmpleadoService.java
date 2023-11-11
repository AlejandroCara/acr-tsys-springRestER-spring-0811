package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEmpleadoDAO;
import com.example.demo.dto.Empleado;

@Service
public class EmpleadoService implements IEmpleadoService{
	
	@Autowired(required=true)
	IEmpleadoDAO iEmpleadoDAO;

	@Override
	public List<Empleado> listAll() {
		return iEmpleadoDAO.findAll();
	}

	@Override
	public Empleado add(Empleado empleado) {
		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public Empleado getOne(String dni) {
		return iEmpleadoDAO.findById(dni).get();
	}

	@Override
	public Empleado update(Empleado empleado) {
		return iEmpleadoDAO.save(empleado);
	}

	@Override
	public void eliminar(String dni) {
		iEmpleadoDAO.deleteById(dni);
	}

}
