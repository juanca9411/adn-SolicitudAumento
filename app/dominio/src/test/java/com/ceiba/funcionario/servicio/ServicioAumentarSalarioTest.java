package com.ceiba.funcionario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExepcionAntiguedadFuncionarioRequerida;
import com.ceiba.dominio.excepcion.ExepcionCantidadDeSalariosMinimo;
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

    @Test
    public void validarAntiguedadFuncionarioErrado(){
        // arrange
        Funcionario funcionario = new FuncionarioTestDataBuilder()
                .conFechaIngreso(LocalDateTime.of(2021,1,17,3,24))
                .build();
        ServicioAumentarSalario servicioAumentarSalario = new ServicioAumentarSalario(this.repositorioFuncionario);

        // act-assert
        BasePrueba.assertThrows(()-> servicioAumentarSalario.ejecutar(funcionario),ExepcionAntiguedadFuncionarioRequerida.class,"Debe tener como minimo 2 años de antiguedad");
    }

    @Test
    public void validarCantidadSalariosMinimos(){
        // arrange
        Funcionario funcionario = new FuncionarioTestDataBuilder()
                .conSalario(2000000.0)
                .conFechaIngreso(LocalDateTime.of(2019,1,17,3,25))
                .build();
        ServicioAumentarSalario servicioAumentarSalario = new ServicioAumentarSalario(this.repositorioFuncionario);

        // act-assert
        BasePrueba.assertThrows(()-> servicioAumentarSalario.ejecutar(funcionario),ExepcionCantidadDeSalariosMinimo.class,"El funcionario supera la cantidad de salarios minimos requisitos para el aumento");
    }

     @Test
   public void validarAumentarSalario(){
        // arrange
        Funcionario funcionario = new FuncionarioTestDataBuilder()
                .conSalario(1700000.0)
                .conFechaIngreso(LocalDateTime.of(2016,1,17,3,25))
                .build();

        double salarioOld = funcionario.getSalario();
        // act
               funcionario.aumentarSalario();
        // assert
        Assert.assertEquals(funcionario.getSalario(),(salarioOld*(PORCENTAJE_AUMENTO_SALARIO/CIEN_PORCIENTO)+salarioOld),0.0);
    }
}
