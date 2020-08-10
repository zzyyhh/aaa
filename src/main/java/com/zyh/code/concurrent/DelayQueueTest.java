package com.zyh.code.concurrent;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * @author yinghui.zhang on 2020/8/10
 */
public class DelayQueueTest {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedImpl> delayQueue = new DelayQueue<DelayedImpl>();
        delayQueue.add(new DelayedImpl(System.currentTimeMillis() + 10 * 1000, "10s"));
        delayQueue.add(new DelayedImpl(System.currentTimeMillis() + 20 * 1000, "20s"));
        delayQueue.add(new DelayedImpl(System.currentTimeMillis() + 15 * 1000, "15s"));
        while (true) {
            DelayedImpl delayed =  delayQueue.poll(1,TimeUnit.SECONDS);
            System.out.println(delayed);
        }
    }

    private static class DelayedImpl implements Delayed {

        private long time;
        private String msg;

        public DelayedImpl(long time, String msg) {
            this.time = time;
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "DelayedImpl{" +
                "time=" + time +
                ", msg='" + msg + '\'' +
                '}';
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.currentTimeMillis(), MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            if (other == this) {
                return 0;
            }
            long diff = getDelay(MILLISECONDS) - other.getDelay(MILLISECONDS);
            return (diff < 0) ? -1 : (diff > 0) ? 1 : 0;
        }
    }
}
