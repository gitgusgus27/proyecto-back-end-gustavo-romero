package com.gustavo.romero.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.romero.model.Modo_pago;
import com.gustavo.romero.repo.IModo_pagoRepo;
import com.gustavo.romero.service.IModo_pagoService;

@Service
public class Modo_pagoServiceImpl  implements IModo_pagoService{
	
	@Autowired
	private IModo_pagoRepo repo;
	
	@Override
	public Modo_pago registrar(Modo_pago obj) {
		return repo.save(obj);
	}
	
	@Override
	public Modo_pago modificar(Modo_pago obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Modo_pago> listar() {
		return repo.findAll();
	}
	
	@Override
	public Modo_pago leerPorId(Integer id) {
		Optional<Modo_pago> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Modo_pago();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
