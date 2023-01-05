package com.example.inventory.model;


import javax.validation.constraints.NotNull;


public class EstoqueRequest {

    @NotNull
    private String descricao;

    @NotNull
    private String fabricante;

    public EstoqueRequest(){

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

}


