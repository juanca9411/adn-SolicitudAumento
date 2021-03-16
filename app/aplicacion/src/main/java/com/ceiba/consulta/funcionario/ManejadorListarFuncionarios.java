package com.ceiba.consulta.funcionario;

import com.ceiba.modelo.dto.funcionario.DtoFuncionario;
import com.ceiba.puerto.dao.funcionario.DaoFuncionario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarFuncionarios {

    private final DaoFuncionario funcionarioDao;

    public ManejadorListarFuncionarios(DaoFuncionario funcionarioDao){

        this.funcionarioDao = funcionarioDao;
    }

    public List<DtoFuncionario> ejecutar(){

        return this.funcionarioDao.listar();
    }
}
