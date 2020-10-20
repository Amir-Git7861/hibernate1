package com.wellsfargo.fsd.td.service;

import java.util.ArrayList;
import java.util.List;

public class NumericOperations {
	
	public boolean isOdd(int number) {
		return number%2==1 || number%2==-1;
		
	}
	
	public int max(int n1,int n2) {
		return n1>=n2?n1:n2;
		
	}
	
	public List<Integer> getFactors(int number){
		List<Integer> factors=new ArrayList<Integer>();
		
		factors.add(1);
		for(int i=2;i<=number/2;i++) {
			if(number%i==2) {
				factors.add(i);
			}
		}
		
	return factors;

	}
	
}
