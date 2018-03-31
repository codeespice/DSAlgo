package com.g.prepare.arrays;
/*
this class prints diagonal, first half of diagonal,second half of diagonal
 */
public class TwoDimensionalArrays {

    int[][] array = new int[4][4];

    public void populateArray()
    {
        array[0][0]=1;
        array[0][1]=2;
        array[0][2]=3;
        array[0][3]=4;

        array[1][0]=5;
        array[1][1]=6;
        array[1][2]=7;
        array[1][3]=8;

        array[2][0]=9;
        array[2][1]=10;
        array[2][2]=11;
        array[2][3]=12;

        array[3][0]=13;
        array[3][1]=14;
        array[3][2]=15;
        array[3][3]=16;

    }

    public void printArray()
    {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                System.out.print(array[i][j] +" \t");
            }
            System.out.println("");
        }
    }
    //row is  equal to column
    public void printDiagonal()
    {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(i==j) {
                    System.out.print(array[i][j] + " \t");
                }
                else
                {
                    System.out.print("*" + " \t");
                }
            }
            System.out.println("");
        }
    }
    //row is Less  than equals column
    public void printFirstHalfOfDiagonal()
    {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(i<=j) {
                    System.out.print(array[i][j] + " \t");
                }
                else
                {
                    System.out.print("*" + " \t");
                }
            }
            System.out.println("");
        }
    }
    //row is grater than equals column
    public void printSecondtHalfOfDiagonal()
    {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(i>=j) {
                    System.out.print(array[i][j] + " \t");
                }
                else
                {
                    System.out.print("*" + " \t");
                }
            }
            System.out.println("");
        }
    }
    public static void main(String[] args)
    {
        TwoDimensionalArrays td = new TwoDimensionalArrays();
        td.populateArray();
       // td.printArray();
       // td.printDiagonal();
        // td.printFirstHalfOfDiagonal();
        td.printSecondtHalfOfDiagonal();

    }
}
