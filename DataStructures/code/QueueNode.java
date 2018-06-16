package com.expotek.confidencetreev1;

public class QueueNode extends Node {

	private QueueNode next;

	public QueueNode getNext(){
		return next;
	}

	protected boolean add(QueueNode node){
		if (next==null) {
			next = node;
			return true;
		}
		return next.add(node);
	}
}
