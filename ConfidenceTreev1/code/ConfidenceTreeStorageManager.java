package com.expotek.confidencetreev1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.expotek.utils.*;


/**
 * This class should only be newed up once per run as it should only be tied to one rootsfile.
 **/
public class ConfidenceTreeStorageManager {

	private String dataDir;
	private String rootsFile;

	protected ConfidenceTreeStorageManager(String dataDir) {
		this.dataDir = dataDir;
		rootsFile = dataDir + "roots.data";
	}
	
	//TODO check for existing... or ensure that in previous step it does not exist. TRY CATCH?? 
	//TODO ADD to UTILS file
	//upNote: one day this will work
	protected boolean storeRoot(String value){
		System.out.println("ConfidenceTreeStorageManager: Storing root - " + value);
		if (!Utils.makeDirsFromString(dataDir)) {//does dir parent dir exist?
			return false;
		}
		if (!Utils.makeFile(rootsFile, false)) {//create file if not exists
			return false;	
		}
		try { 
			Writer writer;
			writer = new BufferedWriter(new FileWriter(rootsFile, true));  //clears file every time
			writer.append(value + "\n\r");
			writer.close();
			return storeRootMapFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	//TODO create backups of old tree maps
	protected boolean storeRootMapFile(ConfidenceNode root) {
		if (Utils.createFile(dataDir+"/"+root.getValue()+".data")==null) {
			return false;
		}

				
		//store file with root name
		//then store file with root name map hashed by modulus
	}

	protected boolean treeExists(String s){
		return false;
	}

	protected ConfidenceNode populateRootInMem(String value){
		ConfidenceNode root = new ConfidenceNode(value);
		List<String> nodesList = Utils.fileListToArrayList(dataDir+rootsFile+"/"+value); //create map of 'index' to node from stream
		Map<String, ConfidenceNode> nodeMap = nodesList.stream().collect(Collectors.toMap(string -> Utils.getParsedColonKey(string), string -> new ConfidenceNode(lookupValue(Utils.getParsedColonKey(string)))));
		for (String s : nodesList) {
			String key, parent, childNode;
			key = Utils.getParsedColonKey(s);
			childNode = Utils.getParsedColonValue(s);
			if (key.contains("l")) {
				parent = key.replace("l","");
				nodeMap.get(parent).setLeftChildConfidenceNode(nodeMap.get(childNode));
			} else if (key.contains("r")) {
				parent = key.replace("r","");
				nodeMap.get(parent).setRightChildConfidenceNode(nodeMap.get(childNode));
			}
		}
		return root;
	}

	/**
	 * Takes the second half of the parsed line - an int value - and maps it to it's value in the db files.
	 **/
	protected String lookupValue(String key) {
		String dataFile = String.valueOf(Integer.parseInt(key)%20);	
		//basically a linked list in the file now. Possibly streamify this, but for now it's old school.
		try (BufferedReader br = new BufferedReader(new FileReader(dataFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (Utils.getParsedColonKey(line).matches(key)) {
					return Utils.getParsedColonValue(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("lookupValue: WOMP womp...");
		return null;
	}

	protected ConfidenceNode getNextInDBFile() {
		//get next line then get value from hash
		int nodeNumber;
		char direction;
		String value;
		return null;
	}

	//TODO Review this method to ensure it's doing what we want it to do.
	private HashMap<String,String> getRootMap(){
		HashMap<String,String> rootMap = new HashMap<String,String>();		
		//read file into stream, try-with-resources
		String line;
    		
		try {
		BufferedReader reader = new BufferedReader(new FileReader(rootsFile));
    		while ((line = reader.readLine()) != null) {
        		String[] parts = line.split(":", 2);
        		if (parts.length >= 2) {
            			String key = parts[0];
            			String value = parts[1];
            			rootMap.put(key, value);
        		} else {
            			System.out.println("ignoring line: " + line);
        		}
    		}
		} catch (IOException e) {

			e.printStackTrace();

		}	
		return rootMap;
	}

	protected void saveTreeToDisk(Optional<ConfidenceNode> root) {
		if (root==null) {
			System.out.println("Root is null! Ain't nothing to save.");
			return;
		}

		File f = Utils.createFile(dataDir + "roots/" + root.get().getValue());	
		ConfidenceQueueNode cQN = new ConfidenceQueueNode(root.get());
		int nodeCount=1;
		while (cQN.hasNext()){ //this loop populates and depopulates the queue! 
			String nodeValue = cQN.getChildValue();
			ConfidenceNode confidenceNode = cQN.getChildNode();
			if (confidenceNode.getLeft()!=null) {
					 	
			}
			if (confidenceNode.getRight()!=null) {
				
			}
			cQN = cQN.remove();
			nodeCount++;
		}
	}
}
