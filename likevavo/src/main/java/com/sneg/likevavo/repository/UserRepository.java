package com.sneg.likevavo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneg.likevavo.entities.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    
    String findRoleByUsername(String username);
}
