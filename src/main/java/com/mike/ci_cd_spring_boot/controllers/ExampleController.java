package com.mike.ci_cd_spring_boot.controllers;

import com.mike.ci_cd_spring_boot.services.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Autowired
    private IMessageService service;

    @GetMapping("/date")
    public String getCurrentDate() {
        return service.getMessage();
    }
}
