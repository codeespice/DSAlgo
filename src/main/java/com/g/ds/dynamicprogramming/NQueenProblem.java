package com.g.ds.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;


/**

 *
 * Given nxn board place n queen on this board so that they dont attack each other. One solution is to find
 * any placement of queens which do not attack each other. Other solution is to find all placements of queen
 * on the board.
 *
 * Time complexity O(n*n)
 * Space complexity O(n*n)
 */
public class NQueenProblem {

    class Position {
        int row, col;
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public Position[] solveNQueenOneSolution(int n) {
        Position[] positions = new Position[n];
        boolean hasSolution = solveNQueenOneSolutionUtil(n, 0, positions);
        if (hasSolution) {
            return positions;
        } else {
            return new Position[0];
        }
    }

    private boolean solveNQueenOneSolutionUtil(int n, int row, Position[] positions) {
        if (n == row) {
            return true;
        }
        int col;
        for (col = 0; col < n; col++) {
            boolean foundSafe = true;

            //check if this row and col is not under attack from any previous queen.
            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col ||
                        positions[queen].row + positions[queen].col == row + col) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                positions[row] = new Position(row, col);
                if (solveNQueenOneSolutionUtil(n, row + 1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }
 public static void main(String[] args){
     NQueenProblem nQueenProblem = new NQueenProblem();
     int GRID_SIZE=4;
     Position[] positions = nQueenProblem.solveNQueenOneSolution(GRID_SIZE);
     Arrays.stream(positions).forEach(position -> System.out.println(position.row + " " + position.col));

 }
}