package com.arturo.jm2api.user;

import com.arturo.jm2api.common.Profiles;
import com.arturo.jm2api.common.error.CustomException;
import com.arturo.jm2api.user.role.UserRole;
import com.arturo.jm2api.user.role.UserRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class UserServiceImplTest {

    @InjectMocks private UserServiceImpl userService;

    @Mock private UserRoleService userRoleService;
    @Mock private UserDAO userDAO;
    @Mock private BCryptPasswordEncoder passwordEncoder;

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsername() throws Exception {
        User user = new User();
        UserRole userRole = new UserRole();
        userRole.setRole("ADMIN");
        user.setUsername("username");
        user.setPassword("password");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));

        String username = "USERNAME";

        Mockito.when(userDAO.findOne(username)).thenReturn((User) user);

        assertEquals(user, userService.loadUserByUsername(username));
        userService.loadUserByUsername(null);
        fail();
    }

    @Test
    public void findUser() throws Exception {
        User user = new User();
        String username = "USERNAME";
        Mockito.when(userDAO.findOne(username)).thenReturn(user);

        assertEquals(user, userService.findUser(username));
    }

    @Test
    public void deleteUser() throws Exception {
        User user = new User();
        String exists = "EXISTS";
        String notExists = "notExists";

        Mockito.when(userDAO.findOne(exists)).thenReturn(user);
        Mockito.when(userDAO.findOne(notExists)).thenReturn(null);

        assertEquals(Boolean.FALSE, userService.deleteUser(exists));
        assertEquals(Boolean.TRUE, userService.deleteUser(notExists));
    }

    @Test
    public void saveUser() throws Exception {
        User user = new User();
        String exists = "EXISTS";
        String notExists = "NOT_EXISTS";

        Mockito.when(userDAO.findOne(exists)).thenReturn(user);
        Mockito.when(userDAO.save(user)).thenReturn(user);

        try {
            user.setUsername(null);
            userService.saveUser(user);
            fail();
        } catch (CustomException ce) {

        }

        try {
            user.setUsername(exists);
            userService.saveUser(user);
            fail();
        } catch (CustomException ce) {

        }

        user.setUsername(notExists);
        assertEquals(user, userService.saveUser(user));

        user.setRoles(new HashSet<>(Arrays.asList(new UserRole(), new UserRole())));
        assertEquals(user, userService.saveUser(user));
    }

    @Test(expected = CustomException.class)
    public void updateUser() throws Exception {
        User user = new User();
        String username = "USERNAME";

        Mockito.when(userDAO.save(user)).thenReturn(user);

        assertEquals(user, userService.updateUser(user));

        user.setUsername(username);
        userService.updateUser(user);
        fail();
    }

}