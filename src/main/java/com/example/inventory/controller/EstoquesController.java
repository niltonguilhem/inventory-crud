package com.example.inventory.controller;

import com.example.inventory.domain.Estoque;
import com.example.inventory.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/estoques")
public class EstoquesController {
    @Autowired
    private EstoqueService service;

    @GetMapping()
    public Iterable<Estoque> get(){
        return service.getEstoques();
    }
}
