package com.ceiba.puerto.dao.funcionario;

import com.ceiba.modelo.dto.funcionario.DtoFuncionario;

import java.util.List;

public interface DaoFuncionario {

    List<DtoFuncionario> listar();

    List<DtoFuncionario> getDetalleFuncionario(Long idFuncionario);
}
