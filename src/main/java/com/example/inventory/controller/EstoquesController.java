package com.example.inventory.controller;

import com.example.inventory.domain.Estoque;
import com.example.inventory.domain.EstoqueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estoques")
public class EstoquesController {
    private EstoqueService service = new EstoqueService();

    @GetMapping()
    public List<Estoque> get(){
        return service.getEstoques();
    }
}
