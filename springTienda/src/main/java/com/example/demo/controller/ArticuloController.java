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

import com.example.demo.dto.Articulo;
import com.example.demo.service.ArticuloService;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {
	
	@Autowired(required=true)
	ArticuloService articuloService;
	
	@GetMapping("/all")
	public List<Articulo> listarArticulos(){
		System.out.println("A");
		return articuloService.listAll();
	}
	
	@PostMapping("/add")
	public Articulo guardarArticulo(@RequestBody Articulo articulo) {
		System.out.println("Codigo: "+articulo.getCodigo());
		System.out.println("Nombre: "+articulo.getNombre());
		System.out.println("Precio: "+articulo.getPrecio());
		System.out.println("Id fabricante: "+articulo.getFabricante().getCodigo());
		return articuloService.add(articulo);
	}
	
	@GetMapping("/{codigo}")
	public Articulo listarUnArticulo(@PathVariable(name="codigo") int codigo) {
		return articuloService.getOne(codigo);
	}
	
	@PutMapping("/update/{id}")
	public Articulo actualizarArticulo(@PathVariable(name="id")int codigo,@RequestBody Articulo articulo) {
		
		Articulo prevArticulo = new Articulo();
		Articulo newArticulo = new Articulo();
		
		prevArticulo= articuloService.getOne(codigo);
		
		prevArticulo.setNombre(articulo.getNombre());
		prevArticulo.setPrecio(articulo.getPrecio());
		prevArticulo.setFabricante(articulo.getFabricante());
		
		newArticulo = articuloService.update(prevArticulo);
		
		return newArticulo;
	}
	
	@DeleteMapping("/delete/{id}")
	public void eleiminarArticulo(@PathVariable(name="id")int codigo) {
		articuloService.eliminar(codigo);
	}
}
