package com.wellsfargo.scd.service;

public class GreetServiceImpl  implements GreetService{

	public String doGreet(String username) {
		
		return "Hello " + username;
	}

}
