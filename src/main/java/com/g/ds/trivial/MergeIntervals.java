package com.g.ds.trivial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int totalIntervals = intervals.length;

        int intervalStart = intervals[0][0];
        int intervalEnd = intervals[0][1];

        List<int[]> mergedList = new ArrayList<>();

        for (int i = 1; i < totalIntervals; i++) {

            if (intervals[i][0] > intervalEnd) {
                mergedList.add(new int[] {intervalStart, intervalEnd});

                intervalStart = intervals[i][0];
                intervalEnd = intervals[i][1];
            } else {
                intervalEnd = Math.max(intervalEnd, intervals[i][1]);
            }
        }
        mergedList.add(new int[] {intervalStart, intervalEnd});

        return mergedList.toArray(new int[mergedList.size()][]);
    }
    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] result =  mergeIntervals.merge(intervals);
        Arrays.stream(result).forEach(arr->System.out.println(arr[0]+","+arr[1]));
    }
}
