package com.ceiba.calendario.controlador;


import com.ceiba.ApplicationMock;
import com.ceiba.calendario.servicio.testdatabuilder.ComandoDiaFestivoTestDataBuilder;
import com.ceiba.comando.ComandoDiaFestivo;
import com.ceiba.controlador.calendario.ComandoControladorDiaFestivo;
import com.ceiba.puerto.repositorio.calendario.RepositorioDiaFestivo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorDiaFestivo.class)
public class ComandoControladorDiaFestivoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Mock
    RepositorioDiaFestivo repositorioDiaFestivo;

    @Test
    public void agregar() throws Exception{
        //arrange
        ComandoDiaFestivo comandoDiaFestivo = new ComandoDiaFestivoTestDataBuilder().build();
        // act -- asset
         mocMvc.perform(post("/dias-festivos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoDiaFestivo)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
