package com.ceiba.comando.manejador.calendario;

import com.ceiba.comando.ComandoDiaFestivo;
import com.ceiba.comando.fabrica.calendario.FabricaDiaFestivo;
import com.ceiba.modelo.entidad.calendario.DiaFestivo;
import com.ceiba.servicio.calendario.ServicioAgregarDiaFestivo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAgregarDiaFestivo {

    private final ServicioAgregarDiaFestivo servicioAgregarDiaFestivo;
    private final FabricaDiaFestivo fabricaDiaFestivo;

    public ManejadorAgregarDiaFestivo(ServicioAgregarDiaFestivo servicioAgregarDiaFestivo, FabricaDiaFestivo fabricaDiaFestivo){
        this.servicioAgregarDiaFestivo=servicioAgregarDiaFestivo;
        this.fabricaDiaFestivo = fabricaDiaFestivo;
    }

    public void ejecutar(ComandoDiaFestivo comandoDiaFestivo){
        DiaFestivo diaFestivo = fabricaDiaFestivo.crear(comandoDiaFestivo);
        this.servicioAgregarDiaFestivo.ejecutar(diaFestivo);
    }

}
