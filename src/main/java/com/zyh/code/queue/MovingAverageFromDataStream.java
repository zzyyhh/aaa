package com.zyh.code.queue;

import java.util.Queue;

import com.google.common.collect.Lists;

/**
 * @author yinghui.zhang on 2020/8/12
 */
public class MovingAverageFromDataStream {

    // Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

    // For example,
    // MovingAverage m = new MovingAverage(3);
    // m.next(1) = 1
    // m.next(10) = (1 + 10) / 2
    // m.next(3) = (1 + 10 + 3) / 3
    // m.next(5) = (10 + 3 + 5) / 3

    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */
    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));
    }

    public static class MovingAverage {

        private Queue<Integer> queue = Lists.newLinkedList();

        private int windowSize;

        private double previousSum = 0.0;

        public MovingAverage(int windowSize) {
            this.windowSize = windowSize;
        }

        public double next(int value) {
            if (queue.size() == windowSize) {
                previousSum =  previousSum - queue.remove();
            }

            queue.add(value);
            previousSum = previousSum + value;

            return previousSum/queue.size();
        }

    }
}
