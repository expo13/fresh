package com.expotek.confidencetreev1;

import java.util.*;
import java.lang.*;
import com.expotek.confidencetreev1.ConfidenceLinkedList;

public class ConfidenceHashTable{

	private ConfidenceLinkedList[] linkedList;

	public ConfidenceHashTable() {
		linkedList = new ConfidenceLinkedList[10];	
	}

	public String hashValue(String value) { 
		//hashed function
		String hashedValue;
		return null;
	}

	public boolean isPresent(String value) {
		String hashedValue = hashValue(value);
		int position = getArrayPosition(hashedValue);
		return searchArrayPosition(hashedValue, position);
	}

	private int getArrayPosition(String hashedValue) {
		//return position;
		return 0;
	}

	private boolean searchArrayPosition(String hashedValue, int position) {
		return false;
		//	return linkedList[position].searchHashedValue(unhashHashedValue(hashedValue)) != null;
	}

	private String unhashHashedValue(String hashedValue){
		//dehash function
		//return value;
		return null;
	}

}
