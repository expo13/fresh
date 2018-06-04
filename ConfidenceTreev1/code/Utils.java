package com.expotek.utils;

import java.lang.*;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * General method tools for doing shit. 
 *
 * TODO - save files at binary?
 * TODO - split this out into a different package
 **/
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
	
	/**
	 * Creates file and parent dirs
	 **/
	public static File createFile(String fileName){
		File file = new File(fileName).mkdirs();
		return file;
	}

	/**
	 * Writes string contents to file replace current file if it's there
	 **/
	public void writeToTextFile(String fileName, String content) throws IOException {
        	Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.CREATE);
    	}

	
	public boolean appendLineToFile (File file, String toAppend) {
      		BufferedWriter bw = null;
      		try {
         		bw = new BufferedWriter(new FileWriter(file, true));
	 		bw.write(toAppend);
	 		bw.newLine();
	 		bw.flush();
      		} catch (IOException ioe) {
	 		ioe.printStackTrace();
			return false;
      		} finally {               
			if (bw != null) try {
	    			bw.close();
				return true;
	 	} catch (IOException ioe2) {
	 		ioe2.printStackTrace();
			return false;
		}} 
   		return false;
	}	 
	
}
