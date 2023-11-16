package com.sample.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sample.microservices.currencyconversionservice.entity.CurrencyConversion;


@RestController
public class CurrencyConversionController {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}/quatity/{quantity}")
	private CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		return new CurrencyConversion(1000L, from, to, quantity, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
	}

}
