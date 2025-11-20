package com.jobportal.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.backend.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private JobService jobService;

//	@PostMapping("/get")
//	public ResponseEntity<List<JobResponse>> getAllJobs() {
//		List<JobResponse> lstofjobs = jobService.getAllJobs();
//		return ResponseEntity.ok(lstofjobs);
//	}

//	@PostMapping("/add")
//	public ResponseEntity<JobRequest> addJob(@RequestBody JobRequest job) {
//		//return ResponseEntity.ok(jobService.createJob(job));
//	}

}
