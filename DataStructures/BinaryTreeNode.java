package com.expotek.datastructures;

public class BinaryTreeNode extends Node {

	private BinaryTreeNode left;
	private BinaryTreeNode right;

	protected void setRight (BinaryTreeNode node) {
		if (node==null) { System.out.println("BinaryTreeNode|WARN|trying to set null as right node"); }
		right=node;
	}

	protected void setLeft (BinaryTreeNode node) {
		if (node==null) { System.out.println("BinaryTreeNode|WARN|trying to set null as left node"); }
		left=node;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

}
