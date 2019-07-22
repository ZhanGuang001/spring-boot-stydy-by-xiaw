package com.example.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.ToString;

@ConfigurationProperties(prefix = "my")
@Configuration
@Data
@ToString
public class ConfigBean {
	private String name;
    private int age;
    private int number;
	private String uuid;
    private int max;
    private String value;
    private String greeting;
}
