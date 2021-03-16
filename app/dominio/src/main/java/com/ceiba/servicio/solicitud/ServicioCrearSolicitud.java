package com.ceiba.servicio.solicitud;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.solicitud.Solicitud;
import com.ceiba.puerto.repositorio.solicitud.RepositorioSolicitud;


import java.util.Date;

import static com.ceiba.modelo.entidad.solicitud.Solicitud.*;


public class ServicioCrearSolicitud {

    private static final String LA_SOLICITUD_YA_EXISTE_EN_EL_SISTEMA = "La solicitud ya existe en el sistema";

    private final RepositorioSolicitud repositorioSolicitud;

    public ServicioCrearSolicitud(RepositorioSolicitud repositorioSolicitud) {
        this.repositorioSolicitud=repositorioSolicitud;
    }

    public Long ejecutar(Solicitud solicitud) {
        validarExistenciaPrevia(solicitud);
        validaNuevaSolicitud(solicitud);
        validarSolicitudFindeSemana(solicitud.getFechaSolicitud());
        validarSolicitudDiaFestivo(solicitud.getFechaSolicitud());
        return this.repositorioSolicitud.crear(solicitud);
    }

    private void validarExistenciaPrevia(Solicitud solicitud) {
        boolean existe = this.repositorioSolicitud.existe(solicitud.getNumSolicitud());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_SOLICITUD_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

     private void validaNuevaSolicitud(Solicitud solicitud){
        Date fechaUltimaSolicitud = this.repositorioSolicitud.getMaxFechaSolicitud(solicitud.getIdFuncionario());
         validarNuevaSolicitud(fechaUltimaSolicitud,solicitud.getFechaSolicitud());
    }

    }
