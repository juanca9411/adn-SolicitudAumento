package com.ceiba.servicio.solicitud;


import com.ceiba.dominio.excepcion.ExepcionNoExiste;
import com.ceiba.modelo.entidad.solicitud.Solicitud;
import com.ceiba.puerto.repositorio.solicitud.RepositorioSolicitud;

public class ServicioResolverSolicitud {

    private static final String LA_SOLICITUD_NO_EXISTE_EN_EL_SISTEMA = "La solicitud no existe en el sistema";

    private final RepositorioSolicitud repositorioSolicitud;

    public ServicioResolverSolicitud(RepositorioSolicitud repositorioSolicitud) {
        this.repositorioSolicitud=repositorioSolicitud;
    }

    public void ejecutar(Solicitud solicitud) {
        validarExistencia(solicitud);
        this.repositorioSolicitud.resolver(solicitud);
    }

    private void validarExistencia(Solicitud solicitud) {
        boolean existe = this.repositorioSolicitud.existe(solicitud.getNumSolicitud());
        if(!existe) {
            throw new ExepcionNoExiste(LA_SOLICITUD_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
