package com.jobportal.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@Column(name = "user_id", length = 20)
	private String userId;

	private String name;

	@Column(unique = true)
	private String email;

	private String password;

	private String phone;

	//@Lob
	private String skills;

	//@Lob
	private String summary;

	private String role;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Experience> experiences = new ArrayList<>();

	@OneToMany(mappedBy = "postedBy", cascade = CascadeType.ALL)
	private List<Job> postedJobs = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<JobApplication> applications = new ArrayList<>();

}
