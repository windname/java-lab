package com.vg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String home(Model model) {
        model.addAttribute("message", "Hello from JSP!");
        return "hello"; // resolves to /WEB-INF/views/hello.jsp
    }
}