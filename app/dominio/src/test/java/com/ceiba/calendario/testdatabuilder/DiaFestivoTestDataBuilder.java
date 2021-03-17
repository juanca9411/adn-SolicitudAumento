package com.ceiba.calendario.testdatabuilder;


import com.ceiba.modelo.entidad.calendario.DiaFestivo;

import java.time.LocalDateTime;

public class DiaFestivoTestDataBuilder {

    private Long codigoFecha;
    private String dia;
    private LocalDateTime fecha;

    public DiaFestivoTestDataBuilder() {
        this.codigoFecha=1L;
        this.dia="Dia de San jose";
        this.fecha=LocalDateTime.now();
    }

    public DiaFestivoTestDataBuilder conCodigoFecha(Long codigoFecha) {
        this.codigoFecha = codigoFecha;
        return this;
    }

    public DiaFestivoTestDataBuilder conDia(String dia) {
        this.dia = dia;
        return this;
    }

    public DiaFestivoTestDataBuilder conFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }
   

    public DiaFestivo build() {
        return new DiaFestivo(codigoFecha,dia,fecha);
    }
}
