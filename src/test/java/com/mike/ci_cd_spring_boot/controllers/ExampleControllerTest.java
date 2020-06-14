package com.mike.ci_cd_spring_boot.controllers;

import com.mike.ci_cd_spring_boot.services.IMessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ExampleController.class)
class ExampleControllerTest {

    @MockBean
    private IMessageService messageService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCurrentDate() throws Exception {
        final String expectedResponseBody = "Test response";
        when(messageService.getMessage()).thenReturn(expectedResponseBody);
        final MvcResult response = mockMvc.perform(get("/date"))
                .andExpect(status().isOk())
                .andReturn();
        final String actualResponseBody = response.getResponse().getContentAsString();
        assertEquals(expectedResponseBody, actualResponseBody, "Should return expected content in response body.");
    }
}