package com.ahmet.springSecurityJWT.business.abstracts;

import com.ahmet.springSecurityJWT.entities.dtos.UserDto;
import com.ahmet.springSecurityJWT.entities.dtos.UserRequest;
import com.ahmet.springSecurityJWT.entities.dtos.UserResponse;

public interface AuthenticationService {

	UserResponse save(UserDto userDto);

	UserResponse auth(UserRequest userRequest);

}
