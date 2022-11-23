package com.example.inventory.handler.exception;


public class EntidadeInexistenteException extends RuntimeException{
    public EntidadeInexistenteException(String mensagem) {
        super(mensagem);
    }
}
