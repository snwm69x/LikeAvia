package com.sneg.likevavo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sneg.likevavo.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
