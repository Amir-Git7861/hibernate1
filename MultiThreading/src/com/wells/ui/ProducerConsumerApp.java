package com.wells.ui;

import com.wells.service.ConsumerThread;
import com.wells.service.JobHandlingService;
import com.wells.service.ProducerThread;

public class ProducerConsumerApp {

	public static void main(String[] args) {
		
		JobHandlingService jhs=new JobHandlingService(5, 10);
		
		ProducerThread pt=new ProducerThread(jhs);
		ConsumerThread ct=new ConsumerThread(jhs);
		
		pt.start();
		ct.start();

	}

}
