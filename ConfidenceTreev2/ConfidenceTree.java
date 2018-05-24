//Beginnings of the confidence algorithm


public class ConfidenceTree {

	ConfidenceNode root;


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
