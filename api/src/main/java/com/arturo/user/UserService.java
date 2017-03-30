package com.arturo.user;

public interface UserService {
    
    public User findUser(String username);
    
    public Boolean deleteUser(String username);
    
    public User updateUser(User user);
    
    public User saveUser(User user);
    
}
