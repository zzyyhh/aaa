package com.zyh.code.linkedlist;

import com.zyh.code.support.ListNode;
import com.zyh.code.support.Support;

/**
 * @author zhangyinghui  Date: 2020/8/22 Time: 10:54 PM
 */
public class ReverseLinkedList {
    // Reverse a singly linked list.

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {
        ListNode node = Support.buildListNode1();
        ListNode reverseNode = reverseList(node);
        System.out.println(reverseNode);
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode result = null;
        while (head != null) {
            //当前下一个元素
            ListNode next =  head.next;

            //head下一个元素应该指向result
            head.next = result;

            //result移动至head
            result = head;

            //head移动至next
            head = next;
        }

        return result;
    }

    private static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode result = new ListNode();
        while (head != null) {

            ListNode next = head.next;

            head.next = result;

            result = head;

            head = next;

        }

        return result;
    }
}























