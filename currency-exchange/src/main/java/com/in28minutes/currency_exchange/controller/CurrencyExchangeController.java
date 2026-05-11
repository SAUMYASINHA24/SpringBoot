package com.in28minutes.currency_exchange.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.currency_exchange.entity.CurrencyExchange;
import com.in28minutes.currency_exchange.repository.CurrencyExchangeRepository;



@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeRate(@PathVariable String from, @PathVariable String to)
	{
		
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		if(currencyExchange == null )
			throw new RuntimeException("Unable to find the currencies");
		//CurrencyExchange currencyExchange = new CurrencyExchange(1,from,to,BigDecimal.valueOf(50));
		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
		return currencyExchange;
		
	}

	
}
