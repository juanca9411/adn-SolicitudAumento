package com.ceiba.adaptador.dao.funcionario;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import java.time.LocalDateTime;

import com.ceiba.modelo.dto.funcionario.DtoFuncionario;
import org.springframework.jdbc.core.RowMapper;

public class MapeoFuncionario implements RowMapper<DtoFuncionario>, MapperResult {

    @Override
    public DtoFuncionario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idFuncionario = resultSet.getLong("idFuncionario");
        String nombre = resultSet.getString("nombre");
        String cedula = resultSet.getString("cedula");
        Double salario = resultSet.getDouble("salario");
        LocalDateTime fechaNacimiento = extraerLocalDateTime(resultSet, "fechaNacimiento");
        LocalDateTime fechaIngreso = extraerLocalDateTime(resultSet,"fechaIngreso");

        return new DtoFuncionario(idFuncionario,nombre,cedula,salario,fechaNacimiento,fechaIngreso);
    }

}
