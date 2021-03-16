package com.ceiba.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoFuncionario{

    private Long idFuncionario;
    private String nombre;
    private String cedula;
    private Double salario;
    private Date fechaNacimiento;
    private Date fechaIngreso;

}
