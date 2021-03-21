package com.ceiba.adaptador.repositorio.calendario;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.modelo.entidad.calendario.DiaFestivo;
import com.ceiba.puerto.repositorio.calendario.RepositorioDiaFestivo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class RepositorioDiaFestivoMysql implements RepositorioDiaFestivo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private static String sqlCrear="insert into dia_festivo (dia, fecha) values (:dia,:fecha)";

    private static String sqlExisteByFecha="select count(*) from dia_festivo where fecha= :fecha";


    public RepositorioDiaFestivoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public void agregar(DiaFestivo diaFestivo) {
        this.customNamedParameterJdbcTemplate.crear(diaFestivo, sqlCrear);
    }

    @Override

    public boolean esFestivo(LocalDateTime fecha) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("fecha",fecha);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteByFecha,parameterSource,Boolean.class);
    }


}
