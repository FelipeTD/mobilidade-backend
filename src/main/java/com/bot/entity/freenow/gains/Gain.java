package com.bot.entity.freenow.gains;

import java.util.List;

public class Gain {
	
	private String index;
	private List<DriverEarnings> driverEarnings;
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public List<DriverEarnings> getDriverEarnings() {
		return driverEarnings;
	}
	public void setDriverEarnings(List<DriverEarnings> driverEarnings) {
		this.driverEarnings = driverEarnings;
	}

}
