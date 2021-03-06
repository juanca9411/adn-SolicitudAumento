package com.ceiba.funcionario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExepcionNoExiste;
import com.ceiba.funcionario.controlador.testdatabuilder.FuncionarioTestDataBuilder;
import com.ceiba.modelo.entidad.funcionario.Funcionario;
import com.ceiba.puerto.repositorio.funcionario.RepositorioFuncionario;
import com.ceiba.servicio.funcionario.ServicioActualizarFuncionario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServicioActualizarFuncionarioTest {

    @Mock
    RepositorioFuncionario repositorioFuncionario;

    @Test
    public void validarExistenciaFuncionarioTest() {
        // arrange
        Funcionario funcionario = new FuncionarioTestDataBuilder()
                .conCedula("1050965338")
                .build();
        Mockito.when(this.repositorioFuncionario.existe("10509653")).thenReturn(true);
        ServicioActualizarFuncionario servicioActualizarFuncionario = new ServicioActualizarFuncionario(this.repositorioFuncionario);
        // act - assert
        BasePrueba.assertThrows(()-> servicioActualizarFuncionario.ejecutar(funcionario),ExepcionNoExiste.class,"El funcionario no existe en el sistema");
    }

}
