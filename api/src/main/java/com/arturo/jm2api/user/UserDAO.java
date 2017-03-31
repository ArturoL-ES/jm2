package com.arturo.jm2api.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, String> {
    
}
