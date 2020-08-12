package com.zyh.code.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yinghui.zhang on 2020/8/12
 */
public class MeetingRooms {

    // Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

    // For example,
    // Given [[0, 30],[5, 10],[15, 20]],
    // return false.

    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
    //解法，a. 排序，b. 找出重叠
    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{new Interval(0,30),new Interval(5,10),new Interval(15,20)};
        boolean result = canMeeting(intervals);
        System.out.println(result);
    }

    private static boolean canMeeting(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return false;
        }
        //sort by start
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }

        return false;
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
