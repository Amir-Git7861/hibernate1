package com.wellsfargo.scd.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.wellsfargo.scd.conf.MyConf;
import com.wellsfargo.scd.service.GreetService;

public class GreetApp1 {

	public static void main(String[] args) {

		ApplicationContext context=new AnnotationConfigApplicationContext(MyConf.class);
		
		GreetService gs=(GreetService) context.getBean("gsb");
		System.out.println(gs.doGreet("Amir"));
		

		GreetService gsa=(GreetService) context.getBean("gsab");
		System.out.println(gsa.doGreet("Amir"));
		
		GreetService gse=(GreetService) context.getBean("gseb");
		System.out.println(gse.doGreet("Amir"));
		
	
		System.out.println(context.getBean("today"));

	}

}
