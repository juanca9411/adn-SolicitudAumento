package com.ceiba.funcionario.servicio.testdatabuilder;


import com.ceiba.comando.ComandoFuncionario;

import java.time.LocalDateTime;
import java.util.Date;

public class ComandoFuncionarioTestDataBuilder {

    private Long idFuncionario;
    private String nombre;
    private String cedula;
    private Double salario;
    private LocalDateTime fechaNacimiento;
    private LocalDateTime fechaIngreso;


    public ComandoFuncionarioTestDataBuilder() {
        nombre = "juan";
        cedula = "1050965338";
        salario = 1500000.0;
        fechaNacimiento = LocalDateTime.of(1995,12,17,3,25);
        fechaIngreso = LocalDateTime.of(2018,12,17,3,25);
    }

    public ComandoFuncionarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    
    public ComandoFuncionarioTestDataBuilder conCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }
    
     public ComandoFuncionarioTestDataBuilder conSalario(Double salario) {
        this.salario = salario;
        return this;
    }
     
     public ComandoFuncionarioTestDataBuilder conFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }
     
     public ComandoFuncionarioTestDataBuilder conFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public ComandoFuncionario build() {
        return new ComandoFuncionario(idFuncionario,nombre, cedula,salario,fechaNacimiento,fechaIngreso);
    }
}
