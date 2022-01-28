package com.lee.springBootSecurityJWT.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LeeUserDetailsService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("saran".equals(username)) {
			return new User("lee", "$2a$12$e7kNknnb23T2AffZyfkQM.0MiTLix8QMCEXWtOwJjb.Qmoaqg4rY6", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
