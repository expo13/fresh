package com.expotek.confidencetreev1;

import com.expotek.datastructures.SimpleStack;

public class FindInTree {

	private SimpleStack simpleStack;

	//depth first search combined with horizontal search 
	public String findNode(String value, ConfidenceNode node){
		
		if (node == null || value == null){
			//da fuck
		}

		if (node.getRight() == null) {//we've reached a leaf somewhere
			node = node.getParent();
			return findNode(value, node.getLeft());
		}
		if (node.getLeft() == null) {
	
		}

		if (searchNodeMap(node) == null) {
			if (node.getRight() !=null) {
				return findNode(value,node.getRight());
			}
		}

		return null;
	}

	public String searchNodeMap(ConfidenceNode node){
		return null;	
	}

}
