package com.bitaka.pfe.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bitaka.pfe.model.Utilisateur;
import com.bitaka.pfe.services.UtilisateurService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UtilisateurService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Utilisateur user = userService.findUserByLogin(username);

		if (user == null)
			throw new UsernameNotFoundException("invalid user");

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));

		System.out.println("*******************");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(authorities);
		System.out.println("*******************");
		return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
