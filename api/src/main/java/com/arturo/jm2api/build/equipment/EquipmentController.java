package com.arturo.build.equipment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/equipments")
public class EquipmentController {
    
    @Autowired private EquipmentService equipmentService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Equipment> all() {
        return equipmentService.findAll();
    }
    
}
