package com.ceiba.controlador.funcionario;

import com.ceiba.consulta.funcionario.ManejadorGetDetalleFuncionario;
import com.ceiba.consulta.funcionario.ManejadorListarFuncionarios;
import com.ceiba.modelo.dto.funcionario.DtoFuncionario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@Api(tags={"Controlador consulta funcionario"})
public class ConsultaControladorFuncionario {

    private final ManejadorListarFuncionarios manejadorListarFuncionarios;
    private final ManejadorGetDetalleFuncionario manejadorGetDetalleFuncionario;

    public ConsultaControladorFuncionario(ManejadorListarFuncionarios manejadorListarFuncionarios, ManejadorGetDetalleFuncionario manejadorGetDetalleFuncionario) {
        this.manejadorListarFuncionarios = manejadorListarFuncionarios;
        this.manejadorGetDetalleFuncionario = manejadorGetDetalleFuncionario;
    }

    @GetMapping
    @ApiOperation("Listar Funcionarios")
    public List<DtoFuncionario> listar() {
        return this.manejadorListarFuncionarios.ejecutar();

    }


    @GetMapping(value="/{idFuncionario}")
    @ApiOperation("Optener detalle Funcionario")
    public List<DtoFuncionario> getDetalle(@PathVariable Long idFuncionario){
        return this.manejadorGetDetalleFuncionario.ejecutar(idFuncionario);
    }



}
