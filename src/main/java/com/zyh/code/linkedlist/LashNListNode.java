package com.zyh.code.linkedlist;

import com.zyh.code.support.ListNode;
import com.zyh.code.support.Support;

/**
 * @author zhangyinghui  Date: 2020/8/12 Time: 3:31 PM
 */
public class LashNListNode {

    //linkedList的倒数第N个节点
    public static void main(String[] args) {
      ListNode node = findTheNList(Support.buildListNode1(), 2);
    }

    private static ListNode findTheNList(ListNode listNode, int n) {
        if (listNode == null) {
            return null;
        }

        ListNode first = listNode;
        //先走n-1步
        for (int i = 1 ;i < n; i++) {

            if (first.next != null) {
                first = first.next;
            } else {
                return null;
            }

        }
        ListNode result = listNode;
        while (first.next != null) {
            result = result.next;
            first = first.next;
        }

        return result;
    }

    ////linkedList的倒数第N个节点
    //
    //public static void main(String[] args) {
    //    //        head = [3,2,0,-4]
    //    ListNode head = Support.buildListNode1();
    //    ListNode node = findTheLastNNode1(head,2);
    //    System.out.println(node);
    //}
    //private static ListNode findTheLastNNode1(ListNode head, int n) {
    //    //
    //    if (head == null || n < 1) {
    //        return null;
    //    }
    //    //从head 到tail 共需要走 size-1
    //    //先走 n-1
    //    //再走 size-1 -(n-1) 即 倒数第n
    //    ListNode temp = head;
    //    for (int i = 1; i < n; i++) {
    //        // 说明还有结点
    //        if (temp.next != null) {
    //            temp = temp.next;
    //        } else {
    //            // 返回结果            // 已经没有节点了，但是i还没有到达k-1说明k太大，链表中没有那么多的元素
    //            return null;
    //        }
    //    }
    //    while (temp.getNext() != null) {
    //        temp = temp.next;
    //        head = head.next;
    //    }
    //    return head;
    //
    //}
    //private static ListNode findTheLastNNode(ListNode head, int n) {
    //    if (head == null) {
    //        return null;
    //    }
    //    int size = 1;
    //    ListNode tail = head;
    //    while (tail.next != null) {
    //        size++;
    //        tail = tail.next;
    //    }
    //    if(n>size) {
    //        return null;
    //    }
    //    ListNode temp = head;
    //    int tempInt = 0;
    //    while (temp != null) {
    //        if (size - n == tempInt) {
    //            return temp;
    //        }
    //        tempInt++;
    //        temp = temp.next;
    //    }
    //    return null;
    //}
}
