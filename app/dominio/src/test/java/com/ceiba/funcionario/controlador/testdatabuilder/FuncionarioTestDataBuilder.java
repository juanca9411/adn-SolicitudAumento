package com.ceiba.funcionario.controlador.testdatabuilder;

import com.ceiba.modelo.entidad.funcionario.Funcionario;

import java.time.LocalDateTime;

public class FuncionarioTestDataBuilder {

    private Long idFuncionario;
    private String nombre;
    private String cedula;
    private Double salario;
    private LocalDateTime fechaNacimiento;
    private LocalDateTime fechaIngreso;

    public FuncionarioTestDataBuilder() {
        nombre = "Juan Camilo";
        cedula = "1050985303";
        salario = 1500000.00;
        fechaNacimiento = LocalDateTime.of(1995,12,17,3,24);
        fechaIngreso = LocalDateTime.now();
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
    
    public FuncionarioTestDataBuilder conFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }
    
    public FuncionarioTestDataBuilder conFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }
   

    public Funcionario build() {
        return new Funcionario(idFuncionario,nombre, cedula,salario,fechaNacimiento,fechaIngreso);
    }
}
