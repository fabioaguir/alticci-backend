package com.alticci.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class AlticciControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAlticciSequence() throws Exception {

        this.mockMvc.perform(get("http://localhost:8080/alticci/" + 10))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(9));
    }

    @Test
    void testAlticciSequenceUndefined() throws Exception {

        this.mockMvc.perform(get("http://localhost:8080/alticci/" + 99999))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Valor indefinido para o ìndice"));
    }
}
