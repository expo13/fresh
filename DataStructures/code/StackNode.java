package com.expotek.datastructures;

import com.expotek.datastructures.Node;

public class StackNode extends Node {

	private StackNode next;
	
	public StackNode(Object value) {
		super(value);
	}

	public StackNode getNext(){
		return next == null ? next : null;
	}

	protected void setNext(StackNode node){
		if (node==null) { System.out.println("StackNode: trying to set null as next"); }
		this.next=node;
	}

}
