package com.g.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.

Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
 Example 1:

Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4] and group2 [2,3].
Example 2:

Input: n = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false


 */
public class PossibleBipartition {

    public boolean possibleBipartition(int N,int[][] dislikes){
        //setup adjacency list
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<N;i++ ){
            map.put(i,new ArrayList<>());
        }
        for(int[] dislikePair : dislikes){
            map.get(dislikePair[0]-1).add(dislikePair[1]-1);
            map.get(dislikePair[1]-1).add(dislikePair[0]-1);
        }
        //create visited array where 0= unvisited 1= groupA, -1=groupB
        int[] visited = new int[N];
        //attempts dfs
        for(int i=0;i<N;i++){
            //if dfs finds two neighbours with the same grouping then return false
            //since we havn't visited this connected component yet , it doesnot matter
            //whether we assign this first node to 1 to -1
            if(visited[i]==0 && !dfs(map,visited,i,1)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(HashMap<Integer, List<Integer>> map,int[] visited,int person,int group){
        visited[person] = group;
        for(int j : map.get(person)){
            //if any of neighbour belongs to same group . i.e alternate nodes should belong to different group
            //otherwise we cannot contruct the groups
            if(visited[j]== group){
                return false;
            }
            //if any neighbours have not been visited yet. DFS to it and assign it to the opposite group
            if(visited[j]==0 && !dfs(map,visited,j,-group)){
                return false;
            }
            //the third case is if a neighbour is in the opposite group no need to DFS there

        }
        return true;

    }
    public static void main(String args[]){
        int n = 4;
        int[][] dislikes = {{1,2},{1,3},{2,4}};
        PossibleBipartition possibleBipartition = new PossibleBipartition();
        boolean result = possibleBipartition.possibleBipartition(n,dislikes);
        System.out.println("result:"+result);
        n = 3;
         int[][] anotherDislikes = {{1,2},{1,3},{2,3}};
        result = possibleBipartition.possibleBipartition(n,anotherDislikes);
        System.out.println("result:"+result);
    }
}
