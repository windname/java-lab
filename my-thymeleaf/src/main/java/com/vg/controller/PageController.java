package com.vg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class PageController {

    @GetMapping("/about")
    public String about(Model model) {
        // Add any data you want to pass to the template
        model.addAttribute("currentYear", LocalDate.now().getYear());
        return "about"; // This will resolve to src/main/resources/templates/about.html
    }
}