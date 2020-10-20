package com.wells.service;

import java.util.LinkedList;
import java.util.List;

public class JobHandlingService {
	private int capacity;
	private int jobCount;
	private List<Integer> jobList;
	
	public JobHandlingService(int capacity, int jobCount) {
		super();
		this.capacity = capacity;
		this.jobCount = jobCount;
		this.jobList = new LinkedList<>();
	}
	
	public void produceJobs() throws InterruptedException {
		for(int i=1;i<=jobCount;i++) {
			synchronized (this) {
				while (jobList.size()==capacity) {
					wait();
				}
				jobList.add(i);
				System.out.println("Produce a job# " +i);
				notify();
				
				Thread.sleep(1000);
				
			}
		}
		
	}
	
	public void consumeJobs() throws InterruptedException {
		for(int i=1;i<=jobCount;i++) {
			synchronized (this) {
				while (jobList.isEmpty()) {
					wait();
				}
				int jobId=jobList.remove(0);
				System.out.println("Consume a job# " +jobId);
				notify();
				
				Thread.sleep(1000);
				
			}
		}
		
	}
	
	

}
