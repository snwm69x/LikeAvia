package com.sneg.likevavo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sneg.likevavo.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    
    @Query("SELECT u.role FROM User u WHERE u.username = :username")
    String findRoleByUsername(@Param("username") String username);
}
