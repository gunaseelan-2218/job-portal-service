package com.jobportal.backend.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.backend.domain.Product;

@RestController
@RequestMapping("/api")
public class ProductController {

	@PostMapping("/products")
	public ResponseEntity<?> getProducts() {
		List<Product> productList = Arrays.asList(new Product(1, "Apple iPhone 15", 999.99),
				new Product(2, "Samsung Galaxy S24", 899.50), new Product(3, "OnePlus 12", 749.99),
				new Product(4, "Google Pixel 8", 799.00));

		return ResponseEntity.ok(productList); // 200 OK with JSON body
	}

}
