package com.gustavo.romero.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.romero.model.Cliente;

public interface IClienteRepo extends JpaRepository<Cliente, Integer> {

}
