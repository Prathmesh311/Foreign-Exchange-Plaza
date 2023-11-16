package com.sample.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sample.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.sample.microservices.currencyexchangeservice.entity.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	private CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		//CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(83.2));
		
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		
		
		if(currencyExchange == null) {
			throw new RuntimeException("No such convertion found");
		}
		
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		
		return currencyExchange;
	}

}