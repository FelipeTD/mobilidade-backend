package com.bot.entity.freenow.historyReservation;

public class BookingRecordList {
	
	private Long id;
	private String pickupDate;
	private Location pickupLocation;
	private String dropoffDate;
	private Location dropoffLocation;
	private String hailingType;
	private Driver driver;
	private TourValue tourValue;
	private String state;
	private Long routeDuration;
	private Long routeDistance;
	private String subFleetTypeLabel;
	private String paymentMethod;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}
	public Location getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(Location pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public String getDropoffDate() {
		return dropoffDate;
	}
	public void setDropoffDate(String dropoffDate) {
		this.dropoffDate = dropoffDate;
	}
	public Location getDropoffLocation() {
		return dropoffLocation;
	}
	public void setDropoffLocation(Location dropoffLocation) {
		this.dropoffLocation = dropoffLocation;
	}
	public String getHailingType() {
		return hailingType;
	}
	public void setHailingType(String hailingType) {
		this.hailingType = hailingType;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public TourValue getTourValue() {
		return tourValue;
	}
	public void setTourValue(TourValue tourValue) {
		this.tourValue = tourValue;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getRouteDuration() {
		return routeDuration;
	}
	public void setRouteDuration(Long routeDuration) {
		this.routeDuration = routeDuration;
	}
	public Long getRouteDistance() {
		return routeDistance;
	}
	public void setRouteDistance(Long routeDistance) {
		this.routeDistance = routeDistance;
	}
	public String getSubFleetTypeLabel() {
		return subFleetTypeLabel;
	}
	public void setSubFleetTypeLabel(String subFleetTypeLabel) {
		this.subFleetTypeLabel = subFleetTypeLabel;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
