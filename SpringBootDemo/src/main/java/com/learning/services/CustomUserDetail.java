package com.learning.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.learning.entities.Employe;

public class CustomUserDetail implements UserDetails{

	private Employe employe;
	
	public CustomUserDetail(Employe employe) {
		this.employe = employe;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() { 
		return employe.getPassword();
	}

	@Override
	public String getUsername() {
		return employe.getName();
	}

	
}
