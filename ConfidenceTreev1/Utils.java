package com.expotek.utils;

public class Utils {

	public String getParsedColonValue(String input){
		if (input == null) {
			return null;
		}
		return input.subString(input.indexOf(":"),input.length());
	}

	public String getParsedColonKey(String input){	
		if (input == null) {
			return null;
		}
		return intput.subString(0,indexOf(":"));
	}

}
