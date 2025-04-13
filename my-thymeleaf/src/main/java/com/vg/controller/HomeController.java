package com.vg.controller;

import com.vg.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Thymeleaf!");
        model.addAttribute("user", new User("Alice", true, 1));
        model.addAttribute("items", Arrays.asList("Book", "Pen", "Laptop"));
        return "index";  // Renders src/main/resources/templates/index.html
    }
}
