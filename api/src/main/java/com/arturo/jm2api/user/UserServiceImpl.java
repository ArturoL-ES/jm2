package com.arturo.jm2api.user;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.arturo.jm2api.common.error.CustomException;
import com.arturo.jm2api.user.role.UserRoleService;

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
		
		return user;
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
	       // TODO set message
	       throw new CustomException(HttpStatus.BAD_REQUEST, "ErrorMessage.Required.ID");
	    }
	    
	    if (userDAO.findOne(user.getUsername()) != null) {
	       // TODO set message
	       throw new CustomException(HttpStatus.BAD_REQUEST, "ErrorMessage.NotFound.USERNAME");
	    }
	    
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    User userSaved = userDAO.save(user);
	    
	    if (CollectionUtils.isEmpty(user.getRoles())) {
	       userSaved.getRoles().add(userRoleService.saveDefaultRole(user));
	    } else {
	        user.getRoles().forEach(role -> {
	        	userRoleService.save(role);
	        	userSaved.getRoles().add(role);
			} );
	    }
	    
	    return userSaved;
	}
	
	@Transactional
	@Override
	public User updateUser(User user) {
	    if (StringUtils.isNotBlank(user.getUsername())) {
	       // TODO set message
	       throw new CustomException(HttpStatus.BAD_REQUEST, "ErrorMessage.Required.ID");
	    }
	    
	    return userDAO.save(user);
	}
}
