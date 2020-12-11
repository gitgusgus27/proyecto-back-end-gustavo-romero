package com.gustavo.romero.Controller;

import java.net.URI;
import java.util.ArrayList;
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

import com.gustavo.romero.dto.ConsultaOrdenDTO;
import com.gustavo.romero.exception.ModeloNotFoundException;
import com.gustavo.romero.model.Orden;
import com.gustavo.romero.service.IOrdenService;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {
	
	@Autowired
	private IOrdenService service;
	
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	//@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DBA')")
	@GetMapping
	public ResponseEntity<List<Orden>> listar() {
		List<Orden> lista = service.listar();
		return new ResponseEntity<List<Orden>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Orden> listarPorId(@PathVariable("id") Integer id) {
		Orden obj = service.leerPorId(id);
		if (obj.getIdOrden() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Orden>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Orden orden) {
		Orden obj = service.registrar(orden);
		//ordenes
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(orden.getIdOrden()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Orden> modificar(@Valid @RequestBody Orden orden) {
		Orden obj = service.modificar(orden);
		return new ResponseEntity<Orden>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Orden obj = service.leerPorId(id);
		if (obj.getIdOrden() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	//dto
	@GetMapping(value = "/listarResumen")
	public ResponseEntity<List<ConsultaOrdenDTO>> listarResumen() {
		List<ConsultaOrdenDTO> consultas = new ArrayList<>();
		consultas = service.listarResumen();
		return new ResponseEntity<List<ConsultaOrdenDTO>>(consultas, HttpStatus.OK);
	}
}



