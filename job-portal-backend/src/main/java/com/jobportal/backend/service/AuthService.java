package com.jobportal.backend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobportal.backend.domain.AuthResponse;
import com.jobportal.backend.domain.LoginRequest;
import com.jobportal.backend.domain.RegisterRequest;
import com.jobportal.backend.entity.Experience;
import com.jobportal.backend.entity.User;
import com.jobportal.backend.exceptions.BusinessException;
import com.jobportal.backend.repository.ExperienceRepository;
import com.jobportal.backend.repository.UserRepository;
import com.jobportal.backend.utils.HelperUtils;
import com.jobportal.backend.utils.JwtUtil;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthService {

	private final HelperUtils helperutils;
	private final UserRepository userRepository;
	private final JwtUtil jwtUtil;

	public AuthService(UserRepository repo, JwtUtil util, HelperUtils helperutils,
			ExperienceRepository experienceRepository) {
		this.userRepository = repo;
		this.jwtUtil = util;
		this.helperutils = helperutils;
	}

	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	/**
	 * @apiNote Helper service to Register the user in to the applications
	 * @param req
	 * @return
	 */
	public String registerUser(RegisterRequest req) {

		if (userRepository.existsByEmail(req.getEmail())) {
			throw new BusinessException("Email already registered", "BSAR001");
		}

		User user = User.builder().name(req.getName()).email(req.getEmail()).userId(helperutils.generateUserId())
				.password(passwordEncoder.encode(req.getPassword())).phone(req.getPhone()).skills(req.getSkills())
				.summary(req.getSummary()).role(req.getRole() == null ? "USER" : req.getRole())
				.createdAt(LocalDateTime.now()).build();
		System.out.println("Expereince list is " + req.getExperience());
		if (req.getExperience() != null && !req.getExperience().isEmpty()) {

			List<Experience> experiences = req.getExperience().stream()
					.map(expDto -> Experience.builder().expId(helperutils.generateExpId()).company(expDto.getCompany())
							.startDate(expDto.getStartDate()).endDate(expDto.getEndDate())
							.techStack(expDto.getTechStack()).user(user) // Set FK
							.build())
					.collect(Collectors.toList());

			user.setExperiences(experiences);
		}
		User savedUser = userRepository.save(user);

		return savedUser.getUserId();
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
		return new AuthResponse(token, user.getUserId());
	}
}
