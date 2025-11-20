package com.jobportal.backend.utils;

import org.springframework.stereotype.Service;

import com.jobportal.backend.repository.ExperienceRepository;
import com.jobportal.backend.repository.JobApplicationRepository;
import com.jobportal.backend.repository.JobRepository;
import com.jobportal.backend.repository.UserRepository;

@Service
public class HelperUtils {

	private final UserRepository userrepository;
	private final JobApplicationRepository jobapplicationRepo;
	private final JobRepository jobrepository;
	private final ExperienceRepository experienceRepository;

	public HelperUtils(UserRepository userrepository, JobApplicationRepository jobapplicationRepo,
			JobRepository jobrepository, ExperienceRepository experienceRepository) {
		this.userrepository = userrepository;
		this.jobapplicationRepo = jobapplicationRepo;
		this.jobrepository = jobrepository;
		this.experienceRepository = experienceRepository;
	}

	/**
	 * 
	 * @return
	 */
	public String generateUserId() {
		Long seqValue = userrepository.getNextUserSequence();
		return "USR" + String.format("%04d", seqValue);

	}

	/**
	 * 
	 * @return
	 */
	public String generateJobId() {
		Long seqValue = jobrepository.getNextJobSeq();
		return "JOB" + String.format("%04d", seqValue);

	}

	/**
	 * 
	 * @return
	 */
	public String generateJobApplicationId() {
		Long seqValue = jobapplicationRepo.getNextApplicationSeq();
		return "JOBApp" + String.format("%04d", seqValue);

	}

	public String generateExpId() {
		Long seqValue = experienceRepository.getNextExpSequence();
		return "EXP" + String.format("%04d", seqValue);

	}

}
