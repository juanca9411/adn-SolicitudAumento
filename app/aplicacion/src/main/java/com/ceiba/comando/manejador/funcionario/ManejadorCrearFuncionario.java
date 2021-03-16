package com.ceiba.comando.manejador.funcionario;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoFuncionario;
import com.ceiba.comando.fabrica.funcionario.FabricaFuncionario;
import com.ceiba.modelo.entidad.funcionario.Funcionario;
import com.ceiba.servicio.funcionario.ServicioCrearFuncionario;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearFuncionario implements ManejadorComandoRespuesta<ComandoFuncionario, ComandoRespuesta<Long>> {

    private final FabricaFuncionario fabricaFuncionario;
    private final ServicioCrearFuncionario servicioCrearFuncionario;

    public ManejadorCrearFuncionario(FabricaFuncionario fabricaUsuario, ServicioCrearFuncionario servicioCrearFuncionario) {
        this.fabricaFuncionario = fabricaUsuario;
        this.servicioCrearFuncionario = servicioCrearFuncionario;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoFuncionario comandoFuncionario) {
        Funcionario funcionario = this.fabricaFuncionario.crear(comandoFuncionario);
        return new ComandoRespuesta<>(this.servicioCrearFuncionario.ejecutar(funcionario));
    }
}
