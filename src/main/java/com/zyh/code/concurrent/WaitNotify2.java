package com.zyh.code.concurrent;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangyinghui  Date: 2020/8/25 Time: 7:28 PM
 */
public class WaitNotify2 {


    private static int max = 10;

    private static final List<Object> queue = Lists.newArrayList();

    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition notEmpty = lock.newCondition();

    private static final Condition notFull = lock.newCondition();

    private static void put(Object o) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == max) {
                notFull.wait();
            }
            queue.add(o);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }

    }

    private static Object get() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.wait();
            }
            Object o = queue.remove(0);
            notFull.signal();
            return o;
        } finally {
            lock.unlock();
        }
    }
}
