package com.ceiba.modelo.entidad.solicitud;

import com.ceiba.dominio.excepcion.ExepcionSolicitudFinDeSemana;
import com.ceiba.dominio.excepcion.ExepcionSolicitudesNoVigente;
import com.ceiba.modelo.objetovalor.Dias;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;


@Getter
@Setter
public class Solicitud {

    private static final String SE_DEBE_INGRESAR_JUSTIFICACION = "Se debe ingresar la justificacion";
    private static final String SE_DEBE_INGRESAR_ID_FUNCIONARIO = "Id funcionario no puede ser null";
    private static final String SE_DEBE_INGRESAR_ESTADO = "Se debe ingresar el estado";
    private static final String SE_DEBE_FECHA_DE_SOLICITUD = "Se debe ingresar la fecha de solicitud";
    private static final String LA_SOLICITUD_NO_PUEDE_SER_UN_FIN_DE_SEMANA = "La solicitud no puede realizarce un fin de semana";
    private static final String NO_CUENTA_CON_EL_TIEMPO_MINIMO_PARA_REALIZAR_UNA_NUEVA_SOLICITU = "No ha pasado el tiempo minimo (6 meses) desde que realizo la ultima solicitud";
    private static final String FORMATO_DD_MM_YYYY = "dd/MM/yyyy";
    private static final int PERIODO_MENSUAL_COMPRENDIDO_ENTRE_DOS_SOLICITUDES = 6;
    private static final int PERIODO_ANUAL_COMPRENDIDO_ENTRE_DOS_SOLICITUDES=1;

    private Long idFuncionario;
    private Long numSolicitud;
    private LocalDateTime fechaSolicitud;
    private String justificacion;
    private String estado;
    private String respuesta;

    public Solicitud(Long idFuncionario, Long numSolicitud, LocalDateTime fechaSolicitud, String justificacion, String estado, String respuesta) {

        validarObligatorio(idFuncionario, SE_DEBE_INGRESAR_ID_FUNCIONARIO);
        validarObligatorio(fechaSolicitud, SE_DEBE_FECHA_DE_SOLICITUD);
        validarObligatorio(justificacion, SE_DEBE_INGRESAR_JUSTIFICACION);
        validarObligatorio(estado, SE_DEBE_INGRESAR_ESTADO);


        this.idFuncionario = idFuncionario;
        this.numSolicitud = numSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.justificacion = justificacion;
        this.estado = estado;
        this.respuesta = respuesta;
    }

    public void validarSolicitudFindeSemana() {
        Locale espanol = new Locale("es", "ES");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE", espanol);
        String fechaTexto = this.fechaSolicitud.format(formatter);
        if (fechaTexto.equals(Dias.sábado.toString()) || fechaTexto.equals(Dias.domingo.toString())) {
            throw new ExepcionSolicitudFinDeSemana(LA_SOLICITUD_NO_PUEDE_SER_UN_FIN_DE_SEMANA);
        }
    }

    public void validarTiempoMinimoNuevaSolicitud(LocalDateTime fechaUltimaSolicitud) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(FORMATO_DD_MM_YYYY);
        String fechaTexto = fechaUltimaSolicitud.format(fmt);
        String fechaTexto2 = this.fechaSolicitud.format(fmt);

        LocalDate ultimaSolicitud = LocalDate.parse(fechaTexto, fmt);
        LocalDate nuevaSolicitud = LocalDate.parse(fechaTexto2, fmt);

        Period periodo = Period.between(ultimaSolicitud, nuevaSolicitud);

        if (periodo.getYears() < PERIODO_ANUAL_COMPRENDIDO_ENTRE_DOS_SOLICITUDES && periodo.getMonths() < PERIODO_MENSUAL_COMPRENDIDO_ENTRE_DOS_SOLICITUDES) {
            throw new ExepcionSolicitudesNoVigente(NO_CUENTA_CON_EL_TIEMPO_MINIMO_PARA_REALIZAR_UNA_NUEVA_SOLICITU);
        }
    }

}
