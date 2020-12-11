package com.gustavo.romero.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gustavo.romero.model.Cliente;
import com.gustavo.romero.repo.IClienteRepo;
import com.gustavo.romero.service.IClienteService;

@Service
public class ClienteServiceImpl  implements IClienteService{

	@Autowired
	private IClienteRepo repo;
	
	@Override
	public Cliente registrar(Cliente obj) {
		return repo.save(obj);
	}
	
	@Override
	public Cliente modificar(Cliente obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Cliente> listar() {
		return repo.findAll();
	}
	
	@Override
	public Cliente leerPorId(Integer id) {
		Optional<Cliente> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Cliente();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
