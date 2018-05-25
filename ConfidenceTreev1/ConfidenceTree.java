//Beginnings of the confidence algorithm



//TODO - need to automate creation of data directory.

public class ConfidenceTree {

	private static ConfidenceNode root;
	private static ConfidenceTreeStorageManager cTSM;
	private static boolean successfullyFinishedAction;
	private Scanner scanner;

	public static void main(String[] args){
		
		scanner = new Scanner(System.in);
		cTSM = new ConfidenceTreeStorageManager();
		
		//Data dir check. No reason to move forward or even fail gracefully if data dir is not present.
		String dataDir = CONF.get("data_dir");
		if (dataDir == null){
			System.out.println("No data dir homie.");
			exit(1);
		}

		if (args == null || args.length() < 1) {
			System.out.println("Must include arguments");
		} else if (args[0].lowercase().trim().matches("help")) {
			System.out.println("Need to add help here");
		} else if (args[0].lowercase().trim().matches("cn") {
			successfullyFinishedAction = createNewTree(args[0], dataDir);
		} else if (args[0].lowercase().trim().matches("uo") {
			successfullyFinishedAction = userStoredStree();
		}
		System.out.println("Finished action? " + successfullyFinishedAction);
	}

	public boolean createNewTree(String value, String dataDir) {
		root = new ConfidenceNode(value);
		return cTSM.storeRoot(root);
	}

	public boolean useStoredTree(String[] args, String dataDir) {
		if (args.length() < 2) {
			HashMap<String> roots = provideTreeList();
			System.out.println("Select root by typing it exactly as seen above: ");
			String selection = scanner.next();
			if (roots.containsKey(selection){
				populateRoot(selection);
			} else {
				//TRY AGAIN OR ADD NEW
			}
			
		} else {
			if (cSTM.treeExists(args[1]){
				populateRoot(args[1])		
			} else {
				System.out.println("Tree root does not exist.. try planting one of these");
				provideTreeList();
			}
		}
	}

	public HashMap<String> provideTreeList() {
		HashMap<String> roots = cSTM.getAllTreeRoots();
		Iterator it = roots.entrySet().iterator();
    		while (it.hasNext()) {
        		Map.Entry pair = (Map.Entry)it.next();
        		it.remove(); // avoids a ConcurrentModificationExceptiond
			System.out.println("Root - " + pair.getKey());
		}
		return roots;
	}

	private void populateRoot(String value){
		root = cSTM.populateRootInMem(value);
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
