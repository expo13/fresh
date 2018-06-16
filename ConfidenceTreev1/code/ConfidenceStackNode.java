package com.expotek.confidencetreev1;

import com.expotek.datastructures.StackNode;

public class ConfidenceStackNode extends StackNode {

	private ConfidenceNode confidenceNode;

	//This class does not need a value for the super in that it's only referencing a node in
	//in the confidence tree. 
	public ConfidenceStackNode(ConfidenceNode node) {
		super(null);
		confidenceNode = node;
	}

	public ConfidenceNode getConfidenceNode() {
		return confidenceNode;
	}
}
