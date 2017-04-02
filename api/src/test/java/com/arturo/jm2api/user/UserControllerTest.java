package com.arturo.jm2api.user;

import com.arturo.jm2api.common.Profiles;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class UserControllerTest {

    @InjectMocks private UserController userController;
    @Mock private UserService userService;

    @Test
    public void get() throws Exception {
        User user = new User();
        String username = "USERNAME";
        Mockito.when(userService.findUser(username)).thenReturn(user);

        assertEquals(user, userController.get(username));
    }

    @Test
    public void delete() throws Exception {
        Boolean expected = Boolean.TRUE;
        String username = "USERNAME";
        Mockito.when(userService.deleteUser(username)).thenReturn(expected);

        assertEquals(expected, userController.delete(username));
    }

    @Test
    public void save() throws Exception {
        User user = new User();
        Mockito.when(userService.saveUser(user)).thenReturn(user);

        assertEquals(user, userController.save(user));
    }

    @Test
    public void update() throws Exception {
        User user = new User();
        Mockito.when(userService.updateUser(user)).thenReturn(user);

        assertEquals(user, userController.update(user));
    }

}