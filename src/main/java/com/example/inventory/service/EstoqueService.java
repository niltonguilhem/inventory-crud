package com.example.inventory.service;

import com.example.inventory.domain.Estoque;
import com.example.inventory.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository rep;

    public Iterable<Estoque> getEstoques() {
        return rep.findAll();
    }

    public Optional<Estoque> getEstoqueByid(Long id){return rep.findById(id);}

    public Iterable<Estoque> getEstoqueByFabricante(String fabricante) {return  rep.findByFabricante(fabricante);}

    /*public Estoque save(Estoque estoque){   // Este é um método básico para salvar via POST
        return rep.save(estoque);
    }*/

    public  Estoque insert (Estoque estoque) {
       Assert.isNull(estoque.getId(), "Não foi possível inserir o registro");
       return rep.save(estoque);
   }

   public Estoque update(Estoque estoque,Long id) {
        Assert.notNull(id,"Não foi possível atualiza o registro");

        //Busca o item no banco de dados estoque
       Optional<Estoque> optional = getEstoqueByid(id);
       if (optional.isPresent()){
           Estoque db = optional.get();
           //Copiar as propriedades
           db.setDescricao(estoque.getDescricao());
           db.setFabricante(estoque.getFabricante());
           System.out.println("Item id: " + db.getId());

           //Atualiza item de estoque
           rep.save(db);

           return db;

       } else {
           throw new RuntimeException("Não foi possível atualizar o registro");
       }
   }

   public void delete(Long id){
        Optional<Estoque> estoque = getEstoqueByid(id);
        if (estoque.isPresent()){
            rep.deleteById(id);
        }
   }

    public List<Estoque> getEstoquesFake() {
        List<Estoque> estoques = new ArrayList<>();

        estoques.add(new Estoque(1L, "Óleo", "Motul"));
        estoques.add(new Estoque(2L,"Filtro de Óleo", "Fran"));
        estoques.add(new Estoque(3L,"Filtro de Ar","Fran"));

        return estoques;
    }
}
