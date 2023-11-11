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

import com.example.demo.dto.Departamento;
import com.example.demo.services.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

	@Autowired(required=true)
	DepartamentoService departamentoService;
	
	@GetMapping("/all")
	public List<Departamento> listarDepartamentos(){
		return departamentoService.listAll();
	}
	
	@PostMapping("/add")
	public Departamento guardarDepartamento(@RequestBody Departamento departamento) {
		return departamentoService.add(departamento);
	}
	
	@GetMapping("/{codigo}")
	public Departamento listarUnDepartamento(@PathVariable(name="codigo") int codigo) {
		return departamentoService.getOne(codigo);
	}
	
	@PutMapping("/update/{id}")
	public Departamento actualizarDepartamento(@PathVariable(name="id")int codigo,@RequestBody Departamento departamento) {
		
		Departamento preDepartamento = new Departamento();
		Departamento newFabricante = new Departamento();
		
		preDepartamento = departamentoService.getOne(codigo);
		
		preDepartamento.setNombre(departamento.getNombre());
		preDepartamento.setEmpleados(departamento.getEmpleados());
		preDepartamento.setPresupuesto(departamento.getPresupuesto());
		
		newFabricante = departamentoService.update(preDepartamento);
		
		return newFabricante;
	}
	
	@DeleteMapping("/delete/{id}")
	public void eliminarDepartamento(@PathVariable(name="id")int codigo) {
		departamentoService.eliminar(codigo);
	}
}
