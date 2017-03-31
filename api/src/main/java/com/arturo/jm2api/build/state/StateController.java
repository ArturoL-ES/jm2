package com.arturo.jm2api.build.state;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/states")
public class StateController {
    
    @Autowired private StateService stateService;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<State> all() {
        return stateService.findAll();
    }
    
}
