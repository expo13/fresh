package com.expotek.confidencetreev1;

public class SimpleQueue {
	
	private QueueNode head;

	public String remove(){
		if (head == null) {
			System.out.println("Something happened here and QueueNode head is null");
		}
		String value = head.getValue();
		this.head = head.getNext();
		return value;
	}

	public boolean add(QueueNode node) {
		if (node == null){
			System.out.println("Trying to add null node to ConfidenceQueue");
		}
		return head.add(node);
	}
}
