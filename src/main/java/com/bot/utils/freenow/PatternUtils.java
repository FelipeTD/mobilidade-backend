package com.bot.utils.freenow;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component
public class PatternUtils {
	
	public String longToFixed(Long data) {
		double km = data.doubleValue() / 1000;		
		BigDecimal bd = new BigDecimal(km).setScale(2, RoundingMode.HALF_EVEN);
		return String.valueOf(bd);
	}
	
	public String getCurrency(String data) {
		if (data.equals("EUR")) {
			return "€";
		} else {
			return "R$";
		}
	}

}
