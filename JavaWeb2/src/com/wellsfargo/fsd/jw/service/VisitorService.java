package com.wellsfargo.fsd.jw.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

import com.wellsfargo.fsd.jw.model.VisitorsModel;

public class VisitorService {
	
	public void  computeAge(VisitorsModel visitorModel) {
		
		Period p=Period.between(visitorModel.getDateOfBirth(), LocalDate.now());
		visitorModel.setAge(p.getYears());
		
	}
	public String getGreeting() {
		String greeting="";
		
		int h=LocalTime.now().getHour();
		
		if(h>=4  && h<=12) {
			greeting="Good Morning ";
			
		}else if(h>=12 && h<=16) {
			greeting="Good noon ";
			
		}else {
			greeting="Good Evening ";
		}
		return greeting;
		
	}

}
