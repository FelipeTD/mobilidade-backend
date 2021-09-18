package com.bot.entity.freenow.gains;

import java.util.List;

public class GainsResponse {
	
	private Totals totals;
	private String currency;
	private List<DriverEarnings> driverEarnings;
	
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
	public List<DriverEarnings> getDriverEarnings() {
		return driverEarnings;
	}
	public void setDriverEarnings(List<DriverEarnings> driverEarnings) {
		this.driverEarnings = driverEarnings;
	}	

}
