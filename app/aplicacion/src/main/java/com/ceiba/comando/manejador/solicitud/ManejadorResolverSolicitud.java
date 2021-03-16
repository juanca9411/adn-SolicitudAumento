package com.ceiba.comando.manejador.solicitud;

import com.ceiba.comando.ComandoSolicitud;
import com.ceiba.comando.fabrica.solicitud.FabricaSolicitud;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.modelo.entidad.solicitud.Solicitud;
import com.ceiba.servicio.solicitud.ServicioResolverSolicitud;
import org.springframework.stereotype.Component;


@Component
public class ManejadorResolverSolicitud implements ManejadorComando<ComandoSolicitud> {


    private final ServicioResolverSolicitud servicioResolverSolicitud;
    private final FabricaSolicitud fabricaSolicitud;

    public ManejadorResolverSolicitud(ServicioResolverSolicitud servicioResolverSolicitud, FabricaSolicitud fabricaSolicitud) {
        this.servicioResolverSolicitud = servicioResolverSolicitud;
        this.fabricaSolicitud = fabricaSolicitud;
    }


    public void ejecutar(ComandoSolicitud comandoSolicitud) {
        Solicitud solicitud = this.fabricaSolicitud.crear(comandoSolicitud);
        this.servicioResolverSolicitud.ejecutar(solicitud);
    }
}
