package com.bot.freenow.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bot.entity.freenow.historyReservation.ReservationHistoryResponse;
import com.bot.utils.freenow.DateUtils;
import com.bot.utils.freenow.PatternUtils;
import com.bot.entity.freenow.historyReservation.ReservationHistory;
import com.bot.entity.freenow.historyReservation.ReservationHistoryData;

@Component
public class HistoryReservationMapper {
	
	@Autowired
	private DateUtils dateUtils;
	
	@Autowired
	private PatternUtils patternUtils;
	
	public ReservationHistoryData reservationHistoryMapper(ReservationHistoryResponse reservationHistory) {
		
		List<ReservationHistory> list = new ArrayList<>();
		
		reservationHistory.getBookingRecordList().forEach(reservation -> {
			ReservationHistory mappedReservation = new ReservationHistory();
			
			mappedReservation.setDriverId(reservation.getDriver().getPublicId());
			
			if (Objects.isNull(reservation.getDriver().getFirstName()) &&
					Objects.isNull(reservation.getDriver().getLastName())) {
				mappedReservation.setDriverName("-");
			} else {
				String driverName = reservation.getDriver().getFirstName() + " " + reservation.getDriver().getLastName();
				mappedReservation.setDriverName(driverName);
			}
			
			String streetName = Objects.isNull(reservation.getPickupLocation().getStreetName()) ? "" : 
				reservation.getPickupLocation().getStreetName() + " ";
			
			String streetNumber = Objects.isNull(reservation.getPickupLocation().getStreetNumber()) ? "," :
				reservation.getPickupLocation().getStreetNumber();
			
			String dropoffStreetName = Objects.isNull(reservation.getDropoffLocation().getStreetName()) ? "" : 
				reservation.getDropoffLocation().getStreetName() + " ";
			
			String dropoffStreetNumber = Objects.isNull(reservation.getDropoffLocation().getStreetNumber()) ? "," :
				reservation.getDropoffLocation().getStreetNumber();
			
			String routes = streetName + streetNumber + " "
					+ reservation.getPickupLocation().getCityCode() + " "
					+ reservation.getPickupLocation().getCityName() + " "
					+ reservation.getPickupLocation().getCountryCode() + " \n "
					+ dropoffStreetName + dropoffStreetNumber + " "
					+ reservation.getDropoffLocation().getCityCode() + " "
					+ reservation.getDropoffLocation().getCityName() + " "
					+ reservation.getDropoffLocation().getCountryCode();
			mappedReservation.setRoutes(routes);
			
			String hour = dateUtils.formatDateAndHourFreeNow(reservation.getPickupDate()) 
					+ " \n " + dateUtils.formatDateAndHourFreeNow(reservation.getDropoffDate());
			mappedReservation.setHour(hour);
			
			String travel = dateUtils.convertInMinutes(reservation.getRouteDuration()) 
					+ " \n " + patternUtils.longToFixed(reservation.getRouteDistance()) + " Km";
			mappedReservation.setTravel(travel);
			
			String value = "Total " + patternUtils.getCurrency(reservation.getTourValue().getCurrency()) + " "  
					+ reservation.getTourValue().getAmount() + " \n " 
					+ "NIF " + reservation.getTourValue().getTaxPercentage() + "%";
			mappedReservation.setValue(value);
			
			String extra = "Gorjeta " + patternUtils.getCurrency(reservation.getTourValue().getCurrency()) + " " 
					+ reservation.getTourValue().getTip() + " \n "
					+ "Portagem " + patternUtils.getCurrency(reservation.getTourValue().getCurrency()) + " "
					+ reservation.getTourValue().getTip();
			mappedReservation.setExtra(extra);
			
			String service = reservation.getHailingType() + "/" + reservation.getSubFleetTypeLabel();
			mappedReservation.setService(service);
			
			mappedReservation.setPaymentMethods(reservation.getPaymentMethod());
			
			list.add(mappedReservation);
		});
		
		ReservationHistoryData response = new ReservationHistoryData();
		response.setReservationHistoryData(list);
		
		return response;
		
	}

}
