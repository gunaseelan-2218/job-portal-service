package com.jobportal.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_applications", uniqueConstraints = @UniqueConstraint(columnNames = { "job_code", "user_id" }))
public class JobApplication {

	@Id
	@Column(name = "application_id", length = 20)
	private String applicationId; // APP0001

	@ManyToOne
	@JoinColumn(name = "job_code", referencedColumnName = "job_code")
	private Job job;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	private String resumePath; // file path or URL
	private String status = "PENDING";
	private LocalDateTime appliedAt = LocalDateTime.now();

}
