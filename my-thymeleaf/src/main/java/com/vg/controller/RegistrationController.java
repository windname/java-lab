package com.vg.controller;

import com.vg.model.Country;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import java.util.Map;
import com.vg.model.UserDto;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new UserDto());
        model.addAttribute("countries", Country.getCountries());
        model.addAttribute("genders", Map.of("M", "Male", "F", "Female"));
        return "register";
    }

    @PostMapping("/register")
    public String processForm(@Valid @ModelAttribute("user") UserDto user,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            model.addAttribute("countries", Country.getCountries());
            model.addAttribute("genders", Map.of("M", "Male", "F", "Female"));
            return "register";
        }
        return "redirect:/registration-success";
    }

    @GetMapping("/registration-success")
    public String showSuccessPage(@ModelAttribute("user") UserDto user) {
        return "registration-success";
    }
}