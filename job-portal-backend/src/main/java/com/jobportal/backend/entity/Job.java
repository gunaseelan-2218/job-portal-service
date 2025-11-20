package com.jobportal.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jobs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {

	@Id
	@Column(name = "job_code", length = 20)
	private String jobCode;

	private String title;

	//@Lob
	private String description;

	private String location;
	
	@Column(name = "posted_date")
	private LocalDate postedDate;
	
	@Column(name = "expiry_date")
	private LocalDate expiryDate;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@ManyToOne
	@JoinColumn(name = "created_by", referencedColumnName = "user_id")
	private User postedBy;

	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
	private List<JobApplication> applications = new ArrayList<>();
 
}
