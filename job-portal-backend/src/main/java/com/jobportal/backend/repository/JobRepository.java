package com.jobportal.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobportal.backend.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {

	 List<Job> findByPostedBy_UserId(String userId);


	@Query(value = "SELECT nextval('job_portal.job_seq')", nativeQuery = true)
	Long getNextJobSeq();
}