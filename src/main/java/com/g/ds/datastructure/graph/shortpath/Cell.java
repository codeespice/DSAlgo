package com.g.ds.datastructure.graph.shortpath;

public class Cell {
    int row;
    int column;
    int distance;

    public Cell(int row, int column, int distance) {
        this.row = row;
        this.column = column;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "row=" + row +
                ", column=" + column +
                ", distance=" + distance +
                '}';
    }
}
