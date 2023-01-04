package com.example.inventory.handler.exception;

public enum ProblemType {

    CORPO_DO_JSON_ESTA_INCORRETO("/corpo-do-json-esta-incorreta", "Corpo do JSON está incorreto"),
    ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada","Entidade não encontrada");

    private String title;
    private String uri;

    ProblemType(String path, String title){
        this.uri = "https://ngtechnology.com.br" + path;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }

}
