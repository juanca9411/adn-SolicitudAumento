package com.ceiba.puerto.repositorio.funcionario;


import com.ceiba.modelo.entidad.funcionario.Funcionario;

public interface RepositorioFuncionario {

    /**
     * Metodo para crear un funcionario
     * */
   
    Long crear(Funcionario funcionario);

    /**
     * Metodo para actualizar un funcionario
     * */

    void actualizar(Funcionario funcionario);

    /**
     * Verificar si existe un funcionario
     * */

    boolean existe(String cedula);

    /**
     * Metodo para aumentar el salario de un funcionario
     * segun las reglas de negocio.
     * */

    void actualizarIncrementoSalario(Funcionario funcionario);


}
