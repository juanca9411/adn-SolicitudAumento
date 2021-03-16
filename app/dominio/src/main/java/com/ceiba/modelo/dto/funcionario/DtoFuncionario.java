package com.ceiba.modelo.dto.funcionario;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DtoFuncionario {
    private Long idFuncionario;
    private String nombre;
    private String cedula;
    private Double salario;
    private LocalDateTime fechaNacimiento;
    private LocalDateTime fechaIngreso;

    public DtoFuncionario(Long idFuncionario, String nombre, String cedula, Double salario, LocalDateTime fechaNacimiento, LocalDateTime fechaIngreso) {
        this.idFuncionario = idFuncionario;
        this.nombre = nombre;
        this.cedula = cedula;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }
    
    

}
