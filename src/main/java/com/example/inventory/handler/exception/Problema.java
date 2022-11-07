package com.example.inventory.handler.exception;

import java.time.LocalDateTime;

public class Problema {
    private LocalDateTime dataHora;
    private String mensagem;

    public Problema(){

    }

    public Problema(LocalDateTime dataHora, String mensagem){
        this.dataHora = dataHora;
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora){
        this.dataHora = dataHora;
    }

    public Problema withBuilderDataHora(LocalDateTime dataHora){
        setDataHora(dataHora);
        return this;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Problema withBuilderMensagem(String mensagem){
        setMensagem(mensagem);
        return this;
    }
}
