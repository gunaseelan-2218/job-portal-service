package com.jobportal.backend.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobportal.backend.domain.AuthResponse;
import com.jobportal.backend.domain.LoginRequest;
import com.jobportal.backend.domain.RegisterRequest;
import com.jobportal.backend.entity.User;
import com.jobportal.backend.exceptions.BusinessException;
import com.jobportal.backend.repository.UserRepository;
import com.jobportal.backend.utils.JwtUtil;

@Service
public class AuthService {

	private final UserRepository userRepository;
	private final JwtUtil jwtUtil;

	public AuthService(UserRepository repo, JwtUtil util) {
		this.userRepository = repo;
		this.jwtUtil = util;
	}

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	/**
	 * @apiNote
	 * @param request
	 * @return
	 */
	public AuthResponse register(RegisterRequest request) {

		if (userRepository.existsByEmail(request.getEmail())) {
			throw new BusinessException("Email already registered" ,"BS001");
		}
		User user = User.builder().username(request.getUsername()).email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword())).role(User.Role.USER)
				.provider(User.Provider.LOCAL).build();
		userRepository.save(user);
		return new AuthResponse("Registration successful for the User " , user.getUsername());
	}

	/**
	 * @apiNote
	 * @param request
	 * @return
	 */
	public AuthResponse login(LoginRequest request) {
		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new RuntimeException("Invalid credentials"));
		if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalid credentials");
		}
		String token = jwtUtil.generateToken(user.getEmail());
		return new AuthResponse("Login successful", token);
	}
}
