package com.sneg.likevavo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sneg.likevavo.entities.Booking;
import com.sneg.likevavo.security.UserDetailsImpl;
import com.sneg.likevavo.service.BookService;

@Controller
@RequestMapping("/book-ticket")
public class BookTicketController {

    private final BookService bookService;

    public BookTicketController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping
    public String bookTicket(@RequestParam("ticketId") Long ticketId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        Long userid = userDetails.getUser().getId();
        System.out.println(userid);
        bookService.book(userid, ticketId);
        return "redirect:/lk";
    }
}
