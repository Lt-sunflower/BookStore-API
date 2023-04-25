package com.example.Bookstore.security.service;

import com.example.Bookstore.security.model.AuthenticationRequest;
import com.example.Bookstore.security.model.AuthenticationResponse;
import com.example.Bookstore.security.model.RegisterRequest;

public interface AuthenticationService {
	
	AuthenticationResponse register(RegisterRequest request);

	AuthenticationResponse authenticate(AuthenticationRequest request);

}
