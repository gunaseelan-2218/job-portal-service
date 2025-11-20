package com.jobportal.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.backend.domain.JobResponse;
import com.jobportal.backend.repository.JobRepository;

@Service
public class JobService {

	@Autowired
	private JobRepository jobRepository;

//	/**
//	 * Helper Service to get the Total no of jobs to the user
//	 * 
//	 * @return
//	 */
//	public List<JobResponse> getAllJobs() {
//		return jobRepository.findAll().stream().map(job -> {
//			JobResponse dto = new JobResponse();
//			dto.setJobId(job.getJobId());
//			dto.setTitle(job.getTitle());
//			dto.setCompany(job.getCompany());
//			dto.setLocation(job.getLocation());
//			dto.setDescription(job.getDescription());
//			dto.setSalary(job.getSalary());
//			return dto;
//		}).collect(Collectors.toList());
//	}
	
} 
