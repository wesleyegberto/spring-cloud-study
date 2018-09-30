package com.github.wesleyegberto.springmvc.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/simple")
public class MainController {

	@GetMapping("hello")
	public String simpleHello() {
		return "Simple Hello World!";
	}
}
