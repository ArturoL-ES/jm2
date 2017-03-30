package com.arturo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arturo.common.Profiles;

@Profile({Profiles.DEVEVELOPMENT})
@RestController
@RequestMapping("/utils")
public class UtilsController {
    
    @Autowired private UtilsService utils;
    
    @RequestMapping("/mockupData")
    public void mockupData() {
        utils.mockupData();
    }
    
    @RequestMapping("/testGet")
    public Object testGet() {
        return utils.testGet();
    }
    
}
