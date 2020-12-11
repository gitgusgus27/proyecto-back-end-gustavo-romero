package com.gustavo.romero.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.romero.model.Mesa;

public interface IMesaRepo extends JpaRepository<Mesa, Integer> {

}
