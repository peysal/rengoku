package com.pey.rengoku;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class DefaultControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetDefault() throws Exception {
        ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of("Asia/Kuala_Lumpur"));
        String dateTimeString = dateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        MvcResult result = mockMvc.perform(get("/default")
                        .param("mandatoryParam", "mandatoryValue")
                        .param("optionalParam", "optionalValue")
                        .header("correlationId", "123456")
                        .header("dateTime", dateTimeString)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(header().string("correlationId", "123456"))
                .andExpect(header().string("dateTime", dateTimeString))
                .andReturn();

        Map<String, String> response = new HashMap<>();
        response.put("optionalParam", "optionalValue");
        response.put("mandatoryParam", "mandatoryValue");
        assertThat(result.getResponse().getContentAsString()).isEqualTo(new ObjectMapper().writeValueAsString(response));
    }
}
