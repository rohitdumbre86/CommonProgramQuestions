package com.datastructures.bintree;

import com.datastructures.stack.Stack;

/**
 * Performs traversing of binary tree.
 * 
 * @author rdumb
 *
 */
public class Traversing {

	private static void iterativeInorder(BinaryTree root, int n) throws Exception {

		if (root == null)
			return;

		Stack<BinaryTree> stack = new Stack<BinaryTree>(n);

		BinaryTree temp = root;

		while (temp != null) {
			stack.push(temp);
			temp = temp.getLeft();
		}

		while (!stack.isEmpty()) {
			final BinaryTree inOrder = stack.pop();
			System.out.print(" " + inOrder.getValue());

			BinaryTree right = inOrder.getRight();
			while (right != null) {
				stack.push(right);
				right = right.getLeft();
			}

		}

	}

	private static void iterativePreorder(BinaryTree root, int n) throws Exception {

		if (root == null)
			return;

		Stack<BinaryTree> stack = new Stack<BinaryTree>(n);
		stack.push(root);

		while (!stack.isEmpty()) {
			BinaryTree preOrder = stack.pop();
			System.out.print(" " + preOrder.getValue());
			
			if (preOrder.getRight() != null) {
				stack.push(preOrder.getRight());
			}

			if (preOrder.getLeft() != null) {
				stack.push(preOrder.getLeft());
			}
			
		}

	}
	
	private static void iterativePostorder(BinaryTree root, int n) throws Exception {
		//TODO
		
	}

	private static void recursiveInorder(BinaryTree root) {
		if (root != null) {
			recursiveInorder(root.getLeft());
			System.out.print(" " + root.getValue());
			recursiveInorder(root.getRight());
		}
	}

	private static void recursivePreorder(BinaryTree root) {
		if (root != null) {
			System.out.print(" " + root.getValue());
			recursivePreorder(root.getLeft());
			recursivePreorder(root.getRight());
		}

	}

	private static void recursivePostorder(BinaryTree root) {
		if (root != null) {
			recursivePostorder(root.getLeft());
			recursivePostorder(root.getRight());
			System.out.print(" " + root.getValue());
		}

	}

	private static BinaryTree createStandardBinaryTree(int[] arr, int left, int right) {

		if (left > right) {
			return null;
		}

		int mid = left + (right - left) / 2;
		final BinaryTree root = new BinaryTree(arr[mid]);

		root.setLeft(createStandardBinaryTree(arr, left, mid - 1));
		root.setRight(createStandardBinaryTree(arr, mid + 1, right));

		return root;
	}

	public static void main(String[] args) throws Exception {

		int n = 11;
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		BinaryTree root = createStandardBinaryTree(arr, 0, arr.length - 1);
		System.out.print("Root value " + root.getValue() + "\n");
		System.out.println("Recursive Inorder traversal");
		recursiveInorder(root);
		System.out.println("\n" + "Recursive Preorder traversal");
		recursivePreorder(root);
		System.out.println("\n" + "Recursive Postorder traversal");
		recursivePostorder(root);
		System.out.println("\n" + "Iterative Inorder traversal");
		iterativeInorder(root, n);
		System.out.println("\n" + "Iterative Preorder traversal");
		iterativePreorder(root, n);
		System.out.println("\n" + "Iterative Postorder traversal");
		iterativePostorder(root, n);
	}



}
