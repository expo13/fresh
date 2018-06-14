package com.expotek.confidencetreev1;

public class FindInTree {

	private ConfidenceStack confidenceStack;

	//depth first search combined with horizontal search 
	public String findNode(String value, ConfidenceNode node){
		
		if (node == null || value == null){
			//da fuck
		}

		if (node.right == null) {//we've reached a leaf somewhere
			node = node.parent;
			return findNode(value, node.left);
		}
		if (node.left == null) {
		
		}

		if (searchNodeMap(node) == null) {
			if (node.right !=null) {
				return findNode(value,node.right);
			}
		}


	}

	public String searchNodeMap(ConfidenceNode node){
	
	}

}
