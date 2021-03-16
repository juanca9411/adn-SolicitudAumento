package com.ceiba.puerto.repositorio.solicitud;


import com.ceiba.modelo.entidad.solicitud.Solicitud;

import java.util.Date;

public interface RepositorioSolicitud {
   
    Long crear(Solicitud solicitud);

    void resolver(Solicitud solicitud);

    boolean existe(Long numSolicitud);

    Date getMaxFechaSolicitud(Long idFuncionario);

}
