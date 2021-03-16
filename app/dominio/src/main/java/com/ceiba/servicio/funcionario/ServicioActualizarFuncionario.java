package com.ceiba.servicio.funcionario;


import com.ceiba.exepcion.ExepcionNoExiste;
import com.ceiba.modelo.entidad.funcionario.Funcionario;
import com.ceiba.puerto.repositorio.funcionario.RepositorioFuncionario;

public class ServicioActualizarFuncionario {

    private static final String EL_FUNCIONARIO_NO_EXISTE_EN_EL_SISTEMA = "El funcionario no existe en el sistema";

    private final RepositorioFuncionario repositorioFuncionario;

    public ServicioActualizarFuncionario(RepositorioFuncionario repositorioFuncionario) {
        this.repositorioFuncionario = repositorioFuncionario;
    }

    public void ejecutar(Funcionario funcionario) {
        validarExistencia(funcionario);
        this.repositorioFuncionario.actualizar(funcionario);
    }

    private void validarExistencia(Funcionario funcionario) {
        boolean existe = this.repositorioFuncionario.existe(funcionario.getCedula());
        if(!existe) {
            throw new ExepcionNoExiste(EL_FUNCIONARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
