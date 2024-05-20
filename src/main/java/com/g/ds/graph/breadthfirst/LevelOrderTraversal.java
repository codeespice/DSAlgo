package com.g.ds.graph.breadthfirst;
/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
https://leetcode.com/problems/binary-tree-level-order-traversal/description/
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
     this.val = val;
         this.left = left;
         this.right = right;
      }
 }

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> finalAns = new ArrayList<List<Integer>>();
        if(root==null){
            return finalAns;
        }
        q.add(root);
        while(!q.isEmpty()){
            int levels = q.size();
            List<Integer> subLevels = new ArrayList<>();
            for(int i=0;i<levels;i++){
                if(q.peek().left!=null){
                    q.add(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.add(q.peek().right);
                }
                subLevels.add(q.remove().val);
            }
            finalAns.add(subLevels);
        }
        return finalAns;
    }
    public static void main(String[] args){
        System.out.println("oam Vigneswara");
        /*
        Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
         */

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        TreeNode root = new TreeNode(3,left,right);
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        List<List<Integer>> finalAns= traversal.levelOrder(root);
        finalAns.forEach(System.out::println);

    }
}
