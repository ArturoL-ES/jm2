package com.arturo.jm2api.user.role;

import com.arturo.jm2api.user.User;

public interface UserRoleService {

    public UserRole save(UserRole userRole);

    public UserRole saveDefaultRole(User user);
    
}
