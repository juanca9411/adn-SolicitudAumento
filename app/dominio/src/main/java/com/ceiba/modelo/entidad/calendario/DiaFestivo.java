package com.ceiba.modelo.entidad.calendario;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class DiaFestivo {

    public static final  String EL_NOMBRE_ES_OBLIGATORIO = "Debe ingresar un nombre";
    public static final  String LA_FECHA_ES_OBLIGATORIA ="Debe ingresar una fecha";

    private Long codigoFecha;
    private String dia;
    private LocalDateTime fecha;

    public DiaFestivo(Long codigoFecha,String dia,LocalDateTime fecha){
        validarObligatorio(dia,EL_NOMBRE_ES_OBLIGATORIO);
        validarObligatorio(fecha,LA_FECHA_ES_OBLIGATORIA);

        this.codigoFecha=codigoFecha;
        this.dia=dia;
        this.fecha=fecha;
    }



}
