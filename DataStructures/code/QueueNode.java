package com.expotek.datastructures;

import com.expotek.datastructures.Node;

public class QueueNode extends Node {

	private QueueNode next;

	public QueueNode(Object value) {
       		super(value);
	}

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
