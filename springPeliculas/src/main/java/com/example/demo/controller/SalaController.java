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

import com.example.demo.dto.Sala;
import com.example.demo.service.SalaService;


@RestController
@RequestMapping("/sala")
public class SalaController {
	
	@Autowired(required = true)
	SalaService salaService;
	
	@GetMapping("/all")
	public List<Sala> listarSalas(){
		return salaService.listAll();
	}
	
	@PostMapping("/add")
	public Sala guardarSala(@RequestBody Sala sala) {
		return salaService.add(sala);
	}
	
	@GetMapping("/{codigo}")
	public Sala listarUnaSala(@PathVariable(name="codigo") int codigo) {
		return salaService.getOne(codigo);
	}
	
	@PutMapping("/update/{codigo}")
	public Sala actualizarSala(@PathVariable(name="codigo") int codigo,@RequestBody Sala sala) {
		
		Sala preSala = new Sala();
		Sala newAlmacen = new Sala();
		
		preSala= salaService.getOne(codigo);
		
		preSala.setNombre(sala.getNombre());
		preSala.setPelicula(sala.getPelicula());
		
		newAlmacen = salaService.update(preSala);
		
		return newAlmacen;
	}
	
	@DeleteMapping("/delete/{codigo}")
	public void eliminarSala(@PathVariable(name="codigo") int codigo) {
		salaService.eliminar(codigo);
	}
}
