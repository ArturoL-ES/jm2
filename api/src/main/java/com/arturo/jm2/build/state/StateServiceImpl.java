package com.arturo.build.state;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StateServiceImpl implements StateService {
    
    @Autowired private StateDAO stateDAO;
    
    @Override
    @Cacheable
    @Transactional(readOnly = true)
    public List<State> findAll() {
        return stateDAO.findAll();
    }
    
}
