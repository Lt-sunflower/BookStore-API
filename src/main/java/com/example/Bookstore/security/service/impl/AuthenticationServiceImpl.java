package com.example.Bookstore.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Bookstore.security.model.AuthenticationRequest;
import com.example.Bookstore.security.model.AuthenticationResponse;
import com.example.Bookstore.security.model.RegisterRequest;
import com.example.Bookstore.security.model.Role;
import com.example.Bookstore.security.model.User;
import com.example.Bookstore.security.repository.UserRepository;
import com.example.Bookstore.security.service.AuthenticationService;
import com.example.Bookstore.security.service.JwtService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Override
	public AuthenticationResponse register(RegisterRequest request) {
		
		User user = User.builder()
				.username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER)
				.build();
						
		userRepository.save(user);
		
		String jwtToken = jwtService.generateToken(user);
		
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}

	@Override
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		
		User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
		
		String jwtToken = jwtService.generateToken(user);
		
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}

	
}
