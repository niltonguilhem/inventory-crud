package com.example.inventory.controller;

import com.example.inventory.domain.Estoque;
import com.example.inventory.service.EstoqueService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/estoques")
public class    EstoquesController {
    @Autowired
    private EstoqueService service;

    @GetMapping()
    public Iterable<Estoque> findAllEstoques(){
        return service.findAllEstoques();
    }

    @GetMapping("/{id}")
    public Optional<Estoque> get (@PathVariable("id") Long id ) {
        return service.getEstoqueById(id);
    }

    @GetMapping("/fabricante/{fabricante}")
    public Iterable<Estoque> getEstoquesByFabricante (@PathVariable("fabricante") String fabricante) {
        return service.getEstoqueByFabricante(fabricante);
    }

    @PostMapping
    public ResponseEntity<Estoque> post(@RequestBody Estoque estoque){
        Estoque e = service.save(estoque);

        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estoque> put(@PathVariable("id") Long id, @RequestBody Estoque estoque) {

        Estoque e = service.update(estoque, id);

        return new ResponseEntity<>(e, HttpStatus.ALREADY_REPORTED);
    }


    /*public String put(@PathVariable("id") Long id, @RequestBody Estoque estoque) {

        Estoque e = service.update(estoque, id);

        return null;
        //return  "Item atualizado com sucesso: "+ e.getId();

    }*/

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {

        service.delete(id);

    }
    /*    return "Item deletado com sucesso";
    }*/

}
