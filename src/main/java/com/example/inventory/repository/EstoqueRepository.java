package com.example.inventory.repository;

import com.example.inventory.domain.Estoque;
import com.example.inventory.domain.EstoqueResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
   Iterable<Estoque> findByFabricante(String fabricante);


}
