package com.wellsfargo.scd.service;

import org.springframework.stereotype.Service;

@Service("gsb")

public class GreetServiceImpl  implements GreetService{

	public String doGreet(String username) {
		
		return "Hello " + username;
	}

}
