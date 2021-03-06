package com.g.ds.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
1.Graph is stored using adjeceny list
2.adjeceny list is nothing but array of Linked list (each linked list corresponds to one src)
3.Visit the first node and the nodes linked to it
if you hit the node linked add the node to the queue and continue traversing
and proceed subsequently.

eg Graph
0->1,2
1->0,3,4
2->0,5
3->1
4->1
5->2
 */
public class BreadthFirstSearch {
    static class Node
    {
        int value;
        Node next;
        public Node(int value,Node next)
        {
            this.value=value;
            this.next=next;
        }

    }
    static class AdjList{
        Node head;
        public AdjList()
        {

        }
    }
    //same as DFSGraph in DepthFirstSearch
    static class BFSGraph{
        AdjList[] adjList;
        int size;
        public  BFSGraph(int size)
        {
            this.size=size;
            adjList = new AdjList[this.size];
            for(int i=0;i<this.size;i++)
            {
                adjList[i]=new AdjList();
                adjList[i].head=null;
            }
        }
        public void addNode(int src,int destination)
        {
            Node node = new Node(destination,null);
            node.next = adjList[src].head;
            adjList[src].head =node;
        }
        /*
      print utility for graph...not significant other than printing
       */
        public void printGraph()
        {
            for( int i=0;i<size; i++)
            {
                System.out.print(i+"->");
               Node node = adjList[i].head;
                while(node!=null)
                {
                    System.out.print(node.value);
                    if(node.next!=null)
                    {
                        System.out.print(",");
                    }
                    node=node.next;
                }
                System.out.println(" ");
            }

        }
        /*
        do the depth first traverse
        maintain the visited node
         */
        public void explore(int startIndex)
        {
          Boolean[] visited = new Boolean[this.size];
          for(int i=0;i<this.size;i++)
          {
              visited[i]=false;
          }
            Queue<Integer> track = new LinkedList<>();
          track.add(startIndex);
          visited[startIndex]=true;
          while(!track.isEmpty())
          {
              int element = track.poll();
              visited[element]=true;
              System.out.println("Visited the Node:"+element);
              Node head = adjList[element].head;

              while(head!=null)
              {
                  if(visited[head.value]==false)
                  {

                      track.add(head.value);
                      visited[head.value]=true;

                  }
                  else
                  {
                      head =head.next;
                  }
              }

          }

        }
    }
    public static void main(String[] args)
    {
        BFSGraph bfsGraph = new BFSGraph(6);
        bfsGraph.addNode(0,2);
        bfsGraph.addNode(0,1);
        bfsGraph.addNode(1,4);
        bfsGraph.addNode(1,3);

        bfsGraph.addNode(1,0);
        bfsGraph.addNode(3,1);
        bfsGraph.addNode(4,1);
        bfsGraph.addNode(2,5);

        bfsGraph.addNode(2,0);
        bfsGraph.addNode(5,2);
        bfsGraph.printGraph();
        //bfsGraph.explore(0);
    }
}
