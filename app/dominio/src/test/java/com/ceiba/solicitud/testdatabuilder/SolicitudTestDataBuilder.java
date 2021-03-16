package com.ceiba.solicitud.testdatabuilder;


import com.ceiba.modelo.entidad.solicitud.Solicitud;

import java.util.Date;

public class SolicitudTestDataBuilder {

    private Long idFuncionario;
    private Long numSolicitud;
    private Date fechaSolicitud;
    private String justificacion;
    private String estado;
    private String respuesta;

    public SolicitudTestDataBuilder() {
        idFuncionario = 1L;
        numSolicitud = 1L;
        fechaSolicitud = new Date();
        justificacion = "Solicito aumento";
        estado = "enviado";
        respuesta = "";
    }

    public SolicitudTestDataBuilder conIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
        return this;
    }

    public SolicitudTestDataBuilder conNumSolicitud(Long numSolicitud) {
        this.numSolicitud = numSolicitud;
        return this;
    }

    public SolicitudTestDataBuilder conFechSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
        return this;
    }

    public SolicitudTestDataBuilder conJustificacion(String justificacion) {
        this.justificacion = justificacion;
        return this;
    }

    public SolicitudTestDataBuilder conEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public SolicitudTestDataBuilder conRespuesta(String respuesta) {
        this.respuesta = respuesta;
        return this;
    }
   

    public Solicitud build() {
        return new Solicitud(idFuncionario,numSolicitud,fechaSolicitud,justificacion,estado,respuesta);
    }
}
