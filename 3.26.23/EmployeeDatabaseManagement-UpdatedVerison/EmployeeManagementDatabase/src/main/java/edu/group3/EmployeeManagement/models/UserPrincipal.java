package edu.group3.EmployeeManagement.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.experimental.Tolerate;

public class UserPrincipal implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	public UserPrincipal(User user) {
		this.user = user;
	}

	/*
	 * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
	 * return Collections.singleton(new SimpleGrantedAuthority("USER")); }
	 */
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		Set<Role> roles = user.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for (Role role : roles)
		{
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return authorities;
	}
	

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getFirstName() {
		return this.user.getFirstName();
	}

	public String getLastName() {
		return this.user.getLastName();
	}
	
	public String getFullName() {
		return this.user.getFullName();
	}
	
}
