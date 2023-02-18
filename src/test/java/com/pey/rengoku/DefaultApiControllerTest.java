package com.pey.rengoku;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasEntry;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DefaultApiController.class)
class DefaultApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetHello() throws Exception {
        mockMvc.perform(get("/default"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("hellooo"))
                .andExpect(jsonPath("$", hasEntry("message", "hellooo")));
    }
}

