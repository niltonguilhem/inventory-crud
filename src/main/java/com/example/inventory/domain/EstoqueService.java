package com.example.inventory.domain;

import java.util.ArrayList;
import java.util.List;

public class EstoqueService {
    public List<Estoque> getEstoques() {
        List<Estoque> estoques = new ArrayList<>();

        estoques.add(new Estoque(1L, "Óleo", "Motul"));
        estoques.add(new Estoque(2L,"Filtro de Óleo", "Fran"));
        estoques.add(new Estoque(3L,"Filtro de Ar","Fran"));

        return estoques;
    }
}
