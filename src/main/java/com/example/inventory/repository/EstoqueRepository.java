package com.example.inventory.repository;

import com.example.inventory.domain.Estoque;
import org.springframework.data.repository.CrudRepository;

public interface EstoqueRepository extends CrudRepository <Estoque, Long> {
}
