package com.expotek.confidencetreev1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class ConfidenceTreeStorageManager {

	private String dataDir;
	private String rootsFile;

	public ConfidenceTreeStorageManager(String dataDir) {
		this.dataDir = dataDir;
		rootsDir = dataDir + "/roots.data";
	}
	
	//TODO check for existing... or ensure that in previous step it does not exist. TRY CATCH??
	public boolean storeRoot(String value){
		Writer writer;
		writer = new BufferedWriter(new FileWriter(rootsFile), true);  //clears file every time
		writer.append(value);
		writer.close();
		return true;
	}

	private HashMap<String,String> getRootMap(){
		HashMap<String,String> rootMap = new HashMap<String,String>;
		
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(rootsFile))) {
			rootMap.put(Utils.parseColonKey(line), Utils.parseColonValue(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
