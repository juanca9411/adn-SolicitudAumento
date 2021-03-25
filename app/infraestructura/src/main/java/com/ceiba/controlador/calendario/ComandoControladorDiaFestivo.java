package com.ceiba.controlador.calendario;

import com.ceiba.comando.ComandoDiaFestivo;
import com.ceiba.comando.manejador.calendario.ManejadorAgregarDiaFestivo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dias-festivos")
@Api(tags = { "Controlador comando dias festivos"})
public class ComandoControladorDiaFestivo {

    private final ManejadorAgregarDiaFestivo manejadorAgregarDiaFestivo;

    public ComandoControladorDiaFestivo(ManejadorAgregarDiaFestivo manejadorAgregarDiaFestivo) {
        this.manejadorAgregarDiaFestivo = manejadorAgregarDiaFestivo;
    }


    @PostMapping
    public void  crear(@RequestBody ComandoDiaFestivo comandoDiaFestivo) {
         this.manejadorAgregarDiaFestivo.ejecutar(comandoDiaFestivo);
    }

}
