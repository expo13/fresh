package com.expotek.confidencetreev1;

import com.expotek.confidencetreev1.ConfidencePairing;
/**
 *
 * TODOS: this class likley doesn't need the confidence pairing parent. Each node should just carry the confidence pairing for its children.
 *
 **/
public class ConfidenceNode {

	//ArrayList. Binary Tree. LinkedList. HashTable?
	//String value could one day be an object of any type
	
	private final String value;

	private ConfidenceNode right;
	private ConfidenceNode left;
	private ConfidenceNode parent;

	private ConfidencePairing confidenceRight;
	private ConfidencePairing confidenceLeft;
	private ConfidencePairing confidenceParent;

	private ConfidenceHashTable associatedValues;
	
	public ConfidenceNode(String value) {
		this.value=value;
	}

	protected void setRightChildConfidenceNode(ConfidenceNode node) {
		this.right=node;
	}

	protected void setLeftChildConfidenceNode(ConfidenceNode node) {
		this.left=node;
	}

	protected void setParentConfidenceNode(ConfidenceNode node) {
		this.parent=node;
	}

	public ConfidenceNode getLeft() {
		return left;
	}

	public ConfidenceNode getRight() {
		return right;
	}

	public ConfidenceNode getParent() {
		return parent;
	}

	protected void setConfidencePairingLeft(ConfidencePairing left) { 
		if (confidenceLeft == null) {		
			this.confidenceLeft = left;
			this.left.setConfidencePairingParent(left);
			return;
		}
		//DO ALGORITHM
	} 

	protected void setConfidencePairingRight(ConfidencePairing right) {
		if (confidenceRight == null){
			this.confidenceRight = right;
			this.right.setConfidencePairingParent(right);
		}
	}

	protected void setConfidencePairingParent(ConfidencePairing parent) {
		if (confidenceParent == null) {	
			this.confidenceParent = parent;
			if (this == this.parent.right){
				this.parent.setConfidencePairingRight(parent);
			}
			else if (this == this.parent.left){
				this.parent.setConfidencePairingLeft(parent);			
			}
		}

	}

	public String getValue(){
		return value;
	}
}
