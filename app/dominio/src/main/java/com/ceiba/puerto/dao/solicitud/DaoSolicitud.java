package com.ceiba.puerto.dao.solicitud;


import com.ceiba.modelo.dto.solicitud.DtoSolicitud;

import java.util.List;

public interface DaoSolicitud {

    List<DtoSolicitud> listar();

    List<DtoSolicitud> listarSolicitudPorFuncionario(Long idFuncionario);


}
