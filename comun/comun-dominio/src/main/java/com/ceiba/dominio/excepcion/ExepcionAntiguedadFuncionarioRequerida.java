package com.ceiba.dominio.excepcion;

public class ExepcionAntiguedadFuncionarioRequerida extends RuntimeException{

    public ExepcionAntiguedadFuncionarioRequerida(String messaje){
        super(messaje);
    }
}
