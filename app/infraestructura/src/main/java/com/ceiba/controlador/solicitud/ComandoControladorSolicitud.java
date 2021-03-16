package com.ceiba.controlador.solicitud;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoSolicitud;
import com.ceiba.comando.manejador.solicitud.ManejadorCrearSolicitud;
import com.ceiba.comando.manejador.solicitud.ManejadorResolverSolicitud;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitudes")
@Api(tags = { "Controlador comando solicitudes"})
public class ComandoControladorSolicitud {

    private final ManejadorCrearSolicitud manejadorCrearSolicitud;
    private final ManejadorResolverSolicitud manejadorResolverSolicitud;

    public ComandoControladorSolicitud(ManejadorCrearSolicitud manejadorCrearSolicitud, ManejadorResolverSolicitud manejadorResolverSolicitud) {
        this.manejadorCrearSolicitud = manejadorCrearSolicitud;
        this.manejadorResolverSolicitud = manejadorResolverSolicitud;
    }


    @PostMapping
    @ApiOperation("Crear solicitud")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitud comandoSolicitud) {
        return manejadorCrearSolicitud.ejecutar(comandoSolicitud);
    }

    
	@PutMapping(value="/{idFuncionario}")
	@ApiOperation("Resolver solicitud")
	public void actualizar(@RequestBody ComandoSolicitud comandoSolicitud,@PathVariable Long idFuncionario) {
        comandoSolicitud.setIdFuncionario(idFuncionario);
        manejadorResolverSolicitud.ejecutar(comandoSolicitud);
	}
}
