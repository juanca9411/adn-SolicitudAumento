package com.ceiba.controlador.calendario;


import com.ceiba.consulta.calendario.ManejadorListarDiasFestivos;
import com.ceiba.modelo.dto.calendario.DtoDiaFestivo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dias-festivos")
public class ConsultaControladorDiaFestivo {

    private final ManejadorListarDiasFestivos manejadorListarDiasFestivos;

    public ConsultaControladorDiaFestivo(ManejadorListarDiasFestivos manejadorListarDiasFestivos) {
        this.manejadorListarDiasFestivos = manejadorListarDiasFestivos;
    }

    @GetMapping
    public List<DtoDiaFestivo> listar() {
        return this.manejadorListarDiasFestivos.ejecutar();
    }


}
