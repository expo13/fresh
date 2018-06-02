package com.expotek.confidencetreev1;

import com.expotek.confidencetreev1.ConfidencePairing;
/**
 * This class hey!
 *
 * TODOS: this class likley doesn't need the confidence pairing parent. Each node should just carry the confidence pairing for its children.
 *
 **/
public class ConfidenceConfidenceNode {

	//ArrayList. Binary Tree. LinkedList. HashTable?
	//String value could one day be an object of any type
	
	private final String value;

	private ConfidenceConfidenceNode right;
	private ConfidenceConfidenceNode left;
	private ConfidenceConfidenceNode parent;

	private ConfidencePairing confidenceRight;
	private ConfidencePairing confidenceLeft;
	private ConfidencePairing confidenceParent;
	
	private ConfidenceHashTable associatedValues;
	
	public ConfidenceConfidenceNode(String value) {
		cTree = new cTree();
		cTree.root = this;
		this.value=value;
	}

	public void setRightChildConfidenceNode(ConfidenceNode node) {
		this.right=node;
	}

	public void setLeftChildConfidenceNode(ConfidenceNode node) {
		this.left=node;
	}

	public void setParentConfidenceNode(ConfidenceNode node) {
		this.parent=node;
	}

	public void setConfidencePairingLeft(ConfidencePairing left) { 
		if (confidenceLeft == null) {		
			this.confidenceLeft = left;
			this.left.setConfidencePairingParent = left;
			return;
		}
		//DO ALGORITHM
	} 

	public void setConfidencePairingRight(ConfidencePairing right) {
		if (confidenceRight == null){
			this.confidenceRight = right;
			this.right.setCondiencePairingParent = right;
		}
	}

	public void setConfidencePairingParent(ConfidncePairing parent) {
		if (confidenceParent == null) {	
			this.confidenceParent = parent;
			if (this == this.parent.right){
				this.parent.setConfidencePairingRight = parent;
			}
			else if (this == this.parent.left){
				this.parenht.setConfidencePairingLeft = parent;
			
			}
		}

	}
}
