package com.ahmet.springSecurityJWT.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahmet.springSecurityJWT.entities.concretes.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
	
}
