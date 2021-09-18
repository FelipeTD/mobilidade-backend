package com.bot.entity.freenow.gains;

import java.util.List;

public class DriverEarnings {
	
	private TotalsDriver totals;
	private Tours tours;
	private Gross tips;
	private String currency;
	private Gross quests;
	private Gross tolls;
	private Gross others;
	private Gross cancellationFees;
	private List<String> commissionable;
	private String driverPublicId;
	private String driverId;
	private String driverProfilePictureUrl;
	private String driverPublicName;
	private String hailingType;
	
	public TotalsDriver getTotals() {
		return totals;
	}
	public void setTotals(TotalsDriver totals) {
		this.totals = totals;
	}
	public Tours getTours() {
		return tours;
	}
	public void setTours(Tours tours) {
		this.tours = tours;
	}
	public Gross getTips() {
		return tips;
	}
	public void setTips(Gross tips) {
		this.tips = tips;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Gross getQuests() {
		return quests;
	}
	public void setQuests(Gross quests) {
		this.quests = quests;
	}
	public Gross getTolls() {
		return tolls;
	}
	public void setTolls(Gross tolls) {
		this.tolls = tolls;
	}
	public Gross getOthers() {
		return others;
	}
	public void setOthers(Gross others) {
		this.others = others;
	}
	public Gross getCancellationFees() {
		return cancellationFees;
	}
	public void setCancellationFees(Gross cancellationFees) {
		this.cancellationFees = cancellationFees;
	}
	public List<String> getCommissionable() {
		return commissionable;
	}
	public void setCommissionable(List<String> commissionable) {
		this.commissionable = commissionable;
	}
	public String getDriverPublicId() {
		return driverPublicId;
	}
	public void setDriverPublicId(String driverPublicId) {
		this.driverPublicId = driverPublicId;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getDriverProfilePictureUrl() {
		return driverProfilePictureUrl;
	}
	public void setDriverProfilePictureUrl(String driverProfilePictureUrl) {
		this.driverProfilePictureUrl = driverProfilePictureUrl;
	}
	public String getDriverPublicName() {
		return driverPublicName;
	}
	public void setDriverPublicName(String driverPublicName) {
		this.driverPublicName = driverPublicName;
	}
	public String getHailingType() {
		return hailingType;
	}
	public void setHailingType(String hailingType) {
		this.hailingType = hailingType;
	}

}
