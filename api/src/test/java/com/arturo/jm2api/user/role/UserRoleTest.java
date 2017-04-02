package com.arturo.jm2api.user.role;

import com.arturo.jm2api.common.Profiles;
import com.arturo.jm2api.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class UserRoleTest {

    private UserRole userRole;
    private Integer id = 1;
    private User user = new User();
    private String role = "ROLE";

    @Before
    public void setUp() throws Exception {
        userRole = new UserRole();
        userRole.setId(id);
        userRole.setUser(user);
        userRole.setRole(role);
    }

    @Test
    public void getId() throws Exception {
        assertEquals(id, userRole.getId());
    }

    @Test
    public void setId() throws Exception {
        Integer id = 2;
        userRole.setId(id);

        assertEquals(id, userRole.getId());
    }

    @Test
    public void getUser() throws Exception {
        assertEquals(user, userRole.getUser());
    }

    @Test
    public void setUser() throws Exception {
        User user  = new User();
        userRole.setUser(user);

        assertEquals(user, userRole.getUser());
    }

    @Test
    public void getRole() throws Exception {
        assertEquals(role, userRole.getRole());
    }

    @Test
    public void setRole() throws Exception {
        String role = "NEW_ROLE";
        userRole.setRole(role);

        assertEquals(role, userRole.getRole());
    }

}