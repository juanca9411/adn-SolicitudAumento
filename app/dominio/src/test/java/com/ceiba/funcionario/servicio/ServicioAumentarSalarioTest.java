package com.ceiba.funcionario.servicio;

import com.ceiba.exepcion.ExepcionAntiguedadFuncionarioRequerida;
import com.ceiba.exepcion.ExepcionCantidadDeSalariosMinimo;
import com.ceiba.funcionario.controlador.testdatabuilder.FuncionarioTestDataBuilder;
import com.ceiba.modelo.entidad.funcionario.Funcionario;
import com.ceiba.puerto.repositorio.funcionario.RepositorioFuncionario;
import com.ceiba.servicio.funcionario.ServicioAumentarSalario;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static com.ceiba.modelo.entidad.funcionario.Funcionario.CIEN_PORCIENTO;
import static com.ceiba.modelo.entidad.funcionario.Funcionario.PORCENTAJE_AUMENTO_SALARIO;


@RunWith(MockitoJUnitRunner.class)
public class ServicioAumentarSalarioTest {

    @Mock
    RepositorioFuncionario repositorioFuncionario;

    @Test(expected = ExepcionAntiguedadFuncionarioRequerida.class)
    public void validarAntiguedadFuncionarioErrado(){
        // arrange
        Funcionario funcionario = new FuncionarioTestDataBuilder()
                .conFechaIngreso(LocalDateTime.of(2021,1,17,3,24))
                .build();
        ServicioAumentarSalario servicioAumentarSalario = new ServicioAumentarSalario(this.repositorioFuncionario);

        // act-assert
        servicioAumentarSalario.ejecutar(funcionario);
    }

    @Test(expected = ExepcionCantidadDeSalariosMinimo.class)
    public void validarCantidadSalariosMinimos(){
        // arrange
        Funcionario funcionario = new FuncionarioTestDataBuilder()
                .conSalario(2000000.0)
                .conFechaIngreso(LocalDateTime.of(2019,1,17,3,25))
                .build();
        ServicioAumentarSalario servicioAumentarSalario = new ServicioAumentarSalario(this.repositorioFuncionario);

        // act-assert
        servicioAumentarSalario.ejecutar(funcionario);
    }

    @Test
    public void validarAumentarSalario(){
        // arrange
        Funcionario funcionario = new FuncionarioTestDataBuilder()
                .conSalario(1700000.0)
                .conFechaIngreso(LocalDateTime.of(2016,1,17,3,25))
                .build();
        // act
        double resultado = funcionario.aumentarSalario();

        // assert
        Assert.assertEquals(resultado,(funcionario.getSalario()*(PORCENTAJE_AUMENTO_SALARIO/CIEN_PORCIENTO)+funcionario.getSalario()),0.0);
    }
}
