package com.bot.freenow.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bot.entity.freenow.gains.GainsResponse;
import com.bot.entity.freenow.gains.DriverEarnings;
import com.bot.entity.freenow.gains.Gain;
import com.bot.entity.freenow.gains.GainsData;

@Component
public class GainsMapper {
	
	public GainsData gainsMapper(GainsResponse gains) {
		
		List<DriverEarnings> list1 = new ArrayList<>();
		List<DriverEarnings> list2 = new ArrayList<>();
		List<DriverEarnings> list3 = new ArrayList<>();
		List<DriverEarnings> list4 = new ArrayList<>();
		
		for (int x = 0; x < gains.getDriverEarnings().size(); x++) {
			if (x < 4) {
				list1.add(gains.getDriverEarnings().get(x));
			} else if (x >= 4 && x < 8) {
				list2.add(gains.getDriverEarnings().get(x));
			} else if (x >= 8 && x < 12) {
				list3.add(gains.getDriverEarnings().get(x));
			} else {
				list4.add(gains.getDriverEarnings().get(x));
			}
		}
		
		
		Gain gainData1 = new Gain();
		gainData1.setIndex("1");
		gainData1.setDriverEarnings(list1);
		
		Gain gainData2 = new Gain();
		gainData2.setIndex("2");
		gainData2.setDriverEarnings(list2);
		
		Gain gainData3 = new Gain();
		gainData3.setIndex("3");
		gainData3.setDriverEarnings(list3);
		
		Gain gainData4 = new Gain();
		gainData4.setIndex("4");
		gainData4.setDriverEarnings(list4);
		
		List<Gain> gainsList = new ArrayList<>();
		
		if (gains.getDriverEarnings().size() < 4) {
			gainsList.add(gainData1);
		} else if (gains.getDriverEarnings().size() >= 4 && gains.getDriverEarnings().size() < 8) {
			gainsList.add(gainData1);
			gainsList.add(gainData2);
		} else if (gains.getDriverEarnings().size() >= 8 && gains.getDriverEarnings().size() < 12) {
			gainsList.add(gainData1);
			gainsList.add(gainData2);
			gainsList.add(gainData3);
		} else {
			gainsList.add(gainData1);
			gainsList.add(gainData2);
			gainsList.add(gainData3);
			gainsList.add(gainData4);
		}
		
		GainsData gainsData = new GainsData();
		gainsData.setGainsData(gainsList);
		gainsData.setCurrency(gains.getCurrency());
		gainsData.setTotals(gains.getTotals());
		
		return gainsData;
		
	}

}
