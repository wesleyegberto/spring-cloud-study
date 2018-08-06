package com.github.wesleyegberto.netflixstackstudy.monitordashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableHystrixDashboard
@SpringBootApplication
public class MonitorDashboardApplication extends SpringBootServletInitializer {

	@RequestMapping("/")
	public String home() {
		return "forward:/hystrix";
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MonitorDashboardApplication.class).web(true);
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(MonitorDashboardApplication.class).web(true).run(args);
	}
}
