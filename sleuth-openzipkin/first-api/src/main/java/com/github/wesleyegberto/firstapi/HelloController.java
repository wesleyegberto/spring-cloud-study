package com.github.wesleyegberto.firstapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
	@Autowired
	private LockyNumberApi luckyNumberApi;

	@GetMapping("hello")
	public String sayHello() {
		return "Hello Tracing World! Here is your lucky number: " + luckyNumberApi.getLuckyNumber();
	}
}
