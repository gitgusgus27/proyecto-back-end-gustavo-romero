package com.gustavo.romero.Controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavo.romero.exception.ModeloNotFoundException;
import com.gustavo.romero.model.Modo_pago;
import com.gustavo.romero.service.IModo_pagoService;

@RestController
@RequestMapping("/modo_pagos")
public class Modo_pagoController {
	@Autowired
	private IModo_pagoService service;
	
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	//@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DBA')")
	@GetMapping
	public ResponseEntity<List<Modo_pago>> listar() {
		List<Modo_pago> lista = service.listar();
		return new ResponseEntity<List<Modo_pago>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Modo_pago> listarPorId(@PathVariable("id") Integer id) {
		Modo_pago obj = service.leerPorId(id);
		if (obj.getIdModoPago() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Modo_pago>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Modo_pago modo_pago) {
		Modo_pago obj = service.registrar(modo_pago);
		//modo_pagos
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(modo_pago.getIdModoPago()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Modo_pago> modificar(@Valid @RequestBody Modo_pago modo_pago) {
		Modo_pago obj = service.modificar(modo_pago);
		return new ResponseEntity<Modo_pago>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Modo_pago obj = service.leerPorId(id);
		if (obj.getIdModoPago() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
