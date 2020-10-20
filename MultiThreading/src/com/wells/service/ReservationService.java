package com.wells.service;

import java.util.ArrayList;
import java.util.List;

import com.wells.model.Flight;


public class ReservationService implements Runnable{
	
	private Flight flight;
	private int requiredSeatCount;
	private List<Integer> seatsReserved;
	
	public ReservationService(Flight flight, int requiredSeatCount) {
		this.flight = flight;
		this.requiredSeatCount = requiredSeatCount;
		this.seatsReserved=new ArrayList<Integer>();
	}
	
	public void reserve() throws InterruptedException {
		
		Thread t=Thread.currentThread();
		String name=t.getName();
		
		
		
		
		
		if(flight.getLastReservedSeat()==flight.getSeatCount()) {
			System.out.println(name +">>Sorry ! the flight is full");
		}else if((flight.getSeatCount()-flight.getLastReservedSeat()) <requiredSeatCount){
			System.out.println(name +">>Sorry! Not Enough Seats");
			
		}else {
			synchronized (flight) {
				for(;requiredSeatCount>0;requiredSeatCount--) {
					if((flight.getSeatCount()-flight.getLastReservedSeat()) >=requiredSeatCount){
					int avilableSeat=flight.getLastReservedSeat()+1;
					seatsReserved.add(avilableSeat);
					flight.setLastReservedSeat(avilableSeat);
					System.out.println(name +">> Reserved Seat #" +avilableSeat);
					Thread.sleep(1000);
					}else {
						break;
					}
			}
				
			}
			System.out.println(name +">>" +seatsReserved);
	}
	
	

	}

	@Override
	public void run() {
		try {
			reserve();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
