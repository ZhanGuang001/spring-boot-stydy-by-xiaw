package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	@Value("${name}")
	private String name;

	@RequestMapping("/hello")
	public String index() {
		logger.debug("Hello," + name);
		return "Hello," + name;
	}
}