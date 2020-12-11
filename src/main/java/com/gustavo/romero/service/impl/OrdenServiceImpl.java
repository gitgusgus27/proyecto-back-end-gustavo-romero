package com.gustavo.romero.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.romero.dto.ConsultaOrdenDTO;
import com.gustavo.romero.model.Orden;
import com.gustavo.romero.repo.IOrdenRepo;
import com.gustavo.romero.service.IOrdenService;

@Service
public class OrdenServiceImpl implements IOrdenService {
	
	@Autowired
	private IOrdenRepo repo;
	
	@Override
	public Orden registrar(Orden obj) {
		return repo.save(obj);
	}
	
	@Override
	public Orden modificar(Orden obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Orden> listar() {
		return repo.findAll();
	}
	
	@Override
	public Orden leerPorId(Integer id) {
		Optional<Orden> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Orden();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
	//dto
	
	@Override
	public List<ConsultaOrdenDTO> listarResumen() {
		List<ConsultaOrdenDTO> consultas = new ArrayList<>();
		
		repo.listarResumen().forEach(x -> {
			ConsultaOrdenDTO cr = new ConsultaOrdenDTO();
			cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
			cr.setFecha(String.valueOf(x[1]));
			consultas.add(cr);
		});
		return consultas;
	}
}