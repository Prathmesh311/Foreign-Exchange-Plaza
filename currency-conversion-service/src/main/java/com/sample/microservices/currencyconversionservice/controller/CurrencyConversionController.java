package com.sample.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sample.microservices.currencyconversionservice.entity.CurrencyConversion;
import com.sample.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;


@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	private CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> resposeEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
				CurrencyConversion.class, uriVariables);
		
		CurrencyConversion currencyConversion = resposeEntity.getBody();
		
		
		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, 
				currencyConversion.getConversionMultiple(), 
				currencyConversion.getConversionMultiple().multiply(quantity), 
				currencyConversion.getEnvironment() + " from REST client");
	}
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	private CurrencyConversion calculateCurrencyConversionFeign(
			@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		
		CurrencyConversion currencyConversion = proxy.retriveExchangeValue(from, to);
		
		
		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity, 
				currencyConversion.getConversionMultiple(), 
				currencyConversion.getConversionMultiple().multiply(quantity), 
				currencyConversion.getEnvironment() + " from feign");
	}
}
