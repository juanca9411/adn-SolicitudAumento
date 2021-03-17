package com.ceiba.servicio.calendario;


import com.ceiba.exepcion.ExepcionDiaNoHabil;
import com.ceiba.modelo.entidad.calendario.DiaFestivo;
import com.ceiba.puerto.repositorio.calendario.RepositorioDiaFestivo;

import java.time.LocalDateTime;

public class ServicioAgregarDiaFestivo {

    private static final String ESTA_FECHA_YA_ESTA_REPORTADA_COMO_FESTIVO="Fecha ya registrada como dia Festivo";

    private final RepositorioDiaFestivo repositorioDiaFestivo;

    public ServicioAgregarDiaFestivo(RepositorioDiaFestivo repositorioDiaFestivo){
        this.repositorioDiaFestivo=repositorioDiaFestivo;
    }

    public void ejecutar(DiaFestivo diaFestivo){
        validarFechaYaReportada(diaFestivo.getFecha());
        this.repositorioDiaFestivo.agregar(diaFestivo);
    }

    private void validarFechaYaReportada(LocalDateTime fecha){
        if(this.repositorioDiaFestivo.esFestivo(fecha)){
            throw new ExepcionDiaNoHabil(ESTA_FECHA_YA_ESTA_REPORTADA_COMO_FESTIVO);
        }
    }

}
