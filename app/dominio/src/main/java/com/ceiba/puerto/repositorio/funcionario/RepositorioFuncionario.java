package com.ceiba.puerto.repositorio.funcionario;


import com.ceiba.modelo.entidad.funcionario.Funcionario;

public interface RepositorioFuncionario {
   
    Long crear(Funcionario funcionario);

    void actualizar(Funcionario funcionario);

    boolean existe(String cedula);

    void actualizarIncrementoSalario(Funcionario funcionario);


}
