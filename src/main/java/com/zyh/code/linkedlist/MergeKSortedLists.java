package com.zyh.code.linkedlist;

import com.zyh.code.support.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

import static com.zyh.code.linkedlist.MergeList.buildListNode2;

/**
 * @author zhangyinghui  Date: 2020/8/22 Time: 11:43 PM
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode list1 = null;
        ListNode list2 = buildListNode2();
        ListNode[] listNodes = new ListNode[]{list1,list2};
        ListNode result = mergeKLists(listNodes);
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
