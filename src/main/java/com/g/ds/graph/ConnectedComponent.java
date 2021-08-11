package com.g.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.

answer depth first search

steps:
    1. construct Adacency List
    2. Recursion to DFS when we encounter new element
 */
public class ConnectedComponent {
    public int countComponents(int n,int[][] edges){
        //initialize djacency list for graph
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        //assign objects
        for(int i=0;i<n;i++){
            adj.put(i,new LinkedList<Integer>());
        }
        for(int i=0;i< edges.length;i++){
            //since graph is undirected we need to add edges for both nodes whihc is deifferent from directed graph
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        //created visited array where false= unvisited and true =visited
        boolean[] visited = new boolean[n];
        //count # of connected nodes
        int count = 0;
        for(int i=0;i<n ;i++){
            if(visited[i]==false){
                count ++;
                dfs(adj,i,visited);
            }
        }
        return count;
    }
    public void dfs(HashMap<Integer,List<Integer>> adj,int index,boolean[] visited){
        visited[index ] =true;
        for(Integer j : adj.get(index)){
            if(visited[j]==false){
                dfs(adj,j,visited);
            }
        }
    }


    public static void main(String[] args){
        ConnectedComponent connectedComponent = new ConnectedComponent();
        int [][] edges =  {{0,1},{1,2},{3,4}};
        int n=5;
        int count = connectedComponent.countComponents(n,edges);
        System.out.println("Count:"+count);


        n = 5;
        int [][] aedges = {{0,1},{1,2},{2,3},{3,4}};
        count = connectedComponent.countComponents(n,aedges);
        System.out.println("Count:"+count);

    }
}
