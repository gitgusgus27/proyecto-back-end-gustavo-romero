package com.gustavo.romero.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.romero.model.Categoria;

public interface ICategoriaRepo extends JpaRepository<Categoria, Integer> {

}
