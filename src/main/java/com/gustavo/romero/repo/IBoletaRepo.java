package com.gustavo.romero.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.romero.model.Boleta;

public interface IBoletaRepo extends JpaRepository<Boleta, Integer> {

}
