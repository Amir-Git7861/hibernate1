package com.wells.service;

import java.time.LocalTime;

public class WelcomeApp {

	public static void main(String[] args) {
		WelcomeService ws1=new WelcomeServiceImpl(); 			
		System.out.println(ws1.welcome(" Amir") );
		
		WelcomeService ws2=new WelcomeService() {
			
			@Override
			public String welcome(String username) {
				// TODO Auto-generated method stub
				return "Sohel " + username;
			}
		};
		System.out.println(ws2.welcome(" Amir"));
		
		WelcomeService ws3= (unm) -> "Please coome " + unm;//LAMDA EXPRESSION CAN BE IMPLEMENT FOR SINGLE METHOD
		System.out.println(ws3.welcome(" Amir"));
		
		WelcomeService ws4= (unm)->{  
			int h=LocalTime.now().getHour();
			
			String greet="";
			
			if(h>=4 && h<=11) greet= "Good morning ";
			else if(h>=11 && h<=16) greet="good noon";
			else greet="good evening ";
			
			return greet + unm;
		};
		System.out.println(ws4.welcome("Amir"));
		
		
			}
		}

	


