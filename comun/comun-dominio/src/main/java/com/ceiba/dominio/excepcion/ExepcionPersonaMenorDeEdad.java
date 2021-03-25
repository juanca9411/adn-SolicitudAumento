package com.ceiba.dominio.excepcion;

public class ExepcionPersonaMenorDeEdad extends RuntimeException{

    public ExepcionPersonaMenorDeEdad(String messaje){
        super(messaje);
    }
}
