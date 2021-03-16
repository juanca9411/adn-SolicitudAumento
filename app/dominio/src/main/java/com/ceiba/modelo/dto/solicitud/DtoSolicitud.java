package com.ceiba.modelo.dto.solicitud;

import lombok.Getter;

import java.util.Date;

@Getter
public class DtoSolicitud {

    private Long idFuncionario;
    private Long numSolicitud;
    private Date fechaSolicitud;
    private String justificacion;
    private String estado;
    private String respuesta;

    public DtoSolicitud(Long numSolicitud, Long idFuncionario, Date fechaSolicitud, String justificacion, String estado, String respuesta) {

        this.numSolicitud=numSolicitud;
        this.idFuncionario = idFuncionario;
        this.fechaSolicitud=fechaSolicitud;
        this.justificacion=justificacion;
        this.estado=estado;
        this.respuesta=respuesta;
    }
    
    

}
