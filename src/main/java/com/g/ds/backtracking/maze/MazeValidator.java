package com.g.ds.backtracking.maze;

import java.io.File;

public class MazeValidator {

    public static void main(String args[]) throws Exception {

        File maze1 = new File("src/main/resources/maze/maze1.txt");
        execute(maze1);
    }
    private static void execute(File file) throws Exception {
        Maze maze = new Maze(file);
        System.out.println("Print Maze");
        maze.printMaze();

    }

}
