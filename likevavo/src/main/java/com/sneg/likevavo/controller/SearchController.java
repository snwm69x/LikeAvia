package com.sneg.likevavo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sneg.likevavo.entities.City;
import com.sneg.likevavo.entities.Ticket;
import com.sneg.likevavo.service_impl.OptionsServiceImpl;
import com.sneg.likevavo.service_impl.SearchServiceImpl;


@Controller
@RequestMapping("/search")
public class SearchController {
    
    private final SearchServiceImpl searchService;
    private final OptionsServiceImpl optionsService;

    public SearchController(SearchServiceImpl searchService, OptionsServiceImpl optionsService) {
        this.searchService = searchService;
        this.optionsService = optionsService;
    }

    @GetMapping
    public String show(Model model){
        List<City> cities = optionsService.getOptions();
        System.out.println(cities);
        model.addAttribute("cities", cities);
        return "search";
    }

    @PostMapping
    public String search(Model model, 
                         @ModelAttribute("destinationCity") String destinationCity, 
                         @ModelAttribute("originCity") String originCity, 
                         @ModelAttribute("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Ticket> tickets = searchService.search(originCity, destinationCity, date);
        System.out.println(tickets.get(0).getId());
        model.addAttribute("tickets", tickets);
        return "result";
    }
}

