package com.ceiba.adaptador.repositorio.funcionario;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.modelo.entidad.funcionario.Funcionario;
import com.ceiba.puerto.repositorio.funcionario.RepositorioFuncionario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioFuncionarioMysql implements RepositorioFuncionario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="funcionario", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="funcionario", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="funcionario", value="existe")
    private static String sqlExiste;

    private static String sqlActualisarIncrementoSalario ="update funcionario set salario= :salario where idFuncionario= :idFuncionario";

    public RepositorioFuncionarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Funcionario funcionario) {
        return this.customNamedParameterJdbcTemplate.crear(funcionario, sqlCrear);
    }

    @Override
    public boolean existe(String cedula) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("cedula", cedula);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizarIncrementoSalario(Funcionario funcionario) {
        this.customNamedParameterJdbcTemplate.actualizar(funcionario,sqlActualisarIncrementoSalario);
    }

    @Override
    public void actualizar(Funcionario funcionario) {
        this.customNamedParameterJdbcTemplate.actualizar(funcionario, sqlActualizar);
    }


}
