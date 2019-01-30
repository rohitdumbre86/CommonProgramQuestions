package com.datastructures.bintree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class CommonBinaryTreeQuestions extends BasicTraversing
{

    public static void main(String[] args) throws Exception
    {
        int n = 11;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = i + 1;
        }
        BinaryTree root = createStandardBinaryTree(arr, 0, arr.length - 1);

        System.out.println("Print nodes per level Recursive");
        final List<List<BinaryTree>> listPerLevel_1 = getListPerLevel(root);

        for (List<BinaryTree> level : listPerLevel_1)
        {
            level.forEach(node -> System.out.print(node.getValue() + ":"));
            System.out.println();
        }

        System.out.println("Print nodes per level iterative");
        final List<List<BinaryTree>> listPerLevel_2 = getListPerLevelIterative(root);

        for (List<BinaryTree> level : listPerLevel_2)
        {
            level.forEach(node -> System.out.print(node.getValue() + ":"));
            System.out.println();
        }

        System.out.println("Print zig zag order");

        printTreeInZigZagOrder(root);

        System.out.println("Mirror images");

        BinaryTree mirrorTree = createStandardBinaryTree(arr, 0, arr.length - 1);
        convertTreeToMirror(mirrorTree);

        List<List<BinaryTree>> listPerLevelReverse = getListPerLevel(mirrorTree);

        for (List<BinaryTree> level : listPerLevelReverse)
        {
            level.forEach(node -> System.out.print(node.getValue() + ":"));
            System.out.println();
        }

        System.out.println("Are two tree mirror images of each other");

        System.out.println(areTwoTreesMirrorImage(root, mirrorTree));

        System.out.println("Print the border images");

        printTheBorder(root);

        System.out.println("Find the least common node");

        System.out.println(returnLCAForTwoNodes(root, 3, 9));
        System.out.println(returnLCAForTwoNodes(root, 1, 4));
        System.out.println(returnLCAForTwoNodes(root, 7, 10));
        System.out.println(returnLCAForTwoNodes(root, 2, 11));

        System.out.println("Get the height of a binary tree");

        int heighofBTree = getHeightOfBinaryTree(root);
        System.out.println("Heigth of BTree " + heighofBTree);
        System.out.println("Print all the paths from root");

        printAllNodesFromRoot(root, new int[heighofBTree + 1], 0);

        System.out.println("Print all the vertical sums");
        Map<Integer, Integer> calculator = new TreeMap<Integer, Integer>();
        printAllVerticalPathSums(root, 0, calculator);
        calculator.values().stream().forEach(System.out::println);

    }

    public static int getHeightOfBinaryTree(final BinaryTree root)
    {
        if (root == null)
            return 0;

        return 1 + Math.max(getHeightOfBinaryTree(root.getLeft()),
                            getHeightOfBinaryTree(root.getRight()));
    }

    /**
     * Question asked these days in Microsoft. Print the left nodes. Print the leaves. Print the
     * right nodes.
     * 
     * @param root
     */
    public static void printTheBorder(final BinaryTree root)
    {
        System.out.print(root.getValue() + " ");
        printTheLeft(root.getLeft());
        printTheLeaves(root);
        printTheRigth(root.getRight());
    }

    /**
     * The algorithm is simple Do inorder traversal. When going to left substree decrement level by
     * 1 if key/level is in tree add the current node to the sum else add a new entry to the map.
     * When going to right substree increment level by 1
     */
    public static void printAllVerticalPathSums(final BinaryTree root,
                                                final int level,
                                                final Map<Integer, Integer> calculator)
    {
        if (root == null)
        {
            return;
        }

        printAllVerticalPathSums(root.getLeft(), level - 1, calculator);

        if (calculator.containsKey(level))
        {
            calculator.compute(level, (k, v) -> v + root.getValue());
        }
        else
        {
            calculator.put(level, root.getValue());
        }

        printAllVerticalPathSums(root.getRight(), level + 1, calculator);
    }

    /**
     * Look at the code.
     */
    public static int returnLCAForTwoNodes(BinaryTree root, int valueA, int valueB)
    {
        if (root == null)
            return -1;

        if (root.getValue() == valueA)
        {
            return valueA;
        }
        else if (root.getValue() == valueB)
        {
            return valueB;
        }

        int left = returnLCAForTwoNodes(root.getLeft(), valueA, valueB);
        int right = returnLCAForTwoNodes(root.getRight(), valueA, valueB);

        if (left != -1 && right != -1)
        {
            return root.getValue();
        }
        else if (left != -1)
        {
            return left;
        }

        return right;

    }

    /**
     * Prints all the nodes from root. Tip use the length of the array as a control to print the
     * path. With every node increment the path array length.
     * 
     * @param root
     * @param path
     * @param len
     */
    public static void printAllNodesFromRoot(BinaryTree root, int[] path, int len)
    {
        if (root == null)
            return;

        path[len] = root.getValue();
        len++;

        if (root.getLeft() == null && root.getRight() == null)
        {

            for (int i = 0; i < len; i++)
            {
                System.out.print(path[i] + ":");
            }

            System.out.println();

            return;
        }

        printAllNodesFromRoot(root.getLeft(), path, len);
        printAllNodesFromRoot(root.getRight(), path, len);
    }

    private static void printTheRigth(BinaryTree root)
    {
        if (root == null)
            return;

        if (root.getLeft() == null && root.getRight() == null)
        {
            return;
        }

        if (root.getRight() != null)
        {
            printTheRigth(root.getRight());
        }
        else if (root.getLeft() != null)
        {
            printTheRigth(root.getLeft());
        }

        System.out.print(root.getValue() + " ");
    }

    private static void printTheLeaves(BinaryTree root)
    {
        if (root != null)
        {
            printTheLeaves(root.getLeft());

            if (root.getLeft() == null && root.getRight() == null)
            {
                System.out.print(root.getValue() + " ");
            }

            printTheLeaves(root.getRight());
        }

    }

    private static void printTheLeft(BinaryTree root)
    {
        if (root == null)
            return;

        if (root.getLeft() == null && root.getRight() == null)
        {
            return;
        }

        System.out.print(root.getValue() + " ");

        if (root.getLeft() == null)
        {
            printTheLeft(root.getRight());
        }
        else if (root.getLeft() != null)
        {
            printTheLeft(root.getLeft());
        }

    }

    /**
     * Algorithm Code below is easy to understand.
     * 
     * @param root
     * @param mirrorTree
     * @return True if trees are mirror of each other
     */
    public static boolean areTwoTreesMirrorImage(BinaryTree root, BinaryTree mirrorTree)
    {
        if (root == null && mirrorTree == null)
        {
            return true;
        }
        if (root == null || mirrorTree == null)
        {
            return false;
        }

        return root.getValue() == mirrorTree.getValue()
               && areTwoTreesMirrorImage(root.getLeft(), mirrorTree.getRight())
               && areTwoTreesMirrorImage(root.getRight(), mirrorTree.getLeft());
    }

    /**
     * Algorithm Do preorder traversal and flip its right and left children.
     * 
     * @param root
     */
    public static void convertTreeToMirror(BinaryTree root)
    {
        if (root != null)
        {

            BinaryTree temp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);

            convertTreeToMirror(root.getLeft());
            convertTreeToMirror(root.getRight());
        }
    }

    public static List<List<BinaryTree>> getListPerLevel(final BinaryTree root)
    {
        List<List<BinaryTree>> listOfNodesPerLevel = new ArrayList<List<BinaryTree>>();

        binaryTreeNodePerLevel(root, 0, listOfNodesPerLevel);

        return listOfNodesPerLevel;
    }

    public static List<List<BinaryTree>> getListPerLevelIterative(final BinaryTree root)
    {

        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.add(root);

        List<List<BinaryTree>> binNodes = new ArrayList<List<BinaryTree>>();

        while (!queue.isEmpty())
        {

            int qSize = queue.size();
            if (qSize == 0)
            {
                break;
            }

            List<BinaryTree> node = new ArrayList<BinaryTree>();

            while (qSize > 0)
            {

                BinaryTree child = queue.remove();
                node.add(child);

                if (child.getLeft() != null)
                {
                    queue.add(child.getLeft());
                }
                if (child.getRight() != null)
                {
                    queue.add(child.getRight());
                }

                qSize--;
            }
            binNodes.add(node);

        }

        return binNodes;
    }

    /**
     * Print in zigzag order. Algorithm
     * 
     * <pre>
     *  Initialize two stacks say s1 and s2.
     *  The stack S1 will have a root node.
     *  While s1 and s2 are not empty.
     *    While s1 is not empty. Pop element print the node and push the children(left and right in order) in stack s2.
     *    While s2 is not empty. Pop element print the node and push the children(right and left in order) in stack s1.
     * </pre>
     * 
     * @param root
     */
    public static void printTreeInZigZagOrder(final BinaryTree root)
    {
        Stack<BinaryTree> s1 = new Stack<BinaryTree>();
        Stack<BinaryTree> s2 = new Stack<BinaryTree>();
        s1.add(root);

        while (!s1.isEmpty() || !s2.isEmpty())
        {
            while (!s1.isEmpty())
            {
                BinaryTree node = s1.pop();
                System.out.print(node.getValue() + ":");
                if (node.getLeft() != null)
                {
                    s2.push(node.getLeft());
                }
                if (node.getRight() != null)
                {
                    s2.push(node.getRight());
                }
            }

            System.out.println();

            while (!s2.isEmpty())
            {
                BinaryTree node = s2.pop();
                System.out.print(node.getValue() + ":");
                if (node.getRight() != null)
                {
                    s1.push(node.getRight());
                }
                if (node.getLeft() != null)
                {
                    s1.push(node.getLeft());
                }
            }

            System.out.println();

        }

    }

    /**
     * Algorithm
     * 
     * @param node The current binary tree node to add.
     * @param level The current level.
     * @param listPerNode The number of nodes per current level.
     */
    private static void binaryTreeNodePerLevel(BinaryTree node,
                                               int level,
                                               List<List<BinaryTree>> listPerNode)
    {
        if (node == null)
            return;

        if (listPerNode.size() < level + 1)
        {
            List<BinaryTree> nodes = new ArrayList<BinaryTree>();
            nodes.add(node);
            listPerNode.add(nodes);
        }
        else
        {
            List<BinaryTree> nodes = listPerNode.get(level);
            nodes.add(node);
        }

        binaryTreeNodePerLevel(node.getLeft(), level + 1, listPerNode);
        binaryTreeNodePerLevel(node.getRight(), level + 1, listPerNode);
    }
}
