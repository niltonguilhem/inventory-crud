package com.example.inventory.service;

import com.example.inventory.controller.EstoquesController;
import com.example.inventory.model.Estoque;
import com.example.inventory.repository.EstoqueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    private static final Logger logger = LoggerFactory.getLogger(EstoqueService.class);
    @Autowired
    private EstoqueRepository repository;

    public List<Estoque> findAllEstoques() {
        logger.info("m=findAllEstoque - status=start");
        List<Estoque> estoqueList = repository.findAll();
        logger.info("m=findAllEstoque - status=finish");
        return estoqueList;
    }

    public Estoque getEstoqueById(Long id){
        logger.info("m=getEstoqueById - status=start " + id);
        Estoque estoque = repository.findById(id).get();
        logger.info("m=getEstoqueById - status=finish " + id);
        return estoque;
    }
    public Optional<Estoque> getEstoqueByIdOptional(Long id) {
        logger.info("m=getEstoqueByIdOptional - status=start " + id);
        Optional<Estoque> estoqueOptional = repository.findById(id);
        logger.info("m=getEstoqueByIdOptional - status=finish " + id);
        return estoqueOptional;
    }

    public List<Estoque> getEstoqueByFabricante (String fabricante) {
        logger.info("m=getEstoqueByFabricante - status=start " + fabricante);
        List<Estoque> estoqueList = repository.findByFabricante(fabricante);
        logger.info("m=getEstoqueByFabricante - status=finish " + fabricante);
        return estoqueList;
    }

    public  Estoque save (Estoque estoque) {
        logger.info("m=save - status=start ");
       Assert.isNull(estoque.getId(), "Não foi possível inserir o registro");
        logger.info("m=save - status=finish ");
       return repository.save(estoque);
   }

   public Estoque update(Estoque estoque) {
       logger.info("m=update - status=start " + estoque.getId());
       Optional<Estoque> optional = getEstoqueByIdOptional(estoque.getId());
       if (optional.isPresent()){
           Estoque estoqueEntity = estoque;
           estoqueEntity.setDescricao(estoque.getDescricao());
           estoqueEntity.setFabricante(estoque.getFabricante());
           repository.save(estoqueEntity);
           logger.info("m=update - status=finish " + estoque.getId());
           return estoqueEntity;
       }
       else {
           logger.warn("m=update - status=warn " + estoque.getId());
           throw new RuntimeException();
       }
   }

   public void delete(Long id){
       logger.info("m=delete - status=start " + id);
        Optional<Estoque> estoque = getEstoqueByIdOptional(id);
        if (estoque.isPresent()){
            logger.info("m=delete - status=finish " + id);
            repository.deleteById(id);
        }else {
            logger.warn("m=delete - status=warn " + id);
            throw new RuntimeException("O id informado é inexistente.");
        }
   }


}
