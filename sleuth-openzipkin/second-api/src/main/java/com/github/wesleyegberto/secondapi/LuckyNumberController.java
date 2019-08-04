package com.github.wesleyegberto.secondapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numbers")
public class LuckyNumberController {
	
	@Autowired
	private LuckyNumberGenerator generator;

	@GetMapping("lucky")
	public String getLuckyNumber() {
		return generator.generate();
	}
}
