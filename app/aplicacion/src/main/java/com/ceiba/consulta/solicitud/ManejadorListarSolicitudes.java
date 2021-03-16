package com.ceiba.consulta.solicitud;


import com.ceiba.modelo.dto.solicitud.DtoSolicitud;
import com.ceiba.puerto.dao.solicitud.DaoSolicitud;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ManejadorListarSolicitudes {

    private final DaoSolicitud solicitudDao;

    public ManejadorListarSolicitudes(DaoSolicitud solicitudDao) {
        this.solicitudDao = solicitudDao;
    }

    public List<DtoSolicitud> ejecutar(){
        return this.solicitudDao.listar();
    }
}
