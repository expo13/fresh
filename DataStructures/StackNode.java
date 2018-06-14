package com.expotek.datastructures;

public class StackNode extends Node {

	private StackNode next;

	public StackNode() {}

	public StackNode getNext(){
		return next == null : next ? null;
	}

	protected void setNext(StackNode node){
		if (node==null) { System.out.println("StackNode: trying to set null as next"); }
		this.next=node;
	}

}
