package com.bot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bot.entity.freenow.gains.GainsData;
import com.bot.entity.freenow.gains.GainsResponse;
import com.bot.entity.freenow.gains.Ranges;
import com.bot.entity.freenow.gains.RangesResponse;
import com.bot.entity.freenow.historyReservation.ReservationHistoryResponse;
import com.bot.freenow.mapper.GainsDatesMapper;
import com.bot.freenow.mapper.GainsMapper;
import com.bot.freenow.mapper.HistoryReservationMapper;
import com.bot.entity.freenow.historyReservation.ReservationHistoryData;
import com.bot.repository.FreeNowRepository;

@RestController
public class FreeNowService {
	
	@Autowired
	private FreeNowRepository repository;
	
	@Autowired
	private HistoryReservationMapper mapper;
	
	@Autowired
	private GainsDatesMapper gainsDatesMapper;
	
	@Autowired 
	private GainsMapper gainsMapper;
	
	@GetMapping("/freenow/reservas")
	public ReservationHistoryData reservas(@RequestParam("dataInicio") String dataInicio, 
			@RequestParam("dataFim") String dataFim) {
		
		Integer page = 0;
		
		ReservationHistoryResponse siteResponse = repository.getReservationHistory(dataInicio, dataFim, page);
		
		Integer max = 100;
		
		if (siteResponse.getTotalCount() > max) {
			while (siteResponse.getTotalCount() > max) {
				page++;
				ReservationHistoryResponse siteWhile = repository.getReservationHistory(dataInicio, dataFim, page);
				siteResponse.getBookingRecordList().addAll(siteWhile.getBookingRecordList());
				max += 100;
			}
		}
		
		ReservationHistoryData response = mapper.reservationHistoryMapper(siteResponse);
		
		return response;
	}
	
	@GetMapping("/freenow/datas")
	public RangesResponse getWeekDates() {
		
		Ranges ranges = repository.getWeekDates();
		RangesResponse response = gainsDatesMapper.weekMapper(ranges);
		
		return response;
	}
	
	@GetMapping("/freenow/ganhos")
	public GainsData getGains(@RequestParam("weekCode") String weekCode) {
		
		GainsResponse siteResponse = repository.getGains(weekCode);
		
		GainsData response = gainsMapper.gainsMapper(siteResponse);
		
		return response;
		
	}

}
