package com.zyh.code.some;

/**
 * @author yinghui.zhang on 2020/8/19
 */
public abstract class TimerTask implements Runnable {

    private long delayMs = 0;
    private TimerTaskEntry timerTaskEntry = null;

    protected void cancel() {
        synchronized (this) {
            if (timerTaskEntry != null) { timerTaskEntry.remove(); }
            timerTaskEntry = null;
        }
    }

    protected void setTimerTaskEntry(TimerTaskEntry entry) {
        synchronized (this) {
            if (timerTaskEntry != null && timerTaskEntry != entry) { timerTaskEntry.remove(); }

            timerTaskEntry = entry;
        }
    }

    protected TimerTaskEntry getTimerTaskEntry() {
        return timerTaskEntry;
    }
}
