package com.gustavo.romero.service;

import java.util.List;

import com.gustavo.romero.model.Menu;

public interface IMenuService extends ICRUD<Menu> {
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
