package com.ceiba.comando.fabrica.funcionario;

import com.ceiba.comando.ComandoFuncionario;
import com.ceiba.modelo.entidad.funcionario.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FabricaFuncionario {

    public Funcionario crear(ComandoFuncionario comandoFuncionario) {
        return new Funcionario(
                comandoFuncionario.getIdFuncionario(),
                comandoFuncionario.getNombre(),
                comandoFuncionario.getCedula(),
                comandoFuncionario.getSalario(),
                comandoFuncionario.getFechaNacimiento(),
                comandoFuncionario.getFechaIngreso()
        );
    }

}
