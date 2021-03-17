package com.ceiba.puerto.repositorio.calendario;

import com.ceiba.modelo.entidad.calendario.DiaFestivo;

import java.time.LocalDateTime;

public interface RepositorioDiaFestivo {

    void agregar(DiaFestivo diaFestivo);

    boolean esFestivo(LocalDateTime fecha);
}
