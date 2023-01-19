package com.ahmet.springSecurityJWT.config;

import java.io.IOException;

import com.ahmet.springSecurityJWT.business.abstracts.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtAuthanticationFilter extends OncePerRequestFilter {

	private final JwtService jwtService;

	private final UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal( @NonNull HttpServletRequest request,
									 @NonNull HttpServletResponse response,
									 @NonNull FilterChain filterChain)
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
			
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			
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
