package com.ceiba.calendario.servicio.testdatabuilder;

import com.ceiba.comando.ComandoDiaFestivo;

import java.time.LocalDateTime;

public class ComandoDiaFestivoTestDataBuilder {

    private Long codigoFecha;
    private String dia;
    private LocalDateTime fecha;

    public ComandoDiaFestivoTestDataBuilder() {
        this.codigoFecha=1L;
        this.dia="Dia de San jose";
        this.fecha=LocalDateTime.now();
    }

    public ComandoDiaFestivoTestDataBuilder conCodigoFecha(Long codigoFecha) {
        this.codigoFecha = codigoFecha;
        return this;
    }

    public ComandoDiaFestivoTestDataBuilder conDia(String dia) {
        this.dia = dia;
        return this;
    }

    public ComandoDiaFestivoTestDataBuilder conFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }


    public ComandoDiaFestivo build() {

        return new ComandoDiaFestivo(codigoFecha,dia,fecha);
    }
}
