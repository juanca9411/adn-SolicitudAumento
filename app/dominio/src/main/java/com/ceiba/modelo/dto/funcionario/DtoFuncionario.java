package com.ceiba.modelo.dto.funcionario;

import lombok.Getter;

import java.util.Date;

@Getter
public class DtoFuncionario {
    private Long idFuncionario;
    private String nombre;
    private String cedula;
    private Double salario;
    private Date fechaNacimiento;
    private Date fechaIngreso;

    public DtoFuncionario(Long idFuncionario, String nombre, String cedula, Double salario, Date fechaNacimiento, Date fechaIngreso) {
        this.idFuncionario = idFuncionario;
        this.nombre = nombre;
        this.cedula = cedula;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }
    
    

}
