package com.ceiba.calendario.servicio;


import com.ceiba.BasePrueba;
import com.ceiba.calendario.testdatabuilder.DiaFestivoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExepcionDiaNoHabil;
import com.ceiba.modelo.entidad.calendario.DiaFestivo;
import com.ceiba.puerto.repositorio.calendario.RepositorioDiaFestivo;
import com.ceiba.servicio.calendario.ServicioAgregarDiaFestivo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class ServicioAgregarDiaFestivoTest {

    @Mock
    RepositorioDiaFestivo repositorioDiaFestivo;

    @Test
    public void validarRegistroDiaFestivoTest() {
        //arrange
        DiaFestivo diaFestivo = new DiaFestivoTestDataBuilder()
                .conFecha(LocalDateTime.of(2021, 3, 22, 3, 5))
                .build();
        Mockito.when(this.repositorioDiaFestivo.esFestivo(LocalDateTime.of(2021, 3, 22, 3, 5))).thenReturn(true);
        ServicioAgregarDiaFestivo servicioAgregarDiaFestivo = new ServicioAgregarDiaFestivo(this.repositorioDiaFestivo);
        //act-assert
        BasePrueba.assertThrows(()-> servicioAgregarDiaFestivo.ejecutar(diaFestivo),ExepcionDiaNoHabil.class,"Fecha ya registrada como dia Festivo");
    }
}