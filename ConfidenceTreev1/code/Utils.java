package com.expotek.utils;

import java.nio.file.StandardOpenOption;
import java.lang.*;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.FileWriter;

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
		File file = new File(fileName);
		file.mkdirs();
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
	
	public static boolean makeDirsFromString(String dir) {
		try {
			new File(dir).mkdirs();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean makeFile(String file, boolean overwrite) {
		try {
			File f = new File(file);
		       	if (f.exists()){
				System.out.println("Utils: File exists - " + file);
				return true;
			} else if (overwrite){
				System.out.println("Utils: Overwriting file - " + file);
				f.delete();
				return f.createNewFile();
			}
				System.out.println("Utils: Creating file - " + file);
				return f.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
