package com.example.inventory.controller;

import com.example.inventory.model.Estoque;
import com.example.inventory.model.EstoqueRequest;
import com.example.inventory.model.EstoqueResponse;
import com.example.inventory.service.EstoqueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/estoques")
public class    EstoquesController {

    private static final Logger logger = LoggerFactory.getLogger(EstoquesController.class);
    @Autowired
    private EstoqueService service;

    @GetMapping()
    public ResponseEntity<List<EstoqueResponse>> getAllEstoque() {
        logger.info("m=getAllEstoque - status=start");
        List<Estoque> estoqueList = service.findAllEstoques();
        List<EstoqueResponse> estoqueResponseList = estoqueList.stream().map(estoque -> new EstoqueResponse()
                .withBuilderId(estoque.getId())
                .withBuilderDescricao(estoque.getDescricao())
                .withBuilderFabricante(estoque.getFabricante())).toList();
        logger.info("m=getAllEstoque - status=finish");
        return new ResponseEntity<>(estoqueResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueResponse> getIdEstoque(@PathVariable("id") Long id) {
        logger.info("m=getIdEstoque - status=start " + id);
        Estoque estoque = service.getEstoqueById(id);
        EstoqueResponse response = new EstoqueResponse()
                .withBuilderId(estoque.getId())
                .withBuilderDescricao(estoque.getDescricao())
                .withBuilderFabricante(estoque.getFabricante());
        logger.info("m=getIdEstoque - status=finish " + id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/fabricante/{fabricante}")
    public ResponseEntity<List<EstoqueResponse>> getFabricante(@PathVariable("fabricante") String fabricante) {
        logger.info("m=getFabricante - status=start " + fabricante);
        List<Estoque> estoqueList = service.getEstoqueByFabricante(fabricante);
        List<EstoqueResponse> response = estoqueList.stream().map(estoque -> new EstoqueResponse()
                .withBuilderId(estoque.getId())
                .withBuilderDescricao(estoque.getDescricao())
                .withBuilderFabricante(estoque.getFabricante())).collect(Collectors.toList());
        logger.info("m=getFabricante - status=finish " + fabricante);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

   @PostMapping
   public ResponseEntity<EstoqueResponse> postEstoque(@RequestBody EstoqueRequest estoqueRequest){
       logger.info("m=postEstoque - status=start");
       Estoque estoque = service.save(new Estoque()
               .withBuilderDescricao(estoqueRequest.getDescricao())
               .withBuilderFabricante(estoqueRequest.getFabricante()));

       EstoqueResponse response = new EstoqueResponse()
               .withBuilderId(estoque.getId())
               .withBuilderDescricao(estoque.getDescricao())
               .withBuilderFabricante(estoque.getFabricante());
       logger.info("m=postEstoque - status=finish");
       return new ResponseEntity<>(response,HttpStatus.CREATED);
   }

    @PutMapping("/{id}")
    public ResponseEntity<EstoqueResponse> putEstoque (@PathVariable("id")Long id,
                                                       @RequestBody EstoqueRequest estoqueRequest){
        logger.info("m=putEstoque - status=start " + id);
        Estoque estoqueUpdate = service.update(new Estoque()
                .withBuilderId(id)
                .withBuilderDescricao(estoqueRequest.getDescricao())
                .withBuilderFabricante(estoqueRequest.getFabricante()));

        EstoqueResponse response = new EstoqueResponse()
                .withBuilderId(estoqueUpdate.getId())
                .withBuilderDescricao(estoqueUpdate.getDescricao())
                .withBuilderFabricante(estoqueUpdate.getFabricante());
        logger.info("m=putEstoque - status=finish " + id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        logger.info("m=delete - status=start " + id);
        service.delete(id);
        logger.info("m=delete - status=finish " + id);
    }


}
