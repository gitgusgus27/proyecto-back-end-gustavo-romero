package com.gustavo.romero.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.romero.model.Recinto;

public interface IRecintoRepo extends JpaRepository<Recinto, Integer> {

}
