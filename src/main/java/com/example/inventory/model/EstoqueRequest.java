package com.example.inventory.model;

import javax.validation.constraints.NotNull;

public class EstoqueRequest {


    private String descricao;

    @NotNull
    private String fabricante;

    public EstoqueRequest(){

    }

    public  EstoqueRequest(String descricao, String fabricante) {

        this.descricao = descricao;
        this.fabricante = fabricante;

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


