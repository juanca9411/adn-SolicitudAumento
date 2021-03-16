package com.ceiba.consulta.funcionario;

import com.ceiba.modelo.dto.funcionario.DtoFuncionario;
import com.ceiba.puerto.dao.funcionario.DaoFuncionario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorGetDetalleFuncionario {

    private final DaoFuncionario daoFuncionario;


    public ManejadorGetDetalleFuncionario(DaoFuncionario daoFuncionario) {

        this.daoFuncionario = daoFuncionario;
    }

    public List<DtoFuncionario> ejecutar(Long idFuncionario){
        return this.daoFuncionario.getDetalleFuncionario(idFuncionario);
    }
}
