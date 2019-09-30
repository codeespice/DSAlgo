package com.g.ds.datastructure.graph;


import java.util.Stack;

/*
1.Graph is stored using adjeceny list
2.adjeceny list is nothing but array of Linked list (each linked list corresponds to one src)
3.Visit the first node and the nodes linked to it
if you hit the node linked to it then go the Node and traverse the list attached to Node
and proceed subsequently.

eg Graph
0->1,2
1->0,3,4
2->0,5
3->1
4->1
5->2
 */
public class DepthFirstSearch {

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
    static class DFSGraph{
        AdjList[] adjList;
        int size;
       public  DFSGraph(int size)
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
            Boolean[] visited = new Boolean[size];
            for(int i =0;i<visited.length;i++)
            {
                visited[i]=false;
            }
            Stack<Integer> trackVisted = new Stack<Integer>();
            trackVisted.push(startIndex);
            while(!trackVisted.isEmpty())
            {
               int element= trackVisted.pop();
               trackVisted.push(element);
               visited[element]=true;
               Node head = adjList[element].head;
               Boolean isDone =true;
               while(head!=null)
               {
                   if(visited[head.value]==false)
                   {
                       trackVisted.push(head.value);
                       visited[head.value]=true;
                       isDone =false;
                       break;
                   }
                   else
                   {
                       head = head.next;
                   }
               }
               if(isDone==true)
               {
                  int poppedElement =  trackVisted.pop();
                  System.out.println("Visited all the child Nodes for :"+poppedElement);
               }
            }

        }
    }

    public static void main(String[] args)
    {
       DFSGraph dfsGraph = new DFSGraph(6);
       dfsGraph.addNode(0,2);
        dfsGraph.addNode(0,1);
        dfsGraph.addNode(1,4);
        dfsGraph.addNode(1,3);

        dfsGraph.addNode(1,0);
        dfsGraph.addNode(3,1);
        dfsGraph.addNode(4,1);
        dfsGraph.addNode(2,5);

        dfsGraph.addNode(2,0);
        dfsGraph.addNode(5,2);
       // dfsGraph.printGraph();
        dfsGraph.explore(0);

    }
}
