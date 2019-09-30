package com.g.ds.datastructure.graph.shortpath;


/*
Travel in four directions
find the shortest path to specific target

1	1	1	1	0
0	0	0	1	0
0	0	1	1	0
0	0	1	0	0
0	0	1	1	0
0	0	1	9	0
 */
import java.util.LinkedList;
import java.util.Queue;

public class ShortPathDFS {
    final static int target=9;
    public static void main(String args[])
    {


      int grid[][] ={{1,1,1,1,0},{0,0,0,1,0},{0,0,1,1,0},{0,0,1,0,0},{0,0,1,1,0},{0,0,1,9,0}};

      System.out.println("before shortpath ");
        printGraph(grid);
        Queue<Cell> cellQueue = new LinkedList<Cell>();
        move(grid,0,0,0,cellQueue);
        while(!cellQueue.isEmpty())
        {
            Cell cell = cellQueue.poll();
        //moverright
            move(grid,cell.row,cell.column+1,cell.distance+1,cellQueue);
        //moveleft
            move(grid,cell.row,cell.column-1,cell.distance+1,cellQueue);
        //movedown
            move(grid,cell.row+1,cell.column,cell.distance+1,cellQueue);
        //moveUp
            move(grid,cell.row-1,cell.column,cell.distance+1,cellQueue);
        }


        System.out.println("After shortpath ");
        printGraph(grid);

   // printGraph(grid);

    }

    static void move(int grid[][],int newRow,int newColumn,int distance,Queue<Cell> cellQueue)
    {
        if(newRow>=0 && newRow<grid.length && newColumn>=0 && newColumn<grid[0].length)
        {
            if(grid[newRow][newColumn]==1)
            {
                cellQueue.add(new Cell(newRow,newColumn,distance));
                grid[newRow][newColumn]=-1;
            }
            else if(grid[newRow][newColumn]==target){
                System.out.println("target found at distance of :" +distance);
                printGraph(grid);
                System.exit(0);


            }
        }
    }

    static void printGraph(int graph[][])
    {
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[0].length;j++)
            {
                System.out.print(graph[i][j]);
                System.out.print("\t");
            }
            System.out.println(" ");
        }
    }
}
