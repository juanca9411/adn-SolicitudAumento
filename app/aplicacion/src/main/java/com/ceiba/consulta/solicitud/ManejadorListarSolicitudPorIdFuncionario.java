package com.ceiba.consulta.solicitud;
import com.ceiba.modelo.dto.solicitud.DtoSolicitud;
import com.ceiba.puerto.dao.solicitud.DaoSolicitud;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarSolicitudPorIdFuncionario {

    private final DaoSolicitud daoSolicitud;

    public ManejadorListarSolicitudPorIdFuncionario(DaoSolicitud daoSolicitud) {
        this.daoSolicitud = daoSolicitud;
    }

    public List<DtoSolicitud> ejecutar(Long idFuncionario){
        return this.daoSolicitud.listarSolicitudPorFuncionario(idFuncionario);
    }
}
