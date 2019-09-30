package com.g.ds.datastructure.graph.TravelPlanning;

import com.g.ds.datastructure.graph.shortpath.Cell;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
this is similar to shortpath analysis except you have to move only two directions right and down
contriant is you have to stay atleast one day in the same place
1	1	1	1	0
0	1	0	1	0
0	0	1	1	0
0	0	1	1	0
0	0	1	0	1
 */
public class TravelPlanner {

    final static int target=9;
    public static void main(String args[])
    {


        int grid[][] ={{1,1,1,1,0},{0,1,0,1,0},{0,0,1,1,0},{0,0,1,1,0},{0,0,1,0,1}};

        System.out.println("before shortpath ");
        printGraph(grid);
        Queue<GCell> cellQueue = new LinkedList<GCell>();
        move(grid,0,0,null,cellQueue);
        while(!cellQueue.isEmpty())
        {
            GCell cell = cellQueue.poll();
            System.out.println(cell);
            //moverright
            move(grid,cell.row,cell.column+1,cell.visitedCities,cellQueue);
            //movedown
            //both row and column are increased because we have to stay a day at least
            move(grid,cell.row+1,cell.column+1,cell.visitedCities,cellQueue);

        }


        System.out.println("After shortpath ");
        printGraph(grid);

        // printGraph(grid);

    }

    static void move(int grid[][], int newRow, int newColumn, ArrayList<Integer> lastVisitedCities, Queue<GCell> cellQueue)
    {
        if(newRow>=0 && newRow<grid.length && newColumn>=0 && newColumn<grid[0].length)
        {
            if(grid[newRow][newColumn]==1 && newColumn==grid[0].length-1)
            {
                grid[newRow][newColumn]=-1;
                lastVisitedCities.add(newColumn);
                System.out.println("target found at distance of :" +lastVisitedCities);
                printGraph(grid);
                System.exit(0);

            }
            else if(grid[newRow][newColumn]==1){


                cellQueue.add(new GCell(newRow,newColumn,lastVisitedCities));

                grid[newRow][newColumn]=-1;

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
