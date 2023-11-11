package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Empleado;
import com.example.demo.services.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired(required=true)
	EmpleadoService empleadoService;
	
	@GetMapping("/all")
	public List<Empleado> listarEmpledos(){
		return empleadoService.listAll();
	}
	
	@PostMapping("/add")
	public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
		return empleadoService.add(empleado);
	}
	
	@GetMapping("/{dni}")
	public Empleado listarUnEmpleado(@PathVariable(name="dni") String dni) {
		return empleadoService.getOne(dni);
	}
	
	@PutMapping("/update/{dni}")
	public Empleado actualizarEmpleado(@PathVariable(name="dni")String dni,@RequestBody Empleado empleado) {
		
		Empleado preEmpleado = new Empleado();
		Empleado newEmpleado = new Empleado();
		
		preEmpleado= empleadoService.getOne(dni);
		
		preEmpleado.setNombre(empleado.getNombre());
		preEmpleado.setApellidos(empleado.getApellidos());
		preEmpleado.setDepartamento(empleado.getDepartamento());
		
		newEmpleado = empleadoService.update(preEmpleado);
		
		return newEmpleado;
	}
	
	@DeleteMapping("/delete/{id}")
	public void eliminarEmpleado(@PathVariable(name="id")String dni) {
		empleadoService.eliminar(dni);
	}
}
