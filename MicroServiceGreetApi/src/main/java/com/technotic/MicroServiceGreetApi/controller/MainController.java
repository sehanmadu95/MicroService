package com.technotic.MicroServiceGreetApi.controller;

import com.technotic.MicroServiceGreetApi.client.WelcomeFeignClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    private final WelcomeFeignClient welcomeFeignClient;
    private final Environment env;

    public MainController(WelcomeFeignClient welcomeFeignClient, Environment env) {
        this.welcomeFeignClient = welcomeFeignClient;
        this.env = env;
    }


    @GetMapping("/greeting")
    public String greeting(){
        String welcome= welcomeFeignClient.getWelcomeMsg();
        String port= env.getProperty("server.port");
        return port+": Hello Good Morning Guys..."+welcome;
    }
}
