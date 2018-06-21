package com.expotek.datastructures;

import java.util.Optional;

public class SimpleStack {

	private StackNode top;

	public Object peek() {
		return !isEmpty() ? top.getValue() : null;
	}

	public Object pop(){
		if (!isEmpty()) {
			if (top.getNext()==null){
				top = null;
				return top;
			}
			StackNode temp = top;
			top = top.getNext();
			return temp;		
		}
		return null;
	}

	public boolean isEmpty(){
		return top == null;
	}

	public Object search(Object o){
		//TODO
		return null;
	}

	public StackNode push(StackNode stackNode){
		stackNode.setNext(top);
		top=stackNode;
		return stackNode;
	}

}
