package com.expotek.confidencetreev1;

import com.expotek.datastructures.SimpleStack;

public class FindInTree {

	private ConfidenceStack confidenceStack;

	public FindInTree() {
		confidenceStack = new ConfidenceStack();
	}

	//depth first search combined with horizontal search 
	public ConfidenceNode findNode(String value, ConfidenceNode node){
		
		//TODO review this initial check
		if (node == null || value == null){
			//da fuck
		}

		if (isNode(value, node)) { return node;} //found a match!Replace with search map

		if (node.getLeft() != null) { //add left nodes to stack
			confidenceStack.push(new ConfidenceStackNode(node.getLeft()));
		}
		if (node.getRight() != null) {//continue diving down the right path
			return findNode(value, node.getRight());
		}
		if (node.getRight() == null && !confidenceStack.isEmpty()) {//we've reach a leaf
			ConfidenceStackNode confidenceStackNode = (ConfidenceStackNode) confidenceStack.pop();
			return findNode(value, confidenceStackNode.getConfidenceNode());
		}	
		return null;
	}


	public boolean isNode(String input, ConfidenceNode node){
		return input.matches(node.getValue());
	}

	//TODO this will be more complex
	public String searchNodeMap(ConfidenceNode node){
		return null;	
	}

}
