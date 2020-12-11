package com.gustavo.romero.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.romero.model.Detalle;
import com.gustavo.romero.repo.IDetalleRepo;
import com.gustavo.romero.service.IDetalleService;

@Service
public class DetalleServiceImpl implements IDetalleService {
	@Autowired
	private IDetalleRepo repo;
	
	@Override
	public Detalle registrar(Detalle obj) {
		return repo.save(obj);
	}
	
	@Override
	public Detalle modificar(Detalle obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Detalle> listar() {
		return repo.findAll();
	}
	
	@Override
	public Detalle leerPorId(Integer id) {
		Optional<Detalle> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Detalle();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
