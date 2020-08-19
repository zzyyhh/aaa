package com.zyh.code.some;

import javax.annotation.Nullable;

import com.google.common.collect.Ordering;

/**
 * @author yinghui.zhang on 2020/8/19
 */
public class TimerTaskEntry extends Ordering<TimerTaskEntry> {

    private volatile TimerTaskList list = null;
    private volatile TimerTaskEntry next = null;
    private volatile TimerTaskEntry prev = null;

    private TimerTask timerTask;
    private long expirationMs;

    public TimerTaskEntry(TimerTask timerTask, long expirationMs) {
        this.timerTask  = timerTask;
        this.expirationMs = expirationMs;
        if (timerTask != null) timerTask.setTimerTaskEntry(this);
    }

    boolean cancelled() {
        return timerTask.getTimerTaskEntry() != this;

    }

    public void remove() {
        TimerTaskList currentList = list;
        while (currentList != null) {
            currentList.remove(this);
            currentList = list;
        }
    }


    @Override
    public int compare(@Nullable TimerTaskEntry left, @Nullable TimerTaskEntry right) {
        return Long.compare(left.expirationMs, right.expirationMs);
    }

}
