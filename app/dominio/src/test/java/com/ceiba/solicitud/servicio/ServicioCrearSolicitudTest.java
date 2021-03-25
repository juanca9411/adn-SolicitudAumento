package com.ceiba.solicitud.servicio;


import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExepcioSolicitudDiaNoHabil;
import com.ceiba.dominio.excepcion.ExepcionSolicitudFinDeSemana;
import com.ceiba.dominio.excepcion.ExepcionSolicitudesNoVigente;
import com.ceiba.modelo.entidad.solicitud.Solicitud;
import com.ceiba.puerto.repositorio.calendario.RepositorioDiaFestivo;
import com.ceiba.puerto.repositorio.solicitud.RepositorioSolicitud;
import com.ceiba.servicio.solicitud.ServicioCrearSolicitud;
import com.ceiba.solicitud.testdatabuilder.SolicitudTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class ServicioCrearSolicitudTest {

    @Mock
    RepositorioSolicitud repositorioSolicitud;
    @Mock
    RepositorioDiaFestivo repositorioDiaFestivo;


    @Test
    public void validarExistenciaSolcitudTest() {
        //arrange
        Solicitud solicitud = new SolicitudTestDataBuilder()
                .build();
        Mockito.when(this.repositorioSolicitud.existe(solicitud.getNumSolicitud())).thenReturn(true);
        ServicioCrearSolicitud servicioCrearSolicitud = new ServicioCrearSolicitud(this.repositorioSolicitud, this.repositorioDiaFestivo);

        //act-assert
        BasePrueba.assertThrows(() ->  servicioCrearSolicitud.ejecutar(solicitud), ExcepcionDuplicidad.class,"La solicitud ya existe en el sistema");

    }

    @Test
    public void validarNuevaSolicitud() {
        //arrange
        Solicitud solicitud = new SolicitudTestDataBuilder()
                .conFechSolicitud(LocalDateTime.of(2021, 12, 17, 3, 25))
                .build();
        Mockito.when(this.repositorioSolicitud.getMaxFechaSolicitud(solicitud.getIdFuncionario())).thenReturn(LocalDateTime.of(2021, 12, 17, 3, 5));
        ServicioCrearSolicitud servicioCrearSolicitud = new ServicioCrearSolicitud(this.repositorioSolicitud, this.repositorioDiaFestivo);
        //act-assert
        BasePrueba.assertThrows(() ->  servicioCrearSolicitud.ejecutar(solicitud), ExepcionSolicitudesNoVigente.class,"No ha pasado el tiempo minimo (6 meses) desde que realizo la ultima solicitud");

    }

    @Test
    public void validarSolicitudDiaFestivo() {
        // arrange
        Solicitud solicitud = new SolicitudTestDataBuilder()
                .conFechSolicitud(LocalDateTime.of(2021, 3, 22, 3, 25))
                .build();
        Mockito.when(this.repositorioDiaFestivo.esFestivo(LocalDateTime.of(2021, 3, 22, 3, 25))).thenReturn(true);
        ServicioCrearSolicitud servicioCrearSolicitud = new ServicioCrearSolicitud(this.repositorioSolicitud, this.repositorioDiaFestivo);
        //act-assert
        BasePrueba.assertThrows(() ->  servicioCrearSolicitud.ejecutar(solicitud), ExepcioSolicitudDiaNoHabil.class,"Solo se pueden realizar solicitudes en dias habiles");

    }

    @Test
    public void validarSolicitudFinDeSemana() {
        // arrange
        Solicitud solicitud = new SolicitudTestDataBuilder()
                .conFechSolicitud(LocalDateTime.of(2020, 12, 13, 3, 5))
                .build();
        //act-assert
        //solicitud.validarSolicitudFindeSemana();
        BasePrueba.assertThrows(() ->  solicitud.validarSolicitudFindeSemana(), ExepcionSolicitudFinDeSemana.class,"La solicitud no puede realizarce un fin de semana");

    }


}
