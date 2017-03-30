package com.arturo.utils;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arturo.build.model.Type;

public interface TypeDAO extends JpaRepository<Type, Integer> {
    
}
