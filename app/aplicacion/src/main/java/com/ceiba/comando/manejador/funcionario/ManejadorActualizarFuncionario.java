package com.ceiba.comando.manejador.funcionario;

import com.ceiba.comando.ComandoFuncionario;
import com.ceiba.comando.fabrica.funcionario.FabricaFuncionario;
import com.ceiba.modelo.entidad.funcionario.Funcionario;
import com.ceiba.servicio.funcionario.ServicioActualizarFuncionario;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarFuncionario implements ManejadorComando<ComandoFuncionario> {

    private final FabricaFuncionario fabricaFuncionario;
    private final ServicioActualizarFuncionario servicioActualizarFuncionario;

    public ManejadorActualizarFuncionario(FabricaFuncionario fabricaFuncionario, ServicioActualizarFuncionario servicioActualizarFuncionario) {
        this.fabricaFuncionario = fabricaFuncionario;
        this.servicioActualizarFuncionario = servicioActualizarFuncionario;
    }

    public void ejecutar(ComandoFuncionario comandoUsuario) {
        Funcionario funcionario = this.fabricaFuncionario.crear(comandoUsuario);
        this.servicioActualizarFuncionario.ejecutar(funcionario);
    }
}
