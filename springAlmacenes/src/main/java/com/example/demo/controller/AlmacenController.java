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

import com.example.demo.dto.Almacen;
import com.example.demo.service.AlmacenService;


@RestController
@RequestMapping("/almacen")
public class AlmacenController {
	
	@Autowired(required=true)
	AlmacenService almacenService;
	
	@GetMapping("/all")
	public List<Almacen> listarAlmacenes(){
		return almacenService.listAll();
	}
	
	@PostMapping("/add")
	public Almacen guardarAlmacen(@RequestBody Almacen almacen) {
		return almacenService.add(almacen);
	}
	
	@GetMapping("/{codigo}")
	public Almacen listarUnAlmacen(@PathVariable(name="codigo") int codigo) {
		return almacenService.getOne(codigo);
	}
	
	@PutMapping("/update/{codigo}")
	public Almacen actualizarAlmacen(@PathVariable(name="codigo") int codigo,@RequestBody Almacen almacen) {
		
		Almacen preAlmacen = new Almacen();
		Almacen newAlmacen = new Almacen();
		
		preAlmacen= almacenService.getOne(codigo);
		
		preAlmacen.setLugar(almacen.getLugar());
		preAlmacen.setCapacidad(almacen.getCapacidad());
		
		newAlmacen = almacenService.update(preAlmacen);
		
		return newAlmacen;
	}
	
	@DeleteMapping("/delete/{codigo}")
	public void eliminarAlmacen(@PathVariable(name="codigo") int codigo) {
		almacenService.eliminar(codigo);
	}
}
