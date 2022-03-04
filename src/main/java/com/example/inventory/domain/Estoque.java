package com.example.inventory.domain;


public class Estoque {
    private Long id;
    private String descricao;
    private String fabricante;

    public Estoque(){

    }

    public  Estoque(Long id, String descricao, String fabricante) {
        this.id = id;
        this.descricao = descricao;
        this.fabricante = fabricante;

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
}
