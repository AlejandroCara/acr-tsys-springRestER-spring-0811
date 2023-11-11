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
import com.example.demo.dto.Caja;
import com.example.demo.service.CajaService;

@RestController
@RequestMapping("/caja")
public class CajaController {
	
	@Autowired(required=true)
	CajaService cajaService;
	
	@GetMapping("/all")
	public List<Caja> listarCajas(){
		return cajaService.listAll();
	}
	
	@PostMapping("/add")
	public Caja guardarCaja(@RequestBody Caja caja) {
		return cajaService.add(caja);
	}
	
	@GetMapping("/{num_referencia}")
	public Caja listarUnaCaja(@PathVariable(name="num_referencia") String num_referencia) {
		return cajaService.getOne(num_referencia);
	}
	
	@PutMapping("/update/{num_referencia}")
	public Caja actualizarFabricante(@PathVariable(name="num_referencia") String num_referencia,@RequestBody Caja caja) {
		
		Caja preCaja = new Caja();
		Caja newAlmacen = new Caja();
		
		preCaja = cajaService.getOne(num_referencia);
		
		preCaja.setContenido(caja.getContenido());
		preCaja.setValor(caja.getValor());
		preCaja.setAlmacen(caja.getAlmacen());
		
		newAlmacen = cajaService.update(preCaja);
		
		return newAlmacen;
	}
	
	@DeleteMapping("/delete/{num_referencia}")
	public void eliminarFabricante(@PathVariable(name="num_referencia") String num_referencia) {
		cajaService.eliminar(num_referencia);
	}
}
