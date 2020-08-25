package com.zyh.code.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangyinghui  Date: 2020/8/25 Time: 6:19 PM
 */
public class WaitNotify1 {

    private static int max = 10;

    private static final ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(max);

    public static void put(Object o, TimeUnit timeUnit, int timeOut) {
        try {
            queue.offer(o, timeOut, timeUnit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Object get(TimeUnit timeUnit, int timeOut) {
        try {
           return queue.poll(timeOut, timeUnit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        WaitNotify1 waitNotify1 = new WaitNotify1();

        Thread producer = new Thread( new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    waitNotify1.put("a",TimeUnit.HOURS,1);
                }
            }
        }, "producer");
        producer.start();

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    System.out.println(waitNotify1.get(TimeUnit.HOURS,1));;
                }
            }
        }, "consumer");

        consumer.start();
        consumer.join();
    }
}
