package com.ceiba.funcionario.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.comando.ComandoFuncionario;
import com.ceiba.controlador.funcionario.ComandoControladorFuncionario;
import com.ceiba.funcionario.servicio.testdatabuilder.ComandoFuncionarioTestDataBuilder;
import org.assertj.core.internal.ErrorMessages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorFuncionario.class)
public class ComandoControladorFuncionarioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoFuncionario funcionario = new ComandoFuncionarioTestDataBuilder()
                .build();

        // act - assert
        mocMvc.perform(post("/funcionarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(funcionario)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[?(@.valor === 2)]").exists())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long idFuncionario = 1L;
        ComandoFuncionario funcionario = new ComandoFuncionarioTestDataBuilder()
                .conCedula("1050951303")
                .build();
        // act - assert
        mocMvc.perform(put("/funcionarios/{idFuncionario}",idFuncionario)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(funcionario)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void actualizarAumento() throws Exception{
        // arrange
        ComandoFuncionario funcionario = new ComandoFuncionarioTestDataBuilder()
                .build();
        // act - assert
        mocMvc.perform(put("/funcionarios/aumentoSalario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(funcionario)))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
