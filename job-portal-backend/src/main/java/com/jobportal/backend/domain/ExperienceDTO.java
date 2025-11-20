package com.jobportal.backend.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExperienceDTO {
	private String company;
	private LocalDate startDate;
	private LocalDate endDate;
	private String role;
	private String techStack;
}
