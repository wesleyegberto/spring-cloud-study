package com.github.wesleyegberto.eurekaclientstock.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockController {

	@GetMapping("products/{sku}/available")
	public int getAvailableStock(@PathVariable("sku") String sku) {
		if ("123".equals(sku))
			return 10;
		return 1;
	}
}
