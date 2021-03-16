package com.ceiba.controlador.solicitud;


import com.ceiba.consulta.solicitud.ManejadorListarSolicitudPorIdFuncionario;
import com.ceiba.consulta.solicitud.ManejadorListarSolicitudes;
import com.ceiba.modelo.dto.solicitud.DtoSolicitud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
@Api(tags={"Controlador consulta solicitudes"})
public class ConsultaControladorSolicitud {

    private final ManejadorListarSolicitudes manejadorListarSolicitudes;
    private final ManejadorListarSolicitudPorIdFuncionario manejadorListarSolicitudPorIdFuncionario;

    public ConsultaControladorSolicitud(ManejadorListarSolicitudes manejadorListarSolicitudes, ManejadorListarSolicitudPorIdFuncionario manejadorListarSolicitudPorIdFuncionario) {
        this.manejadorListarSolicitudes = manejadorListarSolicitudes;
        this.manejadorListarSolicitudPorIdFuncionario = manejadorListarSolicitudPorIdFuncionario;
    }

    @GetMapping
    @ApiOperation("Listar solicitudes")
    public List<DtoSolicitud> listar() {
        return this.manejadorListarSolicitudes.ejecutar();
    }

    @GetMapping(value = "/{idFuncionario}")
    @ApiOperation(("Listar solicitudes por id Funcionario"))
    public  List<DtoSolicitud> listar(@PathVariable Long idFuncionario){
        return this.manejadorListarSolicitudPorIdFuncionario.ejecutar(idFuncionario);
    }

}
