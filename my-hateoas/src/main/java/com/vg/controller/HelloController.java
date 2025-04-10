package com.vg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(name = "userName", required = false, defaultValue = "Guest") String userName) {
        return "Hello, " + userName + "!";
    }
}
