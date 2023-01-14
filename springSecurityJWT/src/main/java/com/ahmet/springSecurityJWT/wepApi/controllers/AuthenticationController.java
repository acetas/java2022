package com.ahmet.springSecurityJWT.wepApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahmet.springSecurityJWT.business.abstracts.AuthenticationService;
import com.ahmet.springSecurityJWT.entities.dtos.UserDto;
import com.ahmet.springSecurityJWT.entities.dtos.UserRequest;
import com.ahmet.springSecurityJWT.entities.dtos.UserResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login/")
@RequiredArgsConstructor
public class AuthenticationController {

	@Autowired
	private final AuthenticationService authService;
	
	@PostMapping("add")
	public ResponseEntity<UserResponse> save(@RequestBody UserDto userDto){
		return ResponseEntity.ok(authService.save(userDto));
	}
	
	@PostMapping("auth")
	public ResponseEntity<UserResponse> auth(@RequestBody UserRequest userRequest){
		return ResponseEntity.ok(authService.auth(userRequest));
	}
	
}
