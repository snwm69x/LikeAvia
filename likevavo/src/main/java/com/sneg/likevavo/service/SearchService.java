package com.sneg.likevavo.service;

import java.time.LocalDate;
import java.util.List;

import com.sneg.likevavo.entities.Ticket;

public interface SearchService {
    public List<Ticket> search(String from, String to, LocalDate date);
}
