package com.gustavo.romero.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.romero.model.Mesa;
import com.gustavo.romero.repo.IMesaRepo;
import com.gustavo.romero.service.IMesaService;

@Service
public class MesaServiceImpl  implements IMesaService{
	
	@Autowired
	private IMesaRepo repo;
	
	@Override
	public Mesa registrar(Mesa obj) {
		return repo.save(obj);
	}
	
	@Override
	public Mesa modificar(Mesa obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Mesa> listar() {
		return repo.findAll();
	}
	
	@Override
	public Mesa leerPorId(Integer id) {
		Optional<Mesa> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Mesa();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}