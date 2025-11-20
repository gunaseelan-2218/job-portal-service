package com.jobportal.backend.repository;

import com.jobportal.backend.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByEmail(String email);

	boolean existsByEmail(String email);

	@Query(value = "SELECT nextval('job_portal.user_seq')", nativeQuery = true)
	Long getNextUserSequence();
}