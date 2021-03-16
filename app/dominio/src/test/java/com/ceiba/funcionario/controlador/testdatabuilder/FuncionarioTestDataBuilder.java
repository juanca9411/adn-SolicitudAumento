package com.ceiba.funcionario.controlador.testdatabuilder;

import com.ceiba.modelo.entidad.funcionario.Funcionario;

import java.util.Date;

public class FuncionarioTestDataBuilder {

    private Long idFuncionario;
    private String nombre;
    private String cedula;
    private Double salario;
    private Date fechaNacimiento;
    private Date fechaIngreso;

    public FuncionarioTestDataBuilder() {
        nombre = "Juan Camilo";
        cedula = "1050985303";
        salario = 1500000.00;
        fechaNacimiento = new Date("December 17, 1995 03:24:00");
        fechaIngreso = new Date();
    }
    
     public FuncionarioTestDataBuilder conIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
        return this;
    }

    public FuncionarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    
    public FuncionarioTestDataBuilder conCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }
    
    public FuncionarioTestDataBuilder conSalario(Double salario) {
        this.salario = salario;
        return this;
    }
    
    public FuncionarioTestDataBuilder conFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }
    
    public FuncionarioTestDataBuilder conFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }
   

    public Funcionario build() {
        return new Funcionario(idFuncionario,nombre, cedula,salario,fechaNacimiento,fechaIngreso);
    }
}
