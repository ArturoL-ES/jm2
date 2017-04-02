package com.arturo.jm2api.user.role;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.arturo.jm2api.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user_roles")
public class UserRole implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username", nullable = false)
	@JsonBackReference
	private User user;
	
	@Column(name = "role", nullable = false, length = 45)
	private String role;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserRole)) return false;

		UserRole userRole = (UserRole) o;

		if (getId() != null ? !getId().equals(userRole.getId()) : userRole.getId() != null) return false;
		if (getUser() != null ? !getUser().equals(userRole.getUser()) : userRole.getUser() != null) return false;
		return getRole() != null ? getRole().equals(userRole.getRole()) : userRole.getRole() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
		result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
		return result;
	}

}
