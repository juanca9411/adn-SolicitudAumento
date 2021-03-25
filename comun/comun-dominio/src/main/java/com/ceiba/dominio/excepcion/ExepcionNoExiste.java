package com.ceiba.dominio.excepcion;

public class ExepcionNoExiste extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExepcionNoExiste(String message){
        super(message);
    }
}
