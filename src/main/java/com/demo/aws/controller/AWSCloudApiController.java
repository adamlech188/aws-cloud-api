package com.demo.aws.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AWSCloudApiController {

	
	@GetMapping("/hello")
	public ResponseEntity<String> getHello() {
		return ResponseEntity.ok("Hello from Adam v2");
	}
	
	@GetMapping("/hostname")
	public ResponseEntity<String> getHostname() {
		String hostname = System.getenv("HOSTNAME");
		return ResponseEntity.ok(hostname);
	}
	
}
