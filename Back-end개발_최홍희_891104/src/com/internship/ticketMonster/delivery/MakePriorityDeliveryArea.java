package com.internship.ticketMonster.delivery;

import java.util.TreeMap;

public class MakePriorityDeliveryArea {
	private int [][] leadTimePerLocal;
	
	public MakePriorityDeliveryArea(int [][] leadTimePerLocal) {
		this.leadTimePerLocal = leadTimePerLocal;
	}
	
	public TreeMap<Integer, String> makePriorty(int local) {
		
		TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>();
		
		for(int i = 0 ; i < (int)leadTimePerLocal.length; i++) 
			sortedMap.put(Integer.valueOf(leadTimePerLocal[i][local]), String.valueOf((char)(i+'A')));
		
		return sortedMap;
	}
}
