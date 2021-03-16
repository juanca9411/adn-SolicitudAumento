package com.ceiba.adaptador.dao.funcionario;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.dto.funcionario.DtoFuncionario;
import com.ceiba.puerto.dao.funcionario.DaoFuncionario;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;


@Component
public class DaoFuncionarioMysql implements DaoFuncionario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="funcionario", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="funcionario", value="listarByIdFuncionario")
    private static String sqlListarBYIdFncionario;

    public DaoFuncionarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoFuncionario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoFuncionario());
    }

    @Override
    public List<DtoFuncionario> getDetalleFuncionario(Long idFuncionario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idFuncionario", idFuncionario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarBYIdFncionario,paramSource, new MapeoFuncionario());
    }
}
