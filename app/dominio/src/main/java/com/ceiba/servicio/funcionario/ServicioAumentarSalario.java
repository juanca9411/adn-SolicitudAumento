package com.ceiba.servicio.funcionario;

import com.ceiba.modelo.entidad.funcionario.Funcionario;
import static com.ceiba.modelo.entidad.funcionario.Funcionario.*;
import com.ceiba.puerto.repositorio.funcionario.RepositorioFuncionario;

public class ServicioAumentarSalario {

    private final RepositorioFuncionario repositorioFuncionario;

    public ServicioAumentarSalario(RepositorioFuncionario repositorioFuncionario){
        this.repositorioFuncionario=repositorioFuncionario;
    }

    public void ejecutar(Funcionario funcionario){
        funcionario.aumentarSalario();
        this.repositorioFuncionario.actualizarIncrementoSalario(funcionario);
    }

}
