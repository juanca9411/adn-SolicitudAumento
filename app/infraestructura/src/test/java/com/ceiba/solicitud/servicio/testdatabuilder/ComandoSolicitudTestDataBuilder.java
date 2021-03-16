package com.ceiba.solicitud.servicio.testdatabuilder;


import com.ceiba.comando.ComandoSolicitud;

import java.time.LocalDateTime;

public class ComandoSolicitudTestDataBuilder {

    private Long idFuncionario;
    private Long numSolicitud;
    private LocalDateTime fechaSolicitud;
    private String justificacion;
    private String estado;
    private String respuesta;


    public ComandoSolicitudTestDataBuilder() {
        idFuncionario = 1L;
        numSolicitud = 1L;
        fechaSolicitud = LocalDateTime.of(2020,12,18,3,25);
        justificacion = "Solicito aumento";
        estado = "enviado";
        respuesta = "";
    }

    public ComandoSolicitudTestDataBuilder conIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
        return this;
    }
    
    public ComandoSolicitudTestDataBuilder conNumSolicitud(Long numSolicitud) {
        this.numSolicitud = numSolicitud;
        return this;
    }
    
     public ComandoSolicitudTestDataBuilder conFechSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
        return this;
    }
     
     public ComandoSolicitudTestDataBuilder conJustificacion(String justificacion) {
        this.justificacion = justificacion;
        return this;
    }
     
     public ComandoSolicitudTestDataBuilder conEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public ComandoSolicitudTestDataBuilder conRespuesta(String respuesta) {
        this.respuesta = respuesta;
        return this;
    }

    public ComandoSolicitud build() {
        return new ComandoSolicitud(idFuncionario,numSolicitud,fechaSolicitud,justificacion,estado,respuesta);
    }
}
