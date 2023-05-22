package com.sneg.likevavo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.sneg.likevavo.entities.Ticket;
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // @Query("SELECT t FROM Ticket t WHERE t.route.originAirport.city = :originCity AND t.route.destinationAirport.city = :destinationCity AND t.route.date = :date")
    // List<Ticket> findByAirportCity(@Param("originCity") String originCity, @Param("destinationCity") String destinationCity, @Param("date") LocalDate date);

    // @Query("SELECT t FROM Ticket t WHERE t.route.originAirport.city = :originCity AND t.route.destinationAirport.city = :destinationCity")
    // List<Ticket> findByAirportCityWithoutDate(@Param("originCity") String originCity, @Param("destinationCity") String destinationCity);

}
