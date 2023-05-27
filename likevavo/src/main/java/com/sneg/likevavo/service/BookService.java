package com.sneg.likevavo.service;

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

@Service
public class BookService {
    private final BookingRepository bookingRepository;
    private final TicketRepository ticketRepository;
    private final PassengerRepository passengerRepository;
    private final UserRepository userRepository;

    public BookService(BookingRepository bookingRepository, TicketRepository ticketRepository, PassengerRepository passengerRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
        this.userRepository = userRepository;
    }

    public void book(Long userid, long ticketid){
        Optional<Passenger> passenger = passengerRepository.findById(1L);
        Optional<Ticket> ticket = ticketRepository.findById(ticketid);
        Optional<User> user = userRepository.findById(userid);
        Booking booking = new Booking();
        booking.setQuantity(1);
        booking.setPassenger(passenger);
        booking.setUser(user);
        booking.setTicket(ticket);
        bookingRepository.save(booking);
    }
}
