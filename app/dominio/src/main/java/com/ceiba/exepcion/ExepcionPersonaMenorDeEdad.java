package com.ceiba.exepcion;

public class ExepcionPersonaMenorDeEdad extends RuntimeException{

    public ExepcionPersonaMenorDeEdad(String messaje){
        super(messaje);
    }
}
