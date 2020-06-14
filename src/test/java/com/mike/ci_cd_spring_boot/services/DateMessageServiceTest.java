package com.mike.ci_cd_spring_boot.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDateTime.*;
import static java.time.format.DateTimeFormatter.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DateMessageServiceTest {

    @Autowired
    private IMessageService messageService;

    @Test
    void getMessage() {
        final String actual = messageService.getMessage();
        final String expected = ofPattern("dd-MM-yyyy").format(now());
        assertEquals(expected, actual, "Should return expected date in appropriate format.");
    }
}