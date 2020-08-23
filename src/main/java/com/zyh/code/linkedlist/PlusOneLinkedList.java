package com.zyh.code.linkedlist;

import com.zyh.code.support.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangyinghui  Date: 2020/8/23 Time: 11:17 AM
 */
public class PlusOneLinkedList {

    // Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

// You may assume the integer do not contain any leading zero, except the number 0 itself.

// The digits are stored such that the most significant digit is at the head of the list.

// Example:
// Input:
// 1->2->3

// Output:
// 1->2->4

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {

    }


    private static ListNode plusOneRecursive(ListNode head) {
        //use stack
        Deque<ListNode> nodeStack = new ArrayDeque<>();
        ListNode current = head;
        while (current != null) {
            nodeStack.add(current);
            current = current.next;
        }

        boolean addOne = true;
        while (!nodeStack.isEmpty()) {
            ListNode pollNode =  nodeStack.poll();
            if (pollNode.value == 9) {
                pollNode.value = 0;
            } else {
                pollNode.value = pollNode.value++;
                addOne = false;
                return head;
            }
        }

        if (addOne) {
            current = new ListNode(1, null);
            current.next = head;
        }

        return current;
    }


}
