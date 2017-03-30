package com.arturo.utils;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.arturo.build.Build;
import com.arturo.build.BuildDAO;
import com.arturo.build.model.Equipment;
import com.arturo.build.model.State;
import com.arturo.build.model.Type;
import com.arturo.common.Profiles;
import com.arturo.user.User;
import com.arturo.user.UserDAO;
import com.arturo.user.role.UserRole;

@Profile({Profiles.DEVEVELOPMENT})
@Service
@Transactional
public class UtilsServiceImpl implements UtilsService {
    
    @Autowired private StateDAO stateDAO;
    @Autowired private TypeDAO typeDAO;
    @Autowired private EquipmentDAO eqDAO;
    @Autowired private BuildDAO buildDAO;
    @Autowired private UserDAO userDAO;
    
    @Autowired private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public void mockupData() {
        State state1 = new State();
        state1.setId(1);
        state1.setValue("TEST_STATE");
        stateDAO.save(state1);
        
        State state2 = new State();
        state2.setId(2);
        state2.setValue("TEST_STATE_2");
        stateDAO.save(state2);
        
        Type type = new Type();
        type.setId(1);
        type.setValue("TEST_TYPE");
        typeDAO.save(type);
        
        Equipment eq = new Equipment();
        eq.setId(1);
        eq.setValue("EQ_1");
        Set<Equipment> eqps = new HashSet<>();
        eqps.add(eq);
        eqDAO.save(eqps);
        
        Build build = new Build();
        State s = new State();
        s.setId(1);
        build.setState(s);
        Type t = new Type();
        t.setId(1);
        build.setType(t);
        build.setCcaa("cccc");
        build.setCity("aaaa");
        build.setPrice(100.00f);
        build.setCurrency("E");
        build.setDescription("aaaa");
        build.setIdentifier("DJFKS");
        Set<Equipment> eqpsBuild = new HashSet<>();
        eqpsBuild.add(eqDAO.findOne(1));
        build.setEquipments(eqpsBuild);
        buildDAO.save(build);
        
        Build build1 = new Build();
        State s1 = new State();
        s1.setId(1);
        build.setState(s1);
        Type t1 = new Type();
        t1.setId(1);
        build1.setType(t1);
        build1.setCcaa("bbbb");
        build1.setCity("aaaa");
        build1.setPrice(100.00f);
        build1.setCurrency("E");
        build1.setDescription("aaaa");
        build1.setIdentifier("DJFKS");
        Set<Equipment> eqpsBuild1 = new HashSet<>();
        eqpsBuild1.add(eqDAO.findOne(1));
        build1.setEquipments(eqpsBuild1);
        buildDAO.save(build1);
        
        /*
        UserRole role = new UserRole();
        role.set
        
        User user = new User();
        user.setUsername("arturo");
        user.setPassword(passwordEncoder.encode("arturo"));
        user.getRoles().add(role);
        user.setEnabled(Boolean.TRUE);
        userDAO.save(user);
        */
       
    }
    
    @Override
    public Object testGet() {
        return eqDAO.findOne(1);
    }
    
}
