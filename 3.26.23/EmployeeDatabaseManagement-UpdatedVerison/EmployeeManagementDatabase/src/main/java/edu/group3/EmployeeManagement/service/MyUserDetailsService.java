package edu.group3.EmployeeManagement.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.group3.EmployeeManagement.models.Role;
import edu.group3.EmployeeManagement.models.User;
import edu.group3.EmployeeManagement.models.UserPrincipal;
import edu.group3.EmployeeManagement.repository.RoleRepository;
import edu.group3.EmployeeManagement.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository  userRepository;
	
	@Autowired
	private RoleRepository  roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found!");
		}
		return new UserPrincipal(user);
	}
	
	/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found!");
		}
 
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
	}
	*/
    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
	
    public void registerDefaultUser(User user)
    {
    	Role roleUser =  roleRepository.findByName("User");
    	user.addRole(roleUser);
    	
    	userRepository.save(user);
    }

}
