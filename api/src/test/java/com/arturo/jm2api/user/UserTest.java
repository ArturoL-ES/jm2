package com.arturo.jm2api.user;

import com.arturo.jm2api.common.Profiles;
import com.arturo.jm2api.user.role.UserRole;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.test.context.ActiveProfiles;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(Profiles.DEVEVELOPMENT)
public class UserTest {

    private User user;
    private String usermame = "USERNAME";
    private String password = "PASSWORD";
    private Boolean enabled = Boolean.TRUE;
    private Set<UserRole> roles = new HashSet<>();
    private Boolean accountNonLocked = Boolean.TRUE;
    private Boolean credentialsNonExpired = Boolean.TRUE;
    private Boolean accountNonExpired = Boolean.TRUE;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setUsername(usermame);
        user.setPassword(password);
        user.setRoles(roles);
        user.setEnabled(enabled);
    }

    @Test
    public void getUsername() throws Exception {
        assertEquals(usermame, user.getUsername());
    }

    @Test
    public void setUsername() throws Exception {
        String username = "NEW_USERNAME";
        user.setUsername(username);

        assertEquals(username, user.getUsername());
    }

    @Test
    public void getPassword() throws Exception {
        assertEquals(password, user.getPassword());
    }

    @Test
    public void setPassword() throws Exception {
        String password = "NEW_PASSWORD";
        user.setPassword(password);

        assertEquals(password, user.getPassword());
    }

    @Test
    public void isEnabled() throws Exception {
        assertEquals(enabled, user.isEnabled());
    }

    @Test
    public void setEnabled() throws Exception {
        Boolean enabled = Boolean.FALSE;
        user.setEnabled(enabled);

        assertEquals(enabled, user.isEnabled());
    }

    @Test
    public void getRoles() throws Exception {
        assertEquals(roles, user.getRoles());
    }

    @Test
    public void setRoles() throws Exception {
        Set<UserRole> roles = new HashSet<>(Arrays.asList(new UserRole(), new UserRole()));
        user.setRoles(roles);

        assertEquals(roles, user.getRoles());
    }

    @Test
    public void getAuthorities() throws Exception {
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();

        assertEquals(authorities, user.getAuthorities());
    }

    @Test
    public void isAccountNonLocked() throws Exception {
        assertEquals(Boolean.TRUE, user.isAccountNonLocked());
    }

    @Test
    public void isCredentialsNonExpired() throws Exception {
        assertEquals(Boolean.TRUE, user.isCredentialsNonExpired());
    }

    @Test
    public void isAccountNonExpired() throws Exception {
        assertEquals(Boolean.TRUE, user.isAccountNonExpired());
    }

}