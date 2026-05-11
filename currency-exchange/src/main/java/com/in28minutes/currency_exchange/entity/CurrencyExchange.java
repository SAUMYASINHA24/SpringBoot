package com.in28minutes.currency_exchange.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrencyExchange {
	
	@Id
	private int id;
	@Column(name ="currency_from")
	private String from;
	@Column(name ="currency_to")
	private String to;
	private BigDecimal conversionRate;
	private String environment;
	
	public CurrencyExchange()
	{
		
	}
	public CurrencyExchange(int id, String from, String to, BigDecimal conversionRate) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionRate = conversionRate;
	}
	
	public CurrencyExchange(int id, String from, String to, BigDecimal conversionRate, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionRate = conversionRate;
		this.environment = environment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", from=" + from + ", to=" + to + ", conversionRate=" + conversionRate
				+ ", environment=" + environment + "]";
	}
	
	

}
