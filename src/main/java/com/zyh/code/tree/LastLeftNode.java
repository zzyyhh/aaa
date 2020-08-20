package com.zyh.code.tree;

import com.zyh.code.support.Support;
import com.zyh.code.support.TreeNode;

/**
 * @author yinghui.zhang on 2020/8/20
 */
public class LastLeftNode {
    //打印二叉树最后一层最左节点

    // Example:

    //     3
    //    / \
    //   9   20
    //      /  \
    //     15   7

    public static void main(String[] args) {
        TreeNode treeNode = Support.buildTree1();
        TreeNode result = findLastLevelLeftNode(treeNode);
    }
    //解法1. 按层遍历
    //解法2.
    private static TreeNode findLastLevelLeftNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;

        return null;
    }
}
