package com.in28minutes.springboot.learn_springboot_framework;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {
	
	@Autowired
	Currency currencyObjectCurrency;
	@RequestMapping("/getConfiguration")
	public Currency getCourses()
	{
		return currencyObjectCurrency;
	}

}
