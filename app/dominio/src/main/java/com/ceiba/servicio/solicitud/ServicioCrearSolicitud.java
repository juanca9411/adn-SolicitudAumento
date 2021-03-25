package com.ceiba.servicio.solicitud;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExepcioSolicitudDiaNoHabil;
import com.ceiba.modelo.entidad.solicitud.Solicitud;
import com.ceiba.puerto.repositorio.calendario.RepositorioDiaFestivo;
import com.ceiba.puerto.repositorio.solicitud.RepositorioSolicitud;


import java.time.LocalDateTime;

public class ServicioCrearSolicitud {

    private static final String LA_SOLICITUD_YA_EXISTE_EN_EL_SISTEMA = "La solicitud ya existe en el sistema";
    private static final String SOLO_SE_PUEDE_REALIZAR_SOLICITUDES_EN_DIAS_HABILES = "Solo se pueden realizar solicitudes en dias habiles";

    private final RepositorioSolicitud repositorioSolicitud;
    private final RepositorioDiaFestivo repositorioDiaFestivo;

    public ServicioCrearSolicitud(RepositorioSolicitud repositorioSolicitud, RepositorioDiaFestivo repositorioDiaFestivo) {
        this.repositorioSolicitud = repositorioSolicitud;
        this.repositorioDiaFestivo = repositorioDiaFestivo;
    }

    public Long ejecutar(Solicitud solicitud) {
        validarExistenciaPrevia(solicitud);
        solicitud.validarSolicitudFindeSemana();
        validarSolicitudDiaFestivo(solicitud.getFechaSolicitud());
        validaNuevaSolicitud(solicitud);
        return this.repositorioSolicitud.crear(solicitud);
    }

    private void validarExistenciaPrevia(Solicitud solicitud) {
        boolean existe = this.repositorioSolicitud.existe(solicitud.getNumSolicitud());
        if (existe) {
            throw new ExcepcionDuplicidad(LA_SOLICITUD_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validaNuevaSolicitud(Solicitud solicitud) {
        LocalDateTime fechaUltimaSolicitud = this.repositorioSolicitud.getMaxFechaSolicitud(solicitud.getIdFuncionario());
       if (fechaUltimaSolicitud != null)
        solicitud.validarTiempoMinimoNuevaSolicitud(fechaUltimaSolicitud);
    }

    private void validarSolicitudDiaFestivo(LocalDateTime fechaSolicitud) {
        if (this.repositorioDiaFestivo.esFestivo(fechaSolicitud)) {
            throw new ExepcioSolicitudDiaNoHabil(SOLO_SE_PUEDE_REALIZAR_SOLICITUDES_EN_DIAS_HABILES);
        }
    }

}
