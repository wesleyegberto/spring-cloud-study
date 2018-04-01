package com.github.wesleyegberto.eurekaclientstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.wesleyegberto.eurekaclientstore.services.StockService;

@RestController
@RequestMapping("/store")
public class StoreResource {
	
	@Autowired
	private StockService stockService;

	@GetMapping("order/item/{sku}")
	public String buyOneItem(@PathVariable("sku") String sku) {
		Integer availableStock = stockService.getAvailableStock(sku);
		if (availableStock == null)
			return "Couldn't verify our stock :(";
		if (availableStock == -1)
			return "Our stock is offline now, please, try again in a few minutes :)";
		return "Buying " + sku + " from stock with " + availableStock + " items available.";
	}
}
