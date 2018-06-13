package com.expotek.confidencetreev1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.expotek.utils.Utils;

//Beginnings of the confidence algorithm
//TODO - need to automate creation of data directory.

public class ConfidenceTree {

	private static ConfidenceNode root;
	private static ConfidenceTreeStorageManager cTSM;
	private static boolean successfullyFinishedAction;
	private static Scanner scanner;

	public static void main(String[] args){
		
		scanner = new Scanner(System.in);
		String dataDir = Conf.get("data_dir");
		
		//Data dir check. No reason to move forward or even fail gracefully if data dir is not present.
		if (dataDir == null){
			System.out.println("No data dir homie.");
			System.exit(1);
		}

		cTSM = new ConfidenceTreeStorageManager(dataDir);

		if (args == null || args.length < 1) {
			System.out.println("Must include arguments");
		} else if (args[0].toLowerCase().trim().matches("help")) {
			System.out.println("Need to add help here");
		} else if (args[0].toLowerCase().trim().matches("cn")) {
			successfullyFinishedAction = createNewTree(args[1], dataDir);
		} else if (args[0].toLowerCase().trim().matches("uo")) {
			successfullyFinishedAction = useStoredTree(args, dataDir);
		} else { System.out.println("We didn't really do anything here."); } 
		System.out.println("Finished action? " + successfullyFinishedAction);
	}

	public static boolean createNewTree(String value, String dataDir) {
		root = new ConfidenceNode(value);
		//TODO review passing root on next line
		return cTSM.storeRoot(value);
	}

	public static boolean useStoredTree(String[] args, String dataDir) {
		if (args.length < 2) {//only "uo" argument supplied
			HashMap<String,String> roots = provideTreeList(dataDir + "roots.data");
			System.out.println("Select root by typing it exactly as seen above: ");
			String selection = scanner.next();
			if (roots.containsKey(selection)) {
				populateRoot(selection);
			} else {
				//TRY AGAIN OR ADD NEW
			}
		} else { 
			if (cTSM.treeExists(args[1])) {
				populateRoot(args[1]);		
			} else {//no tree exists with that root
				System.out.println("Tree root does not exist.. try planting one of these");
				provideTreeList(dataDir + "roots.data");
			}
		}
		return false;
	}

	public static HashMap<String,String> provideTreeList(String file) {
		HashMap<String,String> roots = Utils.fileListToHashMap(file); 
		Iterator it = roots.entrySet().iterator();
    		while (it.hasNext()) {
        		Map.Entry pair = (Map.Entry)it.next();
        		it.remove(); // avoids a ConcurrentModificationExceptiond
			System.out.println("Root - " + pair.getKey());
		}
		return roots;
	}

	private static void populateRoot(String value) {
	//	root = cTSM.populateRootInMem(value);
	}



// TO START A value picks a random starting point?
// th

//	READ THIS CRAIG

	//Every node has a confidence value with it's connections to each node.
	//
	//Each sub node also contains these data points. How do we represent this?
	//Subnode : Confidence Value : Count (times the connection is SUCCESSFULLY USED)
	//there needs to be a positive feedback that increases this count or decrementsa it
	//
	//How to represent this in memory but also on disk in a long term storage format.


	//Today we are building this with a binary tree system. TODO add more dynamic capability
	//with different sub logic structrue. Ie.. each subtree is a linked list .. more of a graph
	//construction. 
	//
	//Think about doing a depth-first search based on confidence value but also a breath search
	//after that upon failure. Each success strengthens a path and each failure weakens a path
	//
	//This path seems to be a one way path from a root. Maybe think about how paths can be 
	//bidirectional
	//
	//How to NEW VALUE connect to the tree.
	//
	//Think about how to better represent this than in java. For example each pairing is a java class
	//which is fine but could likely be lighter in memory if stored otherwise.
	//
	//Do both nodes look at each and agree to disconnect or only one node .. this has to do with the one way flow logic
	//etc.
}
