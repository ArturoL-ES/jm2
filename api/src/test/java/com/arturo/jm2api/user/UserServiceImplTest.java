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
        String notExists = "NOT_EXISTS";

        Mockito.when(userDAO.findOne(exists)).thenReturn(user);

        assertEquals(null, userDAO.findOne(notExists));
        assertEquals(user, userDAO.findOne(exists));
    }

    @Test
    public void saveUser() throws Exception {
        User user = new User();
        String exists = "EXISTS";
        String notExists = "NOT_EXISTS";
        String password = "123456";

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

        // TODO: TEST PASWORD ENCODE

        user.setUsername(notExists);
        assertEquals(user, userService.saveUser(user));

        // ¿Se deberia probar que se añaden roles ?
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