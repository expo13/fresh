

public class ConfidenceNode {

	//ArrayList. Binary Tree. LinkedList. HashTable?
	//String value could one day be an object of any type
	
	private final String value;
	private final ConfidenceTree cTree;
	
	private ConfidenceNode right;
	private ConfidenceNode left;
	private ConfidenceNode parent;

	private ConfidencePairing confidenceRight;
	private ConfidencePairing confidenceLeft;
	private ConfidencePairing confidenceParent;
	
	public ConfidenceNode(String value) {
		cTree = new cTree();
		cTree.root = this;
	}

}
