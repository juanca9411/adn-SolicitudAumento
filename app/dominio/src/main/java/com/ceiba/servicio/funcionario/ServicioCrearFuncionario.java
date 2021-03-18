package com.ceiba.servicio.funcionario;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.modelo.entidad.funcionario.Funcionario;
import com.ceiba.puerto.repositorio.funcionario.RepositorioFuncionario;




public class ServicioCrearFuncionario {

    private static final String EL_FUNCIONARIO_YA_EXISTE_EN_EL_SISTEMA = "El funcionario ya existe en el sistema";

    private final RepositorioFuncionario repositorioFuncionario;

    public ServicioCrearFuncionario(RepositorioFuncionario repositorioFuncionario) {
        this.repositorioFuncionario = repositorioFuncionario;
    }

    public Long ejecutar(Funcionario funcionario) {
        funcionario.validarFuncionarioMayorDeEdad();
        validarExistenciaPrevia(funcionario);
        return this.repositorioFuncionario.crear(funcionario);
    }

    private void validarExistenciaPrevia(Funcionario funcionario) {
        boolean existe = this.repositorioFuncionario.existe(funcionario.getCedula());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_FUNCIONARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }



}
