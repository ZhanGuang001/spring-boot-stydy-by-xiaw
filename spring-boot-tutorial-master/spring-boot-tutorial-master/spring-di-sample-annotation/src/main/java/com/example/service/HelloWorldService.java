package com.example.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


//@Component(value="helloService")
@Named("helloService")
//@Service
public class HelloWorldService {

public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//	@Value("${name:World}")
	@Value("aaaa")
	private String name;

	public String getHelloMessage() {
		return "Hello " + this.name;
	}
	
	public void sayHello() {
		System.out.println("Hello " + this.name);
	}
	
}
