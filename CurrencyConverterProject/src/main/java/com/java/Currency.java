package com.java;

public class Currency { //POJO -plain old java object

	private int currencyId;
	private String sourceCurrency;
	private String targetCurrency;
	private double amountToConvert;
	
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	public String getSourceCurrency() {
		return sourceCurrency;
	}
	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}
	public String getTargetCurrency() {
		return targetCurrency;
	}
	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	public double getAmountToConvert() {
		return amountToConvert;
	}
	public void setAmountToConvert(double amountToConvert) {
		this.amountToConvert = amountToConvert;
	}

	
}