package com.zyh.code.support;

/**
 * @author yinghui.zhang on 2020/8/3
 */
public class Support {
    public static TreeNode buildTree() {
        TreeNode left = new TreeNode(2, null, null);
        TreeNode right = new TreeNode(6, null, null);
        TreeNode root = new TreeNode(4, left, right);
        return root;
    }

//    3
//   /\
//  /  \
//  9  20
//     /\
//    /  \
//   15   7

    public static TreeNode buildTree1() {
        TreeNode left = new TreeNode(9, null, null);
        TreeNode right = new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7,null,null));
        TreeNode root = new TreeNode(3, left, right);
        return root;
    }


    public static ListNode buildListNode1() {
//        head = [3,2,0,-4]
        ListNode head = new ListNode(3, new ListNode(2,  new ListNode(0, new ListNode(-4, null))));
        return head;
    }

    public static ListNode buildListNode() {
//        head = [3,2,0,-4], pos = 1
        ListNode head = new ListNode(3, new ListNode(2,  new ListNode(0, new ListNode())));
        head.getNext().getNext().getNext().setValue(-4);
        head.getNext().getNext().getNext().setNext(head);
        return head;
    }
}
