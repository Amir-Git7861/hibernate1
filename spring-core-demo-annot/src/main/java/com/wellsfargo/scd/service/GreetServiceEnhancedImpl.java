package com.wellsfargo.scd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.scd.util.GreetingProvider;

@Service("gseb")

public class GreetServiceEnhancedImpl implements GreetService {
	
	@Autowired//There is a no node of constructor and setter method
	private GreetingProvider greetingProvider;

	public String doGreet(String userName) {
		
		return greetingProvider.getGreeting() + " " +userName;
	}
	
}
