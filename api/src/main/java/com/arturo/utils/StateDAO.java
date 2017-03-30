package com.arturo.utils;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arturo.build.model.State;

public interface StateDAO extends JpaRepository<State, Integer>{
    
}
