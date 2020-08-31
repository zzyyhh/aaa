package com.zyh.company.kuaishou;

import com.zyh.code.support.ListNode;

/**
 * @author zhangyinghui  Date: 2020/8/31 Time: 9:04 PM
 */
public class SortLinkedList {


    /**
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * 示例 2:
     * <p>
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-list
     */

    private static ListNode sortLinkedList(ListNode node) {
        //分治
        if(node == null || node.next == null) {
            return node;
        }

        //find middle and 断开
        ListNode middle = findMiddle(node);
        ListNode rightHead = middle.next;
        middle.next = null;

        ListNode left = sortLinkedList(node);
        ListNode right = sortLinkedList(rightHead);

        return mergeTwoList(left, right);
    }

    private static ListNode mergeTwoList(ListNode left, ListNode right) {
        return null;
    }

    private static ListNode findMiddle(ListNode node) {
        return null;
    }
}

























