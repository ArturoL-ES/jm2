package com.arturo.jm2api.user.role;

import com.arturo.jm2api.common.Profiles;
import com.arturo.jm2api.user.User;
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
public class UserRoleServiceImplTest {

    @InjectMocks private UserRoleServiceImpl userRoleService;
    @Mock private UserRoleDAO userRoleDAO;

    @Test
    public void save() throws Exception {
        UserRole userRole = new UserRole();
        Mockito.when(userRoleDAO.save(userRole)).thenReturn(userRole);

        assertEquals(userRole, userRoleService.save(userRole));
    }

    @Test
    public void saveDefaultRole() throws Exception {
        User user = new User();
        UserRole userRole = new UserRole();
        userRole.setRole(Roles.DEFAULT);
        userRole.setUser(user);

        Mockito.when(userRoleDAO.save(userRole)).thenReturn(userRole);

        assertEquals(userRole, userRoleService.saveDefaultRole(user));
    }

}