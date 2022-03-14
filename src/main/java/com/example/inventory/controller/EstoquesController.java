package com.example.inventory.controller;

import com.example.inventory.domain.Estoque;
import com.example.inventory.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/estoques")
public class EstoquesController {
    @Autowired
    private EstoqueService service;

    @GetMapping()
    public Iterable<Estoque> get(){
        return service.getEstoques();
    }

    @GetMapping("/{id}")
    public Optional<Estoque> get (@PathVariable("id") Long id ) {
        return service.getEstoqueByid(id);
    }

    @GetMapping("/fabricante/{fabricante}")
    public Iterable<Estoque> getEstoquesByFabricante (@PathVariable("fabricante") String fabricante) {
        return service.getEstoqueByFabricante(fabricante);
    }

   /* @PostMapping  // Este é um método básico via save do POST.
    public String  post(@RequestBody Estoque estoque){
        Estoque e = service.save(estoque);

        return "Item salvo com sucesso: " + e.getId();
    }*/

    @PostMapping
    public String  post(@RequestBody Estoque estoque){
        Estoque e = service.insert(estoque);

        return "Item salvo com sucesso: " + e.getId();
    }

    @PutMapping("/{id}")
    public String put(@PathVariable("id") Long id, @RequestBody Estoque estoque) {

        Estoque e = service.update(estoque, id);

        return  "Item atualizado com sucesso: "+ e.getId();
    }

    @DeleteMapping("/{id}")
    public  String delete(@PathVariable("id") Long id) {

        service.delete(id);

        return "Item deletado com sucesso";
    }

}
