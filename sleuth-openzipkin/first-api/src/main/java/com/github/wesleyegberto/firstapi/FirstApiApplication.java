package com.github.wesleyegberto.firstapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FirstApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstApiApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplateBuilder()
			.defaultMessageConverters()
			.build();
	}
}
