package com.example.inventory.domain;

public class EstoqueResponse {

    private Long id;
    private String descricao;
    private String fabricante;

    public EstoqueResponse(){

    }

    public  EstoqueResponse(Long id, String descricao, String fabricante) {
        this.id = id;
        this.descricao = descricao;
        this.fabricante = fabricante;

    }

    public  Long getId() { return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public EstoqueResponse withBuilderId(Long id){
        setId(id);
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EstoqueResponse withBuilderDescricao(String descricao){
        setDescricao(descricao);
        return this;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public EstoqueResponse withBuilderFabricante(String fabricante){
        setFabricante(fabricante);
        return this;
    }

}


