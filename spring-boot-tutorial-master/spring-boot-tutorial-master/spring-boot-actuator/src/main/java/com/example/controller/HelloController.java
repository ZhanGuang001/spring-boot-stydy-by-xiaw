package com.example.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger logger = LoggerFactory
            .getLogger(HelloController.class);
    
    @RequestMapping("/hello")
    public String index() {
    	logger.trace("HelloController trace Message");
    	logger.debug("HelloController Debug Message");
    	logger.info("HelloController Info Message");
		logger.warn("HelloController warn Message");
		logger.error("HelloController error Message");  
        return "Hello World";
    }
}