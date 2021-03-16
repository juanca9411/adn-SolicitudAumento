package com.ceiba.solicitud.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.comando.ComandoSolicitud;
import com.ceiba.controlador.solicitud.ComandoControladorSolicitud;
import com.ceiba.solicitud.servicio.testdatabuilder.ComandoSolicitudTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorSolicitud.class)
public class ComandoControladorSolicitudTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoSolicitud solicitud = new ComandoSolicitudTestDataBuilder()
                .conNumSolicitud(2l)
                .conFechSolicitud(new Date("January 13, 2021 03:24:00"))
                .build();

        // act - assert
        mocMvc.perform(post("/solicitudes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(solicitud)))
                .andExpect(status().isOk());
    }

    @Test
    public void resolver() throws  Exception{
        //arragne
        ComandoSolicitud solicitud = new ComandoSolicitudTestDataBuilder().build();
        Long idFuncionario=1l;
        //act-assert
        mocMvc.perform(put("/solicitudes/{idFuncionario}",idFuncionario)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(solicitud)))
                .andExpect(status().isOk());
    }


   
}
