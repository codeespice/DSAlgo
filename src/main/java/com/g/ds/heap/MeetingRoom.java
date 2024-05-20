package com.g.ds.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.



Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 */

public class MeetingRoom {
    public int minMeetingRooms(int[][] intervals) {
        Queue<Integer> meeting = new PriorityQueue<Integer>();

        Arrays.sort(intervals, new Comparator<int []>() {
            @Override
            public int compare(int input1[], int input2[]) {
                return input1[0] - input2[0];
            }
        });

        int room = 0;
        for(int i=0; i<intervals.length;i++) {
            while(!meeting.isEmpty() && meeting.peek()<=intervals[i][0]) {
                meeting.remove();
            }
            meeting.add(intervals[i][1]);
            if(meeting.size()>room) {
                room = meeting.size();
            }
        }
        return room;
    }
    public static void main(String[] args){
       int[][] meetingSchedule = {{0,30},{5,10},{15,20}};
        MeetingRoom meetingRoom = new MeetingRoom();
       int rooms= meetingRoom.minMeetingRooms(meetingSchedule);
       System.out.println("Rooms : "+rooms);
    }
}
