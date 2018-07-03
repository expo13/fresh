package com.expotek.confidencetreev1;

public class ConfidenceQueueNode {
	
	private ConfidenceQueueNode next;
	private ConfidenceNode childNode;

	public ConfidenceQueueNode(ConfidenceNode childNode) {
		this.childNode=childNode;
	}

	protected ConfidenceQueueNode remove(){
		if (childNode.getLeft()!=null){
			add(childNode.getLeft());
		}
		if (childNode.getRight()!=null){
			add(childNode.getRight());
		};
		return next;
	}

	public ConfidenceQueueNode getNext(){
		return next;
	}

	protected void add(ConfidenceNode node){
		if (node==null){
			System.out.println("ConfidenceQueueNode: addition node is null. Probably ok.");
		}
		if (this.next == null) {
			next = new ConfidenceQueueNode(node);
		}
		next.add(node);
	}

	public boolean hasNext(){
		return next != null;
	}

	public String getChildValue(){
		return childNode.getValue();
	}

	public ConfidenceNode getChildNode() {
		return this.childNode;
	}
}
