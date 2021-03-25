package com.ceiba.funcionario.servicio;


import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.*;
import com.ceiba.dominio.excepcion.ExepcionPersonaMenorDeEdad;
import com.ceiba.funcionario.controlador.testdatabuilder.FuncionarioTestDataBuilder;
import com.ceiba.modelo.entidad.funcionario.Funcionario;
import com.ceiba.puerto.repositorio.funcionario.RepositorioFuncionario;
import com.ceiba.servicio.funcionario.ServicioCrearFuncionario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;


@RunWith(MockitoJUnitRunner.class)
public class ServicioCrearFuncionarioTest {

    @Mock
    RepositorioFuncionario repositorioFuncionario;

    @Test
    public void validarExistenciaFuncionarioTest() {
        // arrange
        Funcionario funcionario = new FuncionarioTestDataBuilder()
                .conCedula("1050965338")
                .build();
        Mockito.when(this.repositorioFuncionario.existe("1050965338")).thenReturn(true);
        ServicioCrearFuncionario servicioCrearFuncionario = new ServicioCrearFuncionario(this.repositorioFuncionario);
        // act - assert
        BasePrueba.assertThrows(()-> servicioCrearFuncionario.ejecutar(funcionario),ExcepcionDuplicidad.class,"El funcionario ya existe en el sistema");
    }

    @Test
    public void validarFuncionarioMayorDeEdadErrado(){

        // arange
        Funcionario funcionario = new FuncionarioTestDataBuilder()
                .conFechaNacimiento(LocalDateTime.of(2015,12,17,3,24))
                .build();
        ServicioCrearFuncionario servicioCrearFuncionario = new ServicioCrearFuncionario(this.repositorioFuncionario);

        //act-asset
        BasePrueba.assertThrows(()-> servicioCrearFuncionario.ejecutar(funcionario),ExepcionPersonaMenorDeEdad.class,"El funcionario debe ser mayor de edad");
    }


}
