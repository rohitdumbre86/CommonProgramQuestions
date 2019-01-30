package com.datastructures.bintree;

public class ConstructPrePostOrderTraversal
{

    public class TreeNode
    {
        public TreeNode left;
        public TreeNode right;
        public int value;
        
        TreeNode(int value){
            this.value = value;
        }
        
    }
    
    public TreeNode constructTree(int[] pre, int[] post, int start, int end) {
        
        TreeNode root = new TreeNode(pre[start]);
        
        root.left = constructLeftSubTree(pre, post, start+1, end);
        root.right = constructRightSubTree(pre, post, start, end-1);
        
        return root;
    }
    
    public TreeNode constructLeftSubTree(int[] pre, int[] post, int start, int end) {
        if(start > end || start > pre.length  || end < 0) {
            return null;
        }
        
        while(end >=0 && pre[start]!=post[end])
        {
           end--;
        }        
        
        return constructTree(pre, post, start, end);
    }
    
    public TreeNode constructRightSubTree(int[] pre, int[] post, int start, int end) {
        if(start >= end || start > pre.length || end < 0) {
            return null;
        }
        
        while(start < pre.length && pre[start]!=post[end]) {
            start++;
        }
        
        return constructTree(pre, post, start, end);
    }
    
    public static void main(String[] args)
    {
        ConstructPrePostOrderTraversal creator = new ConstructPrePostOrderTraversal();
        
        int[] pre = new int[]{1,2,4,5,3,6,7};
        int[] post = new int[] {4,5,2,6,7,3,1};
        
        TreeNode root = creator.constructTree(pre, post, 0, pre.length-1);
        System.out.println(root.value);
    }

}
