package com.expotek.datastructures;

public class SimpleQueue {
	
	private QueueNode head;

	public Object peek() {
		return head==null ? head.getValue() : null;
	}

	protected Object remove(){
		if (head == null) { System.out.println("SimpleQueue|WARN|Something happened here and QueueNode head is null"); }
		Object value = head.getValue();
		this.head = head.getNext();
		return value;
	}

	protected boolean add(QueueNode node) {
		if (node == null){ System.out.println("SimpleQueue|WARN|Trying to add null node to ConfidenceQueue"); }
		return head.add(node);
	}
}
