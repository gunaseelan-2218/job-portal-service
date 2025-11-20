package com.jobportal.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobportal.backend.entity.JobApplication;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, String> {

	boolean existsByJob_JobCodeAndUser_UserId(String jobCode, String userId);

	List<JobApplication> findByUser_UserId(String userId);

	List<JobApplication> findByJob_JobCode(String jobCode);

	Optional<JobApplication> findByJob_JobCodeAndUser_UserId(String jobCode, String userId);

	@Query(value = "SELECT nextval('job_portal.application_seq')", nativeQuery = true)
	Long getNextApplicationSeq();
}