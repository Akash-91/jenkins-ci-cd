package com.jenkins;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
@AutoConfigureMockMvc
class JenkinsCiCdApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGreetings() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greetings/John Doe"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello John, welcome to your first jenkins demo project..!!"));
    }

    @Test
    public void testGreetingsWithMultipleNames() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greetings/John Doe Smith"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello John, welcome to your first jenkins demo project..!!"));
    }
}