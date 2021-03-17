package com.ceiba.adaptador.dao.calendario;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.modelo.dto.calendario.DtoDiaFestivo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoDiaFestivo implements RowMapper<DtoDiaFestivo>, MapperResult {

    @Override
    public DtoDiaFestivo mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long codigoFecha = resultSet.getLong("codigoFecha");
        String dia = resultSet.getString("dia");
        LocalDateTime fecha = extraerLocalDateTime(resultSet,"fecha");

        return new DtoDiaFestivo(codigoFecha,dia,fecha);
    }

}
