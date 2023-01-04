package com.example.inventory.model;

import javax.persistence.*;


@Entity
@Table (name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "fabricante")
    private String fabricante;

    public Estoque(){

    }

    public  Long getId() { return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Estoque withBuilderDescricao(String descricao){
        setDescricao(descricao);
        return this;
    }

    public Estoque withBuilderFabricante(String fabricante){
        setFabricante(fabricante);
        return this;
    }

    public Estoque withBuilderId(Long id){
        setId(id);
        return this;
    }
}
