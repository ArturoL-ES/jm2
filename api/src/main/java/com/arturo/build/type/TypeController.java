package com.arturo.build.type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/types")
public class TypeController {
    
    @Autowired private TypeService typeService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Type> all() {
        return typeService.findAll();
    }
}
