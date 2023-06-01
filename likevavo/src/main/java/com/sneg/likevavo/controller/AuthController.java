package com.sneg.likevavo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sneg.likevavo.entities.User;
import com.sneg.likevavo.service.RegistrationService;
import com.sneg.likevavo.util.UserValidator;

import javax.validation.Valid;

@Controller
@RequestMapping
public class AuthController {

    private final UserValidator userValidator;
    private final RegistrationService registrationService;

    public AuthController(UserValidator userValidator, RegistrationService registrationService) {
        this.userValidator = userValidator;
        this.registrationService = registrationService;
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "reg";
    }

    @PostMapping("/registration/process")
    public String registration_process(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors())
            return "reg";

        registrationService.register(user);
        return "redirect:/login";
    }
}
