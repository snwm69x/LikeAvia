package com.sneg.likevavo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanTestConfig {
    
    private final List<String> beans = Arrays.asList("searchServiceImpl", "registrationServiceImpl", "optionsServiceImpl", "bookService", "authProviderImpl", "userRepository", "ticketRepository", "routeRepository", "roleRepository", "passengerRepository", "flightClassRepository", "countryRepository", "cityRepository", "bookingRepository", "aviaCompanyRepository", "airportRepository", "userValidator", "searchController", "lkController", "adminController", "bookTicketController", "authController", "securityConfig");

    public List<String> returnBeans(){
        return beans;
    }
}
