package com.sneg.likevavo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sneg.likevavo.entities.Ticket;
import com.sneg.likevavo.service.SearchService;


@Controller
@RequestMapping("/search")
public class SearchController {
    
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    public String show(){
        return "search";
    }

    @PostMapping
    public String search(Model model, @ModelAttribute("destinationCity") String destinationCity, @ModelAttribute("originCity") String originCity, @ModelAttribute("date") LocalDate date) {
        List<Ticket> tickets = searchService.search(originCity, destinationCity, date);
        System.out.println(tickets.get(0).getId());
        model.addAttribute("tickets", tickets);
        return "result";
    }
}

