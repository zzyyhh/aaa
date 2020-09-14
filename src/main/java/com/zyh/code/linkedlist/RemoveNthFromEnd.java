package com.zyh.code.linkedlist;

import com.zyh.code.support.ListNode;

/**
 * @author zhangyinghui  Date: 2020/9/9 Time: 8:58 PM
 */
public class RemoveNthFromEnd {
//    https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null || n <=0) {
                return head;
            }
            if(head.next == null) {
                return null;
            }

            // find the n from end
            // move to the n-1
            ListNode fast = head;
            for (int i = 1;i < n ; i++) {
                if (fast.next != null) {
                    fast = fast.next;
                }
            }
            ListNode slow = head;
            ListNode slowPre = null;
            while (fast.next != null) {
                fast = fast.next;
                slowPre=slow;
                slow=slow.next;
            }

            //delete the n
            if(slowPre != null) {
                slowPre.next=slow.next;
            } else {
                return head.next;
            }
            return head;
        }
}
