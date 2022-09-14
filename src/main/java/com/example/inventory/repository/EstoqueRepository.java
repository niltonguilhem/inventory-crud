package com.example.inventory.repository;

import com.example.inventory.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
   List<Estoque> findByFabricante(String fabricante);


}
