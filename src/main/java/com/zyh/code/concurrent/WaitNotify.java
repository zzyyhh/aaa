package com.zyh.code.concurrent;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author yinghui.zhang on 2020/8/10
 */
public class WaitNotify {

    private static int max = 10;

    private static final List<Object> queue = Lists.newArrayList();

    private static void put(Object o) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == max) {
                queue.wait();
            }
            queue.add(o);
            //注意要使用notifyAll
            queue.notifyAll();
        }
    }

    private static Object get() throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == 0) {
                queue.wait();
            }
            Object o = queue.remove(0);
            //注意要使用notifyAll
            queue.notifyAll();
            //queue.notify();

            return o;
        }
    }

    public static void main(String[] args) {

    }
}
