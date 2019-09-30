package com.g.ds.datastructure.graph.TravelPlanning;

import java.util.ArrayList;

public class GCell {
    int row;
    int column;
    ArrayList<Integer> visitedCities;

    public GCell(int row, int column, ArrayList<Integer> lastVisitedCities) {
        this.row = row;
        this.column = column;
        visitedCities=new ArrayList<>();
        if(lastVisitedCities!=null)
        {
            visitedCities.addAll(lastVisitedCities);
        }
        visitedCities.add(column);
    }

    @Override
    public String toString() {
        return "GCell{" +
                "row=" + row +
                ", column=" + column +
                ", visitedCities=" + visitedCities +
                '}';
    }
}
