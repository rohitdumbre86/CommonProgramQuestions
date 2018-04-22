package com.datastructures.bintree;

public class BinaryTree {
	private int value;
	private BinaryTree left;
	private BinaryTree right;
	
	public BinaryTree(int value) {
	   this.value = value;
	   this.left = null;
	   this.right = null;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public BinaryTree getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}

}
