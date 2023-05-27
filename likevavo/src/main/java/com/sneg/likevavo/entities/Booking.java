package com.sneg.likevavo.entities;

import java.util.Optional;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passengers_id", nullable = false)
    private Passenger passenger;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public Booking() {}

    public Booking(User user, Ticket ticket, Passenger passenger, Integer quantity) {
        this.user = user;
        this.ticket = ticket;
        this.passenger = passenger;
        this.quantity = quantity;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(Optional<User> user) {
        this.user = user.orElse(null);
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Optional<Ticket> ticket) {
        this.ticket = ticket.orElse(null);
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Optional<Passenger> passenger) {
        this.passenger = passenger.orElse(null);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}