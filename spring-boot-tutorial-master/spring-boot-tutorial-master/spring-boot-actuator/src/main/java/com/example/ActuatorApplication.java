package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ActuatorApplication {
	
	@Bean
	public HealthIndicator myHealth() {
		return () -> {
			return Health.up().build();
//			return Health.down().withDetail("Error Code", 404).build();
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(ActuatorApplication.class, args);
	}
}
