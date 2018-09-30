package com.github.wesleyegberto.springmvc;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.netflix.concurrency.limits.servlet.ConcurrencyLimitServletFilter;
import com.netflix.concurrency.limits.servlet.ServletLimiterBuilder;

@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}
	
	@Bean
	public Filter buildConcurrencyLimitFilter() {
		return new ConcurrencyLimitServletFilter(new ServletLimiterBuilder()
			.partitionByPathInfo(s -> "/api", c -> c.assign("/api", 0.50).build())
			.build());
	}
}
