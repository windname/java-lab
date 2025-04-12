package com.vg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
public class ExamplesController {

    private static List<String> examples = List.of("ex1", "ex2", "ex3", "ex4");

    @GetMapping("/example")
    public String getExample(@RequestParam(defaultValue = "ex1") String name, Model model) {
        Optional<String> jsp = examples.stream().filter(e -> e.equals(name)).findFirst();
        return jsp.orElse("error");
    }
}
