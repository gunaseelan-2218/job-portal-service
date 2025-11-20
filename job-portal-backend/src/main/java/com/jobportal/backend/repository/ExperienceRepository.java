package com.jobportal.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobportal.backend.entity.Experience;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, String> {

	List<Experience> findByUser_UserId(String userId);
	
	@Query(value = "SELECT nextval('job_portal.exp_seq')", nativeQuery = true)
	Long getNextExpSequence();
}