package com.ahmet.springSecurityJWT.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ahmet.springSecurityJWT.business.abstracts.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthanticationFilter extends OncePerRequestFilter {

	@Autowired
	private final JwtService jwtService;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		final String header = request.getHeader("Authorization");
		final String jwt;
		final String username;

		if (header == null || header.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}

		jwt = header.substring(7);
		username = jwtService.findUsername(jwt);

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			
			if (jwtService.tokenControl(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				
			}
		}

		filterChain.doFilter(request, response);
		
	}

}
