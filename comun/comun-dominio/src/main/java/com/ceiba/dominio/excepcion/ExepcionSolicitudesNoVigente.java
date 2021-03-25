package com.ceiba.dominio.excepcion;

public class ExepcionSolicitudesNoVigente extends RuntimeException{

    public ExepcionSolicitudesNoVigente(String messaje){
        super(messaje);
    }
}
