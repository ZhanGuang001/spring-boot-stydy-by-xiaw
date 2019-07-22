package com.example.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

//@Component
public class LifeBean{

	@PostConstruct
	public void init() {
		System.out.println("init bean.");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destory bean");
	}
}
