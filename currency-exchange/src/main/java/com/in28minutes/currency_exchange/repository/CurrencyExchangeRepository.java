package com.in28minutes.currency_exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.currency_exchange.entity.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Integer>{
	
	CurrencyExchange findByFromAndTo(String from,String to);

}
