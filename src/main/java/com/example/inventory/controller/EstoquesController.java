package com.example.inventory.controller;

import com.example.inventory.domain.Estoque;
import com.example.inventory.domain.EstoqueResponse;
import com.example.inventory.service.EstoqueService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/estoques")
public class    EstoquesController {
    @Autowired
    private EstoqueService service;

    @GetMapping()
    public ResponseEntity<List<EstoqueResponse>> getAllEstoque() {
        List<Estoque> estoqueList = service.findAllEstoques();
        List<EstoqueResponse> estoqueResponseList = estoqueList.stream().map(estoque -> new EstoqueResponse()
                .withBuilderId(estoque.getId())
                .withBuilderDescricao(estoque.getDescricao())
                .withBuilderFabricante(estoque.getFabricante())).toList();

        return new ResponseEntity<>(estoqueResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueResponse> getId(@PathVariable("id") Long id) {
        Estoque estoque = service.getEstoqueById(id);
        EstoqueResponse response = new EstoqueResponse()
                .withBuilderId(estoque.getId())
                .withBuilderDescricao(estoque.getDescricao())
                .withBuilderFabricante(estoque.getFabricante());

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/fabricante/{fabricante}")
    public ResponseEntity<EstoqueResponse> getFabricante(@PathVariable("fabricante") String fabricante) {
        Estoque estoque = (Estoque) service.getEstoqueByFabricante(fabricante);
        EstoqueResponse response = new EstoqueResponse()
                .withBuilderId(estoque.getId())
                .withBuilderDescricao(estoque.getDescricao())
                .withBuilderFabricante(estoque.getFabricante());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Estoque> post(@RequestBody Estoque estoque) {
        Estoque e = service.save(estoque);

        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estoque> put(@PathVariable("id") Long id, @RequestBody Estoque estoque) {

        Estoque e = service.update(estoque, id);

        return new ResponseEntity<>(e, HttpStatus.ALREADY_REPORTED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {

        service.delete(id);

    }


}
