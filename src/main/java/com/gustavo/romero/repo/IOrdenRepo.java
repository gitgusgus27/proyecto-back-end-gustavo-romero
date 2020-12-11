package com.gustavo.romero.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gustavo.romero.model.Orden;

public interface IOrdenRepo extends JpaRepository<Orden, Integer> {
	
	@Query(value = "select * from orden", nativeQuery = true)
	List<Object[]> listarResumen();


}
