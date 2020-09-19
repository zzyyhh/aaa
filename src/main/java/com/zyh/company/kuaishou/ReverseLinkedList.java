package com.zyh.company.kuaishou;

import com.zyh.code.support.ListNode;
import com.zyh.code.support.Support;

/**
 * @author zhangyinghui  Date: 2020/8/31 Time: 9:03 PM
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = Support.buildListNode1();
        ListNode reverseNode = reverseList(node);
        System.out.println(reverseNode);
    }

    private static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode temp = head;

        ListNode result = null;

        while (temp != null) {

            //next
            ListNode next = temp.next;

            //赋值
            temp.next = result;
            result = temp;

            //移动
            temp = next;

        }

        return result.next;
    }

}
