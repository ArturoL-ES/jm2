package com.arturo.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.arturo.user.role.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users") 
public class User implements UserDetails {
    
    private static final long serialVersionUID = 1L;

    @Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String username;
	
	@Column(name = "password", nullable = false, length = 60)
	@JsonIgnore
	private String password;
	
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	@JsonManagedReference
	private Set<UserRole> roles = new HashSet<UserRole>(0);
	
	@Column
	private Boolean accountNonLocked;
	
	@Column
	private Boolean credentialsNonExpired;
	
	@Column
	private Boolean accountNonExpired;
	
	public User() {	}
    
    @Override
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    @Override
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    @Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}
	
	@Override
	@Transient
	@JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> autorizaciones = new ArrayList<String>();
        this.roles.forEach(role -> autorizaciones.add(role.getRole()));
        return AuthorityUtils.createAuthorityList(autorizaciones.toArray(new String[0]));
    }
	
	@Override
    public boolean isAccountNonLocked() {
        return Boolean.TRUE;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return Boolean.TRUE;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return Boolean.TRUE;
    }

}