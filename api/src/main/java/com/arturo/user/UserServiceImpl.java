package com.arturo.user;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.arturo.user.role.UserRoleService;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {
    
    @Autowired private UserDAO userDAO;
    @Autowired private UserRoleService userRoleService;
    
    @Autowired private BCryptPasswordEncoder passwordEncoder;
    
    @Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(final String username)
		throws UsernameNotFoundException {

		User user = userDAO.findOne(username);
		
		if (user == null) {
		    throw new UsernameNotFoundException("Bad credentials");
		}
		
		UserDetails userDetails = 
		  new org.springframework.security.core.userdetails
		          .User(user.getUsername(), 
    		              user.getPassword(), 
    		              user.isEnabled(), 
    		              user.isAccountNonExpired(), 
    		              user.isCredentialsNonExpired(), 
    		              user.isAccountNonLocked(), 
    		              user.getAuthorities());
		
		return userDetails;
	}
	
	@Transactional(readOnly = true)
	@Override
	public User findUser(String username) {
	    return userDAO.findOne(username);
	}
	
	@Transactional
	@Override
	public Boolean deleteUser(String username) {
	    userDAO.delete(username);
	    return userDAO.findOne(username) == null;
	}
	
	@Transactional
	@Override
	public User saveUser(User user) {
	    if (StringUtils.isBlank(user.getUsername())) {
	       return null;
	    }
	    
	    if (userDAO.findOne(user.getUsername()) != null) {
	       return null;
	    }
	    
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    user = userDAO.save(user);
	    
	    if (CollectionUtils.isEmpty(user.getRoles())) {
	       user.getRoles().add(userRoleService.saveDefaultRole(user));
	    }
	    
	    return user;
	}
	
	@Transactional
	@Override
	public User updateUser(User user) {
	    if (StringUtils.isNotBlank(user.getUsername())) {
	       return null;
	    }
	    
	    return userDAO.save(user);
	}
}
