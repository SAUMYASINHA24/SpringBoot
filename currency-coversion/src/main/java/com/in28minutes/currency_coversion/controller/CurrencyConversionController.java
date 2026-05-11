package com.in28minutes.currency_coversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import com.in28minutes.currency_coversion.entity.CurrencyConversion;
import com.in28minutes.currency_coversion.feign.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyExchangeProxy currencyExchangeProxy;
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveFinalConvertedValue(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity)
	{
		HashMap<String,String> uriVariables =  new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversion.class,uriVariables);
		CurrencyConversion currencyConversion = forEntity.getBody();
		return new CurrencyConversion(currencyConversion.getId(),from,to,quantity,currencyConversion.getConversionRate()
				,quantity.multiply(currencyConversion.getConversionRate()),currencyConversion.getEnvironment()+" rest-template");
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveFinalConvertedValueFeign(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity)
	{
		CurrencyConversion currencyConversion = currencyExchangeProxy.retriveExchangeRate(from, to);
		return new CurrencyConversion(currencyConversion.getId(),from,to,quantity,currencyConversion.getConversionRate()
				,quantity.multiply(currencyConversion.getConversionRate()),currencyConversion.getEnvironment()+" feign ");
	}

}
