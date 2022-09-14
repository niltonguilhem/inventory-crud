package com.example.inventory.model;

public class EstoqueRequest {


    private String descricao;
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


