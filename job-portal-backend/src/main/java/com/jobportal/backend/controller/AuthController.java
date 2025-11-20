package com.jobportal.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.backend.domain.AuthResponse;
import com.jobportal.backend.domain.LoginRequest;
import com.jobportal.backend.domain.RegisterRequest;
import com.jobportal.backend.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
		String response = authService.registerUser(request);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/login")
	public AuthResponse login(@RequestBody LoginRequest request) {
		return authService.login(request);
	}
}
