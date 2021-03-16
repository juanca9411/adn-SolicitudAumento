package com.ceiba.adaptador.dao.solicitud;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.solicitud.DtoSolicitud;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoSolicitud implements RowMapper<DtoSolicitud>, MapperResult {

    @Override
    public DtoSolicitud mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idFuncionario = resultSet.getLong("idFuncionario");
        Long numSolicitud = resultSet.getLong("numSolicitud");
        Date fechaSolicitud = resultSet.getDate("fechaSolicitud");
        String justificacion = resultSet.getString("justificacion");
        String estado = resultSet.getString("estado");
        String respuesta = resultSet.getString("respuesta");

        return new DtoSolicitud(idFuncionario,numSolicitud,fechaSolicitud,justificacion,estado,respuesta);
    }

}
