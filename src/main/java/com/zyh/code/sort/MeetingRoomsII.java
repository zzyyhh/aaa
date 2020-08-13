package com.zyh.code.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yinghui.zhang on 2020/8/12
 */
public class MeetingRoomsII {

    // Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

    // For example,
    // Given [[0, 30],[5, 10],[15, 20]],
    // return 2.

    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
    // 解法: star 和 end 分别排序, 只要star<某一个end则需要一个房间 证明有覆盖关系
    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{new Interval(0, 30),new Interval(5, 10),new Interval(15, 20)};
        int result = minMeetingRooms2(intervals);
        System.out.println(result);
    }
    public static int minMeetingRooms2(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        //sort by start
        int minRooms = 1;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= intervals[i-1].end) {
                minRooms++;
            }
        }
        return minRooms;
    }



    public static int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int endsItr = 0;

        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr]) {
                rooms++;
            } else {
                endsItr++;
            }
        }

        return rooms;
    }
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
