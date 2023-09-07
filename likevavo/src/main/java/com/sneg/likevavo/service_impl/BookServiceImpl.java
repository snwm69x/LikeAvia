package com.sneg.likevavo.service_impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sneg.likevavo.entities.Booking;
import com.sneg.likevavo.entities.Ticket;
import com.sneg.likevavo.entities.User;
import com.sneg.likevavo.repository.BookingRepository;
import com.sneg.likevavo.repository.TicketRepository;
import com.sneg.likevavo.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {
    private final BookingRepository bookingRepository;
    private final TicketRepository ticketRepository;

    public BookServiceImpl(BookingRepository bookingRepository, TicketRepository ticketRepository) {
        this.bookingRepository = bookingRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void book(User user, long ticketid){
        Optional<Ticket> ticket = ticketRepository.findById(ticketid);
        Booking booking = new Booking();
        booking.setQuantity((Integer) 1);
        booking.setPassenger(null);
        booking.setUser(user);
        if(!ticket.isPresent()){
            throw new RuntimeException("Ticket not found");
        }
        else {
            Ticket ticket1 = ticket.orElseThrow(() -> new RuntimeException("Ticket not found"));
            booking.setTicket(ticket1);
        }
        bookingRepository.save(booking);
    }

}
