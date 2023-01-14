package com.ahmet.springSecurityJWT.business.abstracts;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

	String generateToken(UserDetails userDetails);

	String findUsername(String token);

	boolean tokenControl(String jwt, UserDetails userDetails);

}
