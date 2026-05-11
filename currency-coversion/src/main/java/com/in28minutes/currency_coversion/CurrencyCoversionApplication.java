package com.in28minutes.currency_coversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyCoversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyCoversionApplication.class, args);
	}

}
