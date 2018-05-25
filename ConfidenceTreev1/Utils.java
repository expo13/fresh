package com.expotek.utils;

import java.lang.*;

public class Utils {

	public String getParsedColonValue(String input){
		if (input == null) {
			return null;
		}
		return input.substring(input.indexOf(":"),input.length());
	}

public String getParsedColonKey(String input){	
		if (input == null) {
			return null;
		}
		return input.substring(0,input.indexOf(":"));
	}

}
