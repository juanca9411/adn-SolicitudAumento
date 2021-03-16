package com.ceiba.comando.manejador.solicitud;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoSolicitud;
import com.ceiba.comando.fabrica.solicitud.FabricaSolicitud;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.modelo.entidad.solicitud.Solicitud;
import com.ceiba.servicio.solicitud.ServicioCrearSolicitud;
import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearSolicitud implements ManejadorComandoRespuesta<ComandoSolicitud, ComandoRespuesta<Long>> {

    private final FabricaSolicitud fabricaSolicitud;
    private final ServicioCrearSolicitud seviServicioCrearSolicitud;

    public ManejadorCrearSolicitud(FabricaSolicitud fabricaSolicitud, ServicioCrearSolicitud seviServicioCrearSolicitud) {
        this.fabricaSolicitud = fabricaSolicitud;
        this.seviServicioCrearSolicitud = seviServicioCrearSolicitud;
    }


    public ComandoRespuesta<Long> ejecutar(ComandoSolicitud comandoSolicitud) {
        Solicitud solicitud = this.fabricaSolicitud.crear(comandoSolicitud);
        return new ComandoRespuesta<>(this.seviServicioCrearSolicitud.ejecutar(solicitud));
    }
}
