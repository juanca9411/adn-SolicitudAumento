package com.ceiba.puerto.dao.solicitud;


import com.ceiba.modelo.dto.solicitud.DtoSolicitud;

import java.util.List;

public interface DaoSolicitud {

    /**
     * Permite  listar las solicitudes
     */
    List<DtoSolicitud> listar();

    /**
     * Permite listar las solicitudes hechas por un funcionario
     */

    List<DtoSolicitud> listarSolicitudPorFuncionario(Long idFuncionario);


}
