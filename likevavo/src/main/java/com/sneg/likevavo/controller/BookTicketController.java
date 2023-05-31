package com.sneg.likevavo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sneg.likevavo.entities.User;
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
        User user = userDetails.getUser();
        System.out.println(user);
        bookService.book(user, ticketId);
        return "redirect:/lk";
    }
}
