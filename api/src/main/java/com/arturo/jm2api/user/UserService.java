package com.arturo.jm2api.user;

public interface UserService {
    
    public User findUser(String username);
    
    public Boolean deleteUser(String username);
    
    public User updateUser(User user);
    
    public User saveUser(User user);
    
}
