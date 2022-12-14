package com.example.inventory.handler.exception;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Locale;

@ControllerAdvice
public class ApiExceptionHandler {

    @Autowired
    private MessageSource messageSource;
    private MessageSourceResolvable HttpMessageNotReadableException;

    @ExceptionHandler(EntidadeInexistenteException.class)
    public ResponseEntity<Problema> handlerIdNaoEncontradoException(
            EntidadeInexistenteException exception) {
        Problema problema = new Problema()
                .withBuilderDataHora(LocalDateTime.now())
                .withBuilderMensagem(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(problema);
    }

    @ExceptionHandler(PartnerException.class)
    public ResponseEntity<Problema> handlerPartnerNaoEncontradoException(
            PartnerException exceptionPartner) {
        Problema problema = new Problema()
                .withBuilderDataHora(LocalDateTime.now())
                .withBuilderMensagem(exceptionPartner.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(problema);
    }
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Problema> handlerHttpMediaTypeNotSupportedException(){
        Problema problema = new Problema()
                .withBuilderDataHora(LocalDateTime.now())
                .withBuilderMensagem("O tipo de mídia não é aceito.");
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .body(problema);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Problema> handlerHttpMessageNotReadableException(){
        String message = messageSource.getMessage(HttpMessageNotReadableException,LocaleContextHolder.getLocale());
        Problema problema = new Problema()
                .withBuilderDataHora(LocalDateTime.now())
                .withBuilderMensagem(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(problema);
    }

    @ExceptionHandler(FabricanteException.class)
    public ResponseEntity<Problema> handlerExceptionFabricanteException(){
        Problema problema = new Problema()
                .withBuilderDataHora(LocalDateTime.now())
                .withBuilderMensagem("Fabricante informado não é valido!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(problema);
    }
}
