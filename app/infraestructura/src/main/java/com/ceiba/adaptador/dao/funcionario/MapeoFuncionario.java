package com.ceiba.adaptador.dao.funcionario;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import java.sql.Date;

import com.ceiba.modelo.dto.funcionario.DtoFuncionario;
import org.springframework.jdbc.core.RowMapper;

public class MapeoFuncionario implements RowMapper<DtoFuncionario>, MapperResult {

    @Override
    public DtoFuncionario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idFuncionario = resultSet.getLong("idFuncionario");
        String nombre = resultSet.getString("nombre");
        String cedula = resultSet.getString("cedula");
        Double salario = resultSet.getDouble("salario");
        Date fechaNacimiento = resultSet.getDate("fechaNacimiento");
        Date fechaIngreso = resultSet.getDate("fechaIngreso");

        return new DtoFuncionario(idFuncionario,nombre,cedula,salario,fechaNacimiento,fechaIngreso);
    }

}
