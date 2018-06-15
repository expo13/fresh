package com.expotek.datastructures;

import java.util.Optional;

public class Node {
	
	private Optional<Object> value;

	public Node(Object value){
		this.value = Optional.of(value);
	}

	public Object getValue(){
		if (value.isPresent()){
			return value.get();
		}
		return null;
	}

	public Optional<Object> getOptionalValue() {
		return value;
	}
}
