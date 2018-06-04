package com.expotek.confidencetreev1;

public class QueueNode {

	private String value;
	
	public QueueNode next;

	public String getValue(){
		return value;
	}

	public QueueNode getNext(){
		return next;
	}

	public boolean add(QueueNode node){
		return false;
	}
}
