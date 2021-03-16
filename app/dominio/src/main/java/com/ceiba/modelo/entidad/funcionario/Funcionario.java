package com.ceiba.modelo.entidad.funcionario;


import com.ceiba.exepcion.ExepcionAntiguedadFuncionarioRequerida;
import com.ceiba.exepcion.ExepcionCantidadDeSalariosMinimo;
import com.ceiba.exepcion.ExepcionPersonaMenorDeEdad;
import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.props.funcionario.ConstatesFuncionario.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;



@Getter
@Setter
public class Funcionario {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_FUNCIONARIO = "Se debe ingresar el nombre del funcionario";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula";
    private static final String SE_DEBE_INGRESAR_EL_SALARIO = "Se debe ingresar el salario";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO = "Se debe ingresar la fecha de nacimiento";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO = "Se debe ingresar la fecha de ingreso";
    private static final String EL_FUNCIONARIO_DEBE_SER_MAYOR_DE_EDAD = "El funcionario debe ser mayor de edad";
    private static final String NO_CUMPLE_CON_EL_TIEMPO_MINIMO_DE_ANTIGUEDAD = "Debe tener como minimo 2 años de antiguedad";
    private static final String FUNCIONARIO_SUPERA_LA_CANTIDAD_DE_SALARIOS_MINIMOS_REQUISITOS_PARA_AUMENTO = "El funcionario supera la cantidad de " +
            "salarios minimos requisitos para el aumento";

    private Long idFuncionario;
    private String nombre;
    private String cedula;
    private Double salario;
    private Date fechaNacimiento;
    private Date fechaIngreso;

    public Funcionario(Long idFuncionario, String nombre, String cedula, Double salario, Date fechaNacimiento, Date fechaIngreso) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_FUNCIONARIO);
        validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA);
        validarObligatorio(salario, SE_DEBE_INGRESAR_EL_SALARIO);
        validarObligatorio(fechaNacimiento, SE_DEBE_INGRESAR_LA_FECHA_DE_NACIMIENTO);
        validarObligatorio(fechaIngreso, SE_DEBE_INGRESAR_LA_FECHA_DE_INGRESO);

        this.idFuncionario = idFuncionario;
        this.nombre = nombre;
        this.cedula = cedula;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }

    public static Double aumentarSalario(Date fechaIngreso, Double salario){
        validarAntiguedadFuncionario(fechaIngreso);
        validarCantidadSalariosMinimos(salario);
        return  salario * (PORCENTAJE_AUMENTO_SALARIO/100D) +salario;
    }

    public static void validarFuncionarioMayorDeEdad (Date date){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fechaTexto = formatter.format(date);
        LocalDate fechaNac = LocalDate.parse(fechaTexto, fmt);
        LocalDate currentDate = LocalDate.now();
        Period periodo = Period.between(fechaNac, currentDate);
        if (periodo.getYears() < 18) {
            throw new ExepcionPersonaMenorDeEdad(EL_FUNCIONARIO_DEBE_SER_MAYOR_DE_EDAD);
        }
    }

    public static void validarAntiguedadFuncionario(Date fechaIngreso){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String fechaTexto = formatter.format(fechaIngreso);
        LocalDate fechaNac = LocalDate.parse(fechaTexto, fmt);
        LocalDate currentDate = LocalDate.now();
        Period periodo = Period.between(fechaNac, currentDate);
        if (periodo.getYears() < 2) {
            throw new ExepcionAntiguedadFuncionarioRequerida(NO_CUMPLE_CON_EL_TIEMPO_MINIMO_DE_ANTIGUEDAD);
        }
    }

    public static void validarCantidadSalariosMinimos(Double salario){
        var salarioMinimoRequisito = SALARIO_MINIMO_LEGAL_VIGENTE*CANTIDAD_SALARIOS_MINIMOS_REQUERIDOS_PARA_AUMENTO;
        if (salario>salarioMinimoRequisito){
        throw new ExepcionCantidadDeSalariosMinimo(FUNCIONARIO_SUPERA_LA_CANTIDAD_DE_SALARIOS_MINIMOS_REQUISITOS_PARA_AUMENTO);
        }

    }




}
