package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:/META-INF/application-context.xml")
public class SpringDiAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDiAnnotationApplication.class, args);
	}
}
