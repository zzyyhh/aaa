package com.zyh.code.linkedlist;

import com.zyh.code.support.ListNode;


/**
 * @author zhangyinghui  Date: 2020/8/21 Time: 3:45 PM
 */
public class MergeList {

    public static void main(String[] args) {
        ListNode list1 = buildListNode1();
        ListNode list2 = buildListNode2();

        ListNode result = mergeList1(list1, list2);
        ListNode result1 = mergeList2(list1, list2);

        System.out.println(result1);
    }

    private static ListNode mergeList2(ListNode list1, ListNode list2) {
        return null;
    }


    public static ListNode buildListNode2() {
        //head = [2,4,6,8]
        ListNode head = new ListNode(2, new ListNode(4,  new ListNode(6, new ListNode(8, null))));
        return head;
    }

    public static ListNode buildListNode1() {
        //head = [1,5,6,9]
        ListNode head = new ListNode(1, new ListNode(5,  new ListNode(6, new ListNode(9, null))));
        return head;
    }


    private static ListNode mergeList1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode();
        head.next = list1;

        ListNode pre = head;

        while (list2 != null) {
            //list1的当前元素
            ListNode temp1 = pre.next;
            //list2的下一个元素
            ListNode temp2 = list2.next;
            //当list2当前元素值 > list1的当前元素值时,推进list1
            while (list2.value > temp1.value) {
                //如果list1的next为null,则直接指向list2后返回,否则list1往前推进一个元素
                if (temp1.next == null) {
                    temp1.next = list2;
                    return head.next;
                } else {
                    pre = pre.next;
                    temp1 = temp1.getNext();
                }
            }
            //list2当前元素<=list1当前元素,pre指向list2,list2的next指向list1,list2当前为其之前的next
            pre.next = list2;
            list2.next = temp1;
            list2 = temp2;
        }
        return head.next;
    }

}
