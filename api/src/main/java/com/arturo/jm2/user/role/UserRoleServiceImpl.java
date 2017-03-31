package com.arturo.user.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arturo.user.User;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    
    @Autowired private UserRoleDAO userRoleDAO;
    
    @Override
    public UserRole saveDefaultRole(User user) {
        UserRole userRole = new UserRole();
        userRole.setRole(Roles.USER);
        userRole.setUser(user);
        return userRoleDAO.save(userRole);
    }
}
