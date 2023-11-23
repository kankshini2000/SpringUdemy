package com.example.spring.springudemycourse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@GetMapping("/api/hello-world")
	public String helloWorld() {
		return "This is simple Hello world";
	}
}
