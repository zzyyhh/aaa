package com.zyh.code.stack;

import com.zyh.code.support.Support;
import com.zyh.code.support.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangyinghui  Date: 2020/8/12 Time: 2:54 PM
 */
public class BinarySearchTreeIterator {
    // Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

    // Calling next() will return the next smallest number in the BST.

    // Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {

        BSTIterator iterator = new BSTIterator(Support.buildTree());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    public static class BSTIterator {
        private Deque<TreeNode> stack;

        public BSTIterator(TreeNode treeNode) {
            this.stack = new ArrayDeque<>();
            while (treeNode != null) {
                stack.offer(treeNode);
                treeNode = treeNode.getLeft();
            }
        }
        public boolean hasNext() {
            return stack.isEmpty() ? false : true;
        }
        public int next() {
            TreeNode nextSmallest = stack.pollLast();
            TreeNode addToStack = nextSmallest.right;
            if (addToStack != null) {
                stack.offer(addToStack);
                addToStack = addToStack.left;
            }
            return nextSmallest.value;
        }
    }
}
