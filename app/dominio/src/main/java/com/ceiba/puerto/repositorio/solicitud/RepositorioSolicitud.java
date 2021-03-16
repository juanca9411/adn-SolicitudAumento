package com.ceiba.puerto.repositorio.solicitud;


import com.ceiba.modelo.entidad.solicitud.Solicitud;

import java.time.LocalDateTime;

public interface RepositorioSolicitud {

    /**
     * Metodo para crear una solicitud
     * */
   
    Long crear(Solicitud solicitud);

    /**
     * Metodo para resolver o atender una solicitud
     * */

    void resolver(Solicitud solicitud);

    /**
     * Metodo para verificar la existencia de una solicitud
     * */

    boolean existe(Long numSolicitud);

    /**
     * Metodo para optener la fecha de la ultima solicitud
     * realizada por un funcionario.
     * */

    LocalDateTime getMaxFechaSolicitud(Long idFuncionario);

}
