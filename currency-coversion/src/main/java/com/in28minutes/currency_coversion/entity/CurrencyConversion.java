package com.in28minutes.currency_coversion.entity;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private int id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal conversionRate;
	private BigDecimal totalCalculatedAmount;
	private String environment;
	
	public CurrencyConversion()
	{
		
	}
	
	
	public CurrencyConversion(int id, String from, String to, BigDecimal quantity, BigDecimal conversionRate,
			BigDecimal totalCalculatedAmount, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.conversionRate = conversionRate;
		this.totalCalculatedAmount = totalCalculatedAmount;
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
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", from=" + from + ", to=" + to + ", quantity=" + quantity
				+ ", conversionRate=" + conversionRate + ", totalCalculatedAmount=" + totalCalculatedAmount
				+ ", environment=" + environment + "]";
	}
	
	

}
