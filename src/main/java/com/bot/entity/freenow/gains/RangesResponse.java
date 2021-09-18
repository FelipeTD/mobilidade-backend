package com.bot.entity.freenow.gains;

import java.util.List;

public class RangesResponse {
	
	private List<RangeResponse> responseRanges;
	private String requestDate;

	public List<RangeResponse> getResponseRanges() {
		return responseRanges;
	}

	public void setResponseRanges(List<RangeResponse> responseRanges) {
		this.responseRanges = responseRanges;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

}
