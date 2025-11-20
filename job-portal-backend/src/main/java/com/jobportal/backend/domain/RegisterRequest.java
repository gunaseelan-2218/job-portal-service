package com.jobportal.backend.domain;

import lombok.Data;

import java.util.List;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String skills;
    private String summary;
    private String resume;
    private List<ExperienceDTO> experience;
    private String profilePicture;
    private String role; // USER or ADMIN (for testing; in production create admins separately)
}
