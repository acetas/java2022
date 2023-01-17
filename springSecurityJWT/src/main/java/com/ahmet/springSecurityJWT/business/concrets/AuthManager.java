package com.ahmet.springSecurityJWT.business.concrets;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ahmet.springSecurityJWT.business.abstracts.AuthenticationService;
import com.ahmet.springSecurityJWT.business.abstracts.JwtService;
import com.ahmet.springSecurityJWT.dataAccess.abstracts.UserRepository;
import com.ahmet.springSecurityJWT.entities.concretes.User;
import com.ahmet.springSecurityJWT.entities.dtos.UserDto;
import com.ahmet.springSecurityJWT.entities.dtos.UserRequest;
import com.ahmet.springSecurityJWT.entities.dtos.UserResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthenticationService {
	
	private UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	
	private final AuthenticationManager authenticationManager;
	
	@Override
	public UserResponse save(UserDto userDto) {
	
		User user = User.builder()
				.username(userDto.getUsername())
				.password(passwordEncoder.encode(userDto.getPassword()))
				.role(userDto.getRole())
				.build();

		User response = userRepository.save(user);

		var token = jwtService.generateToken(response);

		return UserResponse.builder().token(token).build();
		
	}

	@Override
	public UserResponse auth(UserRequest userRequest) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(),
				userRequest.getPassword()));
		User user = userRepository.findByUsername(userRequest.getUsername()).orElseThrow(()-> new UsernameNotFoundException("User Not Found or Invalid Password"));
		String token = jwtService.generateToken(user);
		return UserResponse.builder().token(token).build();
	}

	

	
	
}
