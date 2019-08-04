package com.github.wesleyegberto.secondapi;

import org.springframework.stereotype.Service;

@Service
public class LuckyNumberGenerator {
	public String generate() {
		int luckyNumber = (int) (Math.random() * 10_000);
		if (luckyNumber < 4000) {
			throw new IllegalArgumentException("Your lucky number was invalidated.");
		}
		return String.valueOf(luckyNumber);
	}
}
