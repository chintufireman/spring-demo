package com.learning.dto;

import com.learning.entities.Employe;

public class JwtResponse {
	
	String accessToken;
	String refreshToken;
	Employe employe;
	
	
	public JwtResponse(String accessToken, String refreshToken, Employe employe) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.employe = employe;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
}
