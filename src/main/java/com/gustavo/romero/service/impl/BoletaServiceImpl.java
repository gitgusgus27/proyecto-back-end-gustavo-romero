package com.gustavo.romero.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.romero.model.Boleta;
import com.gustavo.romero.repo.IBoletaRepo;
import com.gustavo.romero.service.IBoletaService;

@Service
public class BoletaServiceImpl implements IBoletaService{
	

	@Autowired
	private IBoletaRepo repo;
	
	@Override
	public Boleta registrar(Boleta obj) {
		return repo.save(obj);
	}
	
	@Override
	public Boleta modificar(Boleta obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Boleta> listar() {
		return repo.findAll();
	}
	
	@Override
	public Boleta leerPorId(Integer id) {
		Optional<Boleta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Boleta();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
