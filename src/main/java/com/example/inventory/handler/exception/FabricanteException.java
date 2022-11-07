package com.example.inventory.handler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FabricanteException extends RuntimeException{
    public FabricanteException (String mensagem){
        super(mensagem);
    }
}


