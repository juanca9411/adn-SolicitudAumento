package com.ceiba.adaptador.repositorio.solicitud;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.modelo.entidad.solicitud.Solicitud;
import com.ceiba.puerto.repositorio.solicitud.RepositorioSolicitud;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;


import java.util.Date;

@Repository
public class RepositorioSolicitudMysql implements RepositorioSolicitud {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private static String sqlCrear="insert into solicitud (idFuncionario, fechaSolicitud, justificacion, estado, respuesta) values (:idFuncionario, :fechaSolicitud, :justificacion, :estado, :respuesta)";

    private static String sqlResolverSolicitud="update solicitud set  estado = :estado, respuesta = :respuesta where idFuncionario = :idFuncionario";


    private static String sqlExiste="select count(1) from solicitud where numSolicitud = :numSolicitud";

    private static String sqlGetMaxFechaSolicitud="select max(fechaSolicitud) from solicitud where idFuncionario= :idFuncionario";

    public RepositorioSolicitudMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Solicitud solicitud) {
        return this.customNamedParameterJdbcTemplate.crear(solicitud, sqlCrear);
    }

    @Override
    public void resolver(Solicitud solicitud) {
        this.customNamedParameterJdbcTemplate.actualizar(solicitud, sqlResolverSolicitud);
    }

    @Override
    public boolean existe(Long numSolicitud) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("numSolicitud", numSolicitud);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public Date getMaxFechaSolicitud(Long idFuncionario) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("idFuncionario",idFuncionario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlGetMaxFechaSolicitud,parameterSource, Date.class) ;

    }




}
