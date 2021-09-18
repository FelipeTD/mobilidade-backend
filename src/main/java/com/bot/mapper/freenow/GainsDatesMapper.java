package com.bot.mapper.freenow;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bot.entity.freenow.gains.Ranges;
import com.bot.entity.freenow.gains.RangeResponse;
import com.bot.entity.freenow.gains.RangesResponse;

@Component
public class GainsDatesMapper {
	
	public RangesResponse weekMapper(Ranges ranges) {
		
		RangesResponse listResponse = new RangesResponse();
		List<RangeResponse> listRanges = new ArrayList<>();
		
		ranges.getRanges().forEach(range -> {
			RangeResponse response = new RangeResponse();
			
			String[] weekCode = range.getKey().split(",");
			
			response.setWeekCode(weekCode[1]);
			
			String[] initialValue = range.getStartDate().split("T");
			String[] values = initialValue[0].split("-");
			String initialDate = values[2] + "/" + values[1] + "/" + values[0];
			String[] finalValue = range.getEndDate().split("T");
			String[] finalValues = finalValue[0].split("-");
			String finalDate = finalValues[2] + "/" + finalValues[1] + "/" + finalValues[0];;
			String description = "Desde " + initialDate + " até " + finalDate;
			response.setDescription(description);
			
			listRanges.add(response);
		});
		
		listResponse.setResponseRanges(listRanges);
		
		Calendar calendar = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		String formattedDate = sdf.format(calendar.getTime());
		listResponse.setRequestDate(formattedDate);
		
		return listResponse;
	}

}
