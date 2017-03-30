package com.arturo.user.role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDAO extends JpaRepository<UserRole, Integer> {
    
}
