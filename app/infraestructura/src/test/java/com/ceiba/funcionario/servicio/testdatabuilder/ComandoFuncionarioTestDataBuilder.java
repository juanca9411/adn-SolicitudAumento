package com.ceiba.funcionario.servicio.testdatabuilder;


import com.ceiba.comando.ComandoFuncionario;

import java.util.Date;

public class ComandoFuncionarioTestDataBuilder {

    private Long idFuncionario;
    private String nombre;
    private String cedula;
    private Double salario;
    private Date fechaNacimiento;
    private Date fechaIngreso;


    public ComandoFuncionarioTestDataBuilder() {
        nombre = "juan";
        cedula = "1050965338";
        salario = 1500000.0;
        fechaNacimiento = new Date("December 17, 1995 03:24:00");
        fechaIngreso = new Date("December 17, 2018 03:24:00");
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
     
     public ComandoFuncionarioTestDataBuilder conFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }
     
     public ComandoFuncionarioTestDataBuilder conFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public ComandoFuncionario build() {
        return new ComandoFuncionario(idFuncionario,nombre, cedula,salario,fechaNacimiento,fechaIngreso);
    }
}
