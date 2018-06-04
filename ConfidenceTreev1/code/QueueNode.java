package com.expotek.utils;

/**
 * 
 **/
public class ConfidenceQueueNode {

	private QueueNode next;

	private String value;

	public ConfidenceQueueNode(String value) {
		this.value=value;
	}

	private boolean add(QueueNode addition) {
		if (addition == null) {
			System.out.println("QueueNode: addition is null. FUCK THAT NOISE");
			return false;
		}
		if (next==null){
			next=addition;
			return true;
		}
		return next.add(addition);
	}

	public String getValue(){
		return this.value;
	}
}
