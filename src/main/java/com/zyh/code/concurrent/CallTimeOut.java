package com.zyh.code.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author yinghui.zhang on 2020/8/19
 */
public class CallTimeOut {
    public static void main(String[] args) throws InterruptedException {


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000 * 5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run completed !!");
            }
        };

        callTimeOut(runnable, 1, TimeUnit.SECONDS);

    }

    private static void callTimeOut(Runnable runnable, int timeOut, TimeUnit timeUnit) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        async(runnable, countDownLatch);
        countDownLatch.await(timeOut, timeUnit);
    }

    private static void async(Runnable runnable, CountDownLatch countDownLatch) {
        Executors.newFixedThreadPool(1).submit(new Runnable() {
            @Override
            public void run() {
                runnable.run();
                countDownLatch.countDown();
            }
        });
    }
}
