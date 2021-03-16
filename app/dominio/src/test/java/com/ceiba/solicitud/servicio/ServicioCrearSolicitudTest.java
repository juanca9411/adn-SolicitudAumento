package com.ceiba.solicitud.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.exepcion.ExepcionSolicitudFinDeSemana;
import com.ceiba.exepcion.ExepcionSolicitudesNoVigente;
import com.ceiba.modelo.entidad.solicitud.Solicitud;
import com.ceiba.puerto.repositorio.solicitud.RepositorioSolicitud;
import com.ceiba.servicio.solicitud.ServicioCrearSolicitud;
import com.ceiba.solicitud.testdatabuilder.SolicitudTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static com.ceiba.modelo.objetovalor.DiasFestivos.changeLocalDataTimeForDate;
import static com.ceiba.modelo.objetovalor.DiasFestivos.listarDiasFestivos;

@RunWith(MockitoJUnitRunner.class)
public class ServicioCrearSolicitudTest {

    @Mock
    RepositorioSolicitud repositorioSolicitud;

    @Test(expected = ExcepcionDuplicidad.class)
    public void validarExistenciaSolcitudTest() {
        //arrange
        Solicitud solicitud = new SolicitudTestDataBuilder()
                .conNumSolicitud(1L)
                .build();
        Mockito.when(this.repositorioSolicitud.existe(1L)).thenReturn(true);
        ServicioCrearSolicitud servicioCrearSolicitud = new ServicioCrearSolicitud(this.repositorioSolicitud);

        //act-assert
        servicioCrearSolicitud.ejecutar(solicitud);

        }

        @Test(expected = ExepcionSolicitudesNoVigente.class)
        public void validarNuevaSolicitud(){
            //arrange
            Solicitud solicitud = new SolicitudTestDataBuilder()
                    .conFechSolicitud(LocalDateTime.of(2020,12,17,3,25))//(new Date("December 17, 2020 03:24:00"))
                    .build();
            Mockito.when(this.repositorioSolicitud.getMaxFechaSolicitud(1L)).thenReturn(LocalDateTime.of(2020,12,17,3,5));//(new Date("December 17, 2020 03:24:00"));
            ServicioCrearSolicitud servicioCrearSolicitud = new ServicioCrearSolicitud(this.repositorioSolicitud);
            //act-assert
            servicioCrearSolicitud.ejecutar(solicitud);

        }

        @Test
        public void validarSolicitudDiaFestivo(){
        // arrange
         Solicitud solicitud = new SolicitudTestDataBuilder()
                    .conFechSolicitud(LocalDateTime.of(2021,3,15,3,5))
                    .build();
         //act
            boolean resultado = (listarDiasFestivos().contains(changeLocalDataTimeForDate(solicitud.getFechaSolicitud())));
        // assert
            Assert.assertEquals(false,resultado);
        }

    @Test(expected = ExepcionSolicitudFinDeSemana.class)
    public void validarSolicitudFinDeSemana(){
        // arrange
        Solicitud solicitud = new SolicitudTestDataBuilder()
                .conFechSolicitud(LocalDateTime.of(2020,12,13,3,5))
                .build();
        //act-assert
        Solicitud.validarSolicitudFindeSemana(solicitud.getFechaSolicitud());

    }



}
