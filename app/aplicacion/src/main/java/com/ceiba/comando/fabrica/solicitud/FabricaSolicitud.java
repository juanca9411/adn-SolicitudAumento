package com.ceiba.comando.fabrica.solicitud;


import com.ceiba.comando.ComandoSolicitud;
import com.ceiba.modelo.entidad.solicitud.Solicitud;
import org.springframework.stereotype.Component;


@Component
public class FabricaSolicitud {

    public Solicitud crear(ComandoSolicitud comandoSolicitud) {
        return new Solicitud(
                comandoSolicitud.getIdFuncionario(),
                comandoSolicitud.getNumSolicitud(),
                comandoSolicitud.getFechaSolicitud(),
                comandoSolicitud.getJustificacion(),
                comandoSolicitud.getEstado(),
                comandoSolicitud.getRespuesta()
        );
    }

}
