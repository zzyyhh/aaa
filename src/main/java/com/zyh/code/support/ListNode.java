package com.zyh.code.support;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author zhangyinghui  Date: 2020/8/12 Time: 12:06 AM
 */
public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public ListNode() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("value", value)
                .append("next", next)
                .toString();
    }
}
