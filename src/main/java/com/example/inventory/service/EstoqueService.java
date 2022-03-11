package com.example.inventory.service;

import com.example.inventory.domain.Estoque;
import com.example.inventory.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository rep;

    public Iterable<Estoque> getEstoques() {
        return rep.findAll();
    }

    public List<Estoque> getEstoquesFake() {
        List<Estoque> estoques = new ArrayList<>();

        estoques.add(new Estoque(1L, "Óleo", "Motul"));
        estoques.add(new Estoque(2L,"Filtro de Óleo", "Fran"));
        estoques.add(new Estoque(3L,"Filtro de Ar","Fran"));

        return estoques;
    }
}
