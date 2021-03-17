package com.ceiba.comando.fabrica.calendario;

import com.ceiba.comando.ComandoDiaFestivo;
import com.ceiba.modelo.entidad.calendario.DiaFestivo;
import org.springframework.stereotype.Component;

@Component
public class FabricaDiaFestivo {

    public DiaFestivo crear(ComandoDiaFestivo comandoDiaFestivo){
        return new DiaFestivo(
                comandoDiaFestivo.getCodigoFecha(),
                comandoDiaFestivo.getDia(),
                comandoDiaFestivo.getFecha()
                );
    }
}
