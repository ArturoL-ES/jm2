package com.arturo.jm2api.build.state;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StateDAO extends JpaRepository<State, Integer> {
    
}
