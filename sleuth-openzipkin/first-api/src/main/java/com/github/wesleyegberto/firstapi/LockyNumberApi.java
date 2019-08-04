package com.github.wesleyegberto.firstapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LockyNumberApi {
	@Autowired
	private RestTemplate restTemplate;

	public String getLuckyNumber() {
		return restTemplate.getForObject("http://localhost:8090/numbers/lucky", String.class);
	}
}
