package com.technotic.MicroServiceWelcome.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MianController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to new Microservice Project...";
    }
}
