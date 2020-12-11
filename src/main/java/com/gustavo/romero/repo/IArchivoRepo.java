package com.gustavo.romero.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.romero.model.Archivo;

public interface IArchivoRepo extends JpaRepository<Archivo, Integer> {
	
}
