package com.gustavo.romero.service;

import java.util.List;

import com.gustavo.romero.dto.ConsultaOrdenDTO;
import com.gustavo.romero.model.Orden;

public interface IOrdenService extends ICRUD<Orden> {
	
	List<ConsultaOrdenDTO> listarResumen();

}
