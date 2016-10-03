package com.shoppingcart.config.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.shoppingcart.models.User;
import com.shoppingcart.repository.IUserRepository;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private IUserRepository userRepo;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		final Object principal = authentication.getPrincipal();
		if(SecurityContextHolder.getContext().getAuthentication() != null){
			return SecurityContextHolder.getContext().getAuthentication();
		} 
		if (principal instanceof User)
			return authentication;

		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		User user = userRepo.findByUsername(username);
		if(user == null || !user.getPassword().equals(password)) return null;
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		GrantedAuthority ga = new SimpleGrantedAuthority(user.getRole());
		auths.add(ga);
		authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), auths);

		return authentication;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
