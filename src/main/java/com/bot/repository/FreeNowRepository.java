package com.bot.repository;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bot.entity.freenow.gains.GainsResponse;
import com.bot.entity.freenow.gains.Ranges;
import com.bot.entity.freenow.historyReservation.ReservationHistoryResponse;
import com.bot.factory.ConnectionFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FreeNowRepository {
	
	@Autowired
	private ConnectionFactory connection;
	
	public ReservationHistoryResponse getReservationHistory(String dataInicio, String dataFim, Integer page) {
		
		connection.setFreeNowCookie("Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX3RpbWVfem9uZSI6IkV1cm9wZS9MaXNib24iLCJ1c2VyX3R5cGUiOiJDT01QQU5ZIiwidXNlcl9pZCI6MTQ4MzIzLCJ1c2VyX25hbWUiOiJlYXN5Y2FibHhAZ21haWwuY29tIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTYzNjMwNzMzMCwidXNlcl9kaXNwbGF5X25hbWUiOiJFQVNZQ0FCIExEQSIsImF1dGhvcml0aWVzIjpbIkNPTVBBTllfUEhWIiwiT1JJR0lOX0tBUFRFTiJdLCJqdGkiOiIyMDVjMmU4OC1mOTJmLTQzODQtOWVkNS0yNGUxMjg2NmFjYzQiLCJ1c2VyX2NvdW50cnlfY29kZSI6IlBUIiwiY2xpZW50X2lkIjoiVGRrMWhxbGkwdzY2In0.cGi0NrnoZja-00VxYYzN3wAaY7izV_O-VZ1sR7V5om7y_nNkdX5vwPdCH1-KzqQHvQ8gVfjhoNf6A6WRhgss2Q4Y83ilWaAAVLZEMsNVKKyyufqISkP2GDA09P8JM5L8_pe1ZMdaf31CV_cbojK6JXK3oOGaCbT2t9y_nCNiHjWc9XiHy04aaj2vt5JaIZnSKqtrhDE9RRbuofHkLW3lANgEo66vOh67yDP_EXAp9dcmgjgPVNoBTlGHu7WyucGHClE76xfLQstB6gt_a2c_xnbUTB3cRCfHtEA_1uVNXBjXrDCo4AAtjMbLC2x3b7ExcUx7J7pFfzxe_7EJB_8Efw");
		String cookie = connection.getFreeNowCookie();
		
		String[] splitedInitialDate = dataInicio.split("T");
		String[] splitedFinalDate = dataFim.split("T");
		String formatedInitialDate = splitedInitialDate[0];
		String formatedFinalDate = splitedFinalDate[0];
		
		String[] values = formatedFinalDate.split("-");
		Integer year = Integer.valueOf(values[0]);
		Integer month = Integer.valueOf(values[1]);
		Integer day = Integer.valueOf(values[2]);
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String calendarFinalDate = sdf.format(calendar.getTime());
		
		String urlText = "https://api.live.mytaxi.com/partnermanagementgateway/proxy/partnerbffservice/v1/companies/148323/booking-records?from=" 
		+ formatedInitialDate + "T04:00:00.000%2B01:00&page=" 
		+ page.toString() + "&size=1000&to=" + calendarFinalDate + "T03:59:59.5959%2B01:00";

		URL url = null;
		try {
			url = new URL(urlText);
		} catch (MalformedURLException e) {
			System.out.println("Erro ao formar URL");
			e.printStackTrace();
		}

		HttpURLConnection connection = null;
		
		try {
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			System.out.println("Erro ao realizar conexão");
			e.printStackTrace();
		}
		
		connection.setRequestProperty("accept", "application/json");
		connection.setRequestProperty("Authorization", cookie);

		InputStream responseStream = null;
		try {
			responseStream = connection.getInputStream();
		} catch (IOException e) {
			System.out.println("Erro ao pegar retorno");
			e.printStackTrace();
		}
		
		ReservationHistoryResponse reservationHistory = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			reservationHistory = mapper.readValue(responseStream, ReservationHistoryResponse.class);
		} catch (JsonParseException e) {
			System.out.println("Erro ao converter JSON");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.println("Erro ao mapear JSON");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro generico ao processar JSON");
			e.printStackTrace();
		}
		
		return reservationHistory;
		
	}

	public Ranges getWeekDates() {
		
		connection.setFreeNowCookie("Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX3RpbWVfem9uZSI6IkV1cm9wZS9MaXNib24iLCJ1c2VyX3R5cGUiOiJDT01QQU5ZIiwidXNlcl9pZCI6MTQ4MzIzLCJ1c2VyX25hbWUiOiJlYXN5Y2FibHhAZ21haWwuY29tIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTYzNjMwNzMzMCwidXNlcl9kaXNwbGF5X25hbWUiOiJFQVNZQ0FCIExEQSIsImF1dGhvcml0aWVzIjpbIkNPTVBBTllfUEhWIiwiT1JJR0lOX0tBUFRFTiJdLCJqdGkiOiIyMDVjMmU4OC1mOTJmLTQzODQtOWVkNS0yNGUxMjg2NmFjYzQiLCJ1c2VyX2NvdW50cnlfY29kZSI6IlBUIiwiY2xpZW50X2lkIjoiVGRrMWhxbGkwdzY2In0.cGi0NrnoZja-00VxYYzN3wAaY7izV_O-VZ1sR7V5om7y_nNkdX5vwPdCH1-KzqQHvQ8gVfjhoNf6A6WRhgss2Q4Y83ilWaAAVLZEMsNVKKyyufqISkP2GDA09P8JM5L8_pe1ZMdaf31CV_cbojK6JXK3oOGaCbT2t9y_nCNiHjWc9XiHy04aaj2vt5JaIZnSKqtrhDE9RRbuofHkLW3lANgEo66vOh67yDP_EXAp9dcmgjgPVNoBTlGHu7WyucGHClE76xfLQstB6gt_a2c_xnbUTB3cRCfHtEA_1uVNXBjXrDCo4AAtjMbLC2x3b7ExcUx7J7pFfzxe_7EJB_8Efw");
		String cookie = connection.getFreeNowCookie();
		
		String urlText = "https://api.live.mytaxi.com/partnermanagementgateway/proxy/partnerbffservice/v1/companies/148323/earnings/metadata";

		URL url = null;
		try {
			url = new URL(urlText);
		} catch (MalformedURLException e) {
			System.out.println("Erro ao formar URL");
			e.printStackTrace();
		}

		HttpURLConnection connection = null;
		
		try {
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			System.out.println("Erro ao realizar conexão");
			e.printStackTrace();
		}
		
		connection.setRequestProperty("accept", "application/json");
		connection.setRequestProperty("Authorization", cookie);

		InputStream responseStream = null;
		try {
			responseStream = connection.getInputStream();
		} catch (IOException e) {
			System.out.println("Erro ao pegar retorno");
			e.printStackTrace();
		}
		
		Ranges gainsDate = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			gainsDate = mapper.readValue(responseStream, Ranges.class);
		} catch (JsonParseException e) {
			System.out.println("Erro ao converter JSON");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.println("Erro ao mapear JSON");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro generico ao processar JSON");
			e.printStackTrace();
		}
		
		return gainsDate;
		
	}
	
	public GainsResponse getGains(String weekCode) {
		
		connection.setFreeNowCookie("Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX3RpbWVfem9uZSI6IkV1cm9wZS9MaXNib24iLCJ1c2VyX3R5cGUiOiJDT01QQU5ZIiwidXNlcl9pZCI6MTQ4MzIzLCJ1c2VyX25hbWUiOiJlYXN5Y2FibHhAZ21haWwuY29tIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImV4cCI6MTYzNjMwNzMzMCwidXNlcl9kaXNwbGF5X25hbWUiOiJFQVNZQ0FCIExEQSIsImF1dGhvcml0aWVzIjpbIkNPTVBBTllfUEhWIiwiT1JJR0lOX0tBUFRFTiJdLCJqdGkiOiIyMDVjMmU4OC1mOTJmLTQzODQtOWVkNS0yNGUxMjg2NmFjYzQiLCJ1c2VyX2NvdW50cnlfY29kZSI6IlBUIiwiY2xpZW50X2lkIjoiVGRrMWhxbGkwdzY2In0.cGi0NrnoZja-00VxYYzN3wAaY7izV_O-VZ1sR7V5om7y_nNkdX5vwPdCH1-KzqQHvQ8gVfjhoNf6A6WRhgss2Q4Y83ilWaAAVLZEMsNVKKyyufqISkP2GDA09P8JM5L8_pe1ZMdaf31CV_cbojK6JXK3oOGaCbT2t9y_nCNiHjWc9XiHy04aaj2vt5JaIZnSKqtrhDE9RRbuofHkLW3lANgEo66vOh67yDP_EXAp9dcmgjgPVNoBTlGHu7WyucGHClE76xfLQstB6gt_a2c_xnbUTB3cRCfHtEA_1uVNXBjXrDCo4AAtjMbLC2x3b7ExcUx7J7pFfzxe_7EJB_8Efw");
		String cookie = connection.getFreeNowCookie();
		
		String urlText = "https://api.live.mytaxi.com/partnermanagementgateway/proxy/partnerbffservice/v2/companies/148323/earnings?range=CLOSED%252C" 
		+ weekCode;
		
		URL url = null;
		try {
			url = new URL(urlText);
		} catch (MalformedURLException e) {
			System.out.println("Erro ao formar URL");
			e.printStackTrace();
		}

		HttpURLConnection connection = null;
		
		try {
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			System.out.println("Erro ao realizar conexão");
			e.printStackTrace();
		}
		
		connection.setRequestProperty("accept", "application/json");
		connection.setRequestProperty("Authorization", cookie);

		InputStream responseStream = null;
		try {
			responseStream = connection.getInputStream();
		} catch (IOException e) {
			System.out.println("Erro ao pegar retorno");
			e.printStackTrace();
		}
		
		GainsResponse gains = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			gains = mapper.readValue(responseStream, GainsResponse.class);
		} catch (JsonParseException e) {
			System.out.println("Erro ao converter JSON");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.println("Erro ao mapear JSON");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro generico ao processar JSON");
			e.printStackTrace();
		}
		
		return gains;
		
	}
	
}
