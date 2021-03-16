package com.ceiba.adaptador.dao.solicitud;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.modelo.dto.solicitud.DtoSolicitud;
import com.ceiba.puerto.dao.solicitud.DaoSolicitud;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DaoSolicitudMysql implements DaoSolicitud {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    //@SqlStatement(namespace="solicitud", value="listar")
    private static String sqlListar ="SELECT idFuncionario, numSolicitud, fechaSolicitud, justificacion, estado, respuesta FROM solicitud";

   // @SqlStatement(namespace="solicitud", value="listarByIdFuncionario")
    private static String sqlListarBYIdFncionario="SELECT idFuncionario, numSolicitud, fechaSolicitud, justificacion, estado, respuesta\n" +
           "FROM solicitud where idFuncionario = :idFuncionario";

    public DaoSolicitudMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoSolicitud> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoSolicitud());
    }

    @Override
    public List<DtoSolicitud> listarSolicitudPorFuncionario(Long idFuncionario) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("idFuncionario",idFuncionario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarBYIdFncionario,parameterSource,new MapeoSolicitud());
    }

}
