package com.ceiba.puerto.dao.funcionario;

import com.ceiba.modelo.dto.funcionario.DtoFuncionario;

import java.util.List;

public interface DaoFuncionario {

    /**
     * Permite listar funcionarios
     * @return los funcionarios
     */
    List<DtoFuncionario> listar();

    /**
     * Muestra el detalle de un funcionario por su id
     * @return un funcionario
     */

    List<DtoFuncionario> getDetalleFuncionario(Long idFuncionario);
}
