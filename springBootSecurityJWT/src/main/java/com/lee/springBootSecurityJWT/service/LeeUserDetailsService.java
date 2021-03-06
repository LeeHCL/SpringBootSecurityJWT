package com.lee.springBootSecurityJWT.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lee.springBootSecurityJWT.model.DAOUser;
import com.lee.springBootSecurityJWT.model.UserDTO;
import com.lee.springBootSecurityJWT.repo.UserRepository;

@Service
public class LeeUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = repo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with this username" + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public DAOUser save(UserDTO user) {
		
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return repo.save(newUser);
		
	}
}
