package com.zyh.code.linkedlist;

import com.zyh.code.support.ListNode;
import com.zyh.code.support.Support;

/**
 * @author zhangyinghui  Date: 2020/8/12 Time: 12:03 AM
 */
public class LinkedListCycle {

    //Given a linked list, determine if it has a cycle in it.
//Follow up:
//Can you solve it without using extra space?
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    /**
     * 输入：head = [3,2,0,-4], pos = 0
     输出：true
     解释：链表中有一个环，其尾部连接到第1个节点。
     */

//141 判断链表是否有环    https://leetcode-cn.com/problems/linked-list-cycle/
    public static void main(String[] args) throws InterruptedException {
        ListNode head = Support.buildListNode();
        System.out.println(head);
        boolean result = isCycle(head);
        System.out.println(result);
    }

    private static boolean isCycle(ListNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast !=null && fast.next !=null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == slow;

    }
}
