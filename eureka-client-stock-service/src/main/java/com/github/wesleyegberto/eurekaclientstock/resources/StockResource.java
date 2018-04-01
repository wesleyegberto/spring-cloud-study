package com.github.wesleyegberto.eurekaclientstock.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockResource {

	@GetMapping("products/{sku}/available")
	public int getAvailableStock(@PathVariable("sku") String sku) {
		if ("123".equals(sku))
			return 10;
		return 1;
	}
}
