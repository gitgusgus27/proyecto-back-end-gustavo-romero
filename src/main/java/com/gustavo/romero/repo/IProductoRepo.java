package com.gustavo.romero.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.romero.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer> {

}
