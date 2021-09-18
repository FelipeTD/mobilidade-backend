package com.bot.utils.freenow;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class DateUtils {
	
	public String formatDateAndHourFreeNow(String data) {
		
		String[] dateAndHour = data.split("T");
		String[] dateValues = dateAndHour[0].split("-");
		Integer year = Integer.parseInt(dateValues[0]);
		Integer month = Integer.parseInt(dateValues[1]) - 1;
		Integer day = Integer.parseInt(dateValues[2]);
		
		String[] timeValues = dateAndHour[1].split(Pattern.quote("."));
		String timeValuesWithoutMiliseconds = timeValues[0];
		String[] values = timeValuesWithoutMiliseconds.split(":");
		Integer hour = Integer.parseInt(values[0]);
		Integer minutes = Integer.parseInt(values[1]);
		Integer seconds = Integer.parseInt(values[2]);
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day, hour, minutes, seconds);
		calendar.add(Calendar.HOUR_OF_DAY, 1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String formattedDate = sdf.format(calendar.getTime());
		
		return formattedDate;
		
	}

	public String convertInMinutes(Long data) {
		long minutes = (data / 1000)  / 60;
		int seconds = (int)((data / 1000) % 60);		
		String formattedSeconds = "";
		if (seconds < 10) {
			formattedSeconds = "0" + seconds;
		} else {
			formattedSeconds = String.valueOf(seconds);
		}
		return minutes + ":" + formattedSeconds + " min";
	}
	
}
