package com.gustavo.romero.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gustavo.romero.model.Recinto;
import com.gustavo.romero.repo.IRecintoRepo;
import com.gustavo.romero.service.IRecintoService;

@Service
public class RecintoServiceImpl implements IRecintoService {
	
	@Autowired
	private IRecintoRepo repo;
	
	@Override
	public Recinto registrar(Recinto obj) {
		return repo.save(obj);
	}
	
	@Override
	public Recinto modificar(Recinto obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Recinto> listar() {
		return repo.findAll();
	}
	
	@Override
	public Recinto leerPorId(Integer id) {
		Optional<Recinto> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Recinto();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
	


