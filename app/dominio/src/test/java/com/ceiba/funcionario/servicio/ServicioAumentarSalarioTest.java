package com.ceiba.funcionario.servicio;

import com.ceiba.exepcion.ExepcionAntiguedadFuncionarioRequerida;
import com.ceiba.exepcion.ExepcionCantidadDeSalariosMinimo;
import com.ceiba.funcionario.controlador.testdatabuilder.FuncionarioTestDataBuilder;
import com.ceiba.modelo.entidad.funcionario.Funcionario;
import com.ceiba.puerto.repositorio.funcionario.RepositorioFuncionario;
import com.ceiba.servicio.funcionario.ServicioAumentarSalario;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static com.ceiba.modelo.entidad.funcionario.Funcionario.aumentarSalario;
import static com.ceiba.props.funcionario.ConstatesFuncionario.PORCENTAJE_AUMENTO_SALARIO;


public class ServicioAumentarSalarioTest {


    RepositorioFuncionario repositorioFuncionario;

    @Test(expected = ExepcionAntiguedadFuncionarioRequerida.class)
    public void validarAntiguedadFuncionarioErrado(){
        // arrange
        Funcionario funcionario = new FuncionarioTestDataBuilder()
                .conFechaIngreso(new Date("January 17, 2020 03:24:00"))
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
                .conFechaIngreso(new Date("January 17, 2019 03:24:00"))
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
                .conFechaIngreso(new Date("January 17, 2016 03:24:00"))
                .build();
        // act
        double resultado = aumentarSalario(funcionario.getFechaIngreso(),funcionario.getSalario());

        // assert
        Assert.assertTrue(resultado==
                (funcionario.getSalario()*(PORCENTAJE_AUMENTO_SALARIO/100D)+funcionario.getSalario()));
    }



}
