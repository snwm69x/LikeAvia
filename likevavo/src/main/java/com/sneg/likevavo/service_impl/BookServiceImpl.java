package com.sneg.likevavo.service_impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sneg.likevavo.entities.Booking;
import com.sneg.likevavo.entities.Passenger;
import com.sneg.likevavo.entities.Ticket;
import com.sneg.likevavo.entities.User;
import com.sneg.likevavo.repository.BookingRepository;
import com.sneg.likevavo.repository.PassengerRepository;
import com.sneg.likevavo.repository.TicketRepository;
import com.sneg.likevavo.repository.UserRepository;
import com.sneg.likevavo.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {
    private final BookingRepository bookingRepository;
    private final TicketRepository ticketRepository;
    private final PassengerRepository passengerRepository;

    public BookServiceImpl(BookingRepository bookingRepository, TicketRepository ticketRepository, PassengerRepository passengerRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
    }

    @Override
    public void book(User user, long ticketid){
        Optional<Passenger> passenger = passengerRepository.findById(1L);
        Optional<Ticket> ticket = ticketRepository.findById(ticketid);
        Booking booking = new Booking();
        booking.setQuantity((Integer) 1);
        if(!passenger.isPresent()){
            throw new RuntimeException("Passenger not found");
        }
        else {
            Passenger passenger1 = passenger.orElseThrow(() -> new RuntimeException("Passenger not found"));
            booking.setPassenger(passenger1);
        }
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
