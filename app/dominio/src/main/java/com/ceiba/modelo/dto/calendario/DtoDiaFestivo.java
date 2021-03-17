package com.ceiba.modelo.dto.calendario;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DtoDiaFestivo {

    private Long codigoFecha;
    private String dia;
    private LocalDateTime fecha;

    public DtoDiaFestivo(Long codigoFecha,String dia,LocalDateTime fecha){
        this.codigoFecha=codigoFecha;
        this.dia=dia;
        this.fecha=fecha;
    }

}
