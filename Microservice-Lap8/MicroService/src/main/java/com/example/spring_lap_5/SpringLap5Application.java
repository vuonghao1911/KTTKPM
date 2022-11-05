package com.example.spring_lap_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringLap5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringLap5Application.class, args);
	}

}
