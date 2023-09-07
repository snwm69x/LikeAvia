package com.sneg.likevavo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sneg.likevavo.security.UserDetailsImpl;

@RestController
@RequestMapping
public class AdminController {
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/hello")
    public String hello(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        System.out.println(userDetails.getUser().getUsername());
        System.out.println(userDetails.getUser().getRole());
        return "Hello";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }
}
