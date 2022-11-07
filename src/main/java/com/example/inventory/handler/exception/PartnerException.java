package com.example.inventory.handler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PartnerException extends RuntimeException{
    public PartnerException (String mensagem){
        super(mensagem);
    }
}
