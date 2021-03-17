package com.ceiba.consulta.calendario;

import com.ceiba.modelo.dto.calendario.DtoDiaFestivo;
import com.ceiba.puerto.dao.calendario.DaoDiaFestivo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarDiasFestivos {

    private final DaoDiaFestivo daoDiaFestivo;

    public ManejadorListarDiasFestivos(DaoDiaFestivo daoDiaFestivo) {

        this.daoDiaFestivo = daoDiaFestivo;

    }

    public List<DtoDiaFestivo> ejecutar(){
        return this.daoDiaFestivo.listar();

    }
}
