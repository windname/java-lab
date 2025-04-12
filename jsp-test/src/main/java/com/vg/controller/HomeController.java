package com.vg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String hello() {
        return "home"; // This will resolve to WEB-INF/views/hello.jsp
    }
}