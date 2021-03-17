package com.ceiba.adaptador.dao.calendario;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.modelo.dto.calendario.DtoDiaFestivo;
import com.ceiba.puerto.dao.calendario.DaoDiaFestivo;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DaoDiaFestivoMysql implements DaoDiaFestivo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private static String sqlListar="select codigoFecha,dia,fecha from dia_festivo";


    public DaoDiaFestivoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoDiaFestivo> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDiaFestivo());
    }


}
