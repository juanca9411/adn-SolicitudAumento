package com.ceiba.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitud {

    private Long idFuncionario;
    private Long numSolicitud;
    private LocalDateTime fechaSolicitud;
    private String justificacion;
    private String estado;
    private String respuesta;

}
