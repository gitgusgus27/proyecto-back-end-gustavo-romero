package com.gustavo.romero.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gustavo.romero.model.Fecha_pago;
import com.gustavo.romero.repo.IFecha_pagoRepo;
import com.gustavo.romero.service.IFecha_pagoService;

@Service
public class Fecha_pagoServiceImpl implements IFecha_pagoService {
	
	@Autowired
	private IFecha_pagoRepo repo;
	
	@Override
	public Fecha_pago registrar(Fecha_pago obj) {
		return repo.save(obj);
	}
	
	@Override
	public Fecha_pago modificar(Fecha_pago obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Fecha_pago> listar() {
		return repo.findAll();
	}
	
	@Override
	public Fecha_pago leerPorId(Integer id) {
		Optional<Fecha_pago> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Fecha_pago();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}