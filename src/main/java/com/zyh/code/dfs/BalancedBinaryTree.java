package com.zyh.code.dfs;

import com.zyh.code.support.Support;
import com.zyh.code.support.TreeNode;

/**
 * @author zhangyinghui  Date: 2020/8/10 Time: 9:46 PM
 */
public class BalancedBinaryTree {

// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    //解法,深度优先搜索,左子树,右子树高度差距不超过1
    public static void main(String[] args) {
        TreeNode root = Support.buildTree();
        boolean result = isBalancedBinaryTree(root);
        System.out.println(result);

    }

    private static boolean isBalancedBinaryTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int depthLeft = high(root.getLeft());
        int depthRight = high(root.getRight());
        return Math.abs(depthLeft-depthRight) <= 1;
    }

    private static int high(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.getLeft() != null || treeNode.getRight() != null) {
            return 1;
        }
        int leftHigh = high(treeNode.getLeft());
        int rightHigh = high(treeNode.getRight());
        if (leftHigh > rightHigh) {
            return leftHigh;
        }
        return rightHigh;
    }

    public static class BalancedBinaryTree0 {
        boolean balanced = true;

        public boolean isBalanced(TreeNode root) {
            height(root);
            return balanced;
        }

        private int height(TreeNode root) {
            if(root == null) {
                return 0;
            }

            int leftHeight = height(root.getLeft());
            int rightHeight = height(root.getRight());

            if(Math.abs(leftHeight - rightHeight) > 1) {
                balanced = false;
            }

            return 1 + Math.max(leftHeight, rightHeight);
        }
    }


}
