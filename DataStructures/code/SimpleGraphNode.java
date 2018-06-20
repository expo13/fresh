package com.expotek.datastructures;

import java.util.List;

import com.expotek.datastructures.Node;

public class SimpleGraphNode extends Node {

	public SimpleGraphNode (Object value){
		super(value);
	}	
	//use Collection? use List? use Iterable?	
	//default is list but can use a variety of ds's to reprsent local nodes
	private List<SimpleGraphNode> simpleGraphNode;


}
