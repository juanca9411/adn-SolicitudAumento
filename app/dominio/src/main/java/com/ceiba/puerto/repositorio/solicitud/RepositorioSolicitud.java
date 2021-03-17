package com.ceiba.puerto.repositorio.solicitud;


import com.ceiba.modelo.entidad.solicitud.Solicitud;

import java.time.LocalDateTime;

public interface RepositorioSolicitud {

    Long crear(Solicitud solicitud);

    void resolver(Solicitud solicitud);

    boolean existe(Long numSolicitud);

     LocalDateTime getMaxFechaSolicitud(Long idFuncionario);

}
