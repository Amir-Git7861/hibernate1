package com.wells.ui;

import com.wells.model.Flight;
import com.wells.service.ReservationService;

public class ReservationApp2 {

	public static void main(String[] args) {
		Flight f1=new Flight(25);
		
		
		ReservationService rs1=new ReservationService(f1, 10);
		ReservationService rs2=new ReservationService(f1,10);
		ReservationService rs3=new ReservationService(f1,10);
		
		Thread t1=new Thread(rs1);
		Thread t2=new Thread(rs2);
		Thread t3=new Thread(rs3);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();   //main should wait until t1 is complete
			t2.join();     //main should wait until t2 is complete
			t3.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Jobs done");
	
	}

}
