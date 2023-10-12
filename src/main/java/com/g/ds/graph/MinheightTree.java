package com.g.ds.graph;

import java.util.*;
/*
https://www.youtube.com/watch?v=ivl6BHJVcB0
A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

 Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
 Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
Example 3:

Input: n = 1, edges = []
Output: [0]
Example 4:

Input: n = 2, edges = [[0,1]]
Output: [0,1]


solution:
breadth first search
the root will be the mid of the graph
cut down the front element and find the leaves
 */
public class MinheightTree {

    public List<Integer> findMinHeightTrees(int n , int[][] edges){
    //if there's only one node (node 0) then that's the root
        if(n==1){
            return Collections.singletonList(0);
        }
        //set up adjacency list
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n ; i++){
            graph.add(new HashSet<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //keep track of all leaves (nodes on the edge of the graph with only one neighbour)
        List<Integer> leaves = new ArrayList<>();
        for(int i=0;i<n;i++){
            //if this node has only one neighbour(indegree=1) . its a leaf
            if(graph.get(i).size()==1){
                leaves.add(i);
            }
        }
        //keep removing leaves until there is atmost 2 nodes left on the graph
        while(n>2){
            n -= leaves.size();
            //temporary array to hold the new leaves after we remove these leaves
            List<Integer> newLeaves = new ArrayList<>();

            //remove each of the current leaves
            for(int i: leaves ){
                //get this leaf's one and only one neighbour
                int j = graph.get(i).iterator().next();
                //go to this leaf's neighbour and remove this leaf from its list
                graph.get(j).remove(i);
                if(graph.get(j).size()==1){
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;

    }
    public static void main(String[] args){
     int  n = 4;
     int[][] edges = {{1,0},{1,2},{1,3}};
     MinheightTree minheightTree = new MinheightTree();

        List<Integer> minHeightList =  minheightTree.findMinHeightTrees(n,edges);
        System.out.println("First tree");
        minHeightList.forEach(x->System.out.println(x));

       n = 6;
       int[][] anotherEdges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        minHeightList =  minheightTree.findMinHeightTrees(n,anotherEdges);
        System.out.println("Second tree");
        minHeightList.forEach(x->System.out.println(x));
    }
}
