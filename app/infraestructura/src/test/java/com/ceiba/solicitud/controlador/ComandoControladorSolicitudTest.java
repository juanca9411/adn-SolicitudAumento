package com.ceiba.solicitud.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.comando.ComandoSolicitud;
import com.ceiba.controlador.solicitud.ComandoControladorSolicitud;
import com.ceiba.solicitud.servicio.testdatabuilder.ComandoSolicitudTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDateTime;

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
                .conNumSolicitud(2L)
                .conFechSolicitud(LocalDateTime.of(2021,1,13,3,25))
                .build();

        // act - assert
        mocMvc.perform(post("/solicitudes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(solicitud)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[?(@.valor === 2)]").exists())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void resolver() throws  Exception{
        //arragne
        ComandoSolicitud solicitud = new ComandoSolicitudTestDataBuilder()
                .conEstado("aprobado")
                .conRespuesta("Se realizo el aumento de salario con exito")
                .build();
        Long idFuncionario=1L;
        //act-assert
        mocMvc.perform(put("/solicitudes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(solicitud)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


   
}
