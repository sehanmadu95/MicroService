package com.technotic.MicroServiceGreetApi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "welcome-api")
public interface WelcomeFeignClient {

    @GetMapping("/welcome")
    public String getWelcomeMsg();
}
