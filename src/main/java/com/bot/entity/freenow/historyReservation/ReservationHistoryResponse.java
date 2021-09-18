package com.bot.entity.freenow.historyReservation;

import java.util.List;

public class ReservationHistoryResponse {
	
	private List<BookingRecordList> bookingRecordList;
	private Integer page;
	private Integer size;
	private Integer totalCount;

	public List<BookingRecordList> getBookingRecordList() {
		return bookingRecordList;
	}

	public void setBookingRecordList(List<BookingRecordList> bookingRecordList) {
		this.bookingRecordList = bookingRecordList;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	

}
