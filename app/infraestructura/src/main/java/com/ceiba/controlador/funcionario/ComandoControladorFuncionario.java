package com.ceiba.controlador.funcionario;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoFuncionario;
import com.ceiba.comando.manejador.funcionario.ManejadorActualizarFuncionario;
import com.ceiba.comando.manejador.funcionario.ManejadorAumentarSalarioFuncionario;
import com.ceiba.comando.manejador.funcionario.ManejadorCrearFuncionario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/funcionarios")
@Api(tags = { "Controlador comando funcionario"})
public class ComandoControladorFuncionario {

    private final ManejadorCrearFuncionario manejadorCrearFuncionario;
    private final ManejadorActualizarFuncionario manejadorActualizarFuncionario;
    private final ManejadorAumentarSalarioFuncionario manejadorAumentarSalarioFuncionario;

    @Autowired
    public ComandoControladorFuncionario(ManejadorCrearFuncionario manejadorCrearFuncionario, ManejadorActualizarFuncionario manejadorActualizarFuncionario, ManejadorAumentarSalarioFuncionario manejadorAumentarSalarioFuncionario) {
        this.manejadorCrearFuncionario = manejadorCrearFuncionario;
		this.manejadorActualizarFuncionario = manejadorActualizarFuncionario;
        this.manejadorAumentarSalarioFuncionario = manejadorAumentarSalarioFuncionario;
    }

    @PostMapping()
    @ApiOperation("Crear Funcionario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoFuncionario comandoFuncionario) {
        return manejadorCrearFuncionario.ejecutar(comandoFuncionario);
    }

    
	@PutMapping(value="/{idFuncionario}")
	@ApiOperation("Actualizar Funcionario")
	public void actualizar(@RequestBody ComandoFuncionario comandoFuncionario,@PathVariable Long idFuncionario) {
		comandoFuncionario.setIdFuncionario(idFuncionario);
		manejadorActualizarFuncionario.ejecutar(comandoFuncionario);
	}

    @PutMapping("/aumentoSalario")
    @ApiOperation("Aumentar salario funcionario")
    public void actualizarAumento(@RequestBody ComandoFuncionario comandoFuncionario){
        this.manejadorAumentarSalarioFuncionario.ejecutar(comandoFuncionario);
    }
}
