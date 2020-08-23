package com.zyh.code.linkedlist;

import com.zyh.code.support.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

import static com.zyh.code.linkedlist.MergeList.buildListNode2;
import static com.zyh.code.support.Support.buildListNode1;

/**
 * @author zhangyinghui  Date: 2020/8/22 Time: 11:43 PM
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode list1 = buildListNode1();
        ListNode list2 = buildListNode2();
        ListNode[] listNodes = new ListNode[]{list1,list2};
        ListNode result = mergeKLists(listNodes);
        ListNode ss = mergeList(list1, list2);
        System.out.println(ss);
    }


    private static ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode current1 = list1;
        ListNode current2 = list2;
        ListNode current = result;

        while (current1 != null || current2 != null) {
            if (current1 == null) {
                current.next = current2;
                break;
            }
            if (current2 == null) {
                current.next = current1;
                break;
            }
            if (current1.value <= current2.value) {
                current.next = current1;
                current1 = current1.next;
            } else {
                current.next = current2;
                current2 = current2.next;
            }
            current = current.next;
        }
        return result.next;
    }

    private static ListNode mergeKLists(ListNode[] listNodes) {
        if (listNodes==null || listNodes.length ==0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(listNodes.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        });

        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for (ListNode node : listNodes) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next!=null) {
                queue.add(tail.next);
            }
        }

        return dummy.next;
     }

}
