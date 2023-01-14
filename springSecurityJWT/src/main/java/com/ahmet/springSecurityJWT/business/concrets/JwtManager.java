package com.ahmet.springSecurityJWT.business.concrets;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ahmet.springSecurityJWT.business.abstracts.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtManager implements JwtService {

	//TODO Buraya çözüm
	@Value("Z8kcMCD8JOziOKUQoO0iMBviRVfn85cWpP8UmW7jGaNCDWn40xB8IFix54yQv7vo")
	private String SECRET_KEY;
	
	@Override
	public String findUsername(String token) {
		return exportToken(token, Claims::getSubject);
	}

	private <T> T exportToken(String token, Function<Claims, T> claimsTFunction) {
		final Claims claims = Jwts.parserBuilder()
				.setSigningKey(getKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
		return claimsTFunction.apply(claims);
	}
	
	private Key getKey() {
		byte[] key = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(key);
	}

	@Override
	public boolean tokenControl(String jwt, UserDetails userDetails) {
		final String username = findUsername(jwt);
		return (username.equals(userDetails.getUsername()) && !exportToken(jwt, Claims::getExpiration).before(new Date()));
	}

	@Override
	public String generateToken(UserDetails userDetails) {
		return Jwts.builder()
				.setClaims(new HashMap<>())
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
				.signWith(getKey(), SignatureAlgorithm.HS256)
				.compact();
	}

}
