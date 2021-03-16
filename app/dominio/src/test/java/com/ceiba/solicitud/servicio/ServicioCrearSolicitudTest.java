package com.ceiba.solicitud.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.exepcion.ExepcioSolicitudDiaNoHabil;
import com.ceiba.exepcion.ExepcionSolicitudFinDeSemana;
import com.ceiba.exepcion.ExepcionSolicitudesNoVigente;
import com.ceiba.modelo.entidad.solicitud.Solicitud;
import com.ceiba.modelo.objetovalor.DiasFestivos;
import com.ceiba.puerto.repositorio.solicitud.RepositorioSolicitud;
import com.ceiba.servicio.solicitud.ServicioCrearSolicitud;
import com.ceiba.solicitud.testdatabuilder.SolicitudTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;
import java.util.List;

import static com.ceiba.modelo.objetovalor.DiasFestivos.listarDiasFestivos;

@RunWith(MockitoJUnitRunner.class)
public class ServicioCrearSolicitudTest {

    @Mock
    RepositorioSolicitud repositorioSolicitud;

    @Test(expected = ExcepcionDuplicidad.class)
    public void validarExistenciaSolcitudTest() {
        //arrange
        Solicitud solicitud = new SolicitudTestDataBuilder()
                .conNumSolicitud(1l)
                .build();
        Mockito.when(this.repositorioSolicitud.existe(1l)).thenReturn(true);
        ServicioCrearSolicitud servicioCrearSolicitud = new ServicioCrearSolicitud(this.repositorioSolicitud);

        //act-assert
        servicioCrearSolicitud.ejecutar(solicitud);

        }

        @Test(expected = ExepcionSolicitudesNoVigente.class)
        public void validarNuevaSolicitud(){
            //arrange
            Solicitud solicitud = new SolicitudTestDataBuilder()
                    .conFechSolicitud(new Date("December 17, 2020 03:24:00"))
                    .build();
            Mockito.when(this.repositorioSolicitud.getMaxFechaSolicitud(1l)).thenReturn(new Date("December 17, 2020 03:24:00"));
            ServicioCrearSolicitud servicioCrearSolicitud = new ServicioCrearSolicitud(this.repositorioSolicitud);
            //act-assert
            servicioCrearSolicitud.ejecutar(solicitud);

        }

        @Test
        public void validarSolicitudDiaFestivo(){
        // arrange
         Solicitud solicitud = new SolicitudTestDataBuilder()
                    .conFechSolicitud(new Date("15/03/2021"))
                    .build();
         //act
            boolean resultado = (listarDiasFestivos().contains(solicitud.getFechaSolicitud()));
        // assert
            Assert.assertEquals(false,resultado);
        }

    @Test(expected = ExepcionSolicitudFinDeSemana.class)
    public void validarSolicitudFinDeSemana(){
        // arrange
        Solicitud solicitud = new SolicitudTestDataBuilder()
                .conFechSolicitud(new Date("December 13, 2020 03:24:00"))
                .build();
        //act-assert
        Solicitud.validarSolicitudFindeSemana(solicitud.getFechaSolicitud());

    }



}
