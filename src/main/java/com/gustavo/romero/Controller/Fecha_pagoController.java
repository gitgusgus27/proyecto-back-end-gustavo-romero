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
import com.gustavo.romero.model.Fecha_pago;
import com.gustavo.romero.service.IFecha_pagoService;


@RestController
@RequestMapping("/fecha_pagos")
public class Fecha_pagoController {
	@Autowired
	private IFecha_pagoService service;
	
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	//@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DBA')")
	@GetMapping
	public ResponseEntity<List<Fecha_pago>> listar() {
		List<Fecha_pago> lista = service.listar();
		return new ResponseEntity<List<Fecha_pago>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fecha_pago> listarPorId(@PathVariable("id") Integer id) {
		Fecha_pago obj = service.leerPorId(id);
		if (obj.getIdFechaPago() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Fecha_pago>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Fecha_pago fecha_pago) {
		Fecha_pago obj = service.registrar(fecha_pago);
		//fecha_pagos
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fecha_pago.getIdFechaPago()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Fecha_pago> modificar(@Valid @RequestBody Fecha_pago fecha_pago) {
		Fecha_pago obj = service.modificar(fecha_pago);
		return new ResponseEntity<Fecha_pago>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Fecha_pago obj = service.leerPorId(id);
		if (obj.getIdFechaPago() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}