package com.github.wesleyegberto.eurekaclientstore.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "stock-service", fallback = StockServiceFallback.class)
public interface StockService {
	@RequestMapping(method = RequestMethod.GET, path = "/stocks/products/{sku}/available")
	Integer getAvailableStock(@PathVariable("sku") String sku);
}

@Component
class StockServiceFallback implements StockService {
	@Override
	public Integer getAvailableStock(String sku) {
		return -1;
	}
}