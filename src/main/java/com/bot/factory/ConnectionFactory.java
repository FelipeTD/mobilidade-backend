package com.bot.factory;

import org.springframework.stereotype.Component;

@Component
public class ConnectionFactory {

    private String freeNowCookie;
    private String carTrackCookie;
    private String prioCookie;
    private String viaVerdeCookie;
    private String inosatCookie;
    private String boltCookie;
    private String uberCookie;
    private String uberRequestCookie;

	public String getFreeNowCookie() {
		return freeNowCookie;
	}

	public void setFreeNowCookie(String freeNowCookie) {
		this.freeNowCookie = freeNowCookie;
	}

	public String getCarTrackCookie() {
		return carTrackCookie;
	}

	public void setCarTrackCookie(String carTrackCookie) {
		this.carTrackCookie = carTrackCookie;
	}

	public String getPrioCookie() {
		return prioCookie;
	}

	public void setPrioCookie(String prioCookie) {
		this.prioCookie = prioCookie;
	}

	public String getViaVerdeCookie() {
		return viaVerdeCookie;
	}

	public void setViaVerdeCookie(String viaVerdeCookie) {
		this.viaVerdeCookie = viaVerdeCookie;
	}

	public String getInosatCookie() {
		return inosatCookie;
	}

	public void setInosatCookie(String inosatCookie) {
		this.inosatCookie = inosatCookie;
	}

	public String getBoltCookie() {
		return boltCookie;
	}

	public void setBoltCookie(String boltCookie) {
		this.boltCookie = boltCookie;
	}

	public String getUberCookie() {
		return uberCookie;
	}

	public void setUberCookie(String uberCookie) {
		this.uberCookie = uberCookie;
	}

	public String getUberRequestCookie() {
		return uberRequestCookie;
	}

	public void setUberRequestCookie(String uberRequestCookie) {
		this.uberRequestCookie = uberRequestCookie;
	}

}
