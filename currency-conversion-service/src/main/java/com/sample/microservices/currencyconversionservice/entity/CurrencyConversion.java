package com.sample.microservices.currencyconversionservice.entity;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal quatity;
	private BigDecimal conversionMultiple;
	private BigDecimal totalCalculatedAmount;
	private BigDecimal environment;
	
	public CurrencyConversion() {
		
	}
	
	public CurrencyConversion(Long id, String from, String to, BigDecimal quatity, BigDecimal conversionMultiple,
			BigDecimal totalCalculatedAmount, BigDecimal environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quatity = quatity;
		this.conversionMultiple = conversionMultiple;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.environment = environment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public BigDecimal getQuatity() {
		return quatity;
	}

	public void setQuatity(BigDecimal quatity) {
		this.quatity = quatity;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public BigDecimal getEnvironment() {
		return environment;
	}

	public void setEnvironment(BigDecimal environment) {
		this.environment = environment;
	}
	
}