package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Fabricante;
import com.example.demo.service.FabricanteService;

@RestController
@RequestMapping("/fabricante")
public class FabricanteController {
	
	@Autowired(required=true)
	FabricanteService fabricanteService;
	
	@GetMapping("/all")
	public List<Fabricante> listarFabricantes(){
		return fabricanteService.listAll();
	}
	
	@PostMapping("/add")
	public Fabricante guardarFabricante(@RequestBody Fabricante fabricante) {
		return fabricanteService.add(fabricante);
	}
	
	@GetMapping("/{codigo}")
	public Fabricante listarUnFabricante(@PathVariable(name="codigo") int codigo) {
		return fabricanteService.getOne(codigo);
	}
	
	@PutMapping("/update/{id}")
	public Fabricante actualizarFabricante(@PathVariable(name="id")int codigo,@RequestBody Fabricante fabricante) {
		
		Fabricante preFabricante = new Fabricante();
		Fabricante newFabricante = new Fabricante();
		
		preFabricante= fabricanteService.getOne(codigo);
		
		preFabricante.setNombre(fabricante.getNombre());
		
		newFabricante = fabricanteService.update(preFabricante);
		
		return newFabricante;
	}
	
	@DeleteMapping("/delete/{id}")
	public void eliminarFabricante(@PathVariable(name="id")int codigo) {
		fabricanteService.eliminar(codigo);
	}
}
