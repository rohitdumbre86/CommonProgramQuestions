package com.datastructures.bintree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommonTraversingTechniquies extends BasicTraversing {

	public static void main(String[] args) throws Exception {
		int n = 11;
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		BinaryTree root = createStandardBinaryTree(arr, 0, arr.length - 1);

		System.out.println("Print nodes per level");
		List<List<BinaryTree>> listPerLevel = getListPerLevel(root);

		for (List<BinaryTree> level : listPerLevel) {
			level.forEach(node -> System.out.print(node.getValue() + ":"));
			System.out.println();
		}

		System.out.println("Print zig zag order");

		printTreeInZigZagOrder(root);

		System.out.println("Mirror images");

		BinaryTree mirrorTree = (BinaryTree) root.clone();
		convertTreeToMirror(mirrorTree);

		List<List<BinaryTree>> listPerLevelReverse = getListPerLevel(mirrorTree);

		for (List<BinaryTree> level : listPerLevelReverse) {
			level.forEach(node -> System.out.print(node.getValue() + ":"));
			System.out.println();
		}

		System.out.println("Are two tree mirror images of each other");
		
		System.out.println(areTwoTreesMirrorImage(root, mirrorTree));
		
		System.out.println("Print the border images");

	    printTheBorder(root);
	}
	
	public static void printTheBorder(final BinaryTree root)
	{
		printTheLeft(root.getLeft());
		printTheLeaves(root);
		printTheRigth(root.getRight());
	}

	private static void printTheRigth(BinaryTree root) {
		if(root==null) return;
		
		if(root.getLeft()==null && root.getRight()==null) {
			return ;
		}
		
		if(root.getRight()!=null) {
			printTheRigth(root.getRight());
		}
		else if(root.getLeft()!=null) {
			printTheRigth(root.getLeft());
		}
		
		System.out.print(root.getValue()+" ");
	}

	private static void printTheLeaves(BinaryTree root) {
		if(root!=null)
		{
			printTheLeaves(root.getLeft());
			
			if(root.getLeft()==null && root.getRight()==null) {
				System.out.print(root.getValue()+" ");
			}
			
			printTheLeaves(root.getRight());
		}
		
	}

	private static void printTheLeft(BinaryTree root) {
		if(root==null) return;
		
		if(root.getLeft()==null && root.getRight()==null) {
			return ;
		}
				
		System.out.print(root.getValue()+" ");

		if(root.getLeft()==null) {
			printTheLeft(root.getRight());
		}
		else if(root.getLeft()!=null) {
			printTheLeft(root.getLeft());
		}
		
	}

	public static boolean areTwoTreesMirrorImage(BinaryTree root, BinaryTree mirrorTree) {
		if (root == null && mirrorTree == null) {
			return true;
		}
		if (root == null || mirrorTree == null) {
			return false;
		}

		return root.getValue() == mirrorTree.getValue() 
				&& areTwoTreesMirrorImage(root.getLeft(), mirrorTree.getRight())
				&& areTwoTreesMirrorImage(root.getRight(), mirrorTree.getLeft());
	}

	public static void convertTreeToMirror(BinaryTree root) {
		if (root != null) {

			BinaryTree temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);

			convertTreeToMirror(root.getLeft());
			convertTreeToMirror(root.getRight());
		}
	}

	public static List<List<BinaryTree>> getListPerLevel(final BinaryTree root) {
		List<List<BinaryTree>> listOfNodesPerLevel = new ArrayList<List<BinaryTree>>();

		binaryTreeNodePerLevel(root, 0, listOfNodesPerLevel);

		return listOfNodesPerLevel;
	}

	public static void printTreeInZigZagOrder(final BinaryTree root) {
		Stack<BinaryTree> s1 = new Stack<BinaryTree>();
		Stack<BinaryTree> s2 = new Stack<BinaryTree>();
		s1.add(root);

		while (!s1.isEmpty() || !s2.isEmpty()) {
			while (!s1.isEmpty()) {
				BinaryTree node = s1.pop();
				System.out.print(node.getValue() + ":");
				if (node.getLeft() != null) {
					s2.push(node.getLeft());
				}
				if (node.getRight() != null) {
					s2.push(node.getRight());
				}
			}

			System.out.println();

			while (!s2.isEmpty()) {
				BinaryTree node = s2.pop();
				System.out.print(node.getValue() + ":");
				if (node.getRight() != null) {
					s1.push(node.getRight());
				}
				if (node.getLeft() != null) {
					s1.push(node.getLeft());
				}
			}

			System.out.println();

		}

	}

	private static void binaryTreeNodePerLevel(BinaryTree node, int level, List<List<BinaryTree>> listPerNode) {
		if (node == null)
			return;

		if (listPerNode.size() < level + 1) {
			List<BinaryTree> nodes = new ArrayList<BinaryTree>();
			nodes.add(node);
			listPerNode.add(nodes);
		} else {
			List<BinaryTree> nodes = listPerNode.get(level);
			nodes.add(node);
		}

		binaryTreeNodePerLevel(node.getLeft(), level + 1, listPerNode);
		binaryTreeNodePerLevel(node.getRight(), level + 1, listPerNode);
	}
}
