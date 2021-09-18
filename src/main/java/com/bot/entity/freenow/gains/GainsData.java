package com.bot.entity.freenow.gains;

import java.util.List;

public class GainsData {
	
	private Totals totals;
	private String currency;
	private List<Gain> gainsData;

	public Totals getTotals() {
		return totals;
	}

	public void setTotals(Totals totals) {
		this.totals = totals;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<Gain> getGainsData() {
		return gainsData;
	}

	public void setGainsData(List<Gain> gainsData) {
		this.gainsData = gainsData;
	}

	
	
	

}
