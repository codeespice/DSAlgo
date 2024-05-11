package com.g.ds.graph.depthfirst;

import java.util.ArrayList;
import java.util.HashMap;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
Algorithm

Solution:
Hints:
1. This problem is equivalent to finding if a cycle exists in a directed graph.
	If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
2. Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
3. Topological sort could also be done via BFS.

The overall structure of the algorithm is simple, which consists of three main steps:

Step 1). we build a graph data structure from the given list of course dependencies. Here we adopt the adjacency list data structure as shown below to represent the graph, which can be implemented via hashmap or dictionary. Each entry in the adjacency list represents a node which consists of a node index and a list of neighbors nodes that follow from the node. pic
Step 2). we then enumerate each node (course) in the constructed graph, to check if we could form a dependency cycle starting from the node.
Step 3). we perform the cyclic check via backtracking, where we breadcrumb our path (i.e. mark the nodes we visited) to detect if we come across a previously visited node (hence a cycle detected). We also remove the breadcrumbs for each iteration.


Implementation Solution:
1. Create Adjacency List
2. Depth first search
3. to detect the cycles label currently visiting as -1 , visited as 1 and not visited as 0
4. During the Depth first search if we encounter visited as -1 then cycle is detected to return false else continue
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses , int[][] preRequisites){
        //handle bad input
        if(preRequisites==null || numCourses==0 || preRequisites.length==0){
            return true;
        }
        //Set up adjacency list
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            adjList.put(i,new ArrayList<>());
        }
        /*for(int i=0;i<preRequisites.length;i++){
            adjList.get(preRequisites[i][1]).add(preRequisites[i][0]);
        }*/
        for(int[] req : preRequisites){
            adjList.get(req[1]).add(req[0]);
        }
        //create visited array where visited =0 means not visited
        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            //return false if cycle is found
            if(!dfs(adjList,i,visited)){
                return false;
            }
        }
        //if no cycles were found
        return true;
    }

    public boolean dfs(HashMap<Integer, ArrayList<Integer>> adjList,int index, int[] visited){
       //cycle detected
         if(visited[index]==-1){
             return false;
         }
         //already seen node
         if(visited[index]==1){
             return true;
         }
         //mark currently visiting node as -1
         visited[index] = -1;
        if(adjList.containsKey(index)){
            for(int j: adjList.get(index)){
                if(!dfs(adjList,j,visited)){
                    return false;
                }
            }
        }

         visited[index] =1;
         return true;
    }

    public static void main(String[] args){
        CourseSchedule courseSchedule = new CourseSchedule();
       int numCourses = 4;
        int[][] prerequisites ={{1, 0}, {2, 1}, {3, 2}};
        boolean result = courseSchedule.canFinish(numCourses,prerequisites);
        System.out.println("result:"+result);
    }
}
