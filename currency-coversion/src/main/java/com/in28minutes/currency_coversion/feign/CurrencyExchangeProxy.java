package com.in28minutes.currency_coversion.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.currency_coversion.entity.CurrencyConversion;

//@FeignClient(name = "currency-exchange",url = "localhost:8000") // when this URL is mentioned then 
//load balancing and all is not happening
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retriveExchangeRate(@PathVariable String from, @PathVariable String to);
	

}
