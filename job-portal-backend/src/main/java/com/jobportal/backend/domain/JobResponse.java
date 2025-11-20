package com.jobportal.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobResponse {
	private long jobId;
	private String title;
	private String company;
	private String location;
	private String description;
	private String salary;
}
