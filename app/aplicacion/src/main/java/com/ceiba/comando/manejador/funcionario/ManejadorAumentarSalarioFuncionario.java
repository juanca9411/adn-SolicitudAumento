package com.ceiba.comando.manejador.funcionario;

import com.ceiba.comando.ComandoFuncionario;
import com.ceiba.comando.fabrica.funcionario.FabricaFuncionario;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.modelo.entidad.funcionario.Funcionario;
import com.ceiba.servicio.funcionario.ServicioAumentarSalario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAumentarSalarioFuncionario implements ManejadorComando<ComandoFuncionario> {

    private final ServicioAumentarSalario servicioAumentarSalario;
    private final FabricaFuncionario fabricaFuncionario;

    public ManejadorAumentarSalarioFuncionario(ServicioAumentarSalario servicioAumentarSalario, FabricaFuncionario fabricaFuncionario){
        this.servicioAumentarSalario=servicioAumentarSalario;
        this.fabricaFuncionario = fabricaFuncionario;
    }

    public void ejecutar(ComandoFuncionario comandoFuncionario){
        Funcionario funcionario = this.fabricaFuncionario.crear(comandoFuncionario);
        this.servicioAumentarSalario.ejecutar(funcionario);
    }

}
