package com.github.wesleyegberto.eurekaclientstore.resources;

import com.github.wesleyegberto.eurekaclientstore.services.StockServiceUsingRibbon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.github.wesleyegberto.eurekaclientstore.services.StockService;

@RestController
@RequestMapping("/store")
public class StoreResource {
	
	@Autowired
	private StockService stockService;
	@Autowired
	private StockServiceUsingRibbon stockServiceRibbon;

	private String handleStockResult(String sku, Integer availableStock) {
		if (availableStock == null)
			return "Couldn't verify our stock :(";
		if (availableStock == -1)
			return "Our stock is offline now, please, try again in a few minutes :)";
		return "Buying " + sku + " from stock with " + availableStock + " items available.";
	}

	@GetMapping("order/item/{sku}")
	public String buyOneItem(@PathVariable("sku") String sku, @RequestParam(required = false) boolean ribbon) {
		Integer availableStock = ribbon ? stockServiceRibbon.getAvailableStock(sku) : stockService.getAvailableStock(sku);
		return handleStockResult(sku, availableStock);
	}
}
