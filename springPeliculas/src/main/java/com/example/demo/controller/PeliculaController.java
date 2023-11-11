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

import com.example.demo.dto.Pelicula;
import com.example.demo.service.PeliculaService;

@RestController
@RequestMapping("/pelicula")
public class PeliculaController {
	
	@Autowired(required = true)
	PeliculaService peliculaService;
	
	@GetMapping("/all")
	public List<Pelicula> listarPeliculas(){
		return peliculaService.listAll();
	}
	
	@PostMapping("/add")
	public Pelicula guardarPelicula(@RequestBody Pelicula pelicula) {
		return peliculaService.add(pelicula);
	}
	
	@GetMapping("/{codigo}")
	public Pelicula listarUnaPelicula(@PathVariable(name="codigo") int codigo) {
		return peliculaService.getOne(codigo);
	}
	
	@PutMapping("/update/{codigo}")
	public Pelicula actualizarPelicula(@PathVariable(name="codigo") int codigo,@RequestBody Pelicula pelicula) {
		
		Pelicula prePelicula = new Pelicula();
		Pelicula newAlmacen = new Pelicula();
		
		prePelicula= peliculaService.getOne(codigo);
		
		prePelicula.setNombre(pelicula.getNombre());
		prePelicula.setCalificacion_edad(pelicula.getCalificacion_edad());
		
		newAlmacen = peliculaService.update(prePelicula);
		
		return newAlmacen;
	}
	
	@DeleteMapping("/delete/{codigo}")
	public void eliminarPelicula(@PathVariable(name="codigo") int codigo) {
		peliculaService.eliminar(codigo);
	}
}
