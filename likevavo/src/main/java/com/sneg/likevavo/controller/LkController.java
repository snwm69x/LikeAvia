package com.sneg.likevavo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sneg.likevavo.repository.BookingRepository;
import com.sneg.likevavo.security.UserDetailsImpl;

@Controller
@RequestMapping
public class LkController {
    private final BookingRepository bookingRepository;

    public LkController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    
    @GetMapping("/lk")
    public String showlk(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        model.addAttribute("bookings", bookingRepository.findByUserId(userDetails.getUser().getId()));
        return "lk";
    }
}
