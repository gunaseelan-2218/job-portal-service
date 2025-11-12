package com.jobportal.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Map<String, Object>> handleBusinessException(BusinessException ex) {
		Map<String, Object> response = new HashMap<>();
		response.put("status", "FAILURE");
		response.put("message", ex.getMessage());
		response.put("errorCode", ex.getErrorCode());
		response.put("timestamp", LocalDateTime.now());

		// 👇 Return 200 even for business errors
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	// You can still handle real system errors separately
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
		Map<String, Object> response = new HashMap<>();
		response.put("status", "ERROR");
		response.put("message", "Internal Server Error");
		response.put("details", ex.getMessage());
		response.put("timestamp", LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
