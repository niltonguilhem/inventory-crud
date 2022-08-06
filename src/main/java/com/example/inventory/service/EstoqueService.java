package com.example.inventory.service;

import com.example.inventory.domain.Estoque;
import com.example.inventory.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    public List<Estoque> findAllEstoques() {
        return repository.findAll();
    }

    public Estoque getEstoqueById(Long id){return repository.findById(id).get();}

    public Optional<Estoque> getEstoqueByIdOptional(Long id) {
        return repository.findById(id);
    }

    public Iterable<Estoque> getEstoqueByFabricante (String fabricante) { return repository
            .findByFabricante(fabricante);}

    public  Estoque save (Estoque estoque) {
       Assert.isNull(estoque.getId(), "Não foi possível inserir o registro");
       return repository.save(estoque);
   }

   public Estoque update(Estoque estoque,Long id) {
        //Assert.notNull(id,"Não foi possível atualizar o registro");

        //Busca o item no banco de dados estoque
       Optional<Estoque> optional = getEstoqueByIdOptional(estoque.getId());
       if (optional.isPresent()){
           Estoque estoqueEntity = estoque;
           //Copiar as propriedades
           estoqueEntity.setDescricao(estoque.getDescricao());
           estoqueEntity.setFabricante(estoque.getFabricante());
          // System.out.println("Item id: " + db.getId());

           //Atualiza item de estoque
           repository.save(estoqueEntity);

           return estoqueEntity;
       }
       else {
           throw new RuntimeException();
       }
   }

   public void delete(Long id){
        Optional<Estoque> estoque = getEstoqueByIdOptional(id);
        if (estoque.isPresent()){
            repository.deleteById(id);
        }
   }


}
