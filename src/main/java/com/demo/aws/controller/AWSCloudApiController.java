package com.demo.aws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AWSCloudApiController {

	private Logger logger = LoggerFactory.getLogger(this.getClass()); 

	@GetMapping("/hello")
	public ResponseEntity<String> getHello() {
		return ResponseEntity.ok("Hello from Adam v4");
	}
	
	@GetMapping("/hostname")
	public ResponseEntity<String> getHostname() {
		String hostname = System.getenv("HOSTNAME");
		logger.info("Hostname was called");
		return ResponseEntity.ok(hostname);
	}
	
	@GetMapping("/health")
	public ResponseEntity<String> getHealth() {
		return ResponseEntity.ok("Health ping.");
	}
	
}
