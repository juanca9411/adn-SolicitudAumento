package com.ceiba.dominio.excepcion;

public class ExepcioSolicitudDiaNoHabil extends RuntimeException{

    public ExepcioSolicitudDiaNoHabil(String messaje){
        super(messaje);
    }
}
