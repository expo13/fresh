package com.expotek.confidencetreev1;

public class ConfidenceQueueNode {
	
	private ConfidenceQueueNode next;
	private ConfidenceNode root;

	public ConfidenceQueueNode(ConfidenceNode root) {
		this.root=root;
	}

	public ConfidenceQueueNode remove(){
		if (root.getLeft()!=null){
			add(root.getLeft());
		}
		if (root.getRight()!=null){
			add(root.getRight());
		};
		return next;
	}

	public ConfidenceQueueNode getNext(){
		return next;
	}

	public void add(ConfidenceNode node){
		if (node==null){
			System.out.println("ConfidenceQueueNode: addition node is null. Probably ok.");
		}
		if (this.next == null) {
			next = new ConfidenceQueueNode(node)
		}
		next.add(node);
	}

	public boolean hasNext(){
		return next != null;
	}
}
