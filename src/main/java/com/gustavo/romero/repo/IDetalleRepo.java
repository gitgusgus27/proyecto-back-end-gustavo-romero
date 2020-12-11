package com.gustavo.romero.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.romero.model.Detalle;

public interface IDetalleRepo extends JpaRepository<Detalle, Integer> {

}
