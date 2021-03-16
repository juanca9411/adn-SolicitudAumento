package com.ceiba.modelo.entidad.solicitud;

import com.ceiba.exepcion.ExepcioSolicitudDiaNoHabil;
import com.ceiba.exepcion.ExepcionSolicitudFinDeSemana;
import com.ceiba.exepcion.ExepcionSolicitudesNoVigente;
import com.ceiba.modelo.objetovalor.Dias;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.modelo.objetovalor.DiasFestivos.listarDiasFestivos;


@Getter
@Setter
public class Solicitud {

    private static final String SE_DEBE_INGRESAR_JUSTIFICACION = "Se debe ingresar la justificacion";
    private static final String SE_DEBE_INGRESAR_ID_FUNCIONARIO = "Id funcionario no puede ser null";
    private static final String SE_DEBE_INGRESAR_ESTADO= "Se debe ingresar el estado";
    private static final String SE_DEBE_FECHA_DE_SOLICITUD= "Se debe ingresar la fecha de solicitud";
    private static final String LA_SOLICITUD_NO_PUEDE_SER_UN_FIN_DE_SEMANA= "La solicitud no puede realizarce un fin de semana";
    private static final String SOLO_SE_PUEDE_REALIZAR_SOLICITUDES_EN_DIAS_HABILES="Solo se pueden realizar solicitudes en dias habiles";
    private static final String NO_CUENTA_CON_EL_TIEMPO_MINIMO_PARA_REALIZAR_UNA_NUEVA_SOLICITU = "No ha pasado el tiempo minimo (6 meses) desde que realizo la ultima solicitud";

    private Long idFuncionario;
    private Long numSolicitud;
    private Date fechaSolicitud;
    private String justificacion;
    private String estado;
    private String respuesta;

    public Solicitud(Long idFuncionario, Long numSolicitud, Date fechaSolicitud, String justificacion, String estado, String respuesta) {

        validarObligatorio(idFuncionario, SE_DEBE_INGRESAR_ID_FUNCIONARIO);
        validarObligatorio(fechaSolicitud, SE_DEBE_FECHA_DE_SOLICITUD);
        validarObligatorio(justificacion, SE_DEBE_INGRESAR_JUSTIFICACION);
        validarObligatorio(estado, SE_DEBE_INGRESAR_ESTADO);


        this.idFuncionario = idFuncionario;
        this.numSolicitud=numSolicitud;
        this.fechaSolicitud=fechaSolicitud;
        this.justificacion=justificacion;
        this.estado=estado;
        this.respuesta=respuesta;
    }

    public static void validarSolicitudFindeSemana(Date fechaSolicitud){
        Locale espanol = new Locale("es","ES");
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE", espanol);
        String fechaTexto = formatter.format(fechaSolicitud);
        if (fechaTexto.equals(Dias.sábado.toString())||fechaTexto.equals(Dias.domingo.toString())){
            throw new ExepcionSolicitudFinDeSemana(LA_SOLICITUD_NO_PUEDE_SER_UN_FIN_DE_SEMANA);
        }
    }

    public  static void validarSolicitudDiaFestivo(Date fechaSolicitud){
        List<Date> listDiasFestivos = listarDiasFestivos();
        listDiasFestivos.forEach(list ->{
            if (list.compareTo(fechaSolicitud)==0){
                throw new ExepcioSolicitudDiaNoHabil(SOLO_SE_PUEDE_REALIZAR_SOLICITUDES_EN_DIAS_HABILES);
            }
        });
    }

    public static void validarNuevaSolicitud(Date fechaUltimaSolicitud, Date fechaSolicitud){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        String fechaTexto = formatter.format(fechaUltimaSolicitud);
        String fechaTexto2 = formatter.format(fechaSolicitud);

        LocalDate ultimaSolicitud = LocalDate.parse(fechaTexto, fmt);
        LocalDate nuevaSolicitud = LocalDate.parse(fechaTexto2, fmt);

        Period periodo = Period.between(ultimaSolicitud,nuevaSolicitud);

        if(periodo.getYears()<1 && periodo.getMonths()<6){
            throw new ExepcionSolicitudesNoVigente(NO_CUENTA_CON_EL_TIEMPO_MINIMO_PARA_REALIZAR_UNA_NUEVA_SOLICITU);
        }
    }

}
