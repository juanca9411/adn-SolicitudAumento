package com.ceiba.funcionario.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.ApplicationMock;
import com.ceiba.controlador.funcionario.ConsultaControladorFuncionario;
import com.ceiba.modelo.dto.funcionario.DtoFuncionario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorFuncionario.class)
public class ConsultaControladorFuncionarioTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listar() throws Exception {
        // arrange
        // act - assert
        mocMvc.perform(get("/funcionarios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[?(@.idFuncionario === 1)]").exists())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getDetalle() throws  Exception{
        // arrange
        Long idFuncionario=1L;
        // act -assert
        mocMvc.perform(get("/funcionarios/{idFuncionario}",idFuncionario)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[?(@.nombre === 'juan')]").exists())
        .andDo(MockMvcResultHandlers.print());
    }


}
