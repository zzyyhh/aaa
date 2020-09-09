package com.zyh.code.array;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author yinghui.zhang on 2020/8/7
 */
public class InsertInterval_No {
    // Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

    // You may assume that the intervals were initially sorted according to their start times.

    // Example 1:
    // Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

    // Example 2:
    // Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

    // This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

    //https://leetcode-cn.com/problems/insert-interval/solution/cha-ru-qu-jian-by-leetcode/

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

        @Override
        public String toString() {
            return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
        }
    }

    public static void main(String[] args) {
        List<Interval> list = Lists.newArrayList();
        list.add(new Interval(1, 2));
        list.add(new Interval(3, 5));
        list.add(new Interval(6, 7));
        list.add(new Interval(8, 10));
        list.add(new Interval(12, 16));

        Interval insert = new Interval(4, 9);

        List<Interval> result = merge(list, insert);
        System.out.println(result);
    }

    private static List<Interval> merge(List<Interval> list, Interval insert) {
        int i = 0;
        //list中end < insert.start,移动到可重合
        while (i < list.size() && list.get(i).end < insert.start) {
            i++;
        }
        //
        while (i < list.size() && list.get(i).start <= insert.end) {
            insert = new Interval(Math.min(list.get(i).start, insert.start), Math.max(list.get(i).end, insert.end));
            list.remove(i);
        }
        list.add(i, insert);
        return list;

    }



}



