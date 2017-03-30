package com.arturo.utils;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arturo.build.model.Equipment;

public interface EquipmentDAO extends JpaRepository<Equipment, Integer> {
    
}
